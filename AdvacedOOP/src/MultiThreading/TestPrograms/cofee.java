package MultiThreading.TestPrograms;

import java.util.ArrayList;
import java.util.List;

public class cofee {
	static List<Integer> list = new ArrayList<Integer>();

	public static void main(String args[]) throws InterruptedException {
//		for (int i = 0; i < 10; i++) {
//			System.out.println("A " + i);
		new Thread(new NoWorker(list, "" + 0)).start();
		new Thread(new Worker(list, "" + 0)).start();
//		}

	}
}
