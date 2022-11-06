package MultiThreading;

/*

notifyAll()

*/
class Coffee {
	boolean available = false; // indicating there nothing to get.
	// waiting on each other.
	int contents = 55;

	//consumer
	public synchronized int get() {
		System.out.println("Entering Get method " + contents);

//waiting for to get some value
		while (available == false) {
			try {
				// wait for Producer to put value
				System.out.println("Get Waiting "+ contents);
				//synchronnized wait means the thread will keep waiting until
				// something flips the switch
				wait();
			}

			//blocked state because thread is hanging.
			//no other thread will wake it up
			catch (InterruptedException e) {
				System.out.println("Get done waiting "+ contents);
			}
		}
		available = false;
		// notify Producer that value has been retrieved
		System.out.println("Get Notifyall "+ contents);
		notifyAll();
		System.out.println("Get Done! "+ contents);
		return contents;
	}

//producer

	/*

	while the get thread waits, look at the put thread

	*/
	public synchronized void put(int value) {
		System.out.println("Entering Post method "+ contents);
		while (available == true) {
			try {
				// wait for Consumer to get value
				System.out.println("Put Waiting "+ contents);
				wait();

			} catch (InterruptedException e) {
				System.out.println("Put done waiting "+ contents);

			}
		}
		contents = value;
		available = true;
		// notify Consumer that value has been set
		System.out.println("Put added new value - notifyall "+ contents);
		//wake up all threads in wake state
		notifyAll();
		System.out.println("Put done "+ contents);
	}
}