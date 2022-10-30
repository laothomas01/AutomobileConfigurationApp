package Model;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import Exception.AutoException;
import Utils.FileIO;

class OptionSet implements Serializable {
	//array of Option instances
//	private Option options[];
	//array list of Option instances
	private ArrayList<Option> optns;
	private String name;
	private Option choice;

	//option set has SIZE amount of options
	//these number of options are based on the the data of each option set
	protected OptionSet(String name, int size) {
		setName(name);

		//initialize Option instance array with blank Option instances

//		options = new Option[size];
//		for (int i = 0; i < size; i++) {
//			options[i] = new Option("BLANK OPTION", 0);
//		}
		optns = new ArrayList<>();
		//based on size of option set, add N option instances to arraylist
		for (int i = 0; i < size; i++) {
			addOptn("BLANK OPTION", 0f);
		}
		choice = new Option("", 0);
	}

	protected OptionSet(String name) {
		this(name, 0);
	}

	protected OptionSet(int size) {
		this("BLANK OPTION", size);
	}

	protected OptionSet() {
		this("BLANK OPTION", 0);
	}

	protected String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;
	}
	//--------------------------------------------- OLD CODE USING BASIC ARRAY -------------------------------------
//
//	//---------------------- OPTION SET INSTANCE CRUD OPERATIONS ----------------------------------------------------
//	//[O]

//	//retrieve Option array
//	//[O]
//	protected Option[] getOptions() {
//		return options;
//	}
//
//	//retrieve Option array length
//	//[O]
//	protected int getOptionsSize() {
//		if (getOptions().length == 0) {
//			return 0;
//		}
//		return getOptions().length;
//	}
//
//
//	//[O]

//
//	protected Option createOption() {
//		return new Option();
//	}
//
//	//retrieve Option class instance by index
//
//	protected Option getOption(int i) {
//
//		if (getOptions()[i] == null || i < 0 || i >= getOptionsSize()) {
//			return new Option();
//		}
//		return getOptions()[i];
//	}
//
//	//basic retrieve Option instance by name
//	protected Option getOption(String n) {
//		for (int i = 0; i < getOptionsSize(); i++) {
//			if (getOption(i).getName().equals(n)) {
//				return getOption(i);
//			}
//		}
//		return new Option();
//	}
//
//	//search by index and replace current Option instance with new Option instance
//	protected void setOption(int searchIndex, Option o) {
//		if (searchIndex < 0 || searchIndex >= getOptionsSize()) {
//			System.out.println("OPTION DOES NOT EXIST!");
//		}
//		getOptions()[searchIndex] = o;
//	}
//
//	//search by name and replace current Option instance with new Option instance
//	protected void setOption(String searchName, Option o) {
//		for (int i = 0; i < getOptionsSize(); i++) {
//			if (getOption(i).getName().equals(searchName)) {
//				setOption(i, o);
//			}
//		}
//		System.out.println("OPTION DOES NOT EXIST!");
//	}
//
//	//search by index and update option instance to empty Option class instance
//	protected void deleteOption(int i) {
//		//change specified option at index i = to empty Option class instance
//		setOption(i, new Option());
//	}
//
//
//	//search by name and replace option instance with empty Option class instance
//	protected void deleteOption(String name) {
//		setOption(name, new Option());
//	}
//

	//--------------------------------------------- OLD CODE USING BASIC ARRAY -------------------------------------
	//--------------------------------------------- NEW CODE USING ARRAY-LIST -------------------------------------
	protected ArrayList<Option> getOptns() {
		return optns;
	}

	protected int getOptnsListSize() {
		return optns.size();
	}

	protected Option createOption(String name, float price) {
		return new Option(name, price);
	}

	protected Option getOptn(int i) throws IOException {
		try {
			if (getOptns().get(i) == null) {
				throw new AutoException(3);
			}
		} catch (AutoException e) {
			e.setErrorMsg("Missing Option!");
			e.printMyProblem();
			String exception = e.getErrorNo() + "|" + e.getErrorMsg();
			FileIO.writeToFile("listOfErrors.txt", exception);
			try {
				FileIO.writeToLogFile(exception);
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		}
		return getOptns().get(i);
	}

	protected Option getOptn(String n) throws IOException {
		for (int i = 0; i < getOptnsListSize(); i++) {
			if (getOptn(i).getName().equals(n)) {
				return getOptn(i);
			}
		}
		return null;
	}

	protected String getOptnName(int i) throws IOException {
		try {
			if (getOptn(i).getName() == null) {
				throw new AutoException(4);
			}
		} catch (AutoException e) {
			e.setErrorMsg("Missing Option Name!");
			e.printMyProblem();
			String exception = e.getErrorNo() + "|" + e.getErrorMsg();
			FileIO.writeToFile("listOfErrors.txt", exception);
			FileIO.writeToLogFile(exception);
		}
		return getOptn(i).getName();
	}

	protected void setOptnName(int i, String name) throws IOException {
		getOptn(i).setName(name);
	}

	protected void setOptnPrice(int i, float price) throws IOException {
		getOptn(i).setPrice(price);
	}

	protected void setOptn(int i, String name, float price) throws IOException {
		setOptnName(i, name);
		setOptnPrice(i, price);
	}

	protected void addOptn(Option o) {
		getOptns().add(o);
	}

	protected void addOptn(String name, float price) {
		addOptn(createOption(name, price));
	}

	protected void deleteFromOptnList(int i) {
		getOptns().remove(i);
	}

	protected void deleteFromOptnList(String name) throws IOException {
		for (int i = 0; i < getOptnsListSize(); i++) {
			if (getOptn(i).getName().equals(name)) {
				deleteFromOptnList(i);
			}
		}
	}


	//integrate getOptionChoice into setOption
	//inputs passed into setOptionChoice will determine Option choice to return

	protected void setOptnChoice(int i) throws IOException {
		choice = getOptn(i);
	}

	protected Option getOptnChoice() {
		return choice;
	}

	//--------------------------------------------- NEW CODE USING ARRAY-LIST -------------------------------------

	public String toString() {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < getOptnsListSize(); i++) {
			try {
				sb.append("\n" + getOptn(i));
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		return sb.toString();
	}

	protected class Option {

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
			this("BLANK OPTION", p);
		}

		protected Option() {
			this("BLANK OPTION", 0f);
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
			StringBuffer sb = new StringBuffer();
			sb.append(getName() + " " + getPrice());
			return sb.toString();
		}

	}

}
