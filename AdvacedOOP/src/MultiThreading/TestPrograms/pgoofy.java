package MultiThreading.TestPrograms;


//producer thread
public class pgoofy extends Thread {
	coffee a1;

	pgoofy(coffee e) {
		a1 = e;
	}

	public void run() {
		a1.put(10);
		System.out.println("producer:" + a1.contents);
	}
}
