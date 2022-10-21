package Model;

import java.io.Serializable;
import java.util.ArrayList;

public class Automobile implements Serializable {

	private String name;
	private float basePrice;
	//automobile manufacturer
	private String make;
	//automobile year
	private int year;
	//
	private String model;


	//array of Option Set instances

	//stores all possible configurations for an automobile
	private OptionSet[] optionSets;
	//stores all possible configurations for an automobile
	private ArrayList<OptionSet> optSets;
	//used to store a chosen automobile option
	private ArrayList<OptionSet.Option> choice;

	/**
	 * @param n    automobile name
	 * @param p    automobile price
	 * @param size number of option sets
	 */
	public Automobile(String n, float p, int size) {
		// initialize the array of Option Set instances with empty Option Set instances
		optionSets = new OptionSet[size];
		setName(n);
		setBasePrice(p);
		for (int i = 0; i < optionSets.length; i++) {
			optionSets[i] = new OptionSet("BLANK");
		}

		//initialize array list of option sets
		optSets = new ArrayList<>();

		for (int i = 0; i < size; i++) {
			optSets.add(new OptionSet("BLANK"));
		}
		choice = new ArrayList<>();

	}

	public Automobile(String n, float p) {
		this(n, p, 0);
	}

	/**
	 * @param n
	 * @param size
	 */
	public Automobile(String n, int size) {
		this(n, 0f, size);
	}

	/**
	 * @param size
	 * @param p
	 */
	public Automobile(int size, float p) {
		this("BLANK", p, size);
	}

	/**
	 * @param p
	 */
	public Automobile(float p) {
		this("BLANK", p, 0);
	}

	/**
	 * @param size
	 */
	public Automobile(int size) {
		this("BLANK", 0, size);
	}


	/**
	 *
	 */
	public Automobile() {
		this("BLANK", 0, 0);
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

	public ArrayList<OptionSet> getOptionSetList() {
		return optSets;
	}

	// do  not delete. these are old CRUD functions utilizing the array of Option Sets
	//change auto motible data
	public void updateAutomobile(String name, float price) {
		setName(name);
		setBasePrice(price);
	}

	//-------------------- OPTION SET CLASS INSTANCE C.R.U.D ---------------

	//create option set instance
	//[O]
	public OptionSet createOptionSetInstance(String name, int size) {
		return new OptionSet(name, size);
	}

	public OptionSet createOptionSetInstance(int size) {
		return new OptionSet(size);
	}

	public OptionSet createOptionSetInstance(String name) {
		return new OptionSet(name);
	}

	//[O]
	public OptionSet createOptionSetInstance() {
		return new OptionSet();
	}

	//retrieve an option set by index
	//[O]
	public OptionSet getOptionSetClassInstance(int i) {
		if (i < 0 || i >= getOptionSetsSize() || getOptionSets()[i] == null) {
			return new OptionSet();
		}
		return getOptionSets()[i];
	}

	//retrieve an option set by string
	//[O]
	public OptionSet getOptionSetClassInstance(String optionSetName) {
		for (int i = 0; i < getOptionSetsSize(); i++) {
			if (getOptionSetClassInstance(i).getName().equals(optionSetName)) {
				return getOptionSetClassInstance(i);
			}
		}
		System.out.println("CANNOT FIND OPTION SET INSTANCE!");
		return new OptionSet();
	}

	public void printAllOptionSetInstances() {
		for (int i = 0; i < getOptionSetsSize(); i++) {
			System.out.println(getOptionSetClassInstance(i).toString());
		}
	}
	//-------------------------------------------------------------------------


	//[O]
	public String getOptionSetName(int i) {
		return getOptionSetClassInstance(i).getName();
	}

	public String getOptionSetName(String optionSetName) {
		return getOptionSetClassInstance(optionSetName).getName();
	}


	//[O]
	public void updateOptionSetInstance(int i, OptionSet os) {
		if (i < 0 || i >= getOptionSetsSize()) {
			//throw custom exception
			System.out.println("CANNOT FIND OPTION SET INSTANCE!");
		}
		getOptionSets()[i] = os;
	}

	public void updateOptionSetInstance(String optionSetName, OptionSet os) {
		for (int i = 0; i < getOptionSetsSize(); i++) {
			if (getOptionSetClassInstance(i).getName().equals(optionSetName)) {
				updateOptionSetInstance(i, os);
			}
		}
		//throw custom exception
		System.out.println("CANNOT FIND OPTION SET INSTANCE!");
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


	public void updateOptionSetInstance(int optionSetIndex, int optionSetSize, String optionSetName, int optionIndex, String optionName, float optionPrice) {


		updateOptionSetInstance(optionSetIndex, createOptionSetInstance(optionSetName, optionSetSize));
		updateOptionClassInstance(optionSetIndex, optionIndex, optionName, optionPrice);
	}


	//UPDATE
	//using Option Set class instance to retrieve an option set name

	//[O]
	public void updateOptionSetName(int i, String n) {
		getOptionSetClassInstance(i).setName(n);
	}

	public void updateOptionSetName(String replaceName) {
		for (int i = 0; i < getOptionSetsSize(); i++) {
			updateOptionSetName(i, replaceName);
		}
	}

	//[O]
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
	//[O]
	public void deleteOptionSetInstance(int i) {
		updateOptionSetInstance(i, createOptionSetInstance());
		System.out.println("OPTION SET HAS BEEN DELETED!");
	}

	/**
	 * set an option set instance to null
	 *
	 * @param n option set instance name
	 */
	//[O]
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
	 * //access an option set class instance and option class instance by index to gain access to CRUD operations for Option class
	 *
	 * @param optSetIndex
	 * @param optIndex
	 * @return
	 */
	public OptionSet.Option getOptionClassInstance(int optSetIndex, int optIndex) {
		return getOptionSetClassInstance(optSetIndex).getOption(optIndex);
	}

	/**
	 * //access an option set class instance and option class instance by name to gain access to CRUD operations for Option class
	 *
	 * @param optionSetName
	 * @param optionName
	 * @return
	 */
	public OptionSet.Option getOptionClassInstance(String optionSetName, String optionName) {
		return getOptionSetClassInstance(optionSetName).getOption(optionName);
	}

	/**
	 * //access an option set class instance and option class instance by index to gain access to CRUD operations for Option class
	 *
	 * @param optSetIndex
	 * @param optIndex
	 * @return
	 */
	public String getOptionName(int optSetIndex, int optIndex) {
		return getOptionClassInstance(optSetIndex, optIndex).getName();
	}

	public String getOptionName(String optSetName, String optName) {
		return getOptionClassInstance(optSetName, optName).getName();
	}

	/**
	 * //access an option set class instance and option class instance by index to gain access to CRUD operations for Option class
	 *
	 * @param optSetIndex
	 * @param optIndex
	 * @param name
	 */
	public void updateOptionName(int optSetIndex, int optIndex, String name) {
		getOptionClassInstance(optSetIndex, optIndex).setName(name);
	}

	/**
	 * access an option set class instance and option class instance by index to gain access to CRUD operations for Option class
	 *
	 * @param optSetIndex
	 * @param optIndex
	 * @return
	 */

	public float getOptionPrice(int optSetIndex, int optIndex) {
		return getOptionClassInstance(optSetIndex, optIndex).getPrice();
	}

	/**
	 * access an option set class instance and option class instance by index to gain access to CRUD operations for Option class
	 *
	 * @param optSetIndex
	 * @param optIndex
	 * @param price
	 */
	public void updateOptionPrice(int optSetIndex, int optIndex, float price) {
		getOptionClassInstance(optSetIndex, optIndex).setPrice(price);
	}

	/**
	 * access an option set class instance and option class instance by index to gain access to CRUD operations for Option class
	 *
	 * @param OptionSetName
	 * @param OptionName
	 * @param newPrice
	 */
	public void updateOptionPrice(String OptionSetName, String OptionName, float newPrice) {
		getOptionClassInstance(OptionSetName, OptionName).setPrice(newPrice);
	}

	/**
	 * access an option set class instance and option class instance by index to gain access to CRUD operations for Option class
	 *
	 * @param optSetIndex
	 * @param optIndex
	 * @param optionName
	 * @param optionPrice
	 */
	//[O]
	public void updateOptionClassInstance(int optSetIndex, int optIndex, String optionName, float optionPrice) {
		//access the index of an option class instance for both i and j for setting price and name
		updateOptionPrice(optSetIndex, optIndex, optionPrice);
		updateOptionName(optSetIndex, optIndex, optionName);
	}

	/**
	 * search by optset index and opt index. replace with empty option instance
	 *
	 * @param optSetIndex
	 * @param optIndex
	 */

	//[O]
	public void deleteOptionClassInstance(int optSetIndex, int optIndex) {
		getOptionSetClassInstance(optSetIndex).setOption(optIndex, getOptionSetClassInstance(optIndex).createOption());
	}

	/**
	 * search by optset name and opt name. replace with empty option instance
	 *
	 * @param optSetName
	 * @param optName
	 */
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

	public ArrayList<OptionSet> getOptSets() {
		return optSets;
	}

	public int optnSetsListSize() {
		return getOptSets().size();
	}

	public OptionSet getOptnSetOption(int i) {
		return getOptSets().get(i);
	}


	public float getTotalPrice() {
		//@TODO: calculate the total price of purchases
		float total = 0f;
		for (OptionSet.Option o : choice) {
			total += getBasePrice() + o.getPrice();
		}
		return total;
	}


	// new implementation using an array list
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("\n" + this.getName() + "|" + this.getBasePrice());
		for (int i = 0; i < getOptionSetsSize(); i++) {
			sb.append("\n" + this.getOptionSetClassInstance(i).toString());
		}
		return sb.toString();
	}


}
