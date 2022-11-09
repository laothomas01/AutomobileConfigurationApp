package Driver;

import Adapter.BuildAuto;
import Adapter.EditAuto;

import java.io.IOException;


import Exception.AutoException;

public class Lab4Driver {
	public static void main(String args[]) throws IOException, AutoException, InterruptedException {
		Lab4Test();
	}


	public static void Lab4Test() throws IOException, InterruptedException {
		String configurationFile = "CarConfigs.txt";
		String[] args = {"Red", "DarkBlue", "Green", "White"};
		EditAuto a1 = new BuildAuto(configurationFile);
		/**
		 * Each call to edit thread instantiates a new thread operating on the same automobile
		 *
		 * - 2 non-synchronized calls
		 * - 2 synchronized calls
		 */
		a1.editThread("FordWagonZTW", 0, args);
		a1.editThread("FordWagonZTW", 1, args);
		a1.editThread("FordWagonZTW", 2, args);
		a1.editThread("FordWagonZTW", 3, args);
	}
}