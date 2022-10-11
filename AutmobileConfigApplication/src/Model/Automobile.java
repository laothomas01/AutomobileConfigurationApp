package Model;

import java.io.Serializable;

public class Automobile implements Serializable {

    private String name;
    private float basePrice;
    private OptionSet[] optionSets;

    /**
     * @param n    automotive name
     * @param size number of option sets
     * @param p    base price of automotive
     */
    //chain the constructors
    public Automobile(String n, float p, int size) {
        optionSets = new OptionSet[size];
        setName(n);
        setBasePrice(p);
        for (int i = 0; i < optionSets.length; i++) {
            optionSets[i] = new OptionSet();
        }
    }

    public Automobile(String n, int size) {
        this(n, 0f, size);
    }

    public Automobile(int size, float p) {
        this("", p, size);
    }

    public Automobile(float p) {
        this("", p, 0);
    }

    public Automobile(int size) {
        this("", 0, size);
    }


    public Automobile() {
        this("", 0, 0);
    }

    //---------------------------- AUTOMOTIVE CLASS C.R.U.D OPERATIONS ------------------
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(float basePrice) {
        this.basePrice = basePrice;
    }

    //return array of Option Set class instances
    public OptionSet[] getOptionSets() {
        return optionSets;
    }

    //-------------------- OPTION SET CLASS C.R.U.D ---------------


    //creates an instance of an OptionSet class instances

    //CREATE

    //CREATE OPTION SET INSTANCE -> CREATES OPTION INSTANCE
    public OptionSet createOptionSetInstance(String name, int size) {
        return new OptionSet(name, size);
    }

    public OptionSet createOptionSetInstance(int size) {
        return new OptionSet(size);
    }

    public OptionSet createOptionSetInstance(String name) {
        return new OptionSet(name);
    }

    public OptionSet createOptionSetInstance() {
        return new OptionSet();
    }

    //---------------------------------------------------------------------------

    //retrieve Option Set class instance from the array of Option Sets instances

    //READ
    public OptionSet getOptionSetClassInstance(int i) {
        if (i < 0 || i >= getOptionSetsSize() || getOptionSets()[i] == null) {
            return new OptionSet();
        }
        return getOptionSets()[i];
    }

    public OptionSet getOptionSetClassInstance(String n) {
        for (int i = 0; i < getOptionSetsSize(); i++) {
            if (getOptionSetClassInstance(i).getName().equals(n)) {
                return getOptionSetClassInstance(i);
            }
        }
        System.out.println("CANNOT FIND OPTION SET INSTANCE!");
        return new OptionSet();
    }

    //using Option Set class instance to retrieve an option get name based on a specified index

    //READ
    public String getOptionSetName(int i) {
        return getOptionSetClassInstance(i).getName();
    }


    //UPDATE
    public void updateOptionSet(int i, OptionSet os) {
        if (i < 0 || i >= getOptionSetsSize()) {
            System.out.println("CANNOT FIND OPTION SET INSTANCE!");
        }

        getOptionSets()[i] = os;
    }

    /**
     * update instance of Option Set class and instance of Option class
     *
     * @param optionSetIndex look up an option set class instance
     * @param optionIndex    look up an option class instance
     * @param optionSetSize  set size of option set array
     * @param optionSetName  set name of option set
     * @param optionName     set name of option
     * @param optionPrice    set price of option
     */
    public void updateOptionSet(int optionSetIndex, int optionSetSize, String optionSetName, int optionIndex, String optionName, float optionPrice) {


        updateOptionSet(optionSetIndex, createOptionSetInstance(optionSetName, optionSetSize));


        updateOptionClassInstance(optionSetIndex, optionIndex, optionName, optionPrice);
    }


    //replace current option set with new instance
    public void updateOptionSet(String n, OptionSet os) {
        for (int i = 0; i < getOptionSetsSize(); i++) {
            if (getOptionSetClassInstance(i).getName().equals(n)) {
                updateOptionSet(i, os);
            }
        }
        System.out.println("CANNOT FIND OPTION SET INSTANCE!");
    }

    //UPDATE
    //using Option Set class instance to retrieve an option set name
    public void updateOptionSetName(int i, String n) {
        getOptionSetClassInstance(i).setName(n);
    }

    public void updateOptionSetName(String replaceName) {
        for (int i = 0; i < getOptionSetsSize(); i++) {
            updateOptionSetName(i, replaceName);
        }
    }

    public void updateOptionSetName(String OptionSetName, String newName) {
        for (int i = 0; i < getOptionSetsSize(); i++) {
            if (getOptionSetClassInstance(i).getName().equals(OptionSetName)) {
                getOptionSetClassInstance(i).setName(newName);
            }
        }
    }


    //DELETE

    /**
     * set an option set instance to null
     *
     * @param i option set instance index
     */
    public void deleteOptionSetInstance(int i) {
        updateOptionSet(i, createOptionSetInstance());
        System.out.println("OPTION SET HAS BEEN DELETED!");
    }

    /**
     * set an option set instance to null
     *
     * @param n option set instance name
     */
    public void deleteOptionSetInstance(String n) {
        for (int i = 0; i < getOptionSetsSize(); i++) {
            if (getOptionSetName(i).equals(n)) {
                deleteOptionSetInstance(i);
            }
        }
        System.out.println("CANNOT FIND OPTION SET INSTANCE!");
    }

    /**
     * retrieve array of Option class instances by index
     *
     * @param optionSetIndex
     * @return
     */
    public OptionSet.Option[] getOptionsArray(int optionSetIndex) {
        return getOptionSetClassInstance(optionSetIndex).getOptions();
    }

    /**
     * retrieve array of Option class instances by name look up
     *
     * @param optionSetName
     * @return
     */
    public OptionSet.Option[] getOptionsArray(String optionSetName) {
        return getOptionSetClassInstance(optionSetName).getOptions();
    }

    //-------------------------------------------------------------------------------------------------


    //--------------------------------------- OPTION INSTANCE CRUD ------------------------------------

    /**
     * Used to
     *
     * @param optSetIndex
     * @param optIndex
     * @return
     */


    //access an option set class instance and option class instance by index to gain access to CRUD operations for Option class
    public OptionSet.Option getOptionClassInstance(int optSetIndex, int optIndex) {
        return getOptionSetClassInstance(optSetIndex).getOption(optIndex);
    }
    //access an option set class instance and option class instance by name to gain access to CRUD operations for Option class

    public OptionSet.Option getOptionClassInstance(String optionSetName, String optionName) {
        return getOptionSetClassInstance(optionSetName).getOption(optionName);
    }

    //access an option set class instance and option class instance by index to gain access to CRUD operations for Option class
    public String getOptionName(int optSetIndex, int optIndex) {
        return getOptionClassInstance(optSetIndex, optIndex).getName();
    }

    //access an option set class instance and option class instance by index to gain access to CRUD operations for Option class
    public void updateOptionName(int optSetIndex, int optIndex, String name) {
        getOptionClassInstance(optSetIndex, optIndex).setName(name);
    }
    //access an option set class instance and option class instance by index to gain access to CRUD operations for Option class

    public float getOptionPrice(int optSetIndex, int optIndex) {
        return getOptionClassInstance(optSetIndex, optIndex).getPrice();
    }
    //access an option set class instance and option class instance by index to gain access to CRUD operations for Option class

    public void updateOptionPrice(int optSetIndex, int optIndex, float price) {
        getOptionClassInstance(optSetIndex, optIndex).setPrice(price);
    }


    //update an Option based on given option set name and option name
    public void updateOptionPrice(String OptionSetName, String OptionName, float newPrice) {
        getOptionClassInstance(OptionSetName, OptionName).setPrice(newPrice);
    }
    //access an option set class instance and option class instance by index to gain access to CRUD operations for Option class

    public void updateOptionClassInstance(int i, int j, String n, float p) {
        //access the index of an option class instance for both i and j for setting price and name
        updateOptionPrice(i, j, p);
        updateOptionName(i, j, n);
    }


    public void deleteOptionClassInstance(int i, int j) {
        getOptionSetClassInstance(i).setOption(j, getOptionSetClassInstance(i).createOption());
    }


    public void deleteOptionClassInstance(String optSetName, String optName) {
        getOptionSetClassInstance(optSetName).setOption(optName, getOptionSetClassInstance(optSetName).createOption());
    }


    /**
     * @return length of array of option set instances
     */
    public int getOptionSetsSize() {
        return getOptionSets().length;
    }


    /**
     * @param i option set index
     * @return length of array containing option instances
     */
    public int getOptionsArraySize(int i) {
        return getOptionSetClassInstance(i).getOptionsSize();
    }

    /**
     * length of array containing option instances
     *
     * @param n option set name
     */
    public int getOptionsArraySize(String n) {
        return getOptionSetClassInstance(n).getOptionsSize();
    }


    /**
     * @return base price, name, option set names, option names, option prices
     */
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(getName() + "|" + getBasePrice());
        for (int i = 0; i < getOptionSetsSize(); i++) {
            sb.append("\n" + getOptionSetClassInstance(i));
        }
        return sb.toString();
    }


}
