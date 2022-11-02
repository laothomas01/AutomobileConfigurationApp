package Adapter;

import Model.Automobile;
import Model.LHMAuto;

//want to expose proxy auto instances through BuildAuto and an API
public interface BuildableAuto {
	LHMAuto<Automobile> getAutos();
}
