package Driver;

import Model.Automotive;
import Model.OptionSet;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CarConfigApplication {

//	public static OptionSet readOptionSet(Scanner in) {
//		String line = in.nextLine();
//		String[] tokens = line.split("\\|");
//	}


	public static OptionSet readOptionSet(
			//		Scanner in = new Scanner(new FileInputStream("CarConfigs.txt"), "UTF-8");
			Scanner in) {
		String line = in.nextLine();
		String[] tokens = line.split("\\|");

	}

	public static void main(String args[]) throws FileNotFoundException {

		/**
		 * Base reference model
		 *
		 * we will select configurations from this object to fit into out Focus Wagon ZTW
		 * tokens[]
		 * ____________
		 * 0: name
		 * 1: options[]
		 * 2: prices[]
		 * ____________
		 *
		 */
		//Automotive has 5 option sets
		Automotive car = new Automotive("car", 5, 100f);
		Scanner in = new Scanner(new FileInputStream("CarConfigs.txt"), "UTF-8");
		while (in.hasNextLine()) {
			String line = in.nextLine();
			String[] tokens = line.split("\\|");
			for (int i = 0; i < tokens.length; i++) {
				System.out.print(i + ":" + tokens[i] + "\n");
			}
			System.out.println();
		}


//        /**
//         * How to think about this when reading a text file
//         * -option set size = number of options provided
//         * i.e when reading a .txt file
//         * Color
//         * name: "red", "orange", "yellow", "green", "blue", "indigo", "violet"
//         * price: 0
//         */
//
//        //------------------ LETS FIND A WAY TO TRANSLATE THIS IDEA TO FILE IO------------------------------------------
//        String[][] options = new String[][]{
//
//                {"red", "orange", "yellow", "green", "blue", "indigo", "violet"},
//                {"automatic", "manual"},
//                {"standard", "abs", "abs with Advance Trac"},
//                {"1", "0"},
//                {"1", "0"}
//
//        };
//
//        OptionSet Colors = new OptionSet("colors", options[0].length);
//        OptionSet Transmission = new OptionSet("transmission", 2);
//
//        //iterating through array of potential colors
//        for (int i = 0; i < Colors.getOptionsSize(); i++) {
//            Colors.addOption(i, Colors.new Option(options[0][i]));
//        }
//
//        for (int i = 0; i < Transmission.getOptionsSize(); i++) {
//            if (options[1][i].equals("manual")) {
//                Transmission.addOption(0, Colors.new Option(options[1][0], -185f));
//            } else {
//                Transmission.addOption(1, Transmission.new Option(options[1][1]));
//            }
//        }

		//--------------------------------------------------------------------------------------------------------------

//        car.addOptionSet(0, Colors);
//        car.addOptionSet(1, Transmission);
//
//
//        car.printOptionSetsData();


//		};

		/**
		 * Need to write to file a format that we will serialize and also read, parse and apply
		 */
		/**
		 * WRITING TO FILE
		 */


		/**
		 * READING FILE
		 */


		//------------------------------------------------------------------


	}
}
