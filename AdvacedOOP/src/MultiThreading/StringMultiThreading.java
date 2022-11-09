package MultiThreading;

/**
 * Non synchronized vs synchronized
 */
class StringMultiThreading extends Thread {
	static String[] msg = {"Example", "of", "how", "messy", "Java", "is", "without", "synchronization"};

	public static void main(String[] args) {
		StringMultiThreading t1 = new StringMultiThreading("t1: ");
		StringMultiThreading t2 = new StringMultiThreading("t2: ");

		t1.start();
		t2.start();

		boolean t1IsAlive = true;
		boolean t2IsAlive = true;

		do {
			if (t1IsAlive && !t1.isAlive()) {
				t1IsAlive = false;
				System.out.println("t1 is dead.");
			}

			if (t2IsAlive && !t2.isAlive()) {
				t2IsAlive = false;
				System.out.println("t2 is dead.");
			}
		} while (t1IsAlive || t2IsAlive);
	}

	public StringMultiThreading(String id) {
		super(id);
	}

	void randomWait() {
		try {
			Thread.currentThread().sleep((long) (3000 * Math.random()));
		} catch (InterruptedException e) {
			System.out.println("Interrupted!");
		}
	}


	public void run() {
		synchronized (System.out) {
			for (int i = 0; i < msg.length; i++) {
				randomWait();
				System.out.println(getName() + msg[i]);
			}
		}
	}
}

