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
		String fileName = "Car.dat";
		Automotive car = io.buildAutomotive("CarConfigs.txt");
//		System.out.println(car);
		System.out.print("PRINTING BEFORE SERIALIZATION:\n" + car);
		System.out.println();
		io.serializeAutomotive(fileName, car);
		System.out.println();
		car = io.deserializeAutomotive(fileName);
	}


}
