package MultiThreading;

public class Main {
	public static void main(String[] args) {
		Widget w = new Widget();
		//2 separate widget threads
		Thread t1 = new Thread(w);
		Thread t2 = new Thread(w);
	}
}
