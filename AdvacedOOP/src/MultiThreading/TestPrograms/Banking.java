package MultiThreading.TestPrograms;

public class Banking extends Thread {
	/**
	 * The test method for the class
	 *
	 * @param args Time in seconds for which
	 *             this banking process should run
	 */
	public static void main(String[] args) {
		BankAccount ba = new BankAccount();
		// create the spender thread
		Spender spenderThread = new Spender(ba);

		// create the saver thread which is a two-step
		// process because Saver implements Runnable
		Saver aSaver = new Saver(ba);
		Thread saverThread = new Thread(aSaver);

		spenderThread.start();
		saverThread.start();

		int time;
		if (args.length == 0) {
			time = 10000;
		} else {
			time = Integer.parseInt(args[0]) * 1000;
		}

		try {
			Thread.currentThread().sleep(time);
		} catch (InterruptedException iex) {
			/* ignore it */
		}
		// close the bank account
		ba.close();
	}
}
