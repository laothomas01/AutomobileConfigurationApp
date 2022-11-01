package Adapter;

import Model.Automobile;
import Model.LHMAuto;

public class EditOptions extends ProxyBuildAuto implements BuildableAuto {

	{
		ba = new BuildAuto();
	}

	@Override
	public Automobile getAuto() {
		return ba.getAuto();
	}

	@Override
	public LHMAuto<Automobile> getAutos() {
		return ba.getAutoLHM();
	}
}
