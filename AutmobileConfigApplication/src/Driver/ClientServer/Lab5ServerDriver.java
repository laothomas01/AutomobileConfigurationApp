package Driver.ClientServer;

import Server.DefaultServerSocket;

import java.io.IOException;

public class Lab5ServerDriver {
	public static void main(String args[]) throws IOException, InterruptedException {
		DefaultServerSocket server = new DefaultServerSocket(4444);
		server.start();
	}
}
