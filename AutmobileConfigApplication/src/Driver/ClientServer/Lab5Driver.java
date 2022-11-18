package Driver.ClientServer;

import Adapter.BuildAuto;
import Adapter.CreateAuto;
import Server.DefaultServerSocket;
import Server.DefaultSocketClient;

import java.io.IOException;

public class Lab5Driver {
	public static void main(String args[]) throws IOException, InterruptedException {
		DefaultServerSocket server = new DefaultServerSocket(4444);
		server.start();
	}
}
