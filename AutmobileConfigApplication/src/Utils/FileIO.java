package Utils;

import Model.Automotive;

import javax.swing.*;
import java.io.*;
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
			readData(br2, a1);
			br2.close();
		} catch (IOException e) {
			System.out.println("Error -- " + e.toString());
		}
		return a1;
	}

	public Automotive deserializeAutomotive(String filename) {
		Automotive car = null;
		try {
			//Reading the object from a file
			FileInputStream file = new FileInputStream(filename);
			ObjectInputStream in = new ObjectInputStream(file);
			//Method for deserialization of object
			car = (Automotive) in.readObject();
			in.close();
			file.close();
			System.out.println("Object has been deserialized ");
		} catch (IOException ex) {
			System.out.println("IOException is caught");
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException is caught");
			throw new RuntimeException(e);
		}
		return car;

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

	public void readData(BufferedReader br, Automotive a) throws IOException {
		//looping through each option set index within the set of option sets
		for (int i = 0; i < a.getOptionSetsSize(); i++) {
			//0th index = name and price of car. not related to car configs
			if (i == 0) {
				//read a line for the car specs
				String line = br.readLine();
				String[] carAttributes = line.split("\\|");
				a.setName(carAttributes[0]);
				a.setBasePrice(Float.parseFloat(carAttributes[1]));
			}
			//start at the next line for reading car configurations
			String line = br.readLine();
			String[] carConfigs = line.split("\\|");
			String name = carConfigs[0];
			String[] optionNames = carConfigs[1].split(" ");
			String[] optionPrices = carConfigs[2].split(" ");

			int optionsCount = optionNames.length;
			//replace the empty option set with a new populated option set instance
			/**
			 - option name[ ] length = option price [ ] length
			 - 1 to 1 relationship: option name -> option price
			 - option set size = # of option names = # of option prices
			 - after initializing an option set, let's access the option set's options and populate those options with option data
			 */
			a.setOptionSetInstance(i, name, optionsCount);
			for (int j = 0; j < optionNames.length; j++) {
				//parse the prices because they are read as strings
				a.setOption(i, j, optionNames[j], Float.parseFloat(optionPrices[j]));
			}


		}
	}

	//for writing out to a file. for.... later uses
	public void writeData(BufferedWriter bw, Automotive a) throws IOException {
		for (int i = 0; i < a.getOptionSetsSize(); i++) {
			bw.write(a.OptionSetToString(i));
		}
	}

	public void serializeAutomotive(String fileName, Automotive a) {
		try {
			FileOutputStream file = new FileOutputStream(fileName);
			ObjectOutputStream out = new ObjectOutputStream(file);
			//Method for serialization of object
			out.writeObject(a);
			out.close();
			System.out.println("Object has been serialized");
		} catch (IOException ex) {
			System.out.println("IOException is caught");
		}
	}


}
