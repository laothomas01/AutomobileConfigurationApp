package MultiThreading;

//Using Runnable - enqueue/dequeue from list
//Using Runnable - enqueue/dequeue from list
//introduction to synchronization
public class QueueThread {
	int n;

	//does not read value unless there is a new value in queue
	synchronized int get() {
		System.out.println("Got: " + n);
		try {
			Thread.sleep(150);
		} catch (InterruptedException e) {
		}
		return n;
	}

	//does not put value unless value has been read
	synchronized void put(int n) {
		//n has no value unless you set it to a value like here
		this.n = n;
		System.out.println("Put: " + n);
		try {
			Thread.sleep(150);
		} catch (InterruptedException e) {
		}
	}

}

//begin thread through implementing Runnable
//requires input
class Consume implements Runnable {
	// takes an instance of QueueThread
	QueueThread q;

	Consume(QueueThread q) {
		this.q = q;
		//instantiate a new thread
		new Thread(this, "Consume").start();
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
class Produce implements Runnable {
	QueueThread q;

	Produce(QueueThread q) {
		this.q = q;
		new Thread(this, "Produce").start();
	}

	//run thread and write new value to queue instance
	public void run() {

		int i = 0;
		while (true) {
			i = i + 1;
			q.put(i);
		}
	}
}

class Program4 {
	public static void main(String args[]) {
		//create queue object
		QueueThread q = new QueueThread();
		//log it in consumer
		new Consume(q);
		//log it in producer
		new Produce(q);


	}
}