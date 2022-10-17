package Model;

import java.io.Serializable;

/**
 * [O] = works
 * [X] = broken
 */
class OptionSet implements Serializable {

    //array of Option instances
    private Option options[];
    //Option Set instance name
    private String name;


    protected OptionSet(String name, int size) {
        setName(name);
        //initialize Option instance array with blank Option instances

        options = new Option[size];
        for (int i = 0; i < size; i++) {
            options[i] = new Option("BLANK OPTION", 0);
        }
    }

    //[O]
    protected OptionSet(String name) {
        this(name, 0);
    }

    //[O]
    protected OptionSet(int size) {
        this("BLANK OPTION", size);
    }

    //[O]
    protected OptionSet() {
        this("BLANK OPTION", 0);
    }

    //---------------------- OPTION SET INSTANCE CRUD OPERATIONS ----------------
    //[O]
    protected String getName() {
        return name;
    }

    //retrieve Option array
    //[O]
    protected Option[] getOptions() {
        return options;
    }

    //retrieve Option array length
    //[O]
    protected int getOptionsSize() {
        if (getOptions().length == 0) {
            return 0;
        }
        return getOptions().length;
    }

    //[O]
    protected void setName(String name) {
        this.name = name;
    }

    protected Option createOption() {
        return new Option();
    }

    //retrieve Option class instance by index

    protected Option getOption(int i) {

        if (getOptions()[i] == null || i < 0 || i >= getOptionsSize()) {
            return new Option();
        }
        return getOptions()[i];
    }

    //basic retrieve Option instance by name
    protected Option getOption(String n) {
        for (int i = 0; i < getOptionsSize(); i++) {
            if (getOption(i).getName().equals(n)) {
                return getOption(i);
            }
        }
        return new Option();
    }

    //search by index and replace current Option instance with new Option instance
    protected void setOption(int searchIndex, Option o) {
        if (searchIndex < 0 || searchIndex >= getOptionsSize()) {
            System.out.println("OPTION DOES NOT EXIST!");
        }
        getOptions()[searchIndex] = o;
    }

    //search by name and replace current Option instance with new Option instance
    protected void setOption(String searchName, Option o) {
        for (int i = 0; i < getOptionsSize(); i++) {
            if (getOption(i).getName().equals(searchName)) {
                setOption(i, o);
            }
        }
        System.out.println("OPTION DOES NOT EXIST!");
    }

    //search by index and update option instance to empty Option class instance
    protected void deleteOption(int i) {
        //change specified option at index i = to empty Option class instance
        setOption(i, new Option());
    }

    //search by name and replace option instance with empty Option class instance
    protected void deleteOption(String name) {
        setOption(name, new Option());
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < getOptionsSize(); i++) {
            sb.append(getName() + "|" + getOption(i) + "\n");
        }

//		sb.append(getName());
//		sb.append(getOption(0).getName() + " " + getOption(0).getPrice());
//		sb.append(getName() + "|");
//
//        for (int i = 0; i < getOptionsSize(); i++) {
//            if (i == getOptionsSize() - 1) {
//                sb.append(getOption(i).getName() + "");
//            } else {
//                sb.append(getOption(i).getName() + " ");
//            }
//        }
//        sb.append("|");
//        for (int i = 0; i < getOptionsSize(); i++) {
//            if (i == getOptionsSize() - 1) {
//                sb.append(getOption(i).getPrice() + "");
//            } else {
//                sb.append(getOption(i).getPrice() + " ");
//            }
//        }
        return sb.toString();
    }

    //inner class
    protected class Option implements Serializable {

        private String name;
        private float price;

        protected Option(String n, float p) {
            name = n;
            price = p;
        }

        protected Option(String n) {
            this(n, 0);
        }

        protected Option(float p) {
            this("BLANK OPTION", p);
        }

        protected Option() {
            this("BLANK OPTION", 0f);
        }

        protected String getName() {
            return name;
        }

        protected void setName(String name) {
            this.name = name;
        }

        protected float getPrice() {
            return price;
        }

        protected void setPrice(float price) {
            this.price = price;
        }

        public String toString() {
            StringBuffer sb = new StringBuffer();
            sb.append(getName() + " " + getPrice());
            return sb.toString();
        }

    }

}
