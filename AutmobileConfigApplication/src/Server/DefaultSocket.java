package Server;

import java.net.*;
import java.io.*;

import Adapter.Debuggable;

/**
 * Connected socket passed in to this class
 */

/**
 * - use linked hashmap to store automobiles
 * - build automobile object from given .properties object from client
 * - send client server prompt
 * - respond to client requests and handle requests
 */


public class DefaultSocket extends Thread implements Debuggable {

	////////// PROPERTIES //////////

	private ObjectOutputStream send;
	private ObjectInputStream receive;
	private Socket clientSocket;
	private BuildCarModelOptions protocol;

	////////// CONSTRUCTORS //////////

	public DefaultSocket(Socket clientSocket) {
		System.out.println("Connection Accepted.....");
		this.clientSocket = clientSocket;
	}


	////////// INSTANCE METHODS //////////


	public void handleConnection(Socket sock) {
		if (DEBUG) System.out.println("Creating server object streams ... ");
		try {
			//object sent through socket output stream is serialized
			send = new ObjectOutputStream(sock.getOutputStream());
			//object sent through socket output stream is de-serialized
			receive = new ObjectInputStream(sock.getInputStream());
		} catch (IOException e) {
			System.err.println("Error creating server object streams ... ");
			System.exit(1);
		}


		protocol = new BuildCarModelOptions();

		/**
		 * Bulk of the server client is in this menu
		 */
		String menu = "\nEnter 1 to upload a new Automobile\n" +
		              "Enter 2 to configure an Automobile\n" +
		              "Enter 0 to terminate connection\n";
		try {
			//while server can receive responses from client, continue to handle
			do {
				if (DEBUG) System.out.println("Sending client interaction choices ... ");
				try {
					//serialize object
					//send out menu prompt to client
					send.writeObject(menu);
				} catch (IOException e) {
					System.err.println("Error returning output to client ... ");
					System.exit(1);
				}
				if (DEBUG) System.out.println("Reading client request ... " + "\n" + "----------" + "\n");

				//what is causing the code block to be blocked until a response is received????


				//request has been received and parsed
				int request = Integer.parseInt(receive.readObject().toString());
				if (DEBUG) System.out.println(request);
				if (request == 0) break;
				if (DEBUG) System.out.println("Sending client request follow-up ... ");

				try {
					//serialize and send object to client
					//object sent is class String
					send.writeObject(protocol.setRequest(request));
				} catch (IOException e) {
					System.err.println("Error returning output to client ... ");
					System.exit(1);
				}
				if (request >= 1 && request <= 2) {
					//handle received deserialized input

					handleInput(request);
				}
			} while (receive.readObject() != null);

			if (DEBUG) System.out.println("Closing server input stream for client " + sock.getInetAddress() + " ... ");
			receive.close();
		} catch (IOException e) {
			System.err.println("Error handling client connection ... ");
			System.exit(1);
		} catch (ClassNotFoundException e) {

			System.err.println("Error in uploaded object, object may be corrupted ... ");
			System.exit(1);
		}
	}

//	public void sendOutput(Object obj) {
//		try {
//			//write to object output stream via serialization
//			send.writeObject(obj);
//		} catch (IOException e) {
//			System.err.println("Error returning output to client ... ");
//			System.exit(1);
//		}
//	}


	public void handleInput(int request) {
		//received and de-serialized object
		Object fromClient = null;
		//sent out a serialized object
		Object toClient = null;
		try {
			switch (request) {
				case 1: //Client request to build Automobile
					if (DEBUG) System.out.println("Waiting for client to upload file ... ");
					//client sends out .txt or .prop file
					fromClient = receive.readObject();
					if (DEBUG) {
						//properties file being receives
						System.out.println("Received " + fromClient);
						System.out.println("Adding new Automobile to database ... ");
					}

					toClient = protocol.processRequest(fromClient);
//					System.out.println(toClient);
//					sendOutput(toClient);
					try {
						//process request, send automobile object to client
						send.writeObject(toClient);
					} catch (IOException e) {
						e.printStackTrace();
						System.err.println("Error returning output to client ... ");
						System.exit(1);
					}
					break;

				case 2: //Client request to configure Automobile
					if (DEBUG) System.out.println("Waiting for client to select Automobile ... ");
					fromClient = Integer.parseInt(receive.readObject().toString());
					if (DEBUG) System.out.println("Sending Automobile object to client ... ");
					toClient = protocol.processRequest(fromClient);
//					sendOutput(toClient);
					try {
						//write to object output stream via serialization
						send.writeObject(toClient);
					} catch (IOException e) {
						System.err.println("Error returning output to client ... ");
						System.exit(1);
					}
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
		//client within server and we'll be handling serialization and deserialization of data
		handleConnection(clientSocket);

		//Close client output stream
		if (DEBUG)
			System.out.println("Closing server output stream for client " + clientSocket.getInetAddress() + " ... ");
		try {
			send.close();
		} catch (IOException e) {
			System.err.println("Error closing server output stream for client " + clientSocket.getInetAddress() + " ... ");
		}

		//Close client socket
		if (DEBUG) System.out.println("Closing client socket " + clientSocket.getInetAddress() + " ... ");
		try {
			clientSocket.close();
		} catch (IOException e) {
			System.err.println("Error closing client socket " + clientSocket.getInetAddress() + " ... ");
		}
	}

}