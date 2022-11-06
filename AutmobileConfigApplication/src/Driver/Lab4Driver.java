package Driver;

import Adapter.BuildAuto;
import Model.Automobile;
import Scale.EditAuto;
import Scale.EditOptions;

import java.io.IOException;


import Exception.AutoException;

public class Lab4Driver {
	public static void main(String args[]) throws IOException, AutoException {
		Lab4Test();
	}


	public static void Lab4Test() throws IOException {
		String configurationFile = "CarConfigs.txt";
		String[] args = {"DarkBlue", "Red", "DarkBlue", "DarkBlue"};
		BuildAuto a1 = new BuildAuto(configurationFile);
//		EditOptions eo = new EditOptions("FordWagonZTW",0,args);
//		a1.editThread("FordWagonZTW", 1, args);
//		a1.editThread("FordWagonZTW", 0, args);
		for (int i = 0; i < args.length; i++) {
			Thread t = new Thread(new EditOptions("FordWagonZTW", i, args));
			t.start();
//		}

//		a1.editThread("FordWagonZTW", 1, args);
//		}
//		EditAuto ba = new BuildAuto(configurationFile);
//		ba.editThread("FordWagonZTW", 0, args);

//		ba.buildAuto(configurationFile);

//		EditAuto a1 = new BuildAuto(configurationFile);
//		System.out.println(a1.toString());
//		a1.editThread("FordWagonZTW", 0, args);
//		a1.editThread("FordWagonZTW", 1, args);
//		String configurationFile = "CarConfigs.txt";

//		auto.buildAuto(configurationFile);

//		System.out.println(auto.getAuto("FordWagonZTW"));
//		EditOptions eo = new EditOptions(auto);
//
//		for (int i = 0; i < 4; i++) {
//			eo.new Producer(eo);
//			eo.new Consumer(eo);
//		}

		}
	}
}