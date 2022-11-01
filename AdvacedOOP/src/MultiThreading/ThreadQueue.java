package MultiThreading;

//Using Runnable - enqueue/dequeue from list
//Using Runnable - enqueue/dequeue from list
//introduction to synchronization
class Queue {
	int n;
	boolean available = false;

	//does not read value unless there is a new value in queue
	synchronized int get() {
		System.out.println("Got: " + n);
		try {
			if (available == false) {
				Thread.sleep(3000);
			}
		} catch (InterruptedException e) {
		}
		available = true;
		return n;
	}

	//does not put value unless value has been read
	synchronized void put(int n) {
		System.out.println("Put: " + n);

		try {
			if (available) {
				Thread.sleep(3000);
			}
		} catch (InterruptedException e) {
		}
		available = false;
		//n has no value unless you set it to a value like here
		this.n = n;
	}

}

//begin thread through implementing Runnable
//requires input
class Consumer implements Runnable {
	// takes an instance of Queue
	Queue q;

	Consumer(Queue q) {
		this.q = q;
		//instantiate a new thread
		new Thread(this, "Consumer").start();
	}

	//run thread
	public void run() {
		while (true) {
			//return value n from queue
			q.get();
		}
	}

}

//produces output
class Producer implements Runnable {
	Queue q;

	Producer(Queue q) {
		this.q = q;
		new Thread(this, "Producer").start();
	}

	//run thread and write new value to queue instance
	public void run() {

		int i = 1;
		while (true) {
			i = i + 1;
			q.put(i);
		}

	}

}

public class ThreadQueue {
	public static void main(String args[]) {
		//create queue object
		Queue q = new Queue();
		//log it in consumer
		new Consumer(q);
		//log it in producer
		new Producer(q);
	}
}
