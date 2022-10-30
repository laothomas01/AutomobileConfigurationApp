package MultiThreading.TestPrograms;

//consumer thread
public class cgoofy extends Thread {
	//instance of coffee
	coffee a1;

	cgoofy(coffee e) {
		a1 = e;
	}
	public void run()
	{
		System.out.println("consumer" + a1.get());
	}
}
