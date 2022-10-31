package MultiThreading.TestPrograms;

public class cgoofy2 extends Thread {
	coffee2 a2;

	cgoofy2(coffee2 e2) {
		a2 = e2;
	}

	public void run() {
		System.out.println("consumer" + a2.get());
	}
}
