package Utils;

import Model.Automobile;

import java.io.*;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

import Exception.AutoException;

/**
 * Note: file reader is based on this format of a text file
 * car name| car price // basic car attributes
 * option set name | option name(s) | price(s) // car configurations
 * i.e
 * Transmission|automatic,manual|0,-815
 * Brakes|standard,abs,abs with advance trac|0,400,1625
 * Colors|Fort Knox Gold Clearcoat Metallic, Liquid Grey Clearcoat Metallic,Infra-Red Clearcoat,Grabber Green Clearcoat Metallic,Sangria Red Clearcoat Metallic,French Blue Clearcoat Metallic,Twilight Blue Clearcoat Metallic,CD Silver Clearcoat Metallic,Pitch Black Clearcoat,Cloud 9 White Clearcoat|0,0,0,0,0,0,0,0,0,0
 * AirBags|1,0|0,350
 * <p>
 * <p>
 * <p>
 * Some Notes to take when looking through this code:
 * - this code is not module enough for basic file reading and writing
 */
public class FileIO {
	String fileName;

	public FileIO(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * if we are going to make a build auto function,we will have to still return an instance inside using
	 * Automotive and then print values.
	 * <p>
	 * BuildAuto just serves to tell the user the automotive was built and data will be printed
	 *
	 * @return
	 */

	//checking if file can be opened
	public boolean openFile() throws AutoException {
		BufferedReader br = null;
		boolean flag = false;
		try {
			br = new BufferedReader(new FileReader(fileName));
			flag = true;
			br.close();
		} catch (FileNotFoundException e) {
			throw new AutoException();
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {

		}
		return flag;
	}


//    public boolean openFile() throws AutoException {
//        BufferedReader br = null;
//        boolean flag = false;
//        try {
//            br = new BufferedReader(new FileReader(fileName));
//            flag = true;
//        } catch (FileNotFoundException e) {
//            throw new AutoException();
//        } finally {
//
//        }
//        return flag;
//
//
//    }

	//    public Automobile loadAutomotive(String filename) {
//        Automobile a1 = new Automobile();
//        int optionSetsSize;
//        try {
//
//            BufferedReader br1 = new BufferedReader(new FileReader(filename));
//            //if file exists, print it exists and continue with the program
//
//
//            optionSetsSize = getLineCount(br1) - 1;
//            a1 = new Automobile(optionSetsSize);
//            br1.close();
//            BufferedReader br2 = new BufferedReader(new FileReader(filename));
//            readData(br2, a1);
//            br2.close();
//        } catch (IOException e) {
//            System.out.println("Error -- " + e.toString());
//        }
//        return a1;
//    }

	//if file can be opened, proceed with data population
	public Automobile loadAutomotive() {
		//intialize as empty automobile
		Automobile a1 = new Automobile();
		int optionSetsSize;
		try {
			//if configuration file can be read
			if (openFile()) {
				BufferedReader br1 = new BufferedReader(new FileReader(fileName));
				optionSetsSize = getLineCount(br1) - 1;
				//populate with number of option sets
				a1 = new Automobile(optionSetsSize);
				br1.close();
				BufferedReader br2 = new BufferedReader(new FileReader(fileName));
				readData(br2, a1);
				br2.close();
			}
			//if file cannot be read, throw exception
		} catch (AutoException ae) {
			//@TODO:search for and correct the name of input file to open
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
//        try {
//
////            BufferedReader br1 = new BufferedReader(new FileReader(filename));
////            //if file exists, print it exists and continue with the program
////
////
////            optionSetsSize = getLineCount(br1) - 1;
////            a1 = new Automobile(optionSetsSize);
////            br1.close();
////            BufferedReader br2 = new BufferedReader(new FileReader(filename));
////            readData(br2, a1);
////            br2.close();
//        } catch (IOException e) {
////            System.out.println("Error -- " + e.toString());
//        }
		return a1;
	}

	public Automobile deserializeAutomotive(String filename) {
		Automobile car = null;
		try {
			FileInputStream file = new FileInputStream(filename);
			ObjectInputStream in = new ObjectInputStream(file);
			car = (Automobile) in.readObject();
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

	/**
	 * file line count - 1
	 *
	 * @param b bufferedreader
	 * @return total line count
	 * @throws IOException
	 */
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


	/**
	 * case of Exception: automobile name is missing or automobile price is missing
	 * <p>
	 * Check the length of the parsed array:
	 * if length 0:
	 * |
	 * if length == 1:
	 * <p>
	 * //lets focus on this one first
	 * if length == 2:
	 * txt file format:
	 * ''|abc123
	 * car[0] == '' <- not a car name
	 * car[1] == abc123 <- cannot parse into float
	 *
	 * @param br
	 * @param a
	 * @throws IOException
	 * @throws AutoException
	 */
	//when file can be opened and read, check for text file errors such as missing data

	//@TODO make this code more modular for basic file reading

	//break this code up into two separate functions: reading a text file and updating the automobile
	public void readData(BufferedReader br, Automobile a) throws IOException, AutoException {
		//looping through each option set index within the set of option sets
		int errorNo = 0;
		for (int i = 0; i < a.getOptionSetsSize(); i++) {
			//0th index = name and price of car. not related to car configs
			if (i == 0) {
				//read a line for the car specs
				String line = br.readLine();
				String[] carAttributes = line.split("\\|");
				try {
					/**
					 * let's handle more exceptions later
					 */
					//case of missing or number format exception of car price
					if (MiscUtil.getPrimitiveDataTypeForNumberString(carAttributes[1]) == "Unknown") {
						throw new AutoException();
					}

				} catch (AutoException e) {
					/**
					 * set error number and message
					 * print error
					 */
					//@TODO fix this hard coding of the text files
					e.setErrorNo(errorNo);
					e.setErrorMsg("MissingAutomobilePrice!");
					e.printMyProblem();
					String exception = e.getErrorNo() + "|" + e.getErrorMsg();
					writeToFile("listOfErrors.txt", exception);
					writeToLogFile(exception);
				}


				/**
				 * throw exception if carAttributes length < 2.
				 * - check if text is missing car name
				 * - check if text is missing car price
				 */
			}

			String line = br.readLine();
			String[] carConfigs = line.split("\\|");
			String name = carConfigs[0];
			String[] optionNames = carConfigs[1].split(" ");
			String[] optionPrices = carConfigs[2].split(" ");
			int optionsCount = optionNames.length;
			/**
			 - option name[ ] length = option price [ ] length
			 - 1 to 1 relationship: option name -> option price
			 - option set size = # of option names = # of option prices
			 - after initializing an option set, let's access the option set's options and populate those options with option data
			 */
			//replace the empty option set with a new populated option set instance
			a.updateOptionSet(i, a.createOptionSetInstance(name, optionsCount));
			for (int j = 0; j < optionNames.length; j++) {
				//parse the prices because they are read as strings
				a.updateOptionClassInstance(i, j, optionNames[j], Float.parseFloat(optionPrices[j]));
			}


		}
	}

	public int[] readArrayOfErrors(String fileName) throws IOException {
		BufferedReader br1 = new BufferedReader(new FileReader(fileName));
		BufferedReader br2 = new BufferedReader(new FileReader(fileName));
		int fileSize = getLineCount(br1);
		int[] errorNums = new int[fileSize];
		for (int i = 0; i < fileSize; i++) {
			String line = br2.readLine();
			String[] error = line.split("\\|");
			errorNums[0] = Integer.parseInt(error[0]);
		}
		return errorNums;

	}


	/**
	 * Lines of data are written by row
	 *
	 * @param fileName
	 * @param newLines list of lines used to write over the current text file
	 * @throws IOException
	 */
	public void writeToFile(String fileName, ArrayList<String> newLines) throws IOException {
		/**
		 * this does not handle repeated strings being written to file
		 */
		//erases the entire text file
		BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
		//append first line of text
		bw.append(newLines.get(0));
		bw.newLine();
		for (int i = 1; i < newLines.size(); i++) {
			bw.append(newLines.get(i));
			bw.newLine();
		}
		bw.close();
	}

	/**
	 * @param fileName
	 * @param line
	 * @throws IOException
	 */
	public void writeToFile(String fileName, String line) throws IOException {
		/**
		 * this does not handle repeated strings being written to file
		 */
		File file = new File(fileName);
		BufferedWriter bw = null;
		if (file.length() > 0) {
			bw = new BufferedWriter(new FileWriter(file, true));
			bw.append(line);

		} else {
			bw = new BufferedWriter(new FileWriter(file));
			bw.append(line);
		}
		bw.close();
	}

	public void serializeAutomotive(String fileName, Automobile a) {
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


	public static void writeToLogFile(String message) throws IOException {
		boolean append = true;
		FileHandler handler = new FileHandler("exception.log", append);
		Logger logger = Logger.getLogger(message);
		logger.addHandler(handler);
		logger.warning("warning message");
	}

	//File Writer function

	/**
	 * What does it do or what do you want it do do?
	 * 1) allow user to look through lines of text in text file
	 * 2) allow user input to write the correct line
	 * 3) store correct lines into an array
	 * 4) store the incorrect line index as "INCORRECT"
	 * 5)
	 */

	//@TODO make sure you understand this

}
