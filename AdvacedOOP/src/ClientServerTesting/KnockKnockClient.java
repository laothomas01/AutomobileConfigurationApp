package ClientServerTesting;

import java.io.*;
import java.net.*;

public class KnockKnockClient {
	public static void main(String[] args) throws IOException {

		//client socket
		Socket kkSocket = null;
		PrintWriter out = null;
		BufferedReader in = null;

		try {
			/*
			 * 2 options for socket host:
			 * -  localhost
			 * -  192.168.50.82
			 * */


			//client socket instantiate
			kkSocket = new Socket("localhost", 4444);

			//output stream of client
			out = new PrintWriter(kkSocket.getOutputStream(), true);

			//input stream of client
			in = new BufferedReader(new InputStreamReader(kkSocket.getInputStream()));
		} catch (UnknownHostException e) {
			System.err.println("Don't know about host: taranis.");
			System.exit(1);
		} catch (IOException e) {
			System.err.println("Couldn't get I/O for the connection to: taranis.");
			System.exit(1);
		}


		//client input
		BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
		String fromServer;
		String fromUser;

		//when starting client, print a server message first
		while ((

				       fromServer =
						       in.readLine()) != null) {
			System.out.println("Server: " + fromServer);
			if (fromServer.equals("Bye."))
				break;


			fromUser = stdIn.readLine();
			if (fromUser != null) {
				System.out.println("Client: " + fromUser);
				out.println(fromUser);
			}
		}

		out.close();
		in.close();
		stdIn.close();
		kkSocket.close();
	}
}

