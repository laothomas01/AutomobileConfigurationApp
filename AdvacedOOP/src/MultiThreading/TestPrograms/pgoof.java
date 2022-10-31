package MultiThreading.TestPrograms;

public class pgoof extends Thread {
	mySet a1;

	pgoof(mySet e) {
		a1 = e;
	}

	public void run() {
		a1.add(new Object());
	}
}
