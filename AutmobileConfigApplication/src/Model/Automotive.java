package Model;

public class Automotive {


    private String name;
    private float basePrice;
    private OptionSet[] optionSets;

    public Automotive() {

    }

    public Automotive(String n, int size) {
        optionSets = new OptionSet[size];
        name = n;
    }


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

    public OptionSet[] getOptionSets() {
        return optionSets;
    }

    //get an option set based on its index
    public OptionSet getOptionSet(int i) {
        return getOptionSets()[i];
    }

    //get an option set based on input option set's name
//    public OptionSet getOptionSet(String n) {
//
//    }

    public int getOptionSetsSize() {
        return getOptionSets().length;
    }


    public void setOptionSets(OptionSet[] optionSets) {
        this.optionSets = optionSets;
    }

    public static void main(String args[]) {

    }

}
