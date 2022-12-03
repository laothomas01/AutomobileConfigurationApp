package Client;

import java.net.*;
import java.io.*;

import Adapter.Debuggable;

public class DefaultSocketClient extends Thread implements Debuggable {

	////////// PROPERTIES //////////
	private ObjectOutputStream send;
	private ObjectInputStream receive;
	private BufferedReader stdIn;
	private Socket sock;
	private String strHost;
	private int iPort;
	private CarModelOptionsIO clientFTP;
	private SelectCarOptions clientProtocol;

	////////// CONSTRUCTORS //////////

	public DefaultSocketClient(String strHost, int iPort) {
		this.strHost = strHost;
		this.iPort = iPort;
	}

	////////// INSTANCE METHODS //////////

	public void establishConnection() {
		try {
			if (DEBUG) System.out.println("Connecting to host ... ");
			this.sock = new Socket(strHost, iPort);
			if (DEBUG) System.out.println("Connected to host, creating object streams ... ");
			send = new ObjectOutputStream(sock.getOutputStream());
			receive = new ObjectInputStream(sock.getInputStream());
			stdIn = new BufferedReader(new InputStreamReader(System.in));

			clientFTP = new CarModelOptionsIO();
			clientProtocol = new SelectCarOptions();
		} catch (IOException e) {
			System.err.println("Error obtaining I/O for connection to host ... ");
			System.exit(1);
		}
	}

	public void handleConnection() {
		Object fromServer,toServer = null;
		
		try {
			if (DEBUG) System.out.println("Communicating with host ... ");
			//as long as client can receive responses from server, keep loop running
			//when server closes, close the client
			while ((fromServer = receive.readObject()) != null) {
				//-----------------HANDLING RESPONSES FROM SERVER ------------------

				if (DEBUG) System.out.println("Received server response ... ");


				System.out.println("Response to server: ");
				//handle received automobile instance from server after client enters in
				if (clientProtocol.isAutomobile(fromServer)) {
					System.out.println("Is an automobile!");
					clientProtocol.configureAuto(fromServer);
				}
//				else {
				System.out.println(fromServer.toString());
				//-----------------HANDLING RESPONSES TO SERVER ------------------

				//basic user input
				toServer = stdIn.readLine();

				//checking the user response
				if (toServer.toString().contains(".prop")) {
					toServer = clientFTP.loadPropsFile(toServer.toString());
				}
				if (toServer.toString().contains(".txt")) {
					toServer = clientFTP.loadTextFile(toServer.toString());
				}

				if (DEBUG) System.out.println("\n----------\nSending " + toServer + " to server ... ");
//				sendOutput(toServer);
				try {
					send.writeObject(toServer);
				} catch (IOException e) {
					System.err.println("Error in I/O stream while sending object to host ... ");
					System.exit(1);
				}
				System.out.println("");

				if (toServer.equals("0")) {
					break;
				}
				//---------------------------------------------------------------------
//				}


			}

			if (DEBUG) System.out.println("Closing client input stream ... ");
			receive.close();
		} catch (ClassNotFoundException e) {
			System.err.println("Error in downloaded object, object may be corrupted ... ");
			System.exit(1);
		} catch (IOException e) {
			System.err.println("Error in I/O stream ... ");
			System.exit(1);
		}

	}

	//respond back to server
	public void sendOutput(Object obj) {
		try {
			send.writeObject(obj);
		} catch (IOException e) {
			System.err.println("Error in I/O stream while sending object to host ... ");
			System.exit(1);
		}
	}

	@Override
	public void run() {
		establishConnection();
		handleConnection();
		try {
			if (DEBUG) System.out.println("Closing client output stream ... ");
			send.close();

			if (DEBUG) System.out.println("Closing client console input stream ... ");
			stdIn.close();

			if (DEBUG) System.out.println("Closing client socket ... ");
			sock.close();
		} catch (IOException e) {
			System.err.println("Error ending client connection ... ");
			System.exit(1);
		}
	}

}