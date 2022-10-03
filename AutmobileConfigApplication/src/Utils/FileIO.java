package Utils;

import Model.Automotive;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * I need to write to file in a format that I would be able to read, parse, and create POJOs
 * <p>
 * [] writing out to file
 * [] loading data
 * [] serializing data
 */

/**
 * Note: file reader is based on this format of a text file
 * option set name | option name(s) | price(s)
 * i.e
 * Transmission|automatic,manual|0,-815
 * Brakes|standard,abs,abs with advance trac|0,400,1625
 * Colors|Fort Knox Gold Clearcoat Metallic, Liquid Grey Clearcoat Metallic,Infra-Red Clearcoat,Grabber Green Clearcoat Metallic,Sangria Red Clearcoat Metallic,French Blue Clearcoat Metallic,Twilight Blue Clearcoat Metallic,CD Silver Clearcoat Metallic,Pitch Black Clearcoat,Cloud 9 White Clearcoat|0,0,0,0,0,0,0,0,0,0
 * AirBags|1,0|0,350
 */
public class FileIO {
	public FileIO() {

	}


	//read file line by line and create an option set
//	public OptionSet readOptionSet() {
////		String line = in.nextLine();
////		String[] tokens = line.split("\\|");
////		String name = tokens[0];
////		String optionNames[] = tokens[1].split(",");
////		String optionPrices[] = tokens[2].split(",");
//
//	}
//
//
//	public Automotive buildAutoObject(String filename) {
//		try {
//
//		}
//	}

	public Automotive buildAutomotive(String filename) {
		Automotive a1 = new Automotive();

		int optionSetsSize;
		try {
			//count number of lines to get size of option set collection
			BufferedReader br1 = new BufferedReader(new FileReader(filename));

			//we dont want to count the first line as part of the size of car configs
			//we want to maintain the indexing count of  0 -> 5(exclusive)
			optionSetsSize = getLineCount(br1) - 1;
			a1 = new Automotive(optionSetsSize);
			br1.close();
			//for reading lines
			BufferedReader br2 = new BufferedReader(new FileReader(filename));
			//loop through array size of option sets

			//looping through each option set index within the set of option sets
			for (int i = 0; i < a1.getOptionSetsSize(); i++) {
				//0th index = name and price of car. not related to car configs
				if (i == 0) {
					//read a line for the car specs
					String line = br2.readLine();
					String[] carAttributes = line.split("\\|");
					a1.setName(carAttributes[0]);
					a1.setBasePrice(Float.parseFloat(carAttributes[1]));
				}
				//start at the next line for reading car configurations
				String line = br2.readLine();
				String[] carConfigs = line.split("\\|");
				String name = carConfigs[0];
				String[] optionNames = carConfigs[1].split(",");
				String[] optionPrices = carConfigs[2].split(",");

				//replace the empty option set with a populated option set instance
				//currently they are empty but will be populated
				a1.addOptionSet(i, name, optionNames.length);

				/**
				 - option name[ ] length = option price [ ] length
				 - 1 to 1 relationship: option name -> option price
				 - option set size = # of option names = # of option prices
				 - after initializing an option set, let's access the option set's options and populate those options with option data
				 */
				for (int j = 0; j < optionNames.length; j++) {
					a1.addOption(i, j, optionNames[j], Float.parseFloat(optionPrices[j]));
				}


			}
//				String line = br2.readLine();
			//handle the basic attributes of the car
//				if (i == 0) {
//					String[] carAttributes = line.split("\\|");
//					a1.setName(carAttributes[0]);
//					a1.setBasePrice(Float.parseFloat(carAttributes[1]));
//				}

			//let's read 1 line at a time, creation an option set and populate the automobile with it
//				String[] tokens = line.split("\\|");
//				String name = tokens[0];
//				System.out.println(name);
//				System.out.println(name);
//				String[] optionNames = tokens[1].split(",");
//				a1.addOptionSet(i, name, optionNames.length);
//				String[] optionPrices = tokens[2].split(",");
//			}
			// populate automobile with a new option set per iteration
		} catch (IOException e) {
			System.out.println("Error -- " + e.toString());
		}
		//initialize an autombile with a number of option sets

		//return
		return a1;
	}

	public int getLineCount(BufferedReader b) throws IOException {
		int i = 0;
		boolean eof = false;
		while (!eof) {
			String line = b.readLine();
			if (line == null) {
				eof = true;
			} else {
				i++;
			}
		}
		return i;
	}


	public void writeOptionSets() {

	}


	//
//	public OptionSet loadOptionSets(BufferedReader br) throws IOException {
////		String line = br.readLine();
////		String[] tokens = line.split("\\|");
////		String name = tokens[0];
////		String[] optionNames = tokens[1].split(",");
////		String[] optionPrices = tokens[2].split(",");
////
//	}


	//let's read
//	public OptionSet readData()
//

}
