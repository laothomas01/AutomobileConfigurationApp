package Driver;

import Adapter.BuildAuto;
import Adapter.EditAuto;

import java.io.IOException;


import Exception.AutoException;

public class Lab4Driver {
	public static void main(String args[]) throws IOException, AutoException {
		Lab4Test();
	}


	public static void Lab4Test() throws IOException {
		String configurationFile = "CarConfigs.txt";
		String[] args = {"DarkBlue", "Red"};
		EditAuto a1 = new BuildAuto(configurationFile);
		for (int i = 0; i < 10; i++) {
			a1.editThread("FordWagonZTW", 0, args);
			a1.editThread("FordWagonZTW", 1, args);
		}
//		for (int i = 0; i < args.length; i++) {
//			a1.editThread("FordWagonZTW", i, args);
//		}
//		a1.editThread("FordWagonZTW", 5, args);
//		a1.editThread("DASDAS", 0, args);

//		a1.editThread("FordWagonZTW", 0, args);
//		a1.editThread("FordWagonZTW", 0, args);
//		a1.editThread("FordWagonZTW", 1, args);

//			}
	}
}