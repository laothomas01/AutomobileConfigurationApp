package Adapter;

import Model.Automobile;
import Model.LHMAuto;

public class EditOptions implements BuildableAuto {

	BuildAuto ba;

	public EditOptions(BuildAuto ba) {
		this.ba = ba;
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
