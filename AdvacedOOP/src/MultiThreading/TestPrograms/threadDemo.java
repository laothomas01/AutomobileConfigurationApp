package MultiThreading.TestPrograms;

public class threadDemo extends Thread {
	mySet a1;

	public threadDemo(mySet e) {
		a1 = e;
	}

	public void run() {
		try {
			// Displaying the thread that is running
			System.out.println(
					"TD1: Thread " + Thread.currentThread().getId()
					+ " is running");
			a1.add(new Object());
		} catch (Exception e) {
			// Throwing an exception
			System.out.println("Exception is caught" + e);
		}
	}
}
