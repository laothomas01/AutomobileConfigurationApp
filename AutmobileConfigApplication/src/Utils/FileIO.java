package Utils;

import Model.Automobile;

import java.io.*;
import java.util.ArrayList;

import Exception.AutoException;

import java.util.Properties;
import java.util.logging.FileHandler;
import java.util.logging.Logger;


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
	private String fileName;


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
	public boolean openFile() throws IOException {
		BufferedReader br = null;
		boolean flag = false;
		try {
			File f = new File(fileName);
			if (!f.exists()) {
				throw new AutoException(0);
			}
			br = new BufferedReader(new FileReader(f));
			flag = true;
			br.close();
		} catch (FileNotFoundException e) {

		} catch (AutoException e) {
			e.setErrorMsg("Cannot Find File Name!");
			e.printMyProblem();
			String exception = e.getErrorNo() + "|" + e.getErrorMsg();
			writeToFile("listOfErrors.txt", exception);
			writeToLogFile(exception);
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {

		}
		return flag;
	}

	public Object loadProperties(String fname) {
		Properties props = new Properties();
		try {
			props.load(new FileInputStream(fname));
		} catch (FileNotFoundException e) {
			System.err.println("Err in file directory  ... ");
			System.exit(1);
		} catch (IOException e) {
			System.err.println("Error reading file from director ... ");
			System.exit(1);
		}
		return props;
	}

	public String getFileName() {
		return this.fileName;
	}

	public Automobile loadAutomotive(Object obj) throws IOException {
		Properties prop = (Properties) obj;

		/**
		 * Find a more optimal way to parse these property keys
		 */
		String carModel = prop.getProperty("carmodel");
		float carPrice = Float.parseFloat(prop.getProperty("carprice"));
		String[] brakes = prop.getProperty("brakes").split("\\|");
		System.out.println(brakes[0]);
		System.out.println(brakes[1]);
		String[] colors = prop.getProperty("colors").split("\\|");
		System.out.println(colors[0]);
		System.out.println(colors[1]);
		String[] airbags = prop.getProperty("airbags").split("\\|");
		System.out.println(airbags[0]);
		System.out.println(airbags[1]);
		String[] powermoonroof = prop.getProperty("powermoonroof").split("\\|");
		System.out.println(powermoonroof[0]);
		System.out.println(powermoonroof[1]);
		int optnSetSize = prop.size() - 2;
		Automobile a1 = new Automobile();
		return a1;


	}

	//if file can be opened, proceed with attempt to populate automobile instance with read text data
	public Automobile loadAutomotive() throws IOException {
		//intialize as empty automobile
		Automobile a1 = new Automobile();
		if (openFile()) {
			int optionSetsSize;
			BufferedReader br1 = new BufferedReader(new FileReader(fileName));
			//we do not count the first line as part of option sets size
			optionSetsSize = getLineCount(br1) - 1;
//
			br1.close();
			BufferedReader br2 = new BufferedReader(new FileReader(fileName));
			String line = br2.readLine();
			String[] carNameAndPrice = line.split("\\|");
			try {
				//handling malformed pricing of automobile in text file
				if (MiscUtils.getPrimitiveDataTypeForNumberString(carNameAndPrice[1]) == "Unknown") {
					throw new AutoException(1);
				}
				a1 = new Automobile(carNameAndPrice[0], Float.parseFloat(carNameAndPrice[1]), optionSetsSize);
			} catch (AutoException e) {
				e.setErrorMsg("Missing Automobile Price!");
				e.printMyProblem();
				String exception = e.getErrorNo() + "|" + e.getErrorMsg();
				writeToFile("listOfErrors.txt", exception);
				writeToLogFile(exception);
			} finally {
				//if no error, continue parsing
				for (int i = 0; i < a1.getOptnSetsSize(); i++) {
					line = br2.readLine();
					String[] optnSet = line.split("\\|");
					String optnSetName = optnSet[0];
					String[] optnNames = optnSet[1].split(" ");
					String[] optnPrices = optnSet[2].split(" ");
					//needs to finish populating the option sets with empty options
					for (int j = 0; j < optnNames.length; j++) {
						a1.updateOptnSet(i, optnSetName, optnNames.length);
					}
					//populate empty options with new data
					for (int j = 0; j < optnNames.length; j++) {
						a1.setOptn(i, j, optnNames[j], Float.parseFloat(optnPrices[j]));
					}
				}
			}


//		/**
//		 *
//		 *  - try to parse malformed CarConfigs.txt file
//		 *  - if parsed data is improper, i.e malformed automobile name or price, throw custom exception
//		 *  - catch thrown custom exception
//		 *      - proceed to update exception instance
//		 *      - record current error into text file
//		 *          - record error no.
//		 *          - record error message
//		 *      - record exception in log file
//		 *
//		 *
//		 *
//		 */
//		try {
//
//			//check if the automobile attributes are malformed
//			//must look through list of available vehicle names to check for a malformed car name
//			if (MiscUtil.getPrimitiveDataTypeForNumberString(carNameAndPrice[1]) == "Unknown") {
//				throw new AutoException();
//			}
//			a1.updateAutomobile(carNameAndPrice[0], Float.parseFloat(carNameAndPrice[1]));
//
//		} catch (AutoException e) {
//			e.setErrorNo(errorNo += 1);
//			e.setErrorMsg("Missing Automobile Price!");
//			e.printMyProblem();
//			String exception = e.getErrorNo() + "|" + e.getErrorMsg();
////			writeToFile("listOfErrors.txt", exception);
//			//loop 5 times, each iteration =  a text file line (excluding the first line)
//
//
//			//OLD CODE: LOOPING THROUGH OPTION SET SIZES AND PARSING DATA
////			for (int i = 0; i < a1.getOptionSetsSize(); i++) {
////				line = br2.readLine();
////				String[] optionSet = line.split("\\|");
////				String optionSetName = optionSet[0];
////				String[] optionNames = optionSet[1].split(" ");
////				String[] optionPrices = optionSet[2].split(" ");
////
////				//populate
////				for (int j = 0; j < optionNames.length; j++) {
////					//throw auto exception here if option set text file data is improper
////					a1.updateOptionSetInstance(i, a1.createOptionSetInstance(optionSetName, optionNames.length));
////				}
////				for (int j = 0; j < optionNames.length; j++) {
////					//throw auto exception here if option text file data is improper
////					a1.updateOptionClassInstance(i, j, optionNames[j], Float.parseFloat(optionPrices[j]));
////				}
////			}
//			for (int i = 0; i < a1.getOptnSetsSize(); i++) {
//				line = br2.readLine();
//				String[] optionSet = line.split("\\|");
//				String optionSetName = optionSet[0];
//				String[] optionNames = optionSet[1].split(" ");
//				String[] optionPrices = optionSet[2].split(" ");
//
//				//populate
//				for (int j = 0; j < optionNames.length; j++) {
////					//throw auto exception here if option set text file data is improper
//					a1.setOptnSetName(i, optionSetName);
//
//					//OLD CODE: SETTING OPTION SET INSTANCE NAME
////					a1.updateOptionSetInstance(i, a1.createOptionSetInstance(optionSetName, optionNames.length))
//				}
//				for (int j = 0; j < optionNames.length; j++) {
////					//throw auto exception here if option text file data is improper
//					//		OLD CODE: SETTING OPTION INSTANCE PRICES
////					a1.updateOptionClassInstance(i, j, optionNames[j], Float.parseFloat(optionPrices[j]));
//					a1.setOptn(i, j, optionNames[j], Float.parseFloat(optionPrices[j]));
//				}
//			}
//		}
//
//
			br2.close();
		}
		return a1;
	}


//	public Automobile loadAutomobileOptionSets() throws IOException {
//		//intialize as empty automobile
//		int optionSetsSize;
//		BufferedReader br1 = new BufferedReader(new FileReader(fileName));
//		//we do not count the first line as part of option sets size
//		optionSetsSize = getLineCount(br1) - 1;
//
//		//populate automobile with empty option set instances
//
//		//automobile gets 5 option set instances
//		Automobile a1 = new Automobile(optionSetsSize);
//
//		br1.close();
//		BufferedReader br2 = new BufferedReader(new FileReader(fileName));
//
//		//read first line from carconfigs.txt
//		String line = br2.readLine();
//
//
//		//CO//loop 5 times, each iteration =  a text file line (excluding the first line)
//
////		for (int i = 0; i < a1.getOptionSetsSize(); i++) {
////			line = br2.readLine();
////			String[] optionSet = line.split("\\|");
////			String optionSetName = optionSet[0];
////			String[] optionNames = optionSet[1].split(" ");
////			String[] optionPrices = optionSet[2].split(" ");
////
////			//populate
////			for (int j = 0; j < optionNames.length; j++) {
////				//throw auto exception here if option set text file data is improper
////				a1.updateOptionSetInstance(i, a1.createOptionSetInstance(optionSetName, optionNames.length));
////			}
////			for (int j = 0; j < optionNames.length; j++) {
////				//throw auto exception here if option text file data is improper
////				a1.updateOptionClassInstance(i, j, optionNames[j], Float.parseFloat(optionPrices[j]));
////			}
////		}for (int i = 0; i < a1.getOptionSetsSize(); i++) {
//// OLD CODE
//		line = br2.readLine();
//		String[] optionSet = line.split("\\|");
//		String optionSetName = optionSet[0];
//		String[] optionNames = optionSet[1].split(" ");
//		String[] optionPrices = optionSet[2].split(" ");
//
//		for (int j = 0; j < optionNames.length; j++) {
////					//throw auto exception here if option set text file data is improper
//
//			a1.setOptnSetName(j, optionSetName);
//
//			//OLD CODE: SETTING OPTION SET INSTANCE NAME
////					a1.updateOptionSetInstance(i, a1.createOptionSetInstance(optionSetName, optionNames.length))
//		}
//		for (int j = 0; j < optionNames.length; j++) {
////					//throw auto exception here if option text file data is improper
//			//		OLD CODE: SETTING OPTION INSTANCE PRICES
////					a1.updateOptionClassInstance(i, j, optionNames[j], Float.parseFloat(optionPrices[j]));
//			a1.setOptn(j, j, optionNames[j], Float.parseFloat(optionPrices[j]));
//		}
//
//
//		br2.close();
//		return a1;
//	}

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


//when file can be opened and read, check for text file errors such as missing data

//@TODO make this code more modular for basic file reading

//break this code up into two separate functions: reading a text file and updating the automobile
//	public void readData(BufferedReader br, Automobile a) throws IOException, AutoException {
//
//		int errorNo = 0;
//		//looping through each option set index within the set of option sets
//
//		for (int i = 0; i < a.getOptionSetsSize(); i++) {
//			//0th index = name and price of car. not related to car configs
//			if (i == 0) {
//				//read a line for the car specs
//				String line = br.readLine();
//				String[] carAttributes = line.split("\\|");
//				try {
//					/**
//					 * let's handle more exceptions later
//					 */
//					//case of missing or number format exception of car price
//					if (MiscUtil.getPrimitiveDataTypeForNumberString(carAttributes[1]) == "Unknown") {
//						throw new AutoException();
//					}
//
//				} catch (AutoException e) {
//					/**
//					 * set error number and message
//					 * print error
//					 */
//					//@TODO fix this hard coding of the text files
//					e.setErrorNo(errorNo);
//					e.setErrorMsg("MissingAutomobilePrice!");
//					e.printMyProblem();
//					String exception = e.getErrorNo() + "|" + e.getErrorMsg();
//					writeToFile("listOfErrors.txt", exception);
//					writeToLogFile(exception);
//				}
//
//
//				/**
//				 * throw exception if carAttributes length < 2.
//				 * - check if text is missing car name
//				 * - check if text is missing car price
//				 */+
//			}
//
//			String line = br.readLine();
//			String[] carConfigs = line.split("\\|");
//			String name = carConfigs[0];
//			String[] optionNames = carConfigs[1].split(" ");
//			String[] optionPrices = carConfigs[2].split(" ");
//			int optionsCount = optionNames.length;
//			/**
//			 - option name[ ] length = option price [ ] length
//			 - 1 to 1 relationship: option name -> option price
//			 - option set size = # of option names = # of option prices
//			 - after initializing an option set, let's access the option set's options and populate those options with option data
//			 */
//			//replace the empty option set with a new populated option set instance
//			a.updateOptionSetInstance(i, a.createOptionSetInstance(name, optionsCount));
//			for (int j = 0; j < optionNames.length; j++) {
//				//parse the prices because they are read as strings
//				a.updateOptionClassInstance(i, j, optionNames[j], Float.parseFloat(optionPrices[j]));
//			}
//
//
//		}
//	}
//	public readData(BufferedReader br) throws IOException {
//		String line = br.readLine();
//		String[] carAttributes = line.split("\\|");

	//		int errorNo = 0;
//		//looping through each option set index within the set of option sets
//
//number of lines to read from .txt file
//		for (int i = 0; i < a.getOptionSetsSize(); i++) {
//			//0th index = name and price of car. not related to car configs
//			if (i == 0) {
//				//read a line for the car specs
//				String line = br.readLine();
//				String[] carAttributes = line.split("\\|");
//				try {
//					/**
//					 * let's handle more exceptions later
//					 */
//					//case of missing or number format exception of car price
//					if (MiscUtil.getPrimitiveDataTypeForNumberString(carAttributes[1]) == "Unknown") {
//						throw new AutoException();
//					}
//
//				} catch (AutoException e) {
//					/**
//					 * set error number and message
//					 * print error
//					 */
//					//@TODO fix this hard coding of the text files
//					e.setErrorNo(errorNo);
//					e.setErrorMsg("MissingAutomobilePrice!");
//					e.printMyProblem();
//					String exception = e.getErrorNo() + "|" + e.getErrorMsg();
//					writeToFile("listOfErrors.txt", exception);
//					writeToLogFile(exception);
//				}
//
//
//				/**
//				 * throw exception if carAttributes length < 2.
//				 * - check if text is missing car name
//				 * - check if text is missing car price
//				 */
//			}
//
//			String line = br.readLine();
//			String[] carConfigs = line.split("\\|");
//			String name = carConfigs[0];
//			String[] optionNames = carConfigs[1].split(" ");
//			String[] optionPrices = carConfigs[2].split(" ");
//			int optionsCount = optionNames.length;
//			/**
//			 - option name[ ] length = option price [ ] length
//			 - 1 to 1 relationship: option name -> option price
//			 - option set size = # of option names = # of option prices
//			 - after initializing an option set, let's access the option set's options and populate those options with option data
//			 */
//			//replace the empty option set with a new populated option set instance
//			a.updateOptionSetInstance(i, a.createOptionSetInstance(name, optionsCount));
//			for (int j = 0; j < optionNames.length; j++) {
//				//parse the prices because they are read as strings
//				a.updateOptionClassInstance(i, j, optionNames[j], Float.parseFloat(optionPrices[j]));
//			}
//
//
//		}
//	}
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
	public static void writeToFile(String fileName, ArrayList<String> newLines) throws IOException {
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
	public static void writeToFile(String fileName, String line) throws IOException {
		/**
		 * this does not handle repeated strings being written to file
		 */
		File file = new File(fileName);
		BufferedWriter bw = null;
		if (file.length() > 0) {
			bw = new BufferedWriter(new FileWriter(file, true));
			bw.newLine();
			bw.write(line);
		} else {
			bw = new BufferedWriter(new FileWriter(file));
			bw.write(line);
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


}
