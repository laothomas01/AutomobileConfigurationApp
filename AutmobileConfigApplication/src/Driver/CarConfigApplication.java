package Driver;

import Adapter.BuildAuto;
import Model.Automobile;
import Utils.FileIO;

import java.io.*;
import java.util.Random;

import Exception.AutoException;


public class CarConfigApplication {

	public static void main(String args[]) throws IOException, AutoException {

		Lab3Test();
	}


	public static void Lab3Test() throws IOException {


		String configurationFile = "CarConfigs.txt";
		BuildAuto auto = new BuildAuto();

		auto.buildAuto(configurationFile);
		boolean finishedBuilding = false;
	}

	public static void Lab2Test() throws IOException {
	}

	public void Lab1Test() throws IOException {

	}


}
