package MultiThreading.TestPrograms;

import java.util.ArrayList;
import java.util.List;

class UnsynchedArrayListTest implements Runnable {
	private List<Integer> a;

	public UnsynchedArrayListTest(List<Integer> a) {
		this.a = a;
	}

	public void run() {
		try {
			for (int i = 0; i < 20; ++i) {
				//producer
				a.add(i);
				Thread.sleep(10);
			}
		} catch (InterruptedException e) {
		}
	}

	public static void main(String[] args) throws Exception {
		ArrayList<Integer> a = new ArrayList<Integer>();

		Thread t1 = new Thread(new UnsynchedArrayListTest(a));
		Thread t2 = new Thread(new UnsynchedArrayListTest(a));

		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println(a.size());
		for (int i = 0; i < a.size(); ++i) {
			//consumer
			System.out.println(i + "  " + a.get(i));
		}
		/**
		 * must put a value before you can get a value
		 * this applies to both threads
		 * synchronized get : available = false
		 * sychronized put: available = false -> true
		 * sychronized get: available = true -> return value, available -> false
		 */
	}
}
