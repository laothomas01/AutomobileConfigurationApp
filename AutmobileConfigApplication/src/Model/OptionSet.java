package Model;

import java.io.IOException;

public class OptionSet {

	private Option options[];
	private String name;


	public OptionSet() {

		setName("");
		options = new Option[0];
	}

	/**
	 * @param n = name of option set
	 * @param s = number of options
	 */
	public OptionSet(String n, int s) {
		setName(n);
		options = new Option[s];
		//initialize array of options with new instances of options
		for (int i = 0; i < s; i++) {
			options[i] = new Option();
		}
	}

	//if we want to create an option set instance without needing to specify its size of options
	public OptionSet(String n) {
		//initialize array of options with new instances of options
	}


	//access the collection of options
	public Option[] getOptions() {
		return options;
	}

	public int getOptionsSize() {
		if (getOptions().length == 0) {
			return 0;
		}
		return getOptions().length;
	}

	//retrieve an option by index
	public Option getOption(int i) {
		return getOptions()[i];
	}


	public Option getOption(String n) {
		for (int i = 0; i < getOptionsSize(); i++) {
			if (getOption(i).getName().equals(n)) {
				return getOption(i);
			}
		}
		return new Option("DOES NOT EXIST!", 0);
	}

	//if you want to update the list of options to a new set
	public void updateOptions(Option[] options) {
		this.options = options;
	}

	//if you want to update an option, specify an index and a new option
	public void updateOption(int i, Option o) {
		options[i] = o;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public void addOption(int i, Option o) {
		getOptions()[i] = o;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer("OPTIONSET NAME:" + getName());
		return sb.toString();
	}


	//inner class
	public class Option {


		private String name;
		private float price;


		public Option() {
			setName("");
			setPrice(-1);
		}

		public Option(String n) {
			name = n;
			price = 0f;
		}

		public Option(String n, float p) {
			name = n;
			price = p;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public float getPrice() {
			return price;
		}

		public void setPrice(float price) {
			this.price = price;
		}

		public void updateOption(String n, float p) {
			setName(n);
			setPrice(p);
		}


		public String toString() {
			StringBuffer sb = new StringBuffer("                OPTION NAME: " + getName() + ",OPTION PRICE: " + getPrice());
			return sb.toString();
		}

	}

}
