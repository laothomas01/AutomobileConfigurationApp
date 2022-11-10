package Driver;

import Model.Automobile;
import Utils.FileIO;

import java.io.IOException;

public class Lab1Driver {
	public static void main(String args[]) throws IOException {
		String configFile = "CarConfigs.txt";
		FileIO io = new FileIO(configFile);
		Automobile a1 = io.loadAutomotive();
		for (int i = 0; i < a1.getOptnSetsSize(); i++) {
			System.out.println(a1.getOptnSetName(i));
			for (int j = 0; j < a1.getOptnSetSize(i); j++) {
				System.out.println(a1.getOptnName(i, j));
			}
			System.out.println();
		}
		a1.setOptnName("Colors", "Blue", "Green");
		System.out.println(a1.getOptnName("Colors", "Green"));
		a1.addOptionChoice(0, 0);
		a1.addOptionChoice(0, 1);
		a1.printOptionChoices();
		System.out.println(a1.getTotalPrice());

	}
}
