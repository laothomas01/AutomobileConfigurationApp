package MultiThreading.TestPrograms;

public class MultiTread {
	public static void main(String[] args) throws InterruptedException {
		mySet a1 = new mySet();
		//--------------------------------
		//Sanity check on Basic ArrayList API Usage
		System.out.println("BEFORE ADD:" + a1.myElements);

		//adding elements without threads
		for (int j = 0; j < 50; j++) {
			a1.myElements.add("ASJDBASD");
		}

		System.out.println("PRE-NO-THREAD:" + a1.myElements.size());
		System.out.println(a1.myElements);

		//remove elements without threads
		for (int j = 0; j < 50; j++) {
			a1.myElements.remove(0);
		}

		System.out.println("POST-NO-THREAD:" + a1.myElements.size());
		System.out.println(a1.myElements);
		//--------------------------------

		//attempt to add into the array
		for (int j = 0; j < 50; j++) {
			threadDemo td = new threadDemo(a1);

			td.start();
		}
		System.out.println("POST ADD:" + a1.myElements);
		for (int i = 0; i < 50; i++) {
			// 1
			System.out.println(i + " LOOP REMOVE:" + a1.myElements.size());
			//@TODO: why does printing the toString of an arraylist result in a concurrency modification error?
			/**
			 * potential reasons:
			 * 1) ????
			 */
			System.out.println(a1.myElements.get(0).toString());


			//remove while we add into the array to attempt to
			//discover a problem
			// ===============
			// 2
//			System.out.println(i + " BEFORE THREAD START " + a1.myElements.size());
//			threadDemo2 td2 = new threadDemo2(a1);
//			td2.start();
			// ===============
			// 3
			//EXPECT A CONCURRENCY ERROR
			System.out.println(i + " BEFORE THREAD START " + a1.myElements.size());
			threadDemo2 td2 = new threadDemo2(a1);
//			Thread.currentThread().sleep(5000);
			td2.start();

			System.out.println(i + " " + "AFTER THREAD 2 START LOOP REMOVE:" + a1.myElements.size());
			System.out.println("------------------------------------------------");
		}
		System.out.println("LOOP REMOVE:" + a1.myElements.size());

		System.out.println("POST REMOVE:" + a1.myElements);

	}
}
