package Adapter;

import Model.Automobile;
import Utils.FileIO;
import Exception.Fix1to100;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Random;
import java.util.Scanner;

//what is the purpose of this class???
public class BuildAuto extends ProxyAutomobile implements CacheAuto, CreateAuto, UpdateAuto, FixAuto {

    //used to keep an on-going loop until all recorded exceptions are fixed
    boolean problemFixed = false;
    boolean finishedBuilding = false;
    Random rand = new Random();
    //used to cache any built automobile by the user
    LinkedHashMap<String, Automobile> cacheAutos;

    //for building 1 auto

    // OR we can leveraged this method to loop through a list of fileNames and build an automobile for each
    @Override
    public void buildAuto(String fileName) throws IOException {
        cacheAutos = new LinkedHashMap<>();
        FileIO io = new FileIO(fileName);
        //populate a1 with all its car configurations(we do not have more configurations for more cars. lets just hardcode this)

        String[] testCarNames = {"Abarth", "Alfa Romeo", "Aston Martin", "Audi", "Bentley", "BMW", "Bugatti", "Cadillac", "Chevrolet", "Chrysler", "Citroën", "Dacia", "Daewoo", "Daihatsu", "Dodge", "Donkervoort", "DS", "Ferrari", "Fiat", "Fisker", "Ford", "Honda", "Hummer", "Hyundai", "Infiniti", "Iveco", "Jaguar", "Jeep", "Kia", "KTM", "Lada", "Lamborghini", "Lancia", "Land Rover", "Landwind", "Lexus", "Lotus", "Maserati", "Maybach", "Mazda", "McLaren", "Mercedes-Benz", "MG", "Mini", "Mitsubishi", "Morgan", "Nissan", "Opel", "Peugeot", "Porsche", "Renault", "Rolls-Royce", "Rover", "Saab", "Seat", "Skoda", "Smart", "SsangYong", "Subaru", "Suzuki", "Tesla", "Toyota", "Volkswagen", "Volvo"};

        System.out.println("LENGTH:" + testCarNames.length);
        a1 = io.loadAutomotive();


        /**
         * BUILDING CAR INSTANCES WORKFLOW
         *    - user enters the menu
         *    - loop menu until user exits
         *    - have text file with an array of names, prices, a number of option sets, and each option set line containing
         *    an array of option data(this does not account for specific cars with specific parts. its pure customizable)
         *    - when user wants to build auto, load car config data into the automobile(we only have configs for 1 right now).
         - user will have access to that automobile instance's data
         - when customizing, automobile instance will have a list of user's choice( we will do something with this later)
         - when user finishes cache the automobile into a linked hashmap


         here we will make dummy instances for now
         */

        String choice = null;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("BUILDING AUTOMOBILE:");
            System.out.println("Press [Y/N]");
            choice = sc.nextLine();
            if (choice.equalsIgnoreCase("y")) {
                int randInt = rand.nextInt(testCarNames.length - 0) + 0;
                //handle collisons
                if (cacheAutos.containsKey(testCarNames[randInt])) {
                    cacheAutos.put(testCarNames[randInt], cacheAutos.get(testCarNames[randInt]));
                } else {
                    //put in a new car name and automobile instance
                    Automobile a = io.loadAutomobileOptionSets();
                    a.setName(testCarNames[randInt]);
                    a.setBasePrice(rand.nextFloat() * (100000f - 50000f) + 50000f);
                    cacheAutos.put(a.getName(), a);
                }
            } else if (choice.equalsIgnoreCase("n")) {
                System.out.println("SAVED AUTOMOBILES");
                System.out.println("BYE");
                finishedBuilding = true;
            } else {
                System.out.println("INVALID INPUT!");
            }
        } while (finishedBuilding == false);

        for (String s : testCarNames) {
            if (cacheAutos.containsKey(s)) {
                System.out.println(cacheAutos.get(s).toString());
            }
        }
//		int[] errNums = io.readArrayOfErrors("listOfErrors.txt");
//		//@TODO: convert a while-loop
//		if (!problemFixed) {
//			for (int n : errNums) {
//				fix(n);
//			}
//			//update problemFixed when no more problems are left
//			problemFixed = fix(-1);
//		}
//		addAutomobile(a1);


    }
    //for building multiple autos


    @Override
    public void printAuto(String modelName) {
//        System.out.println(cacheAutos.get(modelName));
    }

    @Override
    public void printAutos(LinkedHashMap<String, Automobile> autos) {
        for (String key : autos.keySet()) {
            printAuto(key);
        }
    }


    // CRUD for automobile instances
    public LinkedHashMap<String, Automobile> getCacheAutos() {
        return cacheAutos;
    }

    public Automobile getAutomobile(String name) {
        return getCacheAutos().get(name);
    }

    public void removeAutomobile(String name) {
        getCacheAutos().remove(name);
    }

    public void printAutos() {
        for (String key : getCacheAutos().keySet()) {
            System.out.println(getAutomobile(key));
        }
    }


    @Override
    public void updateOptionSetName(String modelName, String OptionSetName, String newName) {
        if (a1.getName().equals(modelName)) {
            a1.updateOptionSetName(OptionSetName, newName);
        }
    }

    @Override
    public void updateOptionPrice(String modelName, String OptionSetName, String OptionName, float newPrice) {
        if (a1.getName().equals(modelName)) {
            a1.updateOptionPrice(OptionSetName, OptionName, newPrice);
        }
    }


    /**
     * Plan of attack:
     * - externally: loop through a fixed number of lines from the list of errors and parse the first element
     * - funnel that error into this function and we will determine the fix to the program based on the base made in the switch statement
     * - we will right now solve 1 error because i need to get this lab turned in, and work on SQL assignment. then backtrack to this to write cleaner code!
     */

    //each error number is read from a .txt file and directed to a specific fix
    @Override
    public boolean fix(int errNo) throws IOException {
        Fix1to100 f1 = new Fix1to100();
        switch (errNo) {
            case 0:
                f1.fixMissingPriceFromTextFile();
                break;
            default:
                break;
        }
        return true;
    }

    @Override
    public void storeAuto(Automobile a) {
//        cacheAutos.put(a.getName(), a);
    }

    @Override
    public void storeAuto(String name) {

    }
}
