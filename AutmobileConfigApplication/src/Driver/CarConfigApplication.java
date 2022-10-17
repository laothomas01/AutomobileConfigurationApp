package Driver;

import Adapter.BuildAuto;
import Model.Automobile;
import Utils.FileIO;

import java.io.*;

import Exception.AutoException;


public class CarConfigApplication {

    public static void main(String args[]) throws IOException, AutoException {
        testAutomotiveLab2();
    }


    ////        //file reading error checking
////        do {
////            try {
////
////            } catch (AutoException e) {
////
////            }
////        }
////        while (problemFixed == false);
//
//
//////        auto.buildAuto(configurationFile);
////        do {
////            try {
//////                    auto.buildAuto(configurationFile);
////            } catch (AutoException a) {
////                a.findFile("dsadsa", new File("sadsadsa"));
////            }
////
////        }
//
////        auto.updateOptionSetName("FordWagonZTW", "Transmission", "Rear Window");
////        auto.printAuto("FordWagonZTW");
//}

    public static void testAutomotiveLab2() throws IOException {
        //.txt file to read from using FileIO instance
        String configurationFile = "CarConfigs.txt";
        //instantiate BuildAuto
        BuildAuto auto = new BuildAuto();
        //1 problem is only fixed
        auto.buildAuto(configurationFile);
    }

    public void testAutomotiveLab1() throws IOException {

        String configurationFile = "CarConfigs.txt";
        FileIO io = new FileIO(configurationFile);
        String serializedFile = "Car.dat";
        Automobile car = io.loadAutomotive();
        System.out.print("PRINTING BEFORE SERIALIZATION:\n" + car);
        System.out.println();
        io.serializeAutomotive(serializedFile, car);
        System.out.println();


        car = io.deserializeAutomotive(serializedFile);
        System.out.println("PRINTING AFTER DESERIALIZATION:");
        System.out.println(car);
        System.out.println();


        System.out.println("PERFORMING OPTION SET READING!");
        System.out.println(car.getOptionSetName(0));
        System.out.println(car.getOptionSetClassInstance(0));
        System.out.println("PERFORMING OPTION READING!");
        System.out.println(car.getOptionName(0, 0));
        System.out.println(car.getOptionName(0, 1));
        System.out.println(car.getOptionPrice(0, 0));
        System.out.println(car.getOptionPrice(0, 1));
        System.out.println(car.getOptionClassInstance(0, 0));
        System.out.println(car.getOptionClassInstance(0, 1));
        System.out.println();

        System.out.println("PERFORMING OPTION SET DELETION!");
        car.deleteOptionSetInstance(0);
        System.out.println("CONFIRMING DELETION!");
        System.out.println("RESULT:");
        System.out.println(car);
        System.out.println();
        System.out.println("PERFORMING OPTION SET UPDATE!");
        car.updateOptionSetInstance(0, car.createOptionSetInstance("Transmission", 2));
        System.out.println(car);
        System.out.println();
        System.out.println("UPDATING OPTION SET OPTIONS!");
        car.updateOptionClassInstance(0, 0, "automatic", 0.0f);
        car.updateOptionClassInstance(0, 1, "manual", -715.0f);
        System.out.println(car);
        car.deleteOptionSetInstance(0);
        car.updateOptionSetInstance(0, car.createOptionSetInstance("Transmission", 2));
        System.out.println(car);
        System.out.println("UPDATING OPTION SET OPTIONS!");
        car.updateOptionClassInstance(0, 0, "automatic", 0.0f);
        car.updateOptionClassInstance(0, 1, "manual", -715.0f);
        System.out.println();
        System.out.println(car);


        System.out.println("PERFORMING OPTION DELETION!");
        car.deleteOptionClassInstance(0, 0);
        System.out.println();
        System.out.println(car);
        car.updateOptionClassInstance(0, 0, "automatic", 0.0f);
        System.out.println();
        System.out.println(car);
        car.deleteOptionClassInstance(0, 1);
        car.updateOptionClassInstance(0, 1, "manual", -815.0f);
        System.out.println();
        System.out.println(car);

        car.deleteOptionClassInstance(0, 0);
        car.deleteOptionClassInstance(0, 1);
        System.out.println();
        System.out.println(car);

        car.updateOptionClassInstance(0, 0, "automatic", 0.0f);
        car.updateOptionClassInstance(0, 1, "manual", -815.0f);

        System.out.println();
        System.out.println(car);

        System.out.println("TESTING DELETION OF ALL OPTIONS");
        for (int i = 0; i < car.getOptionSetsSize(); i++) {
            for (int j = 0; j < car.getOptionsArraySize(i); j++) {
                car.deleteOptionClassInstance(i, j);
            }
        }
        System.out.println();
        System.out.println(car);
        System.out.println();


        for (int i = 0; i < car.getOptionSetsSize(); i++) {
            for (int j = 0; j < car.getOptionsArraySize(i); j++) {
                car.updateOptionClassInstance(i, j, "helloworld", 1);
            }
        }
        System.out.println(car);
        System.out.println();
    }


}
