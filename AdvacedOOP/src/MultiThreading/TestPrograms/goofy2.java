package MultiThreading.TestPrograms;

//Example of implementation of wait and how to notify between two thread with synchronized
public class goofy2 {
	public static void main(String args[]) {
		coffee2 a1 = new coffee2();
		//let's start with the consumer thread
		cgoofy2 a3 = new cgoofy2(a1);
		//attempt to start a3 thread but have to wait
		a3.start();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		pgoofy2 a2 = new pgoofy2(a1);
		a2.start();

	}
}
