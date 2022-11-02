package Driver;

import Adapter.*;
import Scale.EditOptions;

import java.io.*;

import Exception.AutoException;


public class CarConfigApplication {

	public static void main(String args[]) throws IOException, AutoException {

		Lab3Test();
	}


	public static void Lab3Test() throws IOException {
		String configurationFile = "CarConfigs.txt";
		BuildAuto auto = new BuildAuto();
		auto.buildAuto(configurationFile);
		System.out.println(auto.getAuto("FordWagonZTW"));
		EditOptions eo = new EditOptions(auto);
	}

	public static void Lab2Test() throws IOException {
	}

	public void Lab1Test() throws IOException {

	}


}
