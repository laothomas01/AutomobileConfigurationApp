package Server;

import Adapter.*;

import java.io.*;
import java.net.*;


/*

We will be running this server and processing client requests and object streams

Each new instantiated server = new thread created

can run multiple servers with a single automobile but will have to utilize multi-threading
*/
public class DefaultServerSocket extends Thread implements Debuggable {

	////////// PROPERTIES //////////
	private int port;
	private ServerSocket server;

	////////// CONSTRUCTORS //////////


	// note: place into server function implemented by BuildAuto

	//make sure to call start on this server
	public DefaultServerSocket(int port) {
		this.port = port;
		try {
			this.server = new ServerSocket(port);
		} catch (IOException e) {
			System.err.println("Could not listen on port " + port + " ... ");
			System.exit(1);
		}
	}

	////////// INSTANCE METHODS //////////

	@Override
	public void run() {
		//let's instantiate a socket instance
		Socket clientSocket = null;
		if (DEBUG) {
			System.out.println("Server has started!");
			System.out.println("Waiting for connection......");

		}
		while (true) {

			//Accept client
			try {
				//set socket instance to socket accepted and connecting into server port
				if (DEBUG)
//					System.out.println("Waiting for connection......");
					clientSocket = server.accept();

			} catch (IOException e) {
				System.err.println("Error establishing client connection ... ");
				System.exit(1);
			}

			//Handle client-server interaction
			if (DEBUG)
				System.out.println(clientSocket.getLocalAddress());
			//running the server also runs this default socket client thread

			//pass in connected socket into default socket and start thread
			new DefaultSocket(clientSocket).start();

		}
	}

}