package MultiThreading.TestPrograms;

public class cgoof extends Thread {
	mySet a1;

	public cgoof(mySet e) {
		a1 = e;
	}

	public void run() {
		System.out.println("Cosumer" + a1.remove());
	}
}
