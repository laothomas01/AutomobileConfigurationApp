package Adapter;

import Model.Automobile;
import Utils.FileIO;

/**
 * let's box all CRUD operations into separate interfaces
 * <p>
 * i dont know if this TRULY works. i have to make everything protected in Automobile and test
 * <p>
 * i will need to refactor some of my automobile class to bring and create extensible methods to this class
 * <p>
 * Automobile class needs to create generalized methods of lower level classes
 * <p>
 * Problem here: now i have 2 public classes on my hands and this class did not really do much for my automobile class
 */
//when new interface is added, just implement them here
// also has access to methods in abbstract class proxyAutomible
public class BuildAuto extends proxyAutomobile implements CreateAuto, UpdateAuto {


    //we can build the automotive instance without making the automobile instance public

    //how? BuildAuto contains an un-initialized instance of Automobile
    //through the extension of proxyAutomobile class
    @Override
    public void buildAuto(String fileName) {
        FileIO io = new FileIO();
        a1 = io.loadAutomotive(fileName);
    }

    //can be used AFTER calling buildAuto meaning we have instantiated the encapsulated automobile
    //instance.
    @Override
    public void printAuto(String modelName) {
        if (a1.getName().equals(modelName)) {
            System.out.println(a1.toString());
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
}
