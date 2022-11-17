package ClientServerTesting;
/**
 * Server Socket - socket for a server
 * Socket - socket for a client
 * <p>
 * Note: this is only for 1 client at a time. it's not multi-threaded yet
 */

import java.net.*;
import java.io.*;

public class KnockKnockServer {
	public static void main(String[] args) throws IOException {
		//create socket for server
		//wait for server request to arrive
		ServerSocket serverSocket = null;
		try {
			//establish server port
			serverSocket = new ServerSocket(4444);
		} catch (IOException e) {
			System.err.println("Could not listen on port: 4444.");
			System.exit(1);
		}

		Socket clientSocket = null;
		try {
			//server socket accepts the client socket
			//listens for a client connecting to the port
			//method is blocked until a connection is found
			clientSocket = serverSocket.accept();
		} catch (IOException e) {
			System.err.println("Accept failed.");
			System.exit(1);
		}


		//read the output of the client
		PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
		//reads input from the client
		BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		String inputLine, outputLine;


		//operations that will be communicated between client and server
		KnockKnockProtocol kkp = new KnockKnockProtocol();

		//output line = a specific knock knock protocol
		outputLine = kkp.processInput(null);
		out.println(outputLine);


		while ((inputLine = in.readLine()) != null) {
			//set output line as input from client
			outputLine = kkp.processInput(inputLine);
			//print output
			out.println(outputLine);
			//when knock knock protocol outputline = "Bye", quit
			if (outputLine.equals("Bye.")) break;
		}

		out.close();
		in.close();
		clientSocket.close();
		serverSocket.close();
	}
}
