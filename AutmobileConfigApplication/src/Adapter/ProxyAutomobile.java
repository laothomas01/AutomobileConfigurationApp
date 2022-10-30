package Adapter;

import Model.Automobile;
import Model.LHMAuto;

//what is the purpose of this class???
abstract public class ProxyAutomobile {
	/**
	 * Questions to ask when using abstract class:
	 * -are there any classes closely related to proxy automobile?
	 * no
	 */

	//variable must be static to be able to reference it in other classes
	protected static Automobile a1;
	protected static LHMAuto<Automobile> autos;
}
