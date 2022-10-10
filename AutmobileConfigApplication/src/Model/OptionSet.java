package Model;

import java.io.Serializable;

class OptionSet implements Serializable {

	private Option options[];
	private String name;

	/**
	 * Chained Constructors
	 *
	 * @param n    = name
	 * @param size = length of Option array
	 */
	protected OptionSet(String n, int size) {
		setName(n);
		options = new Option[size];
		//initialize array of options with new instances of empty options
		for (int i = 0; i < size; i++) {
			options[i] = new Option();
		}
	}

	protected OptionSet(String n) {
		this(n, 0);
	}

	protected OptionSet(int n) {
		this("", n);
	}

	protected OptionSet() {
		this("", 0);
	}

	//---------------------- OPTION SET INSTANCE CRUD OPERATIONS ----------------
	protected String getName() {
		return name;
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

	protected void setName(String name) {
		this.name = name;
	}

	//replace current array of Option instances with new array
	protected void updateOptions(Option[] opts) {
		this.options = opts;
	}


	//we print out our option set data in the same format to CarConfigs.txt
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

	protected Option createOption(String n, float p) {
		return new Option(n, p);
	}

	protected Option createOption(String n) {
		return new Option(n);
	}

	protected Option createOption() {
		return new Option();
	}

	//retrieve Option class instance by index
	protected Option getOption(int i) {
		if (getOptions()[i] == null || i < 0 || i >= getOptionsSize()) {
			return new Option();
		}
		return getOptions()[i];
	}

	//basic retrieve Option instance by name
	protected Option getOption(String n) {
		for (int i = 0; i < getOptionsSize(); i++) {
			if (getOption(i).getName().equals(n)) {
				return getOption(i);
			}
		}
		return new Option();
	}

	//search by index and replace current Option instance with new Option instance
	protected void setOption(int i, Option o) {
		if (i < 0 || i >= getOptionsSize()) {
			System.out.println("OPTION DOES NOT EXIST!");
		}
		getOptions()[i] = o;
	}

	//search by name and replace current Option instance with new Option instance
	protected void setOption(String n, Option o) {
		for (int i = 0; i < getOptionsSize(); i++) {
			//will not trigger set option exception
			if (getOption(i).getName().equals(n)) {
				setOption(i, o);
			}
		}
		System.out.println("OPTION DOES NOT EXIST!");
	}

	//search by index, input replacing name and price, and use those parameters to input into a empty Option class instancee
	protected void setOption(int searchIndex, String replaceName, float replaceOptionPrice) {
		setOption(searchIndex, new Option(replaceName, replaceOptionPrice));
	}

	//search by name, input replacing name and price, and use those parameters to input to empty Option class instance
	protected void setOption(String searchOptionName, String replaceName, float replaceOptionPrice) {
		setOption(searchOptionName, new Option(replaceName, replaceOptionPrice));
	}

	//search by index and update option instance to empty Option class instance
	protected void deleteOption(int i) {
		//change specified option at index i = to empty Option class instance
		setOption(i, new Option());
	}

	//search by name and update option instance to to empty Option class instance
	protected void deleteOption(String name) {
		setOption(name, new Option());
	}


	//inner class
	protected class Option implements Serializable {

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

		public String toString() {

			StringBuffer sb = new StringBuffer(getName() + "|" + getPrice());
			return sb.toString();
		}

	}

}
