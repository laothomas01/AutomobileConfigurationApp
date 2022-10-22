package Driver;

import Adapter.BuildAuto;
import Model.Automobile;
import Utils.FileIO;

import java.io.*;
import java.util.Random;

import Exception.AutoException;


public class CarConfigApplication {

	public static void main(String args[]) throws IOException, AutoException {
		/**
		 * Handling multiple autos
		 * - linked hashmap inside proxy auto
		 * - use generics to store any child of automotive
		 * - write two methods: 1 to make a choice and 1 to calculate total price
		 * -do everything through interfaces
		 * -have two choice arraylists (storing option instances)
		 * to see the levels of look up
		 * - create custom template for linked hashmap
		 * -
		 */
		Lab3Test();
	}


	public static void Lab3Test() throws IOException {


		//.txt file to read from using FileIO instance
		String configurationFile = "CarConfigs.txt";
		//instantiate BuildAuto
		BuildAuto auto = new BuildAuto();

		auto.buildAuto(configurationFile);
		auto.printAuto("FordWagonZTW");

//		auto.addOptionChoice(0, 0);
//		auto.addOptionChoice(0, 0);
//		auto.printAuto("FordWagonZTW");
//		auto.printOptionChoices();
		//1 problem is only fixed
//		auto.buildAuto(configurationFile);
		//TAKING USER INPUT
		boolean finishedBuilding = false;
//		String choice = null;
//		Scanner sc = new Scanner(System.in);
//		do {
//			System.out.println("BUILDING AUTOMOBILE:");
//			System.out.println("Press [Y/N]");
//			choice = sc.nextLine();
//			if (choice.equalsIgnoreCase("y")) {
//				int randInt = rand.nextInt(testCarNames.length - 0) + 0;
//				//handle collisons
//				if (cacheAutos.containsKey(testCarNames[randInt])) {
//					cacheAutos.put(testCarNames[randInt], cacheAutos.get(testCarNames[randInt]));
//				} else {
//					//put in a new car name and automobile instance
//					Automobile a = io.loadAutomobileOptionSets();
//					a.setName(testCarNames[randInt]);
//					a.setBasePrice(rand.nextFloat() * (100000f - 50000f) + 50000f);
//					cacheAutos.put(a.getName(), a);
//				}
//			} else if (choice.equalsIgnoreCase("n")) {
//				System.out.println("SAVED AUTOMOBILES");
//				System.out.println("BYE");
//				finishedBuilding = true;
//			} else {
//				System.out.println("INVALID INPUT!");
//			}
//		} while (finishedBuilding == false);
	}

	/**
	 * Make sure to malform the carconfigs.txt's price and see the change
	 *
	 * @throws IOException
	 */
	public static void Lab2Test() throws IOException {
//		//.txt file to read from using FileIO instance
//		String configurationFile = "CarConfigs.txt";
//		//instantiate BuildAuto
//		BuildAuto auto = new BuildAuto();
//		//1 problem is only fixed
//		auto.buildAuto(configurationFile);
	}

	public void Lab1Test() throws IOException {

//		String configurationFile = "CarConfigs.txt";
//		FileIO io = new FileIO(configurationFile);
//		String serializedFile = "Car.dat";
//		Automobile car = io.loadAutomotive();
//		System.out.print("PRINTING BEFORE SERIALIZATION:\n" + car);
//		System.out.println();
//		io.serializeAutomotive(serializedFile, car);
//		System.out.println();
//
//
//		car = io.deserializeAutomotive(serializedFile);
//		System.out.println("PRINTING AFTER DESERIALIZATION:");
//		System.out.println(car);
//		System.out.println();
//
//
//		System.out.println("PERFORMING OPTION SET READING!");
//		System.out.println(car.getOptionSetName(0));
//		System.out.println(car.getOptionSetClassInstance(0));
//		System.out.println("PERFORMING OPTION READING!");
//		System.out.println(car.getOptionName(0, 0));
//		System.out.println(car.getOptionName(0, 1));
//		System.out.println(car.getOptionPrice(0, 0));
//		System.out.println(car.getOptionPrice(0, 1));
//		System.out.println(car.getOptionClassInstance(0, 0));
//		System.out.println(car.getOptionClassInstance(0, 1));
//		System.out.println();
//
//		System.out.println("PERFORMING OPTION SET DELETION!");
//		car.deleteOptionSetInstance(0);
//		System.out.println("CONFIRMING DELETION!");
//		System.out.println("RESULT:");
//		System.out.println(car);
//		System.out.println();
//		System.out.println("PERFORMING OPTION SET UPDATE!");
//		car.updateOptionSetInstance(0, car.createOptionSetInstance("Transmission", 2));
//		System.out.println(car);
//		System.out.println();
//		System.out.println("UPDATING OPTION SET OPTIONS!");
//		car.updateOptionClassInstance(0, 0, "automatic", 0.0f);
//		car.updateOptionClassInstance(0, 1, "manual", -715.0f);
//		System.out.println(car);
//		car.deleteOptionSetInstance(0);
//		car.updateOptionSetInstance(0, car.createOptionSetInstance("Transmission", 2));
//		System.out.println(car);
//		System.out.println("UPDATING OPTION SET OPTIONS!");
//		car.updateOptionClassInstance(0, 0, "automatic", 0.0f);
//		car.updateOptionClassInstance(0, 1, "manual", -715.0f);
//		System.out.println();
//		System.out.println(car);
//
//
//		System.out.println("PERFORMING OPTION DELETION!");
//		car.deleteOptionClassInstance(0, 0);
//		System.out.println();
//		System.out.println(car);
//		car.updateOptionClassInstance(0, 0, "automatic", 0.0f);
//		System.out.println();
//		System.out.println(car);
//		car.deleteOptionClassInstance(0, 1);
//		car.updateOptionClassInstance(0, 1, "manual", -815.0f);
//		System.out.println();
//		System.out.println(car);
//
//		car.deleteOptionClassInstance(0, 0);
//		car.deleteOptionClassInstance(0, 1);
//		System.out.println();
//		System.out.println(car);
//
//		car.updateOptionClassInstance(0, 0, "automatic", 0.0f);
//		car.updateOptionClassInstance(0, 1, "manual", -815.0f);
//
//		System.out.println();
//		System.out.println(car);
//
//		System.out.println("TESTING DELETION OF ALL OPTIONS");
//		for (int i = 0; i < car.getOptionSetsSize(); i++) {
//			for (int j = 0; j < car.getOptionsArraySize(i); j++) {
//				car.deleteOptionClassInstance(i, j);
//			}
//		}
//		System.out.println();
//		System.out.println(car);
//		System.out.println();
//
//
//		for (int i = 0; i < car.getOptionSetsSize(); i++) {
//			for (int j = 0; j < car.getOptionsArraySize(i); j++) {
//				car.updateOptionClassInstance(i, j, "helloworld", 1);
//			}
//		}
//		System.out.println(car);
//		System.out.println();
	}


}
