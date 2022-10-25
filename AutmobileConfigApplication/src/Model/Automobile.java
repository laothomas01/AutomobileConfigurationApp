package Model;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import Exception.AutoException;
import Utils.FileIO;

public class Automobile implements Serializable {

	//	private String name;
	private float basePrice;
	//automobile manufacturer
	private String maker;


	//automobile year
	private int year;
	//
	private String model;


	//array of Option Set instances

	//stores all possible configurations for an automobile
//	private OptionSet[] optionSets;
	//stores all possible configurations for an automobile
	private ArrayList<OptionSet> optnSets;
	//used to store a chosen automobile option
	private ArrayList<OptionSet.Option> optnChoice;

	/**
	 * @param n    automobile name
	 * @param p    automobile price
	 * @param size number of option sets
	 */

	//automobile has SIZE amount of option sets
	public Automobile(String n, float p, int size) {
		// initialize the array of Option Set instances with empty Option Set instances
//		optionSets = new OptionSet[size];
		setModel(n);
		setBasePrice(p);


		//initialize array list of option sets
		optnSets = new ArrayList<>();

		for (int i = 0; i < size; i++) {
			//each option set should have 0 option instances until updated
			optnSets.add(createOptnSet("BLANK", 0));
		}
		optnChoice = new ArrayList<>();

		maker = "";
		year = 0;
	}


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

	public Automobile() {
		this("BLANK", 0, 0);
	}

	public String getModel() {
		return model;
	}

	public void setModel(String name) {
		this.model = name;
	}

	public float getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(float basePrice) {
		this.basePrice = basePrice;
	}

	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public void updateAutomobile(String name, float price) {
		setModel(name);
		setBasePrice(price);
	}

	// do  not delete. these are old CRUD functions utilizing the array of Option Sets
	//change automobile data


	//--------------------------------------------- OLD CODE USING BASIC ARRAY -----------------------------------------

//	//return array of Option Set class instances
//	public OptionSet[] getOptionSets() {
//		return optionSets;
//	}
//
//
//	//------------------------------------------- OPTION SET CLASS INSTANCE C.R.U.D ------------------------------------
//
//	//create option set instance
//	//[O]
//	public OptionSet createOptionSetInstance(String name, int size) {
//		return new OptionSet(name, size);
//	}
//
//	public OptionSet createOptionSetInstance(int size) {
//		return new OptionSet(size);
//	}
//
//	public OptionSet createOptionSetInstance(String name) {
//		return new OptionSet(name);
//	}
//
//	//[O]
//	public OptionSet createOptionSetInstance() {
//		return new OptionSet();
//	}
//
//	//retrieve an option set by index
//	//[O]
//	public OptionSet getOptionSetClassInstance(int i) {
//		if (i < 0 || i >= getOptionSetsSize() || getOptionSets()[i] == null) {
//			return new OptionSet();
//		}
//		return getOptionSets()[i];
//	}
//
//	//retrieve an option set by string
//	//[O]
//	public OptionSet getOptionSetClassInstance(String optionSetName) {
//		for (int i = 0; i < getOptionSetsSize(); i++) {
//			if (getOptionSetClassInstance(i).getName().equals(optionSetName)) {
//				return getOptionSetClassInstance(i);
//			}
//		}
//		System.out.println("CANNOT FIND OPTION SET INSTANCE!");
//		return new OptionSet();
//	}
//
//	public void printAllOptionSetInstances() {
//		for (int i = 0; i < getOptionSetsSize(); i++) {
//			System.out.println(getOptionSetClassInstance(i).toString());
//		}
//	}
//	//-------------------------------------------------------------------------
//
//
//	//[O]
//	public String getOptionSetName(int i) {
//		return getOptionSetClassInstance(i).getName();
//	}
//
//	public String getOptionSetName(String optionSetName) {
//		return getOptionSetClassInstance(optionSetName).getName();
//	}
//
//
//	//[O]
//	public void updateOptionSetInstance(int i, OptionSet os) {
//		if (i < 0 || i >= getOptionSetsSize()) {
//			//throw custom exception
//			System.out.println("CANNOT FIND OPTION SET INSTANCE!");
//		}
//		getOptionSets()[i] = os;
//	}
//
//	public void updateOptionSetInstance(String optionSetName, OptionSet os) {
//		for (int i = 0; i < getOptionSetsSize(); i++) {
//			if (getOptionSetClassInstance(i).getName().equals(optionSetName)) {
//				updateOptionSetInstance(i, os);
//			}
//		}
//		//throw custom exception
//		System.out.println("CANNOT FIND OPTION SET INSTANCE!");
//	}
//
//	/**
//	 * update instance of Option Set class and instance of Option class
//	 *
//	 * @param optionSetIndex look up an option set class instance
//	 * @param optionIndex    look up an option class instance
//	 * @param optionSetSize  set size of option set array
//	 * @param optionSetName  set name of option set
//	 * @param optionName     set name of option
//	 * @param optionPrice    set price of option
//	 */
//
//
//	public void updateOptionSetInstance(int optionSetIndex, int optionSetSize, String optionSetName, int optionIndex, String optionName, float optionPrice) {
//
//
//		updateOptionSetInstance(optionSetIndex, createOptionSetInstance(optionSetName, optionSetSize));
//		updateOptionClassInstance(optionSetIndex, optionIndex, optionName, optionPrice);
//	}
//
//
//	//UPDATE
//	//using Option Set class instance to retrieve an option set name
//
//	//[O]
//	public void updateOptionSetName(int i, String n) {
//		getOptionSetClassInstance(i).setName(n);
//	}
//
//	public void updateOptionSetName(String replaceName) {
//		for (int i = 0; i < getOptionSetsSize(); i++) {
//			updateOptionSetName(i, replaceName);
//		}
//	}
//
//	//[O]
//	public void updateOptionSetName(String OptionSetName, String newName) {
//		for (int i = 0; i < getOptionSetsSize(); i++) {
//			if (getOptionSetClassInstance(i).getName().equals(OptionSetName)) {
//				getOptionSetClassInstance(i).setName(newName);
//			}
//		}
//	}
//
//
//	//DELETE
//
//	/**
//	 * set an option set instance to null
//	 *
//	 * @param i option set instance index
//	 */
//	//[O]
//	public void deleteOptionSetInstance(int i) {
//		updateOptionSetInstance(i, createOptionSetInstance());
//		System.out.println("OPTION SET HAS BEEN DELETED!");
//	}
//
//	/**
//	 * set an option set instance to null
//	 *
//	 * @param n option set instance name
//	 */
//	//[O]
//	public void deleteOptionSetInstance(String n) {
//		for (int i = 0; i < getOptionSetsSize(); i++) {
//			if (getOptionSetName(i).equals(n)) {
//				deleteOptionSetInstance(i);
//			}
//		}
//		System.out.println("CANNOT FIND OPTION SET INSTANCE!");
//	}
//
//	/**
//	 * retrieve array of Option class instances by index
//	 *
//	 * @param optionSetIndex
//	 * @return
//	 */
//	public OptionSet.Option[] getOptionsArray(int optionSetIndex) {
//		return getOptionSetClassInstance(optionSetIndex).getOptions();
//	}
//
//	/**
//	 * retrieve array of Option class instances by name look up
//	 *
//	 * @param optionSetName
//	 * @return
//	 */
//	public OptionSet.Option[] getOptionsArray(String optionSetName) {
//		return getOptionSetClassInstance(optionSetName).getOptions();
//	}
//
//	//-------------------------------------------------------------------------------------------------
//
//
//	//--------------------------------------- OPTION INSTANCE CRUD ------------------------------------
//
//
//	/**
//	 * //access an option set class instance and option class instance by index to gain access to CRUD operations for Option class
//	 *
//	 * @param optSetIndex
//	 * @param optIndex
//	 * @return
//	 */
//	public OptionSet.Option getOptionClassInstance(int optSetIndex, int optIndex) {
//		return getOptionSetClassInstance(optSetIndex).getOption(optIndex);
//	}
//
//	/**
//	 * //access an option set class instance and option class instance by name to gain access to CRUD operations for Option class
//	 *
//	 * @param optionSetName
//	 * @param optionName
//	 * @return
//	 */
//	public OptionSet.Option getOptionClassInstance(String optionSetName, String optionName) {
//		return getOptionSetClassInstance(optionSetName).getOption(optionName);
//	}
//
//	/**
//	 * //access an option set class instance and option class instance by index to gain access to CRUD operations for Option class
//	 *
//	 * @param optSetIndex
//	 * @param optIndex
//	 * @return
//	 */
//	public String getOptionName(int optSetIndex, int optIndex) {
//		return getOptionClassInstance(optSetIndex, optIndex).getName();
//	}
//
//	public String getOptionName(String optSetName, String optName) {
//		return getOptionClassInstance(optSetName, optName).getName();
//	}
//
//	/**
//	 * //access an option set class instance and option class instance by index to gain access to CRUD operations for Option class
//	 *
//	 * @param optSetIndex
//	 * @param optIndex
//	 * @param name
//	 */
//	public void updateOptionName(int optSetIndex, int optIndex, String name) {
//		getOptionClassInstance(optSetIndex, optIndex).setName(name);
//	}
//
//	/**
//	 * access an option set class instance and option class instance by index to gain access to CRUD operations for Option class
//	 *
//	 * @param optSetIndex
//	 * @param optIndex
//	 * @return
//	 */
//
//	public float getOptionPrice(int optSetIndex, int optIndex) {
//		return getOptionClassInstance(optSetIndex, optIndex).getPrice();
//	}
//
//	/**
//	 * access an option set class instance and option class instance by index to gain access to CRUD operations for Option class
//	 *
//	 * @param optSetIndex
//	 * @param optIndex
//	 * @param price
//	 */
//	public void updateOptionPrice(int optSetIndex, int optIndex, float price) {
//		getOptionClassInstance(optSetIndex, optIndex).setPrice(price);
//	}
//
//	/**
//	 * access an option set class instance and option class instance by index to gain access to CRUD operations for Option class
//	 *
//	 * @param OptionSetName
//	 * @param OptionName
//	 * @param newPrice
//	 */
//	public void updateOptionPrice(String OptionSetName, String OptionName, float newPrice) {
//		getOptionClassInstance(OptionSetName, OptionName).setPrice(newPrice);
//	}
//
//	/**
//	 * access an option set class instance and option class instance by index to gain access to CRUD operations for Option class
//	 *
//	 * @param optSetIndex
//	 * @param optIndex
//	 * @param optionName
//	 * @param optionPrice
//	 */
//	//[O]
//	public void updateOptionClassInstance(int optSetIndex, int optIndex, String optionName, float optionPrice) {
//		//access the index of an option class instance for both i and j for setting price and name
//		updateOptionPrice(optSetIndex, optIndex, optionPrice);
//		updateOptionName(optSetIndex, optIndex, optionName);
//	}
//
//	/**
//	 * search by optset index and opt index. replace with empty option instance
//	 *
//	 * @param optSetIndex
//	 * @param optIndex
//	 */
//
//	//[O]
//	public void deleteOptionClassInstance(int optSetIndex, int optIndex) {
//		getOptionSetClassInstance(optSetIndex).setOption(optIndex, getOptionSetClassInstance(optIndex).createOption());
//	}
//
//	/**
//	 * search by optset name and opt name. replace with empty option instance
//	 *
//	 * @param optSetName
//	 * @param optName
//	 */
//	public void deleteOptionClassInstance(String optSetName, String optName) {
//		getOptionSetClassInstance(optSetName).setOption(optName, getOptionSetClassInstance(optSetName).createOption());
//	}
//
//
//	/**
//	 * @return length of array of option set instances
//	 */
//	public int getOptionSetsSize() {
//		return getOptionSets().length;
//	}
//
//
//	/**
//	 * @param i option set index
//	 * @return length of array containing option instances
//	 */
//	public int getOptionsArraySize(int i) {
//		return getOptionSetClassInstance(i).getOptionsSize();
//	}
//
//	/**
//	 * length of array containing option instances
//	 *
//	 * @param n option set name
//	 */
//	public int getOptionsArraySize(String n) {
//		return getOptionSetClassInstance(n).getOptionsSize();
//	}

	//------------------------------------------- OPTION SET CLASS INSTANCE C.R.U.D ------------------------------------

	//--------------------------------------------- OLD CODE USING BASIC ARRAY -----------------------------------------


	//--------------------------------------------- NEW CODE USING ARRAY-LIST -----------------------------------------

	//OPTION SETS C.R.U.D
	public OptionSet getOptnSet(int i) throws IOException {
		try {
			if (getOptnSets().get(i) == null) {
				throw new AutoException(3);
			}
		} catch (AutoException e) {
			e.setErrorMsg("Cannot Find File Name!");
			e.printMyProblem();
			String exception = e.getErrorNo() + "|" + e.getErrorMsg();
			FileIO.writeToFile("listOfErrors.txt", exception);
			FileIO.writeToLogFile(exception);
		}
		return getOptnSets().get(i);
	}

	public ArrayList<OptionSet> getOptnSets() {
		return optnSets;
	}

	public int getOptnSetsSize() {
		return getOptnSets().size();
	}

	public void addOptnSet(OptionSet os) {
		getOptnSets().add(os);
	}

	//creating an option set with SIZE amount of options
	public void addOptnSet(String name, int size) {
		getOptnSets().add(createOptnSet(name, size));
	}

	public void setOptnSetName(int i, String name) throws IOException {
		getOptnSet(i).setName(name);
	}

	public void deleteOptnSet(int i) {
		getOptnSets().remove(i);
	}


	public void deleteOptnSet(String name) throws IOException {
		for (int i = 0; i < getOptnSetsSize(); i++) {
			if (getOptnSet(i).getName().equals(name)) {
				deleteOptnSet(i);
			}
		}
	}

	//OPTION SET C.R.U.D

	public OptionSet createOptnSet(String name, int size) {
		return new OptionSet(name, size);
	}

	public void setOptnSet(int i, OptionSet os) {
		getOptnSets().set(i, os);
	}

	public void setOptnSet(int i, String name, int size) {
		setOptnSet(i, createOptnSet(name, size));
	}

	public int getOptnSetSize(int i) throws IOException {
		return getOptnSet(i).getOptnsListSize();
	}

	public String getOptnSetName(int i) throws IOException {
		return getOptnSet(i).getName();
	}

	public ArrayList<OptionSet.Option> getOptns(int i) throws IOException {
		return getOptnSet(i).getOptns();
	}


	public int getOptnListSize(int i) throws IOException {
		return getOptnSet(i).getOptnsListSize();
	}


	//OPTION C.R.U.D
//	public OptionSet.Option getOptn(int i, int j) {
//		return getOptnSet(i).getOptn(j);
//	}


	//@TODO: (WIP)
//	public OptionSet.Option getOptn(String optSetName, String optionName) {
//
//	}

//	public String getOptnName(int i, int j) {
//		return getOptn(i, j).getName();
//	}
//
//	public float getOptnPrice(int i, int j) {
//		return getOptn(i, j).getPrice();
//	}
//
//	public void setOptnName(int i, int j, String name) {
//		getOptn(i, j).setName(name);
//	}
//
//	public void setOptnPrice(int i, int j, float p) {
//		getOptn(i, j).setPrice(p);
//	}

	public void setOptn(int i, int j, OptionSet.Option o) throws IOException {
		getOptnSet(i).getOptns().set(j, o);
	}

	public void setOptn(int i, int j, String n, float p) throws IOException {
//		getOptnSet(i).getOption(j).setName(n);
//		getOptnSet(i).getOption(j).setPrice(p);
		getOptnSet(i).getOptn(j).setName(n);
		getOptnSet(i).getOptn(j).setPrice(p);
	}


	/**
	 * Option Set:
	 * set option choice(i) : choice(i) -> retrieved option(i)
	 * getOptnChoice: return choice
	 * <p>
	 * Automobile:
	 * setOptnChoice(i,j): access option set -> set up option choice
	 * <p>
	 * retrieving option choice:
	 * - get option choice name
	 * - get option choice price
	 * - get the option choice
	 */


	//access an option set
	//access an option
	//set the option choice to the

	// 1) set the option choice
	//acess option set and update option choice

	//MUST BE CALLED FIRST!
	public void setOptnChoice(int i, int j) throws IOException {
		getOptnSet(i).setOptnChoice(j);
	}


	// 2) retrieve the option choice instance you just set the option choice
	// by accessing an option set instance
	public OptionSet.Option getOptnChoice(int i) throws IOException {
		return getOptnSet(i).getOptnChoice();
	}

	// 3) get option choice name
	public String getOptnChoiceName(int i) throws IOException {
		return getOptnSet(i).getOptnChoice().getName();
	}

	// 4) get option choice price
	public float getOptnChoicePrice(int i) throws IOException {
		return getOptnSet(i).getOptnChoice().getPrice();
	}

	// 5) add the option choice

	// after setting the option choice, you can add it to the array list
	public void addOptionChoice(int i, int j) throws IOException {
////        //1) set the option choice
		setOptnChoice(i, j);
////        //2) add the option choice
		optnChoice.add(getOptnChoice(i));
	}

	public void removeOptionChoice(int i) {
		optnChoice.remove(i);
	}

	public ArrayList<OptionSet.Option> getOptnChoice() {
		return optnChoice;
	}

	//--------------------------------------------- NEW CODE USING ARRAY-LIST -----------------------------------------

	public float getTotalPrice() {
		//@TODO: calculate the total price of purchases
		float total = 0;
		for (OptionSet.Option o : optnChoice) {
			total += o.getPrice();
		}
		total += getBasePrice();
		return total;
	}


	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("\n" + getMaker() + "-" + this.getModel() + "-" + getYear() + "|" + this.getBasePrice());
		// new implementation using an array list
		for (int i = 0; i < getOptnSetsSize(); i++) {
			try {
				sb.append("\n" + this.getOptnSet(i));
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}

		//OLD CODE

//		for (int i = 0; i < getOptionSetsSize(); i++) {
//			sb.append("\n" + this.getOptionSetClassInstance(i).toString());
//		}
		return sb.toString();
	}


}
