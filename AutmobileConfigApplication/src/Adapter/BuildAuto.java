package Adapter;

import Model.Automobile;
import Model.LHMAuto;
import Utils.FileIO;
import Exception.Fix1to100;

import java.io.IOException;


public class BuildAuto extends ProxyAutomobile implements CreateAuto, UpdateAuto, ReadAuto, FixAuto {


	@Override
	public void buildAuto(String fileName) throws IOException {
		FileIO io = new FileIO(fileName);
		a1 = io.loadAutomotive();
		setAutoLHM(new LHMAuto<>());
	}

	//an Automobile linked hashmap
	public LHMAuto<Automobile> getAutoLHM() {
		return autos;
	}

	//get an Automobile
	public Automobile getAuto() {
		return a1;
	}

	public void setAutoLHM(LHMAuto lhm) {
		autos = lhm;
	}


	@Override
	public void printAuto(String modelName) {
		System.out.println(autos.getAuto(modelName));
	}


	@Override
	public void updateOptnSetName(String modelName, String OptionSetName, String newName) {
	}

	@Override
	public void updateOptnPrice(String modelName, String OptionSetName, String OptionName, float newPrice) {

	}

	@Override
	public float getTotalPrice() {
		return a1.getTotalPrice();
	}


	@Override
	public void addOptnChoice(String optSetName, String optionName) {

	}

	@Override
	public void addOptnChoice(int i, int j) throws IOException {
		a1.addOptionChoice(i, j);
	}


	@Override
	public void removeOptnChoice(int i) {
		a1.removeOptionChoice(i);
	}

	@Override
	public void setOptnChoice(int i, int j) throws IOException {
		a1.setOptnChoice(i, j);
	}

	@Override
	public void setOptnChoice(String optSetName, String optionName) {

	}

	@Override
	public void printOptionChoices() {
		System.out.println(a1.getOptnChoice().toString());
	}

	/**
	 * catch 5 errors, fix 1
	 *
	 * @param errNo logged error number
	 * @return
	 * @throws IOException
	 */
	@Override
	public boolean fix(int errNo) throws IOException {
		Fix1to100 f1 = new Fix1to100();
		switch (errNo) {
			case 0:
				break;
			case 1:
				f1.fixMissingPriceFromTextFile();
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;

			default:
				break;
		}
		return true;
	}


}
