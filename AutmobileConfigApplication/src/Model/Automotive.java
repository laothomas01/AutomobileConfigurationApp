package Model;

/**
 * let's build a reference base object model with options the end user should be able to select from
 * to customize their vehicle
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
	//chain the constructors

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

	//return array of option sets
	public OptionSet[] getOptionSets() {
		return optionSets;
	}

	//get an option set based on its index
	public OptionSet getOptionSet(int i) {
		return getOptionSets()[i];
	}

	//get an option set based on name
	public OptionSet getCarOptionSet(String n) {
		for (int i = 0; i < getOptionSetsSize(); i++) {
			if (getOptionSet(i).getName().equals(n)) {
				return getOptionSet(i);
			}
		}
		return new OptionSet("DOES NOT EXIST!", 0);
	}

	public OptionSet.Option getOption(int optSetIndex, int optIndex) {
		return getOptionSet(optSetIndex).getOption(optIndex);
	}

	public OptionSet.Option getOption(int optSetIndex, String optionName) {
		return getOptionSet(optSetIndex).getOption(optionName);
	}

	public int getOptionSetsSize() {
		return getOptionSets().length;
	}


	public void setOptionSets(OptionSet[] optionSets) {
		this.optionSets = optionSets;
	}


	public void printOptionSetsData() {
		//print vehicle name and base price
		System.out.println(this.toString());
		for (int i = 0; i < getOptionSetsSize(); i++) {
			System.out.println(getOptionSet(i).toString());
			for (int j = 0; j < getOptionSet(i).getOptionsSize(); j++) {
				System.out.println(getOptionSet(i).getOption(j).toString());
			}
		}
	}


	public void addOptionSet(int i, OptionSet os) {
		getOptionSets()[i] = os;
	}

	//not finished
	public float calculateBasePrice() {
		return 0;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer("CAR NAME:" + getName() + " CAR BASE-PRICE: " + getBasePrice());
		return sb.toString();
	}


}
