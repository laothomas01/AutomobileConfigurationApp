package Driver.ClientServer;

import Adapter.BuildAuto;
import Server.AutoServer;
import Server.DefaultServerSocket;

import java.io.IOException;

public class Lab5ServerDriver {
	public static void main(String args[]) throws IOException, InterruptedException {
		AutoServer auto = new BuildAuto();
		auto.server(4444);
	}
}
