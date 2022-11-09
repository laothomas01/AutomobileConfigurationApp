package Synchronization;

public class Solution {
	void sol(String message) {
		System.out.println("[ " + message);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println(e);
		}
		// Sol method Ends
		System.out.println("]");
		// Solution Class Ends
	}

}

class CallerSolution implements Runnable {
	String msg;
	Solution target;
	Thread t;

	public CallerSolution(Solution tar, String s) throws InterruptedException {
		target = tar;
		msg = s;
		t = new Thread(this);
		t.start();
//		t.join();
	}

	public void run() {
		target.sol(msg);
	}
} // CallerSolution Ends

class SynchMainClass {
	public static void main(String args[]) throws InterruptedException {
		Solution obj1 = new Solution();
		CallerSolution c1 = new CallerSolution(obj1, "Hello");
		CallerSolution c2 = new CallerSolution(obj1, "Synchronized");
		CallerSolution c3 = new CallerSolution(obj1, "Method");

		try {
			c1.t.join();
			c2.t.join();
			c3.t.join();
		} catch (InterruptedException e) {
			System.out.println(e);
		}

	}
}

