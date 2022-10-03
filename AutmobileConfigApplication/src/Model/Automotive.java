package Model;

/**
 * let's build a reference base object model with options the end user should be able to select from
 * to customize their vehicle
 * <p>
 * make public and handle CRUD for option set instances and option instances
 * <p>
 * OPTION SETS = collection of option sets
 */
public class Automotive {


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
		setOptionPrice(i, j, p);
		setOptionName(i, j, n);
	}


	//---------------------- GET ARRAY SIZES -----------------------

	// Size of array of Option Set instances
	public int getOptionSetsSize() {
		return getOptionSets().length;
	}

	// Size of array of Option instances
	public int getOptionsSize(int i) {
		return getOptions(i).length;
	}


//	public String getOptionSetName(int i) {
//		return getOptionSet(i).getName();
//	}
//
//	public void setOptionSetName(int i, String n) {
//		getOptionSet(i).setName(n);
//	}
//
//	public OptionSet getOptionSet(String n) {
//		for (int i = 0; i < getOptionSetsSize(); i++) {
//			if (getOptionSet(i) == null) {
//				return new OptionSet();
//			} else if (getOptionSet(i).getName().equals(n)) {
//				return getOptionSet(i);
//			} else {
//				return new OptionSet();
//			}
//		}
//		return new OptionSet();
//	}
//
//
//	public int getOptionSetSize(int i) {
//		return getOptionSet(i).getOptionSetSize();
//	}
//
//	public String optionSetToString(int i) {
//		return getOptionSet(i).toString();
//	}
//
//	public void deleteOptionSet(int i) {
//		setOptionSet(i, null);
//	}
//
//	public void setOptionSet(int i, OptionSet o) {
//		getOptionSets()[i] = o;
//	}
//
//	public void addOptionSet(int index, String n, int size) {
////		optionSets[index] = new OptionSet(n, size);
//		setOptionSet(index, new OptionSet(n, size));
//	}
//
//
//	// --------------------- HANDLING AN OPTION ------------------
////	public OptionSet.Option getOption(int optionSetIndex, int optionIndex) {
////		return getOptionSet(optionSetIndex).
////	}
////	public OptionSet.Option getOption(int optionSetIndex, int optionIndex) {
////		return getOptionSet(optionIndex).getOption(optionIndex);
////	}
//
//
//	//  @TODO BUGGED.
//
//	/**
//	 * Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 3 out of bounds for length 2
//	 * at Model.OptionSet.getOption(OptionSet.java:59)
//	 * at Model.Automotive.getOption(Automotive.java:147)
//	 * at Model.Automotive.optionToString(Automotive.java:153)
//	 * at Driver.CarConfigApplication.main(CarConfigApplication.java:48)
//	 */
////	public String optionToString(int optionSetIndex, int optionIndex) {
////		return "";
////	}
////
////	public String getOptionName(int optionSetIndex, int optionIndex) {
////		return getOption(optionSetIndex, optionIndex).getName();
////	}
////
////	public float getOptionPrice(int optionSetIndex, int optionIndex) {
////		return getOption(optionSetIndex, optionIndex).getPrice();
////	}
//	public void setOption(int optionSetIndex, int optionIndex, OptionSet.Option o) {
//		getOptionSet(optionSetIndex).setOption(optionIndex, o);
//	}
//
//	public void addOption(int optionSetIndex, int optionIndex, String name, float price) {
//		OptionSet os = getOptionSet(optionSetIndex);
//		OptionSet.Option opt = os.new Option(name, price);
//
//		setOption(optionSetIndex, optionIndex, opt);
//	}


	//------------------------------------------------------------


//-----------------------------------

	/**
	 * Let's create public access through an Automotive instance to the protected OptionSet and Option functions
	 *
	 * @return
	 */

//	public OptionSet getOptionSet(int i) {
//		return getOptionSets()[i];
//	}
//
//	public String getOptionSetName(int i) {
//		return getOptionSet(i).getName();
//	}

//
//	//get an option set based on its index
//	public OptionSet getOptionSet(int i) {
//		return getOptionSets()[i];
//	}
//
//	//get an option set based on name
//	public OptionSet getOptionSet(String n) {
//		for (int i = 0; i < getOptionSetsSize(); i++) {
//			if (getOptionSet(i).getName().equals(n)) {
//				return getOptionSet(i);
//			}
//		}
//		return new OptionSet("DOES NOT EXIST!", 0);
//	}

	//-----------------------------------------------------------------------------

	//--------------------------- HANDLING AN OPTION ------------------------------
//	public OptionSet.Option getOption(int optSetIndex, int optIndex) {
//		return getOptionSet(optSetIndex).getOption(optIndex);
//	}
//
//	public OptionSet.Option getOption(int optSetIndex, String optionName) {
//		return getOptionSet(optSetIndex).getOption(optionName);
//	}


	//
//
//	public void setOptionSets(OptionSet[] optionSets) {
//		this.optionSets = optionSets;
//	}
//
//
	public void printOptionSetsData() {
		//print vehicle name and base price
//		for (int i = 0; i < getOptionSetSize(0); i++) {
//			System.out.println(getOption(0, i));
//		}
//		for (int i = 0; i < getOptionSetsSize(); i++) {
//			System.out.println(getOptionSet(i));
////			for (int j = 0; j < getOptionSetSize(i); i++) {
////				System.out.println(getOption(optSet, opt));
////			}
//		}
	}

	//
//
//	public void addOptionSet(int i, OptionSet os) {
//		getOptionSets()[i] = os;
//	}
//
//	//not finished
//	public float calculateBasePrice() {
//		return 0;
//	}
	public String toString() {
		StringBuffer sb = new StringBuffer(getName() + "|" + getBasePrice());
//		for (int i = 0; i < getOptionSetsSize(); i++) {
//			System.out.println(getOptionSet(i));
//		}
		return sb.toString();
	}


}
