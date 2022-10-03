package Model;

import java.io.IOException;

/**
 * Handles CRUD of Option instances
 * <p>
 * OPTION SET = collection of options
 */
class OptionSet {

	private Option optionSet[];
	private String name;


	/**
	 * @param n    = name of option set
	 * @param size = number of options
	 */
	public OptionSet(String n, int size) {
		setName(n);
		optionSet = new Option[size];
		//initialize array of options with new instances of empty options
		for (int i = 0; i < size; i++) {
			optionSet[i] = new Option();
		}
	}

	public OptionSet(String n) {
		this(n, 0);
	}

	public OptionSet(int n) {
		this("", n);
	}

	public OptionSet() {
		setName("");
		optionSet = new Option[0];
	}

	//if we want to create an option set instance without needing to specify its size of options


	//access the collection of options
	protected Option[] getOptions() {
		return optionSet;
	}

	protected int getOptionSetSize() {
		if (getOptions().length == 0) {
			return 0;
		}
		return getOptions().length;
	}

	//retrieve an option by index
	protected Option getOption(int i) {
		return getOptions()[i];
	}

	protected Option getOption(String n) {
		for (int i = 0; i < getOptionSetSize(); i++) {
			if (getOption(i).getName().equals(n)) {
				return getOption(i);
			}
		}
		return new Option("DOES NOT EXIST!", 0);
	}


	protected String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;
	}


	protected void addOption(int i, Option o) {

	}

	protected void setOption(int i, Option o) {
		getOptions()[i] = o;
	}

	//if you want to update the list of options to a new set
	protected void updateOptions(Option[] options) {
		this.optionSet = options;
	}

	//if you want to update an option, specify an index and a new option
	protected void updateOption(int i, Option o) {
		optionSet[i] = o;
	}


	// [X] printing info about option set and its options
	public String toString() {
		StringBuffer sb = new StringBuffer("OPTIONSET NAME:" + getName());
		for (int i = 0; i < getOptionSetSize(); i++) {
			sb.append("\n" + getOption(i).toString());
		}
		return sb.toString();
	}

	//inner class
	public class Option {


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
			this("", p);
		}

		protected Option() {
			setName("");
			setPrice(0f);
		}
//		protected Option(String n, float p) {
//			name = n;
//			price = p;
//		}
//
//		protected Option(String n) {
//			name = n;
//			price = 0f;
//		}
//
//
//		protected Option() {
//			setName("");
//			setPrice(-1);
//		}

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

		protected void updateOption(String n, float p) {
			setName(n);
			setPrice(p);
		}

		//[X] printing information about option instance
		public String toString() {
			StringBuffer sb = new StringBuffer("                OPTION NAME: " + getName() + ",OPTION PRICE: " + getPrice());
			return sb.toString();
		}

	}

}
