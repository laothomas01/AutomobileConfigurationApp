package Model;

public class Automotive {


    private String name;
    private float basePrice;
    private OptionSet[] optionSets;

    public Automotive() {

    }

    /**
     * @param n    = automotive name
     * @param size = number of option sets
     * @param p    = base price of automotive
     */
    public Automotive(String n, int size, float p) {
        optionSets = new OptionSet[size];
        setName(n);
        setBasePrice(p);
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

    public String toString() {
        StringBuffer sb = new StringBuffer(
                "NAME:" +
                getName() +
                " BASE-PRICE: "
                + getBasePrice());
        return sb.toString();
    }


}
