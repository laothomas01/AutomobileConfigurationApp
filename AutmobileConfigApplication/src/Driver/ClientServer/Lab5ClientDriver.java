package Driver.ClientServer;

import Client.DefaultSocketClient;

public class Lab5ClientDriver {
	public static void main(String args[]) {
		DefaultSocketClient client = new DefaultSocketClient("192.168.50.82", 4444);
		client.start();
	}
}
