package MultiThreading.TestPrograms;

public class coffee2 {
	boolean available = false;
	int contents;

	//there is nothing to get so wait on other thread
	//consumer function
	public synchronized int get() {
		while (available == false) {
			try {

				wait();
			} catch (InterruptedException e) {
				System.out.println("Done waiting to get...");
			}

		}
		available = false;
		//producer function
		// notify producer that value has been retrieved
		notifyAll();
		return contents;
	}

	//update value of contents with val
	public synchronized void put(int val) {
		while (available == true) {
			try {
				//wait for consumer to get value
				wait();
			} catch (InterruptedException e) {
				System.out.println("Done waiting to put...");
			}

		}
		//there is no value available to get
		contents = val;
		available = true;
		//notify consumer that value has been set
		notifyAll();
	}
}
