package MultiThreading.TestPrograms;

public class Hello extends Thread {

	//thread num. temp variable
	int x;
	Coffee x1;
	int threadno;

	Hello(int x, Coffee x1) {
		this.x = x;
		threadno = x;
		this.x1 = x1;
	}

	public void run() {
		//switch thread num
		switch (x) {
			case 0:
				System.out.println("Start thread " + threadno + " Get");
				break;
			case 1:
				System.out.println("Start thread " + threadno + " Put");
				break;
		}
		ops();
		System.out.println("Stopping thread " + threadno);

	}


	public void ops() {
		switch (x) {
			case 0:
				// call get thread
				x1.get();
				break;
			case 1:
				// call put thread
				x1.put(45);
				break;
		}
	}

	public static void main(String[] args) {
		Coffee c1 = new Coffee();
		//call get thread
		Hello get = new Hello(0, c1);
		//call put thread
		Hello put = new Hello(1, c1);
		get.start();
		put.start();

	}
}
