package Exception;

import Utils.FileIO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * plan of attack:
 * trigger error in file io's read data
 * throw autoexception which will be caught and the exception number and message will be stored
 * read text file containing exception number, funnel that parsed number into the fix function from build auto
 * create instance of fix1to100 where each method in fix1to100 will be dedicated to a particular fix in the software
 */
public class Fix1to100 {
	public Fix1to100() {

	}

	//for fixing missing price from text file
	public void fixMissingPriceFromTextFile() throws IOException {
		FileIO io = new FileIO("CarConfigs.txt");
		BufferedReader br = new BufferedReader(new FileReader("CarConfigs.txt"));
		ArrayList<String> lines = new ArrayList<>();
		//@TODO take user input instead but force a rule on users that they must follow the format: <car name> "|" <car price>
		String fixedLine = "FordWagonZTW|128500";
		lines.add(fixedLine);
		br.readLine();
		boolean eof = false;
		while (!eof) {
			String line = br.readLine();
			if (line == null) {
				eof = true;
			} else {
				lines.add(line);
			}
		}

		io.writeToFile("CarConfigs.txt", lines);

	}
}
