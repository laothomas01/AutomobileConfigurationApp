package Server;

import java.net.*;
import java.io.*;

import Adapter.Debuggable;

/**
 * Interaction with a client's menu system for building car models from the server-side
 */
public class DefaultSocketClient extends Thread implements Debuggable {

	////////// PROPERTIES //////////

	private ObjectOutputStream out;
	private ObjectInputStream in;
	private Socket clientSocket;
	private BuildCarModelOptions protocol;

	////////// CONSTRUCTORS //////////

	public DefaultSocketClient(Socket clientSocket) {
		this.clientSocket = clientSocket;
	}


	////////// INSTANCE METHODS //////////


	public void handleConnection(Socket sock) {
		if (DEBUG)
			System.out.println("Creating server object streams ... ");
		try {
			//for serialization of objects
			out = new ObjectOutputStream(sock.getOutputStream());
			//for deserialization of objects
			in = new ObjectInputStream(sock.getInputStream());
		} catch (IOException e) {
			System.err.println("Error creating server object streams ... ");
			System.exit(1);
		}


		protocol = new BuildCarModelOptions();
		/**
		 * Bulk of the server client is in this menu
		 */
		String menu = "\nEnter 1 to upload a new Automobile\n"
		              + "Enter 2 to configure an Automobile\n"
		              + "Enter 0 to terminate connection\n";

		try {
			do {
				if (DEBUG)
					System.out.println("Sending client interaction choices ... ");
				//serialize the menu object, wait for response
				//will be deserialized in the client-side client socket
				sendOutput(menu);
				if (DEBUG)
					System.out.println("Reading client request ... ");
				//client-side client socket sends serialized input
				//deserialize request
				//handle response to the server-side client menu
				int request = Integer.parseInt(in.readObject().toString());
				if (DEBUG)
					System.out.println(request);
				if (request == 0)
					break;
				if (DEBUG)
					System.out.println("Sending client request follow-up ... ");
				//serialize returned string from input request

				sendOutput(protocol.setRequest(request));

				if (request >= 1 && request <= 2)
					handleInput(request);
			} while (in.readObject() != null);

			if (DEBUG)
				System.out.println("Closing server input stream for client " + sock.getInetAddress() + " ... ");
			in.close();
		} catch (IOException e) {
			System.err.println("Error handling client connection ... ");
			System.exit(1);
		} catch (ClassNotFoundException e) {
			System.err.println("Error in uploaded object, object may be corrupted ... ");
			System.exit(1);
		}
	}

	public void sendOutput(Object obj) {
		try {
			//write to object output stream via serialization
			out.writeObject(obj);
		} catch (IOException e) {
			System.err.println("Error returning output to client ... ");
			System.exit(1);
		}
	}

	public void handleInput(int request) {
		Object fromClient = null;

		Object toClient = null;

		try {
			switch (request) {
				case 1: //Client request to build Automobile
					if (DEBUG)
						System.out.println("Waiting for client to upload file ... ");
					//deserialize object sent from client
					//properties file has been located and uploaded
					fromClient = in.readObject();
					if (DEBUG) {
						System.out.println(fromClient);
						System.out.println("Adding new Automobile to database ... ");
					}


					toClient = protocol.processRequest(fromClient);
					sendOutput(toClient);
					break;

				case 2: //Client request to configure Automobile
					if (DEBUG)
						System.out.println("Waiting for client to select Automobile ... ");
					fromClient = Integer.parseInt(in.readObject().toString());
					if (DEBUG)
						System.out.println("Sending Automobile object to client ... ");
					toClient = protocol.processRequest(fromClient);
					sendOutput(toClient);
					break;
				default: //Invalid requests
			}
		} catch (ClassNotFoundException e) {
			System.err.println("Error in uploaded object, file may be corrupted ... ");
			System.exit(1);
		} catch (IOException e) {
			System.err.println("Error in retrieving object from client ... ");
			System.exit(1);
		}
	}

	//when starting server, server starts new instance of client's socket
	@Override
	public void run() {
		handleConnection(clientSocket);

		//Close client output stream
		if (DEBUG)
			System.out.println("Closing server output stream for client " + clientSocket.getInetAddress() + " ... ");
		try {
			out.close();
		} catch (IOException e) {
			System.err.println("Error closing server output stream for client " + clientSocket.getInetAddress() + " ... ");
		}

		//Close client socket
		if (DEBUG)
			System.out.println("Closing client socket " + clientSocket.getInetAddress() + " ... ");
		try {
			clientSocket.close();
		} catch (IOException e) {
			System.err.println("Error closing client socket " + clientSocket.getInetAddress() + " ... ");
		}
	}

}