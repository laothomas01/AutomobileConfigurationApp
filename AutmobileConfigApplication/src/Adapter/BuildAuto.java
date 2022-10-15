package Adapter;

import Utils.FileIO;
import Exception.Fix1to100;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BuildAuto extends proxyAutomobile implements CreateAuto, UpdateAuto, FixAuto {

	boolean problemFixed = false;

	@Override
	public void buildAuto(String fileName) throws IOException {
		FileIO io = new FileIO(fileName);
		a1 = io.loadAutomotive();
		int[] errNums = io.readArrayOfErrors("listOfErrors.txt");
		if (!problemFixed) {
			for (int n : errNums) {
				fix(n);
			}
			//after all problems are fixed
			problemFixed = fix(-1);
		}
		System.out.println(a1);
	}

	@Override
	public void printAuto(String modelName) {
		if (a1.getName().equals(modelName)) {
			System.out.println(a1.toString());
		}
	}

	@Override
	public void updateOptionSetName(String modelName, String OptionSetName, String newName) {
		if (a1.getName().equals(modelName)) {
			a1.updateOptionSetName(OptionSetName, newName);
		}
	}

	@Override
	public void updateOptionPrice(String modelName, String OptionSetName, String OptionName, float newPrice) {
		if (a1.getName().equals(modelName)) {
			a1.updateOptionPrice(OptionSetName, OptionName, newPrice);
		}
	}


	/**
	 * Plan of attack:
	 * - externally: loop through a fixed number of lines from the list of errors and parse the first element
	 * - funnel that error into this function and we will determine the fix to the program based on the base made in the switch statement
	 * - we will right now solve 1 error because i need to get this lab turned in, and work on SQL assignment. then backtrack to this to write cleaner code!
	 */
	@Override
	public boolean fix(int errNo) throws IOException {
		Fix1to100 f1 = new Fix1to100();
		switch (errNo) {
			case 0:
				f1.fixMissingPriceFromTextFile();
				break;
			default:
				break;
		}
		return true;

	}
}

//how does a .txt file, an instance of fix1to100, and auto exception connect?

// fileio.readData throws AutoException -> exceptionNo, exceptionMsg