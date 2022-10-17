package Adapter;

import Utils.FileIO;
import Exception.Fix1to100;

import java.io.IOException;


public class BuildAuto extends ProxyAutomobile implements CreateAuto, UpdateAuto, FixAuto {

    //used to keep an on-going loop until all recorded exceptions are fixed
    boolean problemFixed = false;

    @Override
    public void buildAuto(String fileName) throws IOException {
        FileIO io = new FileIO(fileName);
        //attempt to populate the automobile instance with data read from the text file
        a1 = io.loadAutomotive();
        int[] errNums = io.readArrayOfErrors("listOfErrors.txt");
//
//		//@TODO: convert a while-loop
        if (!problemFixed) {
            for (int n : errNums) {
                fix(n);
            }
            //update problemFixed when no more problems are left
            problemFixed = fix(-1);
        }
        System.out.println(a1);


    }

    public void testAutomotiveFunctions() {
        System.out.println(a1.getOptionClassInstance(0, 0));
        System.out.println("BEFORE DELETING OPTION SET:" + a1);
        a1.deleteOptionSetInstance(0);
        System.out.println("AFTER DELETING OPTION SET BY INDEX:" + a1);
        a1.deleteOptionSetInstance("Brakes");
        System.out.println("AFTER DELETING OPTION SET BY NAME:" + a1);
    }


    //search for a valid automobile name and if valid, print the name
    @Override
    public void printAuto(String modelName) {
        if (a1.getName().equals(modelName)) {
            System.out.println(a1.toString());
        }
        System.out.println("Automobile cannot be found!");
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
}
