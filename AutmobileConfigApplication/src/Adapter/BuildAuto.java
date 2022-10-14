package Adapter;

import Utils.FileIO;


public class BuildAuto extends proxyAutomobile implements CreateAuto, UpdateAuto, FixAuto {


    @Override
    public void buildAuto(String fileName) {
        FileIO io = new FileIO(fileName);
//        a1 = io.loadAutomotive(fileName);
    }

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


    @Override
    public void fix(int errNo) {
        /**
         * Fix1to100 f1 = new Fix1to100()
         *
         */

    }
}
