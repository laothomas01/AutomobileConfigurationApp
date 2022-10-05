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
		car.deleteOptionSetInstance(0);
		System.out.println("DELETED AN OPTION SET");
		car.updateOptionSet(0, car.createOptionSetInstance("Transmission", 2));
		car.updateOptionClassInstance(0, 0, "automatic", 0.0f);
		car.updateOptionClassInstance(0, 1, "manual", -815.0f);
		System.out.println("UPDATING OPTION SET");
		System.out.println();
		System.out.println(car);


		//		car.updateOptionSet(0, 0, 2, "Transmission","automatic",0.0f );
//		car.updateOptionSetClassInstance(0, car.createOptionSetInstance("Transmission", 2));
//		car.updateOptionClassInstance(0, 0, "automatic", 0.0f);
//		car.updateOptionClassInstance(0, 1, "manual", -815.0f);
//
//		System.out.println();
//		System.out.println(car);
	}


}
