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

	public Automotive(String n, int size, float p) {
		optionSets = new OptionSet[size];
		setName(n);
		setBasePrice(p);
		for (int i = 0; i < optionSets.length; i++) {
			optionSets[i] = new OptionSet();
		}
		// each instance of Automotive will have N number of empty instances of option set
	}

	public Automotive(String n, int size) {
		this(n, size, -1);
	}

	public Automotive(int size, float p) {
		this("", size, p);
	}

	public Automotive(float p) {
		this("", 0, p);
	}

	//chain the constructors
	public Automotive(int size) {
		this("", size, -1);
	}

	public Automotive() {
		setName("");
		setBasePrice(-1);
		optionSets = new OptionSet[0];
	}

	/**
	 * Create a chaining of constructors
	 *
	 * @return
	 */
	//---------------------------- BASE FUNCTIONS FOR AUTOMOTIVE------------------
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

	//-----------------------------------------------------------------------------
	//return array of option sets


	//----------------------------- HANDLING OPTION SETS ------------------------
	public OptionSet[] getOptionSets() {
		return optionSets;
	}

	public int getOptionSetsSize() {
		return getOptionSets().length;
	}

	//----------------------------------------------------------------------------

	//------------------- HANDLING AN OPTION SET --------------------------
	public OptionSet getOptionSet(int i) {
		//alter the option set within OPTION SETS
		return getOptionSets()[i];
	}

	public String getOptionSetName(int i) {
		return getOptionSet(i).getName();
	}

	public void setOptionSetName(int i, String n) {
		getOptionSet(i).setName(n);
	}

	public OptionSet getOptionSet(String n) {
		for (int i = 0; i < getOptionSetsSize(); i++) {
			if (getOptionSet(i) == null) {
				return new OptionSet();
			} else if (getOptionSet(i).getName().equals(n)) {
				return getOptionSet(i);
			} else {
				return new OptionSet();
			}
		}
		return new OptionSet();
	}


	public int getOptionSetSize(int i) {
		return getOptionSet(i).getOptionSetSize();
	}

	public String optionSetToString(int i) {
		return getOptionSet(i).toString();
	}

	public void deleteOptionSet(int i) {
		setOptionSet(i, null);
	}

	public void setOptionSet(int i, OptionSet o) {
		getOptionSets()[i] = o;
	}

	public void addOptionSet(int index, String n, int size) {
//		optionSets[index] = new OptionSet(n, size);
		setOptionSet(index, new OptionSet(n, size));
	}


	// --------------------- HANDLING AN OPTION ------------------

	public OptionSet.Option getOption(int optionSetIndex, int optionIndex) {
		return getOptionSet(optionIndex).getOption(optionIndex);
	}


	//  @TODO BUGGED.

	/**
	 * Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 3 out of bounds for length 2
	 * at Model.OptionSet.getOption(OptionSet.java:59)
	 * at Model.Automotive.getOption(Automotive.java:147)
	 * at Model.Automotive.optionToString(Automotive.java:153)
	 * at Driver.CarConfigApplication.main(CarConfigApplication.java:48)
	 */
	public String optionToString(int optionSetIndex, int optionIndex) {
		return "";
	}

	public String getOptionName(int optionSetIndex, int optionIndex) {
		return getOption(optionSetIndex, optionIndex).getName();
	}

	public void setOption(int optionSetIndex, int optionIndex, OptionSet.Option o) {
		getOptionSet(optionSetIndex).setOption(optionIndex, o);
	}

	public void addOption(int optionSetIndex, int optionIndex, String name, float price) {
		OptionSet os = getOptionSet(optionSetIndex);
		OptionSet.Option opt = os.new Option(name, price);

		setOption(optionSetIndex, optionIndex, opt);
	}


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
////				System.out.println(getOption(i, j));
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
		StringBuffer sb = new StringBuffer("CAR NAME:" + getName() + "\nCAR BASE-PRICE: " + getBasePrice());
		printOptionSetsData();
		return sb.toString();
	}


}
