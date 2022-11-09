package MultiThreading;

class Counter {
	int count; // count = count + 1

	//synchronized = one thread can work with this method
	//unsynchronized = not thread safe = multiple threads accessing at same time
	public synchronized void increment() {
		count++;
	}
}

public class SychronizedCounter {
	public static void main(String args[]) throws InterruptedException {
		Counter c = new Counter();
		Thread t = new Thread(new Runnable() {
			public void run() {
				for (int i = 1; i <= 1000; i++) {
					c.increment();
				}
			}
		});
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				for (int i = 1; i <= 1000; i++) {
					c.increment();
				}
			}
		});
		t.start();
		t2.start();
		t.join();
		t2.join();


		System.out.println("Count " + c.count);
	}

}
