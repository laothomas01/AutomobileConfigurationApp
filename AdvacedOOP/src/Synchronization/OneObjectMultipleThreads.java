package Synchronization;

public class OneObjectMultipleThreads implements Runnable {
	private static final int ITERATIONS = 10;
	private static final ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>() {
		@Override
		protected Integer initialValue() {
			return 0;
		}
	};

	@Override
	public void run() {
		for (int i = 0; i < ITERATIONS; i++) {
			synchronized (threadLocal) {
				//Although accessing a static field, we get our own (previously saved) value.
				int value = threadLocal.get();
				System.out.println(Thread.currentThread().getName() + ": " + value);
				//Update our own variable
				threadLocal.set(value + 1);

				try {
					threadLocal.notifyAll();
					if (i < ITERATIONS - 1) {
						threadLocal.wait();
					}
				} catch (InterruptedException ex) {
				}
			}
		}
	}
}

class Test {
	public static void main(String args[]) {
		OneObjectMultipleThreads foo = new OneObjectMultipleThreads();
		new Thread(foo, "Thread 1").start();
		new Thread(foo, "Thread 2").start();
	}
}
