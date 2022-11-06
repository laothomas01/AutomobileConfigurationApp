package Driver;

import Adapter.BuildAuto;
import Adapter.CreateAuto;
import Adapter.ReadAuto;
import Adapter.UpdateAuto;
import Scale.EditAuto;

import java.io.IOException;

public class Lab3Driver {
	public static void main(String args[]) throws IOException {
		String configurationFile = "CarConfigs.txt";
		CreateAuto ca = new BuildAuto(configurationFile);
		ca.printAuto("FordWagonZTW");
	}
}
