package MultiThreading;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SychronizeDifference {
	public static void main(String args[]) throws InterruptedException {
//		List<String> list = new ArrayList<>();
		List<String> list = Collections.synchronizedList(new ArrayList<>());
		//thread 1 modification to array list
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


		t2.start();
		t1.start();

		Thread.sleep(1000);
		System.out.println(list);
		/**
		 * Unsychronized function Results:
		 * run 1:
		 * [Mumbai, Punjab, Hyderabad, Chennai, Delhi, Bengaluru]
		 * run 2:
		 * [Chennai, Delhi, Bengaluru]
		 *
		 * Sychronized function results:
		 *
		 * [Mumbai, Punjab, Hyderabad, Chennai, Delhi, Bengaluru]
		 */
	}
}
