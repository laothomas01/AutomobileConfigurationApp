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
        //number of option sets

//		System.out.println(car.OptionToString(0, 1));

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
