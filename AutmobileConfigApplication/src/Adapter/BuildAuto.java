package Adapter;

import Model.Automobile;
import Model.LHMAuto;
import Utils.FileIO;

import java.io.IOException;

/**
 * API for our car configuration app
 * Methods we want to expose to users.
 * Requirements:
 * 1) CRUD for automobile
 * total price
 * option choices
 * 2) CRUD for automobile option sets
 * 3) CRUD for automobile options
 */

public class BuildAuto extends ProxyAutomobile implements CreateAuto, UpdateAuto, ReadAuto {

	@Override
	public void buildAuto(String fileName) throws IOException {
		FileIO io = new FileIO(fileName);
		lhm = new LHMAuto<>();
		a1 = io.loadAutomotive();
		a1.setMaker("Ford");
		a1.setYear(2000);

//		a1 = new Automobile("FordWagonZTW", 100000, 5);
//		a1.setMaker("Ford");
//		a1.setYear(2000);
////		a1 = io.loadAutomotive();
////		a1.setOptnSetName(0, "Transmission");
//		a1.setOptnSet(0, "Transmission", 2);
//		a1.setOptn(0, 0, "Auto", 0);
//		a1.setOptn(0, 1, "Manual", 100);
//
////		a1.setOptn(0, 0, "Auto", 100);
////		a1.setOptn(0, 1, "Manual", 0);
		lhm.addAuto(a1);
	}

	@Override
	public void printAuto(String modelName) {
		System.out.println(lhm.getAuto(modelName));
//		System.out.println(lhm.getAuto(modelName).getOptnSet(0));
//		System.out.println(lhm.getAuto(modelName).getOptn(0, 0));
//		System.out.println(lhm.getAuto(modelName).getOptn(0, 1));
//		System.out.println(lhm.getAuto(modelName).getOptnPrice(0, 1));

	}

	@Override
	public void updateOptionSetName(String modelName, String OptionSetName, String newName) {

	}

	@Override
	public void updateOptionPrice(String modelName, String OptionSetName, String OptionName, float newPrice) {

	}

	@Override
	public void addOptionChoice(String optSetName, String option) {

	}


	//@TODO: provide exception handling
	public void addOptionChoice(int i, int j) {
		a1.addOptionChoice(a1.getOptn(i, j));
	}

	@Override
	public void removeOptionChoice(int i) {
		a1.removeOptionChoce(i);
	}


	@Override
	public float getTotalPrice() {
		return a1.getTotalPrice();
	}

	@Override
	public void printOptionChoices() {
		System.out.println(a1.getOptionChoiceList().toString());
	}


//	//used to keep an on-going loop until all recorded exceptions are fixed
//	//used to cache any built automobile by the user
////	LinkedHashMap<String, Automobile> cacheAutos;
//
//	//for building 1 auto
//
//	// OR we can leveraged this method to loop through a list of fileNames and build an automobile for each
////	LinkedHashMap<String, Automobile> cacheAutos = new LinkedHashMap<>();
//
//	/**
//	 * We will use this once we understand the logic of our system
//	 *
//	 * @param fileName
//	 * @throws IOException
//	 */
//
//	@Override
//	public void buildAuto(String fileName) throws IOException {
//		FileIO io = new FileIO(fileName);
//		//populate a1 with all its car configurations(we do not have more configurations for more cars. lets just hardcode this)
//
//
////		a1 = io.loadAutomotive();
//		a1 = new Automobile("FordWagonZTW", 100000, 5);
//		printAuto(a1.getName());
//
//		/**
//		 * 1) Load in 1 car
//		 * 2) allow user to select car options
//		 * 3) return car's price
//		 */
//
////		Random rand = new Random();
////		String[] testCarNames = {"Abarth", "Alfa Romeo", "Aston Martin", "Audi", "Bentley", "BMW", "Bugatti", "Cadillac", "Chevrolet", "Chrysler", "Citroën", "Dacia", "Daewoo", "Daihatsu", "Dodge", "Donkervoort", "DS", "Ferrari", "Fiat", "Fisker", "Ford", "Honda", "Hummer", "Hyundai", "Infiniti", "Iveco", "Jaguar", "Jeep", "Kia", "KTM", "Lada", "Lamborghini", "Lancia", "Land Rover", "Landwind", "Lexus", "Lotus", "Maserati", "Maybach", "Mazda", "McLaren", "Mercedes-Benz", "MG", "Mini", "Mitsubishi", "Morgan", "Nissan", "Opel", "Peugeot", "Porsche", "Renault", "Rolls-Royce", "Rover", "Saab", "Seat", "Skoda", "Smart", "SsangYong", "Subaru", "Suzuki", "Tesla", "Toyota", "Volkswagen", "Volvo"};
////
////
////		boolean finishedBuilding = false;
//////		do {
////		System.out.println("BEGIN BUILDING");
////		int randInt = rand.nextInt(testCarNames.length - 0) + 0;
////		float randBasePrices = rand.nextFloat() * (100000f - 50000f) + 50000f;
////
////
////		//load in option set data for a generated automobile instance
////		a1 = io.loadAutomobileOptionSets();
////		//load in a random name
////		a1.setName(testCarNames[randInt]);
////		//load in a random price
////		a1.setBasePrice(randBasePrices);
//
//
//		//cache car when finished building
////		}
////		while (finishedBuilding == false);
//
//		/**
//		 //		 * BUILDING CAR INSTANCES WORKFLOW
//		 //		 *    - user enters the menu
//		 //		 *    - loop menu until user exits
//		 //		 *    - have text file with an array of names, prices, a number of option sets, and each option set line containing
//		 //		 *    an array of option data(this does not account for specific cars with specific parts. its pure customizable)
//		 //		 *    - when user wants to build auto, load car config data into the automobile(we only have configs for 1 right now).
//		 //		 - user will have access to that automobile instance's data
//		 //		 - when customizing, automobile instance will have a list of user's choice( we will do something with this later)
//		 //		 - when user finishes cache the automobile into a linked hashmap
//		 //
//		 //
//		 //		 here we will make dummy instances for now
//		 //
//
//
//		 1) load in all cars with their respective configurations
//		 2) have user enter a pseudo-menu system where user can select car options
//		 -going to have to display all the available car options per car configuration for user to select
//		 3) per car, cache those selection options: make sure to store their prices for later usage
//		 4)
//		 */
//
//		//we will load in 10 more cars for user to build
////		for (int i = 0; i < 10; i++) {
////			int randInt = rand.nextInt(testCarNames.length - 0) + 0;
////			//handle collisons
////			if (cacheAutos.containsKey(testCarNames[randInt])) {
////				cacheAutos.put(testCarNames[randInt], cacheAutos.get(testCarNames[randInt]));
////			} else {
////				//put in a new car name and automobile instance
////				Automobile a = io.loadAutomobileOptionSets();
////				a.setName(testCarNames[randInt]);
////				a.setBasePrice(rand.nextFloat() * (100000f - 50000f) + 50000f);
////				cacheAutos.put(a.getName(), a);
////			}
////		}
//
//		//TAKING USER INPUT
//
////		String choice = null;
////		Scanner sc = new Scanner(System.in);
////		do {
////			System.out.println("BUILDING AUTOMOBILE:");
////			System.out.println("Press [Y/N]");
////			choice = sc.nextLine();
////			if (choice.equalsIgnoreCase("y")) {
////				int randInt = rand.nextInt(testCarNames.length - 0) + 0;
////				//handle collisons
////				if (cacheAutos.containsKey(testCarNames[randInt])) {
////					cacheAutos.put(testCarNames[randInt], cacheAutos.get(testCarNames[randInt]));
////				} else {
////					//put in a new car name and automobile instance
////					Automobile a = io.loadAutomobileOptionSets();
////					a.setName(testCarNames[randInt]);
////					a.setBasePrice(rand.nextFloat() * (100000f - 50000f) + 50000f);
////					cacheAutos.put(a.getName(), a);
////				}
////			} else if (choice.equalsIgnoreCase("n")) {
////				System.out.println("SAVED AUTOMOBILES");
////				System.out.println("BYE");
////				finishedBuilding = true;
////			} else {
////				System.out.println("INVALID INPUT!");
////			}
////		} while (finishedBuilding == false);
//
//		//PRINTING CACHED AUTOS
////		for (String s : testCarNames) {
////			if (cacheAutos.containsKey(s)) {
////				System.out.println(cacheAutos.get(s).toString());
////			}
////		}
//
//		//ERROR HANDLING
////		int[] errNums = io.readArrayOfErrors("listOfErrors.txt");
////		//@TODO: convert a while-loop
////		if (!problemFixed) {
////			for (int n : errNums) {
////				fix(n);
////			}
////			//update problemFixed when no more problems are left
////			problemFixed = fix(-1);
////		}
//
//
//	}
//	//for building multiple autos
//
//	//test build auto class with randomized data
////	public void buildAuto() {
////		String fileNames = "CarConfigs.txt";
////		Random rand = new Random();
////		String[] testCarNames = {"Abarth", "Alfa Romeo", "Aston Martin", "Audi", "Bentley", "BMW", "Bugatti", "Cadillac", "Chevrolet", "Chrysler", "Citroën", "Dacia", "Daewoo", "Daihatsu", "Dodge", "Donkervoort", "DS", "Ferrari", "Fiat", "Fisker", "Ford", "Honda", "Hummer", "Hyundai", "Infiniti", "Iveco", "Jaguar", "Jeep", "Kia", "KTM", "Lada", "Lamborghini", "Lancia", "Land Rover", "Landwind", "Lexus", "Lotus", "Maserati", "Maybach", "Mazda", "McLaren", "Mercedes-Benz", "MG", "Mini", "Mitsubishi", "Morgan", "Nissan", "Opel", "Peugeot", "Porsche", "Renault", "Rolls-Royce", "Rover", "Saab", "Seat", "Skoda", "Smart", "SsangYong", "Subaru", "Suzuki", "Tesla", "Toyota", "Volkswagen", "Volvo"};
////		int randInt = rand.nextInt(testCarNames.length - 0) + 0;
////		float basePrices = rand.nextFloat() * (100000f - 50000f) + 50000f;
////
////	}
//
//	@Override
//	public void printAuto(String modelName) {
//		System.out.println(modelName);
////        System.out.println(cacheAutos.get(modelName));
//	}
//
//
//	// CRUD for automobile instances
////	public LinkedHashMap<String, Automobile> getCacheAutos() {
////		return cacheAutos;
////	}
//
////	public Automobile getAutomobile(String name) {
////		return getCacheAutos().get(name);
////	}
////
////	public void removeAutomobile(String name) {
////		getCacheAutos().remove(name);
////	}
////
//
//
////	@Override
////	public void updateOptionSetName(String modelName, String OptionSetName, String newName) {
//////		if (a1.getName().equals(modelName)) {
//////			a1.updateOptionSetName(OptionSetName, newName);
//////		}
////	}
////
////	@Override
////	public void updateOptionPrice(String modelName, String OptionSetName, String OptionName, float newPrice) {
//////		if (a1.getName().equals(modelName)) {
//////			a1.updateOptionPrice(OptionSetName, OptionName, newPrice);
//////		}
////	}
////
////
////	/**
////	 * Plan of attack:
////	 * - externally: loop through a fixed number of lines from the list of errors and parse the first element
////	 * - funnel that error into this function and we will determine the fix to the program based on the base made in the switch statement
////	 * - we will right now solve 1 error because i need to get this lab turned in, and work on SQL assignment. then backtrack to this to write cleaner code!
////	 */
////
////	//each error number is read from a .txt file and directed to a specific fix
////	@Override
////	public boolean fix(int errNo) throws IOException {
////		Fix1to100 f1 = new Fix1to100();
////		switch (errNo) {
////			case 0:
////				f1.fixMissingPriceFromTextFile();
////				break;
////			default:
////				break;
////		}
////		return true;
////	}


}
