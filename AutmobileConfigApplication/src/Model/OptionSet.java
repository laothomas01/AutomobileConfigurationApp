package Model;

import java.io.IOException;

/**
 * Handles CRUD of Option instances
 * <p>
 * OPTION SET = collection of options
 */
class OptionSet {

	private Option options[];
	private String name;


	/**
	 * Chained Constructors
	 *
	 * @param n    = name
	 * @param size = length of Option array
	 */
	public OptionSet(String n, int size) {
		setName(n);
		options = new Option[size];
		//initialize array of options with new instances of empty options
		for (int i = 0; i < size; i++) {
			options[i] = new Option();
		}
	}

	public OptionSet(String n) {
		this(n, 0);
	}

	public OptionSet(int n) {
		this("", n);
	}

	public OptionSet() {
		this("", 0);
	}

	/**
	 * Accessors and Mutators
	 *
	 * @return
	 */
	protected String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;
	}

	//retrieve Option array
	protected Option[] getOptions() {
		return options;
	}

	//retrieve Option array length
	protected int getOptionsSize() {
		if (getOptions().length == 0) {
			return 0;
		}
		return getOptions().length;
	}


	//replace with new array of Option instances
	protected void updateOptions(Option[] opts) {
		this.options = opts;
	}

	// [X] printing info about option set and its options
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(getName() + "|");
		for (int i = 0; i < getOptionsSize(); i++) {
			if (i == getOptionsSize() - 1) {
				sb.append(getOption(i).getName() + "");
			} else {
				sb.append(getOption(i).getName() + " ");
			}
		}
		sb.append("|");
		for (int i = 0; i < getOptionsSize(); i++) {
			if (i == getOptionsSize() - 1) {
				sb.append(getOption(i).getPrice() + "");
			} else {
				sb.append(getOption(i).getPrice() + " ");
			}
		}
		return sb.toString();
	}

	//retrieve an Option instance by index
	protected Option getOption(int i) {
		return getOptions()[i];
	}

	//retrieve option instance by name
	protected Option getOption(String n) {
		for (int i = 0; i < getOptionsSize(); i++) {
			if (getOption(i).getName().equals(n)) {
				return getOption(i);
			}
		}
		return new Option();
	}

	protected void setOption(int i, String n, float p) {
		updateOption(i, new Option(n, p));
	}

	//replace , by index , an input Option instance within Option array
	protected void updateOption(int i, Option o) {
		getOptions()[i] = o;
	}

	protected void deleteOption(int i) {
		//change specified option at index i = new empty Option instance.
		getOptions()[i] = new Option();
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
			this("", 0f);
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

		//[X] printing information about option instance
		public String toString() {

			StringBuffer sb = new StringBuffer(getName() + "|" + getPrice());
			return sb.toString();
		}

	}

}
