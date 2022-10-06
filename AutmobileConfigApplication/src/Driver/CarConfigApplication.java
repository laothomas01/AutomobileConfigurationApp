package Driver;

import Model.Automotive;
import Utils.FileIO;

import java.io.*;

/**
 * @TODO LIST
 * [] update functions for option set, option and in automotive
 * [X] deserialization
 * [X] serialization
 * [] clean up class diagram
 * [X] create test cases
 * [X] write car data to file
 * [] clean code up
 * [] turn homework in
 * [] provide extensibility for your methods
 */
public class CarConfigApplication {

//	public static OptionSet readOptionSet(Scanner in) {
//		String line = in.nextLine();
//		String[] tokens = line.split("\\|");
//	}


//	public static OptionSet readOptionSet(
//			//		Scanner in = new Scanner(new FileInputStream("CarConfigs.txt"), "UTF-8");
//			Scanner in) {
//		String line = in.nextLine();
//		String[] tokens = line.split("\\|");
//
//	}

	public static void main(String args[]) throws IOException {

		CarConfigApplication run = new CarConfigApplication();
		run.testAutomotive_CRUD();
	}

	public void testAutomotive_CRUD() {
		/**
		 * Base reference model
		 *
		 * we will select configurations from this object to fit into out Focus Wagon ZTW
		 * PSEUDO CODE
		 * tokens[]
		 * ____________
		 * 0: name
		 * 1: options[]
		 * 2: prices[]
		 * -> optionset{ option(name,price)... }
		 *
		 * ____________
		 *
		 */

		FileIO io = new FileIO();
		String serializedFile = "Car.dat";
		String configurationFile = "CarConfigs.txt";
		Automotive car = io.buildAutomotive(configurationFile);
		System.out.print("PRINTING BEFORE SERIALIZATION:\n" + car);
		System.out.println();
		io.serializeAutomotive(serializedFile, car);
		System.out.println();


		car = io.deserializeAutomotive(serializedFile);
		System.out.println("PRINTING AFTER DESERIALIZATION:");
		System.out.println(car);
		System.out.println();


		System.out.println("PERFORMING OPTION SET READING!");
		System.out.println(car.getOptionSetName(0));
		System.out.println(car.getOptionSetClassInstance(0));
		System.out.println("PERFORMING OPTION READING!");
		System.out.println(car.getOptionName(0, 0));
		System.out.println(car.getOptionName(0, 1));
		System.out.println(car.getOptionPrice(0, 0));
		System.out.println(car.getOptionPrice(0, 1));
		System.out.println(car.getOptionClassInstance(0, 0));
		System.out.println(car.getOptionClassInstance(0, 1));
		System.out.println();

		System.out.println("PERFORMING OPTION SET DELETION!");
		car.deleteOptionSetInstance(0);
		System.out.println("CONFIRMING DELETION!");
		System.out.println("RESULT:");
		System.out.println(car);
		System.out.println();
		System.out.println("PERFORMING OPTION SET UPDATE!");
		car.updateOptionSet(0, car.createOptionSetInstance("Transmission", 2));
		System.out.println(car);
		System.out.println();
		System.out.println("UPDATING OPTION SET OPTIONS!");
		car.updateOptionClassInstance(0, 0, "automatic", 0.0f);
		car.updateOptionClassInstance(0, 1, "manual", -715.0f);
		System.out.println(car);
		car.deleteOptionSetInstance(0);
		car.updateOptionSet(0, car.createOptionSetInstance("Transmission", 2));
		System.out.println(car);
		System.out.println("UPDATING OPTION SET OPTIONS!");
		car.updateOptionClassInstance(0, 0, "automatic", 0.0f);
		car.updateOptionClassInstance(0, 1, "manual", -715.0f);
		System.out.println();
		System.out.println(car);


		System.out.println("PERFORMING OPTION DELETION!");
		car.deleteOptionClassInstance(0, 0);
		System.out.println();
		System.out.println(car);
		car.updateOptionClassInstance(0, 0, "automatic", 0.0f);
		System.out.println();
		System.out.println(car);
		car.deleteOptionClassInstance(0, 1);
		car.updateOptionClassInstance(0, 1, "manual", -815.0f);
		System.out.println();
		System.out.println(car);

		car.deleteOptionClassInstance(0, 0);
		car.deleteOptionClassInstance(0, 1);
		System.out.println();
		System.out.println(car);

		car.updateOptionClassInstance(0, 0, "automatic", 0.0f);
		car.updateOptionClassInstance(0, 1, "manual", -815.0f);

		System.out.println();
		System.out.println(car);

		System.out.println("TESTING DELETION OF ALL OPTIONS");
		for (int i = 0; i < car.getOptionSetsSize(); i++) {
			for (int j = 0; j < car.getOptionsArraySize(i); j++) {
				car.deleteOptionClassInstance(i, j);
			}
		}
		System.out.println();
		System.out.println(car);
		System.out.println();


		for (int i = 0; i < car.getOptionSetsSize(); i++) {
			for (int j = 0; j < car.getOptionsArraySize(i); j++) {
				car.updateOptionClassInstance(i, j, "helloworld", 1);
			}
		}
		System.out.println(car);
		System.out.println();
	}


}
