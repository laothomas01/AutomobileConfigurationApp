package MultiThreading;

class ThreadX extends Thread {
	public void run() {
		try {
			while (true) {
				Thread.sleep(2000);
				System.out.println("Hello");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

public class LearningThread1 {
	public static void main(String args[]) {
		ThreadX tx = new ThreadX();
		tx.start();
	}
}
