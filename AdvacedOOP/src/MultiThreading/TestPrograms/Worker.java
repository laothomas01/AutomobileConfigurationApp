package MultiThreading.TestPrograms;

import java.util.List;

class Worker implements Runnable {
	List<Integer> al;
	String name;

	public Worker(List<Integer> list, String name) {
		this.al = list;
		this.name = name;
	}

	@Override
	public void run() {
		while (true) {
			int no = (int) (Math.random() * 10);
			System.out.println("[thread " + name + "]Adding:" + no + "to Object id:" + System.identityHashCode(al));
			al.add(no);
		}
	}
}