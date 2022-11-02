package Scale;

import Adapter.BuildAuto;
import Adapter.BuildableAuto;
import Model.Automobile;
import Model.LHMAuto;

/**
 * -Building an API to edit automobile options through implementing interfaces and Build Auto instance
 * -EditOptions should use synchronized methods in the Automobile class
 * should i sychronize methods in this class and why?
 * - if synchronize in EditOptions, i would have to implement O
 */
public class EditOptions implements BuildableAuto, Runnable {

	BuildAuto ba;

	public EditOptions(BuildAuto ba) {
		this.ba = ba;
	}


	//expose proxy automobile linked hashmap of automobile instance

	/**
	 * 	//required synchronized functions
	 * 	- access linked hashmap
	 * 	- access proxy auto's automobile instance via linked hashmap access and search of model name
	 * 	- access option set instance
	 * 	- access option instance
	 * 	- edit option instance attribute
	 * 	- edit entire option instance
	 *
	 */
	@Override
	public LHMAuto<Automobile> getAutos() {
		return ba.getAutos();
	}

	//synchronize
	public Automobile getAuto(String modelName) {
		return ba.getAuto(modelName);
	}



	@Override
	public void run() {
		//@TODO: add producer,consumer functionality
	}
}
