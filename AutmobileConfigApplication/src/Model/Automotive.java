package Model;

import java.io.Serializable;

/**
 * let's build a reference base object model with options the end user should be able to select from
 * to customize their vehicle
 * <p>
 * make public and handle CRUD for option set instances and option instances
 * <p>
 * OPTION SETS = collection of option sets
 */
public class Automotive implements Serializable {
	/**
	 * Note to self:
	 * chaining methods can allow for resusability, less lines of code, and faster computation
	 * ex: just look up 1 instance of an option set via using an index and print it. it will give you the option set data and
	 * a data of each option set's options.
	 * <p>
	 * - reusing instances of a class that depends on a parent allows for access down a hierarchy of classes that relies only on the parent class method's input.
	 */

	private String name;
	private float basePrice;
	private OptionSet[] optionSets;

	/**
	 * @param n    = automotive name
	 * @param size = number of option sets
	 * @param p    = base price of automotive
	 */
	//chain the constructors
	public Automotive(String n, float p, int size) {
		optionSets = new OptionSet[size];
		setName(n);
		setBasePrice(p);
		for (int i = 0; i < optionSets.length; i++) {
			optionSets[i] = new OptionSet();
		}
	}

	public Automotive(String n, int size) {
		this(n, 0f, size);
	}

	public Automotive(int size, float p) {
		this("", p, size);
	}

	public Automotive(float p) {
		this("", p, 0);
	}

	public Automotive(int size) {
		this("", 0, size);
	}


	public Automotive() {
		this("", 0, 0);
	}

	/**
	 * Create a chaining of constructors
	 * Things to notice(write this down into notes later)
	 * - Make sure the backend class functions are properly working
	 * - There is a hierarchy of class dependencies at work here
	 * Automotive -> OptionSet -> Option
	 * OptionSets [ Option Set [ Option ] ]
	 *
	 * @return
	 */
	//---------------------------- AUTOMOTIVE MUTATOR AND ACCESSOR ------------------
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


	//-------------------- OPTION SET ARRAY MUTATOR AND ACCESSOR ---------------


	//retrieve Option Set class instance from the array of Option Sets instances

	//takes an index to retrieve current option set instance
	public OptionSet getOptionSetInstance(int i) {
		return getOptionSets()[i];
	}

	//update Option Set class instance
	//replace, by index , a new instance of an Option Set
	//set name and size
	public void setOptionSetInstance(int i, String name, int size) {
		getOptionSets()[i] = new OptionSet(name, size);
	}

	//retrieve set of Option Set class instances
	public OptionSet[] getOptionSets() {
		return optionSets;
	}

	public String OptionSetToString(int i) {
		return getOptionSetInstance(i).toString();
	}


	//-------------------- (inside OptionSet class) OPTIONS ARRAY MUTATORS AND ACCESSORS ---------------

	//retrieve set of Options

	// takes single index = index of current option set instance and uses the instance to retrieve the array of Option class instances
	public OptionSet.Option[] getOptions(int i) {
		return getOptionSetInstance(i).getOptions();
	}

	//using Option Set class instance to retrieve an option get name based on a specified index
	public String getOptionSetName(int i) {
		return getOptionSetInstance(i).getName();
	}

	//using Option Set class instance to retrieve an option set name

	public void setOptionSetName(int i, String n) {
		getOptionSetInstance(i).setName(n);
	}

	//using Option Set class instance, set the class's Option array to a new array
	public void setOptions(int i, OptionSet.Option[] opts) {
		getOptionSetInstance(i).updateOptions(opts);
	}


	// --------------------- OPTION MUTATORS AND ACCESSORS -----------------

	/**
	 * Used to
	 *
	 * @param optSetIndex
	 * @param optIndex
	 * @return
	 */
	//retrieve Option class instance from array of OptionSet instances

	//these instances will be to modify or retrieve Option class instances from an array

	//will require a second index to map to each index within the Option class array
	public OptionSet.Option getOptionInstance(int optSetIndex, int optIndex) {
		return getOptionSetInstance(optSetIndex).getOption(optIndex);
	}

	//use an indexed Option class instance from array of OptionSet instances to retrieve option name
	public String getOptionName(int optSetIndex, int optIndex) {
		return getOptionInstance(optSetIndex, optIndex).getName();
	}
	//use an indexed Option class instance from array of OptionSet instances to set option name

	public void setOptionName(int optSetIndex, int optIndex, String name) {
		getOptionInstance(optSetIndex, optIndex).setName(name);
	}
	//use an indexed Option class instance from array of OptionSet instances to retrieve option price

	public float getOptionPrice(int optSetIndex, int optIndex) {
		return getOptionInstance(optSetIndex, optIndex).getPrice();
	}

	//use an indexed Option class instance from array of OptionSet instances to set option name
	public void setOptionPrice(int optSetIndex, int optIndex, float price) {
		getOptionInstance(optSetIndex, optIndex).setPrice(price);
	}

	//uses Option Set class insrtance to set an Option instance to a new instance within Option array

	public void setOption(int i, int j, String n, float p) {
		//access the index of an option class instance for both i and j for setting price and name
		setOptionPrice(i, j, p);
		setOptionName(i, j, n);
	}

	public String OptionToString(int i, int j) {
		return getOptionInstance(i, j).toString();
	}


	//---------------------- GET ARRAY SIZES -----------------------

	// Size of array of Option Set instances
	public int getOptionSetsSize() {
		return getOptionSets().length;
	}

	//get an instance of the option set class and return the length of the class's array of Option instances
	public int getOptionSetSize(int i) {
		return getOptionSetInstance(i).getOptionsSize();
	}


	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(getName() + "|" + getBasePrice());
		for (int i = 0; i < getOptionSetsSize(); i++) {
			sb.append("\n" + getOptionSetInstance(i));
		}
		return sb.toString();
	}


}
