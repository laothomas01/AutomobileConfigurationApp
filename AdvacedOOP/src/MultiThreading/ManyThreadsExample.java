package MultiThreading;

import Interfaces.Man;

//many threads of the same class and each has its own name
public class ManyThreadsExample extends Thread {
	private int countDown = 5;
	private int threadNum;
	private static int threadCount = 0;

	public ManyThreadsExample() {
		threadNum = ++threadCount;
		System.out.println("Making " + threadNum);
	}

	public void run() {
		while (true) {
			System.out.println("Thread " + threadNum + " ( " + countDown + " ) ");
			if (--countDown == 0) {
				return;
			}
		}
	}


	public static void main(String[] args) {
		//instantiate 5 new threads
		for (int I = 0; I < 5; I++) {
			new ManyThreadsExample().start();
			System.out.println("All threads started!");

		}

	}
}
