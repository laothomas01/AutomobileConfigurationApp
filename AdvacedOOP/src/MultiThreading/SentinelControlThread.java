package MultiThreading;

//Using stop with a sentinel since stop itself is depreciated now
public class SentinelControlThread implements Runnable {
	public int click = 0;
	private Thread t;
	private boolean running = true;

	public SentinelControlThread(int p) {
		t = new Thread(this);
		t.setPriority(p);
	}

	public void printThread() {
		System.out.println(t.getId() + "," + t.getState() + "," + t.getPriority());
	}

	public void run() {
		while (running) {
			click++;
		}
	}

	public boolean isRunning() {
		return running;
	}

	public void stop() {
		running = false;
	}

	public void start() {
		t.start();
	}
}

class Program3 {
	public static void main(String args[]) {
		Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
		SentinelControlThread hi = new SentinelControlThread(Thread.NORM_PRIORITY + 2);
		SentinelControlThread lo = new SentinelControlThread(Thread.NORM_PRIORITY - 2);
		lo.start();
		hi.start();

		try {
			while (hi.isRunning() && lo.isRunning()) {
				Thread.sleep(3000);
				hi.printThread();
				lo.printThread();
				System.out.println(lo.click + " vs. " + hi.click);
			}
		} catch (Exception e) {
		}

//		lo.stop();
//		hi.stop();

	}

}
