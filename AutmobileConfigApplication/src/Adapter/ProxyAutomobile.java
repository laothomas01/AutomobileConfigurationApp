package Adapter;

import Model.Automobile;
import Model.LHMAuto;

//what is the purpose of this class???
abstract public class ProxyAutomobile {

	/*
	When a variable is declared as static, then a single copy of the variable is created and shared among all objects at a class level.

	Static variables are, essentially, global variables

	All instances of the class share the same static variable.

	 */
	static protected Automobile a1;
	static protected LHMAuto<Automobile> autos;

	public abstract String getAllModels();


}
