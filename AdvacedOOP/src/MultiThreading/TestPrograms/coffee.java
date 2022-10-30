package MultiThreading.TestPrograms;

public class coffee {
	boolean available = false;
	int contents;

	//indicating there nothing to get
	//waiting on each other
	//consumer function: returns a value if there exists one
	public synchronized int get() {
		while (available == false) {
			try {
				//wait for producer to put value
				wait();
			} catch (InterruptedException e) {

			}
		}
		available = false;
		//notify producer that value has been retrieved
		notifyAll();
		return contents;
	}

	//produce function: inputs a value if there is no thread with value to return
	public synchronized void put(int val) {
		while (available == true) {
			try {
				//wait for consumer to get value
				wait();
			} catch (InterruptedException e) {

			}
		}
		contents = val;
		available = true;
		//notify Consumer that value has been set
		notifyAll();
	}
}

