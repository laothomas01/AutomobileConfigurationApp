package Adapter;

import Model.Automobile;
import Model.LHMAuto;

/**
 * API built to expose the instances of proxy automobile through the Build Auto class
 */
public interface BuildableAuto {
	LHMAuto<Automobile> getAutos();

	Automobile getAuto(String modelName);


}
