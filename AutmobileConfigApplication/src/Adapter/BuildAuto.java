package Adapter;

import Model.Automobile;
import Utils.FileIO;
import Exception.Fix1to100;

import java.io.IOException;
import java.util.LinkedHashMap;

/**
 * for constructing 1 instance of an automobile
 *
 *
 * What about multiple?
 */
public class BuildAuto extends ProxyAutomobile implements CreateAuto, UpdateAuto, FixAuto {

	//used to keep an on-going loop until all recorded exceptions are fixed
	boolean problemFixed = false;
	//building multiple automobiles
//	LinkedHashMap<String, Automobile> automobiles;

	@Override
	public void buildAuto(String fileName) throws IOException {
//		automobiles = new LinkedHashMap<>();
		FileIO io = new FileIO(fileName);
		//attempt to populate the automobile instance with data read from the text file
		a1 = io.loadAutomotive();
//		a2 = new Automobile("Batmobile", 100000, 5);

		int[] errNums = io.readArrayOfErrors("listOfErrors.txt");
		//@TODO: convert a while-loop
		if (!problemFixed) {
			for (int n : errNums) {
				fix(n);
			}
			//update problemFixed when no more problems are left
			problemFixed = fix(-1);
		}
//		addAutomobile(a1);



	}

	@Override
	public void printAuto(String modelName) {

	}


	// CRUD for automobile instances
//	public LinkedHashMap<String, Automobile> getAutomobiles() {
//		return automobiles;
//	}
//
//	public Automobile getAutomobile(String automobileName) {
//		return getAutomobiles().get(automobileName);
//	}
//
//	public void addAutomobile(Automobile a1) {
//		getAutomobiles().put(a1.getName(), a1);
//	}
//
//	public void removeAutomobile(String automobileName) {
//		getAutomobiles().remove(automobileName);
//	}
//
//	@Override
//	public void printAuto(String modelName) {
//		System.out.println(getAutomobile(modelName));
//	}
//
//	public void printAutos() {
//		for (String key : getAutomobiles().keySet()) {
//			System.out.println(getAutomobile(key).getName());
//		}
//	}

	@Override
	public void updateOptionSetName(String modelName, String OptionSetName, String newName) {
		if (a1.getName().equals(modelName)) {
			a1.updateOptionSetName(OptionSetName, newName);
		}
	}

	@Override
	public void updateOptionPrice(String modelName, String OptionSetName, String OptionName, float newPrice) {
		if (a1.getName().equals(modelName)) {
			a1.updateOptionPrice(OptionSetName, OptionName, newPrice);
		}
	}


	/**
	 * Plan of attack:
	 * - externally: loop through a fixed number of lines from the list of errors and parse the first element
	 * - funnel that error into this function and we will determine the fix to the program based on the base made in the switch statement
	 * - we will right now solve 1 error because i need to get this lab turned in, and work on SQL assignment. then backtrack to this to write cleaner code!
	 */

	//each error number is read from a .txt file and directed to a specific fix
	@Override
	public boolean fix(int errNo) throws IOException {
		Fix1to100 f1 = new Fix1to100();
		switch (errNo) {
			case 0:
				f1.fixMissingPriceFromTextFile();
				break;
			default:
				break;
		}
		return true;

	}
}
