package Networking;

import java.net.*;

public class MyMachineName {
	public static void main(String args[]) {
		InetAddress local = null;
		try {
			local = InetAddress.getLocalHost();
			System.out.println(local);
		} catch (UnknownHostException e) {
			System.err.println("Identity Crisis!");
			System.exit(0);
		}
		String strAddress = local.getHostName();
		System.out.println("Local Host = " + strAddress);
	}
}
