package Scale;

import Adapter.BuildAuto;
import Adapter.BuildableAuto;
import Adapter.UpdateAuto;
import Model.Automobile;
import Model.LHMAuto;

import java.io.IOException;

/**
 * -Building an API to edit automobile options through implementing interfaces and Build Auto instance
 * -EditOptions should use synchronized methods in the Automobile class
 * - should i sychronize methods in this class and why?
 * - if synchronize in EditOptions, i would have to implement O
 */
public class EditOptions implements BuildableAuto, Runnable {
	BuildAuto ba;
	boolean available;

	public EditOptions(BuildAuto ba) {
		this.ba = ba;
		available = true;
		new Thread(this, "Edit Options").start();
	}

	//expose proxy automobile linked hashmap of automobile instance

	/**
	 * //required synchronized functions
	 * [x] access linked hashmap
	 * [x] access proxy auto's automobile instance via linked hashmap access and search of model name
	 * [x] access option set instance
	 * [x] access option instance
	 * [x] edit option instance attribute
	 * [ ] lock down objects during multi-threading
	 */

	@Override
	public synchronized LHMAuto<Automobile> getAutos() {
		return ba.getAutos();
	}

	/**
	 * Synchronized for multi-threading
	 *
	 * @param modelName automobile name
	 * @return an automobile object
	 */
	@Override
	//synchronize
	public synchronized Automobile getAuto(String modelName) {
		//proxyauto automobile instance can only be accessed through linked hash map and through a valid model name
		while (available == false) {
			try {
				System.out.println("Get Auto waiting!");
				wait();
			} catch (InterruptedException e) {
				System.out.println("Get Auto done waiting!");
			}
		}


		return getAutos().getAuto(modelName);
	}

	public synchronized void editOptionName(String modelName, int i, int j, String newName) throws IOException {
//		ba.getAuto(modelName).setOptnName(i, j, newName);
		getAuto(modelName).setOptnName(i, j, newName);
	}

	public synchronized void editOptionPrice(String modelName, int i, int j, float newPrice) throws IOException {
//		ba.getAuto(modelName).setOptnPrice(i, j, newPrice);
		getAuto(modelName).setOptnPrice(i, j, newPrice);
	}

	public synchronized void editOption(String modelName, int i, int j, String newName, float newPrice) throws IOException {
//		ba.getAuto(modelName).setOptn(i, j, newName, newPrice);
		getAuto(modelName).setOptn(i, j, newName, newPrice);
	}


	@Override
	public void run() {
		//@TODO: add producer,consumer functionality
		// gets the name of current thread
		System.out.println("Current Thread Name: " + Thread.currentThread().getName());

		// gets the ID of the current thread
		System.out.println("Current Thread ID: " + Thread.currentThread().getId());


	}


}



