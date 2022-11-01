package Adapter;

import Model.Automobile;
import Model.LHMAuto;

public interface BuildableAuto {
	Automobile getAuto();

	LHMAuto<Automobile> getAutos();
}
