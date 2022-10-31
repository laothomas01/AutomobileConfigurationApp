package Exception;

import Utils.FileIO;

import java.io.*;
import java.util.ArrayList;


public class Fix1to100 {
	public Fix1to100() {

	}

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


	public String findFile(String name, File file) {
		File[] list = file.listFiles();
		boolean foundFile = false;
		if (list != null)
			for (File fil : list) {
				if (foundFile) {
					break;
				}
				if (fil.isDirectory()) {
					findFile(name, fil);
				} else if (name.equalsIgnoreCase(fil.getName())) {
					System.out.println(fil.getName());
					return fil.getName();
				}
			}
		return "";
	}
}
