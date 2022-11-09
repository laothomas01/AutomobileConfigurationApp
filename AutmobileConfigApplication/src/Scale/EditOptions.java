package Scale;

import Adapter.BuildAuto;
import Adapter.BuildableAuto;
import Adapter.ProxyAutomobile;
import Adapter.UpdateAuto;
import Model.Automobile;
import Model.LHMAuto;

import java.io.IOException;

/**
 * -Building an API to edit automobile options through implementing interfaces and Build Auto instance
 * -EditOptions should use synchronized methods in the Automobile class
 * - should i sychronize methods in this class and why?
 * - if synchronize in EditOptions, i would have to implement O
 * using synchronized functions:
 * - locks current object
 * - object contains sychronized functions
 * - don't care about sychronization of nested functions
 * /**
 */

//VERSION 1
//public class EditOptions implements BuildableAuto {
//
//
//	BuildAuto ba;
//	//wil need to place somewhere else
//	boolean available;
//
//	int n;
//	String testing;
//
//	/**
//	 * consumer = getAuto
//	 * producer = editAuto
//	 *
//	 * @param ba
//	 */
//	public EditOptions(BuildAuto ba) {
//		this.ba = ba;
//		available = false;
//		n = 0;
//	}
//
//	//expose proxy automobile linked hashmap of automobile instance
//
//	/**
//	 * //required synchronized functions
//	 * [x] access linked hashmap
//	 * [x] access proxy auto's automobile instance via linked hashmap access and search of model name
//	 * [x] access option set instance
//	 * [x] access option instance
//	 * [x] edit option instance attribute
//	 * [ ] lock down objects during multi-threading
//	 */
//
//	@Override
//	public synchronized LHMAuto<Automobile> getAutos() {
//		return ba.getAutos();
//	}
//
//	/**
//	 * Synchronized for multi-threading
//	 *
//	 * @param modelName automobile name
//	 * @return an automobile object
//	 */
//
//
//	//consumer
//	@Override
//	//synchronize
//
//	//retrieves an automobile after editing
//	public synchronized Automobile getAuto(String modelName) {
//		System.out.println("BEGIN GET");
//		System.out.println("AVAILABILITY:" + available);
//		//lock down object access during getting and editing process
//		while (available == false) {
//			try {
//				System.out.println("Waiting to get Automobile......");
//				wait();
//			} catch (InterruptedException e) {
//				System.out.println("Waiting to get Automobile done");
//			}
//		}
//		available = false;
//		n += 1;
//		testing = "testing" + " " + n;
//		notify();
//		System.out.println("FINISHED RETRIEVING AUTOMOBILE!");
//		System.out.println("AVAILABILITY:" + available);
//
//		return ba.getAuto(modelName);
//	}
//
//	//producer
//
//
//	public synchronized void editOptionName(String modelName, int i, int j, String newName) throws IOException {
//		System.out.println("BEGIN EDITING");
//		System.out.println("AVAILABILITY:" + available);
//
//		while (available == true) {
//			try {
//				System.out.println("Waiting to edit Automobile......");
//				wait();
//			} catch (InterruptedException e) {
//				System.out.println("Waiting to edit Automobile done");
//			}
//		}
//
//		available = true;
//		n += 1;
//		testing = "testing" + " " + n;
//		notify();
//		ba.getAuto(modelName).setOptnName(i, j, newName);
//		System.out.println("FINISHED EDITING AUTOMOBILE OPTION NAME!");
//		System.out.println("AVAILABILITY:" + available);
//
//	}
//
//	public synchronized void editOptionPrice(String modelName, int i, int j, float newPrice) throws IOException {
//
//		System.out.println("AVAILABILITY:" + available);
//
//		while (available == true) {
//			try {
//				System.out.println("Waiting to edit Automobile......");
//				wait();
//			} catch (InterruptedException e) {
//				System.out.println("Waiting to edit Automobile done");
//			}
//		}
//		available = true;
//		n += 1;
//		testing = "testing" + " " + n;
//		notifyAll();
//		ba.getAuto(modelName).setOptnPrice(i, j, newPrice);
//		System.out.println("FINISHED EDITING AUTOMOBILE OPTION PRICE!");
//	}
//
//	/**
//	 * sychronized for multi-threading
//	 *
//	 * @param modelName modelName
//	 * @param i         optionSetIndex
//	 * @param j         optionIndex
//	 * @param newName   new Option Name
//	 * @param newPrice  new Option Price
//	 * @throws IOException
//	 */
//	public synchronized void editOption(String modelName, int i, int j, String newName, float newPrice) throws IOException {
//
//		System.out.println("AVAILABILITY:" + available);
//
//		while (available == true) {
//			try {
//				System.out.println("Waiting to edit Automobile......");
//				wait();
//			} catch (InterruptedException e) {
//				System.out.println("Waiting to edit Automobile done");
//			}
//		}
//
//		available = true;
//		n += 1;
//		testing = "testing" + " " + n;
//		notifyAll();
//		ba.getAuto(modelName).setOptn(i, j, newName, newPrice);
//		System.out.println("FINISHED EDITING AUTOMOBILE OPTION!");
//	}
//
////	@Override
////	public void run() {
////		//	 gets the name of current thread
////		float a = 0;
////		System.out.println("Current Thread Name: " + Thread.currentThread().getName());
////		// gets the ID of the current thread
////		System.out.println("Current Thread ID: " + Thread.currentThread().getId());
////		String modelName = "FordWagonZTW";
////		for (int i = 0; i < 10; i++) {
////			System.out.println(getAuto(modelName));
////			try {
////				editOptionName(modelName, 0, 0, testing);
////			} catch (IOException e) {
////				throw new RuntimeException(e);
////			}
////			System.out.println(getAuto(modelName));
////			try {
////				a += 1;
////				editOptionPrice(modelName, 0, 0, a);
////			} catch (IOException e) {
////				throw new RuntimeException(e);
////			}
////		}
////	}
//
//	public class Consumer implements Runnable {
//		EditOptions eo;
//
//		public Consumer(EditOptions eo) {
//			this.eo = eo;
//			new Thread(this, "Get Auto").start();
//		}
//
//		@Override
//		public void run() {
//			System.out.println("CONSUMER:" +
//			                   " Current Thread Name: " + Thread.currentThread().getName() + "" +
//			                   "Current Thread ID: " + Thread.currentThread().getId());
//
//			// gets the ID of the current thread
//			System.out.println("Current Thread ID: " + Thread.currentThread().getId());
//			System.out.println(eo.getAuto("FordWagonZTW"));
//		}
//	}
//
//	public class Producer implements Runnable {
//		EditOptions eo;
//		String modelName = "FordWagonZTW";
//
//		public Producer(EditOptions eo) {
//			this.eo = eo;
//			new Thread(this, "Edit Auto").start();
//		}
//
//		@Override
//		public void run() {
//			System.out.println("PRODUCER:" +
//			                   " Current Thread Name: " + Thread.currentThread().getName() +
//			                   "Current Thread ID: " + Thread.currentThread().getId());
//			// gets the ID of the current thread
//			System.out.println();
//			try {
//				eo.editOptionName(modelName, 0, 0, "OPTIONSET:" + "a" + Math.random());
//			} catch (IOException e) {
//				throw new RuntimeException(e);
//			}
//
//		}
//	}
//}


//VERSION 2

//simplify your approach
//HELLO
public class EditOptions
		//gives me automatic access to linked hash map
		extends ProxyAutomobile implements Runnable {
	//instantiate thread per edit options instance
	/**
	 * We will be creating multiple threads from within this one EditOptions class instance
	 */
	private Thread t;
	private Automobile auto;
	private boolean DEBUG = true;
	private String modelName;
	//string arguments
	private String[] args;
	//operation number
	private int operation;

	//	/**
//	 * @param modelName automobile model name
//	 * @param operation synchronized and un-synchronized function number
//	 * @param args      array of strings used to
//	 */
	public EditOptions(String modelName, int operation, String[] args) {
		setModelName(modelName);
		setOperation(operation);
		setArgs(args);
		setAuto(autos.getAuto(modelName));
	}

	public Automobile getAuto() {
		return this.auto;
	}

	public void setAuto(Automobile a) {
		this.auto = a;
	}

	public String getModelName() {
		return modelName;
	}

	public int getOperation() {
		return operation;
	}

	public String[] getArgs() {
		return args;
	}

	public void setArgs(String[] args) {
		this.args = args;
	}

	public void setModelName(String name) {
		this.modelName = name;
	}

	public void setOperation(int o) {
		this.operation = o;
	}

	//select 1 method to run per thread
	@Override
	public void run() {
//		try {
//			switch (operation) {
//				case 0:
//					System.out.println("THREAD ID:" + Thread.currentThread().getId());
//					System.out.println("THREAD STATE:" + Thread.currentThread().getState());
//					break;
//				case 1:
//					System.out.println("THREAD ID:" + Thread.currentThread().getId());
//					System.out.println("THREAD STATE:" + Thread.currentThread().getState());
//					break;
//				case 2:
//					System.out.println("THREAD ID:" + Thread.currentThread().getId());
//					System.out.println("THREAD STATE:" + Thread.currentThread().getState());
//					break;
//				case 3:
//					System.out.println("THREAD ID:" + Thread.currentThread().getId());
//					System.out.println("THREAD STATE:" + Thread.currentThread().getState());
//					break;
//			}
		try {
			ops();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
//			System.out.println("Stopping thread " + Thread.currentThread().getId());
//		} catch (IOException e) {
//			throw new RuntimeException(e);
//		}
	}

	// we need multiple threads editing a singular object
	//dont want to instantiate thread in just edit options class becuase that is
	// bad implementation

	/**
	 * -multiple calls to editThread should update the value of the edit options instance
	 * -instantiate a new thread with each new edit Thread call
	 * - each new thhread should operate on the same edit option instance
	 */
	public void threadStart() {
		this.t = new Thread(this);
		t.start();
	}

	public void ops() throws IOException {
		Helper h = new Helper(); //add synchronized/non sychronized methods here
		switch (operation) {
			case 0:
				h.set("Colors", "Blue", "Yellow");
				h.get();
				break;
			case 1:
				h.set("Colors", "Blue", "Green");
				h.get();
				break;
//			case 0:
//				if (!auto.getOptnName(0, 0).equals("Green")) {
//					System.out.println("CANNOT EDIT!");
//					System.out.println("CURRENT OPTION NAME:" + auto.getOptnName(0, 0));
//				} else {
//					System.out.println("MATCHED OPTION NAME!");
//					auto.setOptnName(0, 0, "Green");
//				}
////				h.unsynchedEditOptionName("Colors", "Blue", "Green");
//				break;
//			case 1:
//				if (!auto.getOptnName(0, 0).equals("Yellow")) {
//					System.out.println("CANNOT EDIT!");
//					System.out.println("CURRENT OPTION NAME:" + auto.getOptnName(0, 0));
//				} else {
//					System.out.println("MATCHED OPTION NAME!");
//					auto.setOptnName(0, 0, "Yellow");
//				}
//				h.unsynchedEditOptionName("Colors", "Blue", "Yellow");
		}


	}


	//inner class for sake of easier member access
	class Helper {
		public void set

				(String optionSetName, String optionName, String newName)

				throws IOException {
			auto.setOptnName(optionSetName, optionName, newName);
		}

		public void get
				()
				throws IOException {
			System.out.println(auto.getOptnSet("Colors"));
		}


//		public synchronized Automobile getAutomobile() {
//			System.out.println("ENTER GET AUTO METHOD");
//			//when object is locked down, unlock it and return automobile instance
//			while (DEBUG == true) {
//				try {
//					System.out.println(Thread.currentThread().getId() + " WAITING TO GET ");
//					wait();
//				}
//				//blocked state because thread is hanging.
//				//no other thread will wake it up
//				catch (InterruptedException e) {
//					System.out.println(Thread.currentThread().getId() + " GET DONE WAITING");
//				}
//			}
//			DEBUG = true;
//			System.out.println("GET NOTIFY ALL");
//			notifyAll();
//			System.out.println("GET DONE!");
//			return auto;
//		}

		public synchronized void synchedEditOptionName(String optionSetName, String optionName, String newName) throws IOException {
			//currently object is unlocked
			//DEBUG = true
			//locking down the object and waiting until DEBUG = true
			//base case
			//immediately lock down the object if unlocked so other threads cannot access
			//perform option name edit
			//if DEBUG = true, unlock it
			//tell all waiting threads DEBUG = false
			auto.setOptnName(optionSetName, optionName, newName);
			System.out.println("FINISHED EDITING!");
		}

	}

}


