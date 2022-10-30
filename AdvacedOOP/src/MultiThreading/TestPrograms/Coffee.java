package MultiThreading.TestPrograms;

public class Coffee {
	boolean available = false;
	int contents = 55;

	public synchronized int get() {
		System.out.println("Entering get method" + contents);
		while (available == false) {
			try {
				System.out.println("Get Waiting" + contents);
				wait();
			} catch (InterruptedException e) {
				System.out.println("Get done waiting" + contents);
			}

		}
		available = false;
		System.out.println("Get Notfifyall" + contents);
		notifyAll();
		System.out.println("Get Done!" + contents);
		return contents;
	}

	public synchronized void put(int value) {
		System.out.println("Enter put method" + contents);
		while (available == true) {
			try {
				System.out.println("Put Waiting" + contents);
				wait();
			} catch (InterruptedException e) {
				System.out.println("Put done waiting!" + contents);
			}
			contents = value;
			available = true;
			System.out.println("Put added new value - notifyall " + contents);
			notifyAll();
			System.out.println("Put done" + contents);
		}
	}
}
