package Scale;

import Adapter.ProxyAutomobile;
import Model.Automobile;

import java.io.IOException;

/**
 * Purpose of the class:
 * - to learn how multi-threading works
 * - synchronized functions and multi-thread access
 * - to update the automobile's configurations
 */
public class EditOptions extends ProxyAutomobile implements Runnable {
	public Thread t;
	private Automobile auto;
	private boolean DEBUG = true;
	private String modelName;
	private String[] args;
	private int operation;

	public EditOptions(String modelName, int operation, String[] args)
			throws InterruptedException {
		this.modelName = modelName;
		this.operation = operation;
		this.args = args;
		//instantiate new thread inside edit options instance
		this.t = new Thread(this);
		//access linked hash map using get function
		this.auto = autos.getAuto(modelName);
	}

	public Automobile getAuto() {
		return this.auto;
	}

	public void setModelName(String n) {
		this.modelName = n;
	}

	public void setOperation(int o) {
		this.operation = o;
	}

	public void setArgs(String[] arr) {
		this.args = arr;
	}

	public void setAuto(Automobile a1) {
		this.auto = a1;
	}

	@Override
	public void run() {
		try {
			ops();
		} catch (IOException e) {
			throw new RuntimeException(e);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	public void start() {
		t.start();
	}

	//operations for automobile option name modification
	public void ops() throws IOException, InterruptedException {
		System.out.println("ID:" + t.getId());
		System.out.println("STATE:" + t.getState());
		Helper h = new Helper();
		switch (operation) {
			case 0:
				h.non_synchEditOptionName("Colors", "Blue", args[0]);
				break;
			case 1:
				h.non_synchEditOptionName("Colors", "Blue", args[1]);
				break;
			case 2:
				h.synchEditOptionName("Colors", "Blue", args[2]);
				break;
			case 3:
				h.synchEditOptionName("Colors", "Blue", args[3]);
				break;
		}

	}

	@Override
	public String getAllModels() {
		return "";
	}


	class Helper {
		void non_synchEditOptionName(String optnSetName, String optnName, String newName) throws IOException {
			auto.updateOptnName(optnSetName, optnName, newName);
			System.out.println(getAuto());
		}

		synchronized void synchEditOptionName(String optnSetName, String optnName, String newName) throws IOException {
			auto.updateOptnName(optnSetName, optnName, newName);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println(e);
			}
			System.out.println(t.getId() + " Finished Editing!" + getAuto());
		}
	}
}


