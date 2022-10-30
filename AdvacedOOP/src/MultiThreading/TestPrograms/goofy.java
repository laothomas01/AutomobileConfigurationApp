package MultiThreading.TestPrograms;

/**
 * Waiting and notify between two threads with sychronized
 */
public class goofy {
	public static void main(String[] args) {

		//produce,consumer synchronized functions
		coffee a1 = new coffee();
		//consumer thread
		//consumer attempt to return a value
		cgoofy a3 = new cgoofy(a1);
		a3.start();
		try {
			Thread.sleep(2000);
		} catch (Exception e) {

		}
		pgoofy a2 = new pgoofy(a1);
		a2.start();
	}
}
