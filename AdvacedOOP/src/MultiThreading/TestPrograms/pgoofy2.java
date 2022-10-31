package MultiThreading.TestPrograms;

public class pgoofy2 extends Thread {
	coffee2 a2;

	pgoofy2(coffee2 e2) {
		a2 = e2;
	}

	public void run() {
		a2.put(10);
		System.out.println(a2.contents);
	}

}
