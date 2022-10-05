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


	//return array of Option Set instances
	public OptionSet[] getOptionSets() {
		return optionSets;
	}

	//creates an instance of an OptionSet
	public OptionSet createOptionSetInstance(String name, int size) {
		return new OptionSet(name, size);
	}

	public OptionSet createOptionSetInstance(int size) {
		return new OptionSet(size);
	}

	public OptionSet createOptionSetInstance(String name) {
		return new OptionSet(name);
	}


	//retrieve Option Set class instance from the array of Option Sets instances
	public OptionSet getOptionSetClassInstance(int i) {
		if (getOptionSets()[i] == null || i < 0 || i >= getOptionSetsSize()) {
			System.out.println("CANNOT FIND OPTION SET INSTANCE!");
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

		return null;
	}


	//update Option Set class instance
	//replace, by index , a new instance of an Option Set
	//set name and size

	public void updateOptionSet(int i, OptionSet os) {
		if (i < 0 || i >= getOptionSetsSize() || getOptionSetClassInstance(i) == null) {
			System.out.println("CANNOT FIND OPTION SET INSTANCE!");
		}
		getOptionSets()[i] = os;
	}

	public void updateOptionSet(int optionSetIndex, int optionIndex, int optionSetSize,
	                            String optionSetName, String optionName, float optionPrice) {
		updateOptionSet(optionSetIndex, createOptionSetInstance(optionSetName, optionSetSize));
		updateOptionClassInstance(optionSetIndex, optionIndex, optionName, optionPrice);
	}


	public void updateOptionSet(String n, OptionSet os) {
		for (int i = 0; i < getOptionSetsSize(); i++) {
			if (getOptionSetClassInstance(i).getName().equals(n)) {
				updateOptionSet(i, os);
			}
		}
		System.out.println("CANNOT FIND OPTION SET INSTANCE!");
	}
//
//	public void updateOptionSetClassInstance(int searchIndex, String replacementName, int replacementSize) {
//		updateOptionSetClassInstance(searchIndex, new OptionSet(replacementName, replacementSize));
//	}
//
//	public void updateOptionSetClassInstance(String searchName, String replacementName, int replacementSize) {
//		updateOptionSetClassInstance(searchName, new OptionSet(replacementName, replacementSize));
//	}

	public void deleteOptionSetInstance(int i) {
		updateOptionSet(i, null);
	}

//	public void deleteOptionSetInstance(String n) {
//		updateOptionSetClassInstance(n, null);
//	}


	//-------------------- (inside OptionSet class) OPTIONS ARRAY MUTATORS AND ACCESSORS ---------------

	//retrieve set of Options


	public OptionSet.Option[] getOptionsArray(int optionSetIndex) {
		return getOptionSetClassInstance(optionSetIndex).getOptions();
	}

	public OptionSet.Option[] getOptionsArray(String optionSetName) {
		return getOptionSetClassInstance(optionSetName).getOptions();
	}


	//using Option Set class instance to retrieve an option get name based on a specified index
	public String getOptionSetName(int i) {
		return getOptionSetClassInstance(i).getName();
	}

	//using Option Set class instance to retrieve an option set name
	public void updateOptionSetName(int i, String n) {
		getOptionSetClassInstance(i).setName(n);
	}

	public void updateOptionSetName(String replaceName) {
		for (int i = 0; i < getOptionSetsSize(); i++) {
			updateOptionSetName(i, replaceName);
		}
	}
//
//	//using Option Set class instance, set the class's Option array to a new array
//	public void setOptionsArray(int i, OptionSet.Option[] opts) {
//		getOptionsetInstance(i).updateOptions(opts);
//	}


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
	public OptionSet.Option getOptionClassInstance(int optSetIndex, int optIndex) {
		return getOptionSetClassInstance(optSetIndex).getOption(optIndex);
	}

	public OptionSet.Option getOptionClassInstance(String optionSetName, String optionName) {
		return getOptionSetClassInstance(optionSetName).getOption(optionName);
	}


	//use an indexed Option class instance from array of OptionSet instances to retrieve option name
	public String getOptionName(int optSetIndex, int optIndex) {
		return getOptionClassInstance(optSetIndex, optIndex).getName();
	}

	//use an indexed Option class instance from array of OptionSet instances to set option name
	public void updateOptionName(int optSetIndex, int optIndex, String name) {
		getOptionClassInstance(optSetIndex, optIndex).setName(name);
	}

	//use an indexed Option class instance from array of OptionSet instances to retrieve option price
	public float getOptionPrice(int optSetIndex, int optIndex) {
		return getOptionClassInstance(optSetIndex, optIndex).getPrice();
	}

	//use an indexed Option class instance from array of OptionSet instances to set option name
	public void updateOptionPrice(int optSetIndex, int optIndex, float price) {
		getOptionClassInstance(optSetIndex, optIndex).setPrice(price);
	}

	//uses Option Set class instance to set an Option instance to a new instance within Option array
	public void updateOptionClassInstance(int i, int j, String n, float p) {
		//access the index of an option class instance for both i and j for setting price and name
		updateOptionPrice(i, j, p);
		updateOptionName(i, j, n);
	}

	//---------------------- GET ARRAY SIZES -----------------------

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
