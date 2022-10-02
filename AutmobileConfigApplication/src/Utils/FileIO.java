package Utils;

import Model.Automotive;
import Model.OptionSet;

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
public class FileIO {
	public FileIO() {

	}


	//read whole file to determine number of option sets
//	public int getOptionSetsSize() {
////		int optionSetsSize = 0;
////		while (in.hasNextLine()) {
////			in.nextLine();
////			optionSetsSize++;
////		}
////		return optionSetsSize;
//	}

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

	public Automotive buildAutomotive(String filename, Automotive a1) {

		int optionSetsSize = 0;

		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			optionSetsSize = getLineCount(br, filename);
		} catch (IOException e) {
			System.out.println("Error -- " + e.toString());
		}
		a1 = new Automotive(optionSetsSize);
		return a1;
	}

	public int getLineCount(BufferedReader b, String n) throws IOException {
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
//	public OptionSet readData()
//

}
