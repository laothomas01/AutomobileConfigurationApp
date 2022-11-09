package MultiThreading;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayListMultiThreading {

	/**
	 * Steps to multi-threading
	 * 1) implement runnable
	 * 2) instantiate multiple threads
	 * 3) instantiate a singular object to modify
	 * 4) test out unsychronized and sychronized functions
	 */

	public static void main(String args[]) throws InterruptedException {
		List<String> list = Collections.synchronizedList(new ArrayList<>());
		Thread t1 = new Thread(new Runnable() {

			public void run() {
				list.addAll(Arrays.asList("Chennai", "Delhi", "Bengaluru"));
			}
		});

		//thread 2 modification to array list
		Thread t2 = new Thread(new Runnable() {
			public void run() {

				list.addAll(Arrays.asList("Mumbai", "Punjab", "Hyderabad"));
			}
		});
		System.out.println(t1.getState());
		System.out.println(t2.getState());
		t1.start();
		System.out.println(t1.getState());
		System.out.println(t2.getState());
		t2.start();
		System.out.println(t1.getState());
		System.out.println(t2.getState());
		Thread.sleep(1000);
		System.out.println(t1.getState());
		System.out.println(t2.getState());
		System.out.println(list);
	}

}
