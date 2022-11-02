package Model;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import Exception.AutoException;
import Utils.FileIO;

class OptionSet implements Serializable {

	private ArrayList<Option> optns;
	private String name;
	private Option choice;


	protected OptionSet(String name, int size) {
		setName(name);

		optns = new ArrayList<>();
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
