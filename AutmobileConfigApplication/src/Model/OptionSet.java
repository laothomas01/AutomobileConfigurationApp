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
	protected Option[] getOptions() {
		return options;
	}

	protected int getOptionsSize() {
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
		for (int i = 0; i < getOptionsSize(); i++) {
			if (getOption(i).getName().equals(n)) {
				return getOption(i);
			}
		}
		return new Option("DOES NOT EXIST!", 0);
	}

	//if you want to update the list of options to a new set
	protected void updateOptions(Option[] options) {
		this.options = options;
	}

	//if you want to update an option, specify an index and a new option
	protected void updateOption(int i, Option o) {
		options[i] = o;
	}

	protected String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;
	}


	protected void addOption(int i, Option o) {
		getOptions()[i] = o;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer("OPTIONSET NAME:" + getName());
		return sb.toString();
	}

	//inner class
	protected class Option {


		private String name;
		private float price;


		protected Option() {
			setName("");
			setPrice(-1);
		}

		protected Option(String n) {
			name = n;
			price = 0f;
		}

		protected Option(String n, float p) {
			name = n;
			price = p;
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

		protected void updateOption(String n, float p) {
			setName(n);
			setPrice(p);
		}


		public String toString() {
			StringBuffer sb = new StringBuffer("                OPTION NAME: " + getName() + ",OPTION PRICE: " + getPrice());
			return sb.toString();
		}

	}

}
