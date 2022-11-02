package Adapter;

import Model.Automobile;
import Model.LHMAuto;
import Utils.FileIO;
import Exception.Fix1to100;

import java.io.IOException;

/**
 * - Building an API to create an automobile through implementing interfaces and an Automobile instance
 * - perform CRUD on the automobile instance
 */
public class BuildAuto extends ProxyAutomobile implements CreateAuto, UpdateAuto, ReadAuto, FixAuto {


	@Override
	public void buildAuto(String fileName) throws IOException {
		FileIO io = new FileIO(fileName);
		a1 = io.loadAutomotive();
		setAutoLHM(new LHMAuto<>());
		getAutos().addAuto(a1);
	}

	/**
	 * synchronized for access to linked hashmap of automobile
	 *
	 * @return
	 */
	public synchronized LHMAuto<Automobile> getAutos() {
		return autos;
	}

	/**
	 * synchronized for access to automobile object of linked hashmap of automobile
	 *
	 * @param modelName model name look up
	 * @return cached automobile object
	 */
	public synchronized Automobile getAuto(String modelName) {
		return autos.getAuto(modelName);
	}

	public void addAuto(Automobile a1) {
		getAutos().addAuto(a1);
	}

	public void removeAuto(String modelName) {
		getAutos().removeAuto(modelName);
	}


	public void setAutoLHM(LHMAuto lhm) {
		autos = lhm;
	}


	@Override
	public void printAuto(String modelName) {
		System.out.println(getAuto(modelName));
	}

	@Override
	public void setOptnSetName(String modelName, int i, String newName) throws IOException {
		getAuto(modelName).setOptnSetName(i, newName);
	}

	@Override
	public void setOptnSetName(String modelName, String OptionSetName, String newName) {

	}

	@Override
	public void setOptnPrice(String modelName, String OptionSetName, String OptionName, float newPrice) {

	}
	// access linked hashmap of automobiles, select a valid automobile name,select the option set you want to modify
	// modify its attribute

	@Override
	public void setOptnPrice(String modelName, int i, int j, float newPrice) throws IOException {
		getAuto(modelName).setOptnPrice(i, j, newPrice);
	}

	@Override
	public void setOptnName(String modelName, int i, int j, String newName) throws IOException {
		getAuto(modelName).setOptnName(i, j, newName);
	}

	/**
	 * Loop through each automobile in linked hashmap and calculate the total price of selected options
	 *
	 * @return total price of automobile options
	 */
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
