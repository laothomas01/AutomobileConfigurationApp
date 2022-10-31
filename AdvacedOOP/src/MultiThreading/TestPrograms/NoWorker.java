package MultiThreading.TestPrograms;

import java.util.List;

public class NoWorker implements Runnable {
	List<Integer> al;
	String name;

	public NoWorker(List<Integer> list, String name) {
		this.al = list;
		this.name = name;
	}

	public void run() {
		while (true) {
			int no = (int) (Math.random() * 10);
			System.out.println("[thread " + name + "]Adding:" + no + "to Object id:" + System.identityHashCode(al));
			al.add(no);
		}
	}
}
