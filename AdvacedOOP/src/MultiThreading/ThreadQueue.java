package MultiThreading;

import java.util.ArrayList;

//Using Runnable - enqueue/dequeue from list
//Using Runnable - enqueue/dequeue from list
//introduction to synchronization
class Queue {
	int n;
	boolean available = false;
	ArrayList<Integer> a = new ArrayList<>();

	//does not read value unless there is a new value in queue
	synchronized int get() {
		System.out.println("AVAILABLE: BEFORE GET " + available);
		System.out.println("Got: " + n);
		System.out.println("PRE-REMOVE,CHECKING DATA:" + a + "," + n);
		while (available == false) {
			try {
				System.out.println("Get Waiting " + n);
				wait(5000, 0);
			} catch (InterruptedException e) {
				System.out.println("Get done waiting " + n);
			}
		}
		available = false;
		System.out.println("Get Notifyall " + n);
		System.out.println("ADDING DATA:" + a.add(7777) + "," + n);

//		System.out.println("REMOVING DATA:" + a.remove(0) + "," + n);
		System.out.println("POST-FIRST ADD,CHECKING DATA:" + a + "," + n);
		notifyAll();
		System.out.println("Get Done! " + n);
		System.out.println("AVAILABLE: AFTER GET " + available);

		return n;
	}

	//does not put value unless value has been read
	synchronized void put(int n) {
		System.out.println("AVAILABLE: BEFORE PUT " + available);

		System.out.println("Put: " + n);
		System.out.println("PRE-ADD,CHECKING DATA:" + a + "," + n);
		while (available == true) {
			try {
				System.out.println("Put Waiting " + n);
				wait(5000, 0);
			} catch (InterruptedException e) {
				System.out.println("Put done waiting " + n);
			}
		}

		//n has no value unless you set it to a value like here
		this.n = n;
		available = true;
		//notify consumer that value has been set
		System.out.println("Put added new value - notifyall " + n);
		System.out.println("ADDING DATA:" + a.add(6666) + "," + n);
		System.out.println("POST-SECOND ADD,CHECKING DATA :" + a + "," + n);
		notifyAll();
		System.out.println("Put done " + n);
		System.out.println("AVAILABLE: AFTER PUT " + available);

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
		//return value n from queue
		System.out.println(q.get());

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

		int i = 0;
		i = i + 1;
		q.put(i);

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
