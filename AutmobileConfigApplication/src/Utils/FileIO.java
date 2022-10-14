package Utils;

import Model.Automobile;

import java.io.*;

import Exception.AutoException;

/**
 * Note: file reader is based on this format of a text file
 * car name| car price // basic car attributes
 * option set name | option name(s) | price(s) // car configurations
 * i.e
 * Transmission|automatic,manual|0,-815
 * Brakes|standard,abs,abs with advance trac|0,400,1625
 * Colors|Fort Knox Gold Clearcoat Metallic, Liquid Grey Clearcoat Metallic,Infra-Red Clearcoat,Grabber Green Clearcoat Metallic,Sangria Red Clearcoat Metallic,French Blue Clearcoat Metallic,Twilight Blue Clearcoat Metallic,CD Silver Clearcoat Metallic,Pitch Black Clearcoat,Cloud 9 White Clearcoat|0,0,0,0,0,0,0,0,0,0
 * AirBags|1,0|0,350
 */
public class FileIO {
    String fileName;

    public FileIO(String fileName) {
        this.fileName = fileName;
    }

    /**
     * if we are going to make a build auto function,we will have to still return an instance inside using
     * Automotive and then print values.
     * <p>
     * BuildAuto just serves to tell the user the automotive was built and data will be printed
     *
     * @return
     */

    public boolean openFile() throws AutoException {
        BufferedReader br = null;
        boolean flag = false;
        try {
            br = new BufferedReader(new FileReader(fileName));
            flag = true;
            br.close();
        } catch (FileNotFoundException e) {
            throw new AutoException();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {

        }
        return flag;
    }


//    public boolean openFile() throws AutoException {
//        BufferedReader br = null;
//        boolean flag = false;
//        try {
//            br = new BufferedReader(new FileReader(fileName));
//            flag = true;
//        } catch (FileNotFoundException e) {
//            throw new AutoException();
//        } finally {
//
//        }
//        return flag;
//
//
//    }

    //    public Automobile loadAutomotive(String filename) {
//        Automobile a1 = new Automobile();
//        int optionSetsSize;
//        try {
//
//            BufferedReader br1 = new BufferedReader(new FileReader(filename));
//            //if file exists, print it exists and continue with the program
//
//
//            optionSetsSize = getLineCount(br1) - 1;
//            a1 = new Automobile(optionSetsSize);
//            br1.close();
//            BufferedReader br2 = new BufferedReader(new FileReader(filename));
//            readData(br2, a1);
//            br2.close();
//        } catch (IOException e) {
//            System.out.println("Error -- " + e.toString());
//        }
//        return a1;
//    }
    public Automobile loadAutomotive() {
        //intialize as empty automobile
        Automobile a1 = new Automobile();
        int optionSetsSize;
        //try to see if file can be read
        try {
            //if configuration file can be read
            if (openFile()) {
                BufferedReader br1 = new BufferedReader(new FileReader(fileName));
                optionSetsSize = getLineCount(br1) - 1;
                //populate with number of option sets
                a1 = new Automobile(optionSetsSize);
                br1.close();
                BufferedReader br2 = new BufferedReader(new FileReader(fileName));
                readData(br2, a1);
                br2.close();
            }
            //if file cannot be read, throw exception
        } catch (AutoException ae) {

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//        try {
//
////            BufferedReader br1 = new BufferedReader(new FileReader(filename));
////            //if file exists, print it exists and continue with the program
////
////
////            optionSetsSize = getLineCount(br1) - 1;
////            a1 = new Automobile(optionSetsSize);
////            br1.close();
////            BufferedReader br2 = new BufferedReader(new FileReader(filename));
////            readData(br2, a1);
////            br2.close();
//        } catch (IOException e) {
////            System.out.println("Error -- " + e.toString());
//        }
        return a1;
    }

    public Automobile deserializeAutomotive(String filename) {
        Automobile car = null;
        try {
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);
            car = (Automobile) in.readObject();
            in.close();
            file.close();
            System.out.println("Object has been deserialized ");
        } catch (IOException ex) {
            System.out.println("IOException is caught");
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException is caught");
            throw new RuntimeException(e);
        }
        return car;

    }

    /**
     * file line count - 1
     *
     * @param b bufferedreader
     * @return total line count
     * @throws IOException
     */
    public int getLineCount(BufferedReader b) throws IOException {
        int i = 0;
        boolean eof = false;
        while (!eof) {
            String line = b.readLine();
            if (line == null) {
                eof = true;
            } else {
                i++;
            }
        }
        return i;
    }


    /**
     * read file again and load data into automobile instance
     *
     * @param br bufferedreader
     * @param a  automotive
     * @throws IOException use when file can be read
     */
    public void readData(BufferedReader br, Automobile a) throws IOException {
        //looping through each option set index within the set of option sets
        for (int i = 0; i < a.getOptionSetsSize(); i++) {
            //0th index = name and price of car. not related to car configs
            if (i == 0) {
                //read a line for the car specs
                String line = br.readLine();
                String[] carAttributes = line.split("\\|");


                //there will be an error here when trying to access index 0

                a.setName(carAttributes[0]);

                //there will be an error here when trying to access index 1
                a.setBasePrice(Float.parseFloat(carAttributes[1]));


                /**
                 * throw exception if carAttributes length < 2.
                 * - check if text is missing car name
                 * - check if text is missing car price
                 */
            }
            String line = br.readLine();
            String[] carConfigs = line.split("\\|");
            String name = carConfigs[0];
            String[] optionNames = carConfigs[1].split(" ");
            String[] optionPrices = carConfigs[2].split(" ");

            int optionsCount = optionNames.length;
            /**
             - option name[ ] length = option price [ ] length
             - 1 to 1 relationship: option name -> option price
             - option set size = # of option names = # of option prices
             - after initializing an option set, let's access the option set's options and populate those options with option data
             */
            //replace the empty option set with a new populated option set instance
            a.updateOptionSet(i, a.createOptionSetInstance(name, optionsCount));
            for (int j = 0; j < optionNames.length; j++) {
                //parse the prices because they are read as strings
                a.updateOptionClassInstance(i, j, optionNames[j], Float.parseFloat(optionPrices[j]));
            }


        }
    }

    public void serializeAutomotive(String fileName, Automobile a) {
        try {
            FileOutputStream file = new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(file);
            //Method for serialization of object
            out.writeObject(a);
            out.close();
            System.out.println("Object has been serialized");
        } catch (IOException ex) {
            System.out.println("IOException is caught");
        }
    }


}
