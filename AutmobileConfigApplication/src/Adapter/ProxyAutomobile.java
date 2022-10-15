package Adapter;

import Model.Automobile;


//instance of automobile class is encapsulated inside ProxyAutomobile
abstract public class ProxyAutomobile {

	//variable must be static to be able to reference it in other classes
	protected static Automobile a1;
}
