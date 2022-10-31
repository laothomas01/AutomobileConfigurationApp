package MultiThreading.TestPrograms;

public class threadDemo2 extends Thread {
	mySet a1;

	public threadDemo2(mySet e) {
		a1 = e;
	}

	public void run() {
		try {
			// Displaying the thread that is running
			System.out.println(
					"TD2: Thread " + Thread.currentThread().getId()
					+ " is running");
			if(a1 == null) {
				System.out.println("NULL");
			}
			a1.remove();
		} catch (Exception e) {
			// Throwing an exception
			System.out.println("Exception is caught:" + e.toString());
		}
	}
}
