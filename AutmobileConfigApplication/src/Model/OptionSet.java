package Model;

public class OptionSet {

    private Option options[];
    private String name;


    public OptionSet() {

    }

    /**
     * @param n = name of option set
     * @param s = number of options
     */
    public OptionSet(String n, int s) {
        setName(n);
        options = new Option[s];
    }

    //access the collection of options
    public Option[] getOptions() {
        return options;
    }

    public int getOptionsSize() {
        return getOptions().length;
    }

    //retrieve an option by index
    public Option getOption(int i) {
        return getOptions()[i];
    }

    //retrieve an option by name
    //run time complexity grows really quick when size gets too large
    public Option getOption(String n) {
        for (int i = 0; i < getOptionsSize(); i++) {
            if (getOption(i).getName().equals(n)) {
                return getOption(i);
            }
        }
        return null;
    }

    //if you want to update the list of options to a new set
    public void updateOptions(Option[] options) {
        this.options = options;
    }

    //if you want to update an option, specify an index and a new option
    public void updateOption(int i, Option o) {
        options[i] = o;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer("NAME:" + getName());
        return sb.toString();
    }

    //inner class
    class Option {

        private String name;
        private int price;


        public Option(String s, int p) {
            setName(s);
            setPrice(p);
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public String toString() {
            StringBuffer sb = new StringBuffer("NAME:" + getName() + "PRICE:" + getPrice());
            return sb.toString();
        }

    }

}
