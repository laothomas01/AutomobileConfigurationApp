package MultiThreading.TestPrograms;

public class ThreadY extends Thread {
	public int click = 0;
	private Thread t;
	private boolean running = true;

	public ThreadY(int p) {
		t = new Thread(this);
		t.setPriority(p);
	}

	public void run() {
		while (running) {
			click++;
		}
	}

	public void stopp() {
		running = false;
	}

	public void start() {
		t.start();
	}
}

class Program3 {
	public static void main(String args[]) {
		//main thread is set to highest priority.
		Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
		ThreadY hi = new ThreadY(Thread.NORM_PRIORITY + 2);
		ThreadY lo = new ThreadY(Thread.NORM_PRIORITY - 2);
		lo.start();
		hi.start();

		try {
			Thread.sleep(10000);
		} catch (Exception e) {
		}

		lo.stopp();
		hi.stopp();
		System.out.println(lo.click + " vs. " + hi.click);
	}

}
