package Adapter;

import Model.Automobile;
import Utils.FileIO;
import Exception.Fix1to100;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Scanner;

//what is the purpose of this class???
public class BuildAuto extends ProxyAutomobile implements CacheAuto,CreateAuto, UpdateAuto, FixAuto {

	//used to keep an on-going loop until all recorded exceptions are fixed
	boolean problemFixed = false;
	boolean finishedBuilding = false;


	private LinkedHashMap<String, Automobile> cacheAutos = new LinkedHashMap<>();


	//for building 1 auto

	// OR we can leveraged this method to loop through a list of fileNames and build an automobile for each
	@Override
	public void buildAuto(String fileName) throws IOException {

		FileIO io = new FileIO(fileName);
		//attempt to populate the automobile instance with data read from the text file
		a1 = io.loadAutomotive();


		/**
		 * BUILDING CAR INSTANCES WORKFLOW
		 *    - user enters the menu
		 *    - loop menu until user exits
		 *    - have text file with an array of names, prices, a number of option sets, and each option set line containing
		 *    an array of option data(this does not account for specific cars with specific parts. its pure customizable)
		 *    - when user wants to build auto, load car config data into the automobile(we only have configs for 1 right now).
		 - user will have access to that automobile instance's data
		 - when customizing, automobile instance will have a list of user's choice( we will do something with this later)
		 - when user finishes cache the automobile into a linked hashmap


		 here we will make dummy instances for now
		 */
		String choice = null;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Press [Y/N]");
			choice = sc.nextLine();
			if (choice.equalsIgnoreCase("y")) {
				System.out.println("BUILDING");

			} else if (choice.equalsIgnoreCase("N")) {
				System.out.println("BYE");
				finishedBuilding = true;
			} else {
				System.out.println("INVALID INPUT!");
			}
		}
		while (finishedBuilding == false);
////		a2 = new Automobile("Batmobile", 100000, 5);
//
//		int[] errNums = io.readArrayOfErrors("listOfErrors.txt");
//		//@TODO: convert a while-loop
//		if (!problemFixed) {
//			for (int n : errNums) {
//				fix(n);
//			}
//			//update problemFixed when no more problems are left
//			problemFixed = fix(-1);
//		}
//		addAutomobile(a1);


	}
	//for building multiple autos


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

	@Override
	public void storeAuto(Automobile a) {

	}

	@Override
	public void storeAuto(String name) {

	}
}
