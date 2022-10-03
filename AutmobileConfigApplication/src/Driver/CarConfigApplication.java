package Driver;

import Model.Automotive;
import Utils.FileIO;

import java.io.*;

/**
 * @TODO LIST
 * [] update functions for option set, option and in automotive
 * [] serialization
 * [] clean up class diagram
 * [] create test cases
 * [] write car data to file
 * [] clean code up
 * [] turn homework in
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
		Automotive car = io.buildAutomotive("CarConfigs.txt");


		//		for (int i = 0; i < car.getOptionSetsSize(); i++) {
//			System.out.println("OPTION SET:" + car.getOptionSetInstance(i) + " OPTION SET SIZE:" + car.getOptionsSize(i));
//		}

//		for (int i = 0; i < car.getOptionSetsSize(); i++) {
//			System.out.println(car);
//		}


//			System.out.print(car.getOptionSetName(i));
////			System.out.println(car.getOptionSetSize(i));
//			for (int j = 0; j < car.getOptionSetSize(i); j++) {
//				System.out.println(car.getOptionName(i,3));
//			System.out.println();
//
////			System.out.println(car.getOptionName(i, 0));
//		}
		//		for (int i = 0; i < car.getOptionSetsSize(); i++) {
//			System.out.println(car.getOptionSetName(i));
//		}

		//		for (int i = 0; i < car.getOptionSetsSize(); i++) {
//			System.out.println("---------------------------------");
//			System.out.println(car.optionSetToString(i));
//		}
//		System.out.println(car.optionSetToString(1));
//		car.printOptionSetsData();
//		for (int i = 0; i < car.getOptionSetsSize(); i++) {
//			System.out.println(car.optionSetToString(i));
//		}
//

//		System.out.println(car.toString());
		//		car.setBasePrice(128500);
//		car.setName("Ford ZTW Wagon");
//		try {
////			BufferedReader br = new BufferedReader(new FileReader("CarConfigs.txt"));
//
//		} catch (IOException e) {
//			System.out.println("Error -- " + e.toString());
//		}
//		int i = 0;
//		try {
//			FileReader f = new FileReader("CarConfigs.txt");
//			BufferedReader b = new BufferedReader(f);
//			boolean eof = false;
//			while (!eof) {
//				String line = b.readLine();
//				if (line == null) {
//					eof = true;
//				} else {
//					i++;
//				}
//			}
//
//		} catch (IOException e) {
//			System.out.println("ERROR -- " + e.toString());
//		}
//		// we will build an automotive object using FileIO
//		//------------------- GETTING OPTION SETS SIZE ----------------------
//		Scanner in = new Scanner(new FileInputStream("CarConfigs.txt"), "UTF-8");
//		int optionSetsSize = 0;
//		while (in.hasNextLine()) {
//			in.nextLine();
//			optionSetsSize++;
//		}
//		//------------------------------------------------------------------
//		Automotive car = new Automotive("car", optionSetsSize, 100f);
////		car.printOptionSetsData();
//		//------------------ RETRIEVE TEXT FILE DATA ----------------------
//		in = new Scanner(new FileInputStream("CarConfigs.txt"), "UTF-8");
//		//keep reading the text file
////		int optionSetIndex = 0;
////		while (in.hasNextLine()) {
////			optionSetIndex++;
//		String line = in.nextLine();
//		String[] tokens = line.split("\\|");
//		String name = tokens[0];
//		System.out.println("NAME: " + name);
//		String[] optionNames = tokens[1].split(",");
//		String[] optionPrices = tokens[2].split(",");
//		for (int i = 0; i < optionNames.length; i++) {
//
//			/**
//			 * option set size = # of options = # of optionNames = # of optionPrices
//			 * i = 0
//			 * Option(name,price)
//			 * i = 1
//			 * Option(name,price)
//			 * ...
//			 * i = n
//			 * Option(name,price)
//			 */
//
//		}
////		for (String o : options) {
////
////
////			for (String p : prices) {
////				System.out.println("OPTION:");
////				System.out.println(o);
////				System.out.println("PRICE:");
////				System.out.println(p);
////			}
////		}
//
//		//convert to floats
//
//
//		System.out.println("END OF LINE");


		//-------------------------------------------------------------------


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

		//------------------------------------------------------------------


//		}


	}

//	public int getOptionSetsSize(BufferedReader br, String fileName) {
//
////		int size = 0;
////		try {
////			FileReader file = new FileReader(fileName);
////			boolean eof = false;
////			while (!eof) {
////				String line = br.readLine();
////				if (line == null) {
////					eof = true;
////				} else {
////					size++;
////					System.out.println(line);
////				}
////			}
////		} catch (IOException e) {
////			System.out.println("ERROR -- " + e.toString());
////		}
////		return size;
//
//	}

}
