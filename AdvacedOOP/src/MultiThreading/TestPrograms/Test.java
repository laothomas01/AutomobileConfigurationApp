package MultiThreading.TestPrograms;

import java.util.ArrayList;
import java.util.List;

public class Test implements Runnable {
	static List<Integer> ls = new ArrayList<Integer>();

	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new Test());
		Thread t2 = new Thread(new Test());

		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println(ls.size());
		for (int i = 0; i < ls.size(); ++i) {
			System.out.println(i + "  " + ls.get(i));
		}
	}

	@Override
	public void run() {
		try {
			for (int i = 0; i < 20; ++i) {
				ls.add(i);
				Thread.sleep(2);
			}
			for (int i = 0; i < 21; ++i) {
				ls.remove(i);
				Thread.sleep(2);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
