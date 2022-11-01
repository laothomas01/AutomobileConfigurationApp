package Model;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import Exception.AutoException;
import Utils.FileIO;

/**
 * Synchronize these methods
 */
public class Automobile implements Serializable {
	//	private String name;
	private float basePrice;
	//automobile manufacturer
	private String maker;


	//automobile year
	private int year;
	//
	private String model;


	//array of Option Set instances

	//stores all possible configurations for an automobile
//	private OptionSet[] optionSets;
	//stores all possible configurations for an automobile
	private ArrayList<OptionSet> optnSets;
	private ArrayList<OptionSet.Option> optnChoice;


	public Automobile(String n, float p, int size) {
		setModel(n);
		setBasePrice(p);


		optnSets = new ArrayList<>();

		for (int i = 0; i < size; i++) {
			optnSets.add(createOptnSet("BLANK", 0));
		}
		optnChoice = new ArrayList<>();

		maker = "";
		year = 0;
	}

	public Automobile(String n, int size) {
		this(n, 0f, size);
	}

	/**
	 * @param size
	 * @param p
	 */
	public Automobile(int size, float p) {
		this("BLANK", p, size);
	}

	/**
	 * @param p
	 */
	public Automobile(float p) {
		this("BLANK", p, 0);
	}

	/**
	 * @param size
	 */
	public Automobile(int size) {
		this("BLANK", 0, size);
	}

	public Automobile() {
		this("BLANK", 0, 0);
	}

	public String getModel() {
		return model;
	}

	public void setModel(String name) {
		this.model = name;
	}

	public float getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(float basePrice) {
		this.basePrice = basePrice;
	}

	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public void updateAutomobile(String name, float price) {
		setModel(name);
		setBasePrice(price);
	}


	public OptionSet getOptnSet(int i) throws IOException {
		try {
			if (getOptnSets().get(i) == null) {
				throw new AutoException(3);
			}
		} catch (AutoException e) {
			e.setErrorMsg("Cannot Find File Name!");
			e.printMyProblem();
			String exception = e.getErrorNo() + "|" + e.getErrorMsg();
			FileIO.writeToFile("listOfErrors.txt", exception);
			FileIO.writeToLogFile(exception);
		}
		return getOptnSets().get(i);
	}

	public void setOptnSetName(int i, String name) throws IOException {
		getOptnSet(i).setName(name);
	}

	public ArrayList<OptionSet> getOptnSets() {
		return optnSets;
	}

	public int getOptnSetsSize() {
		return getOptnSets().size();
	}

	public void addOptnSet(OptionSet os) {
		getOptnSets().add(os);
	}

	public void addOptnSet(String name, int size) {
		getOptnSets().add(createOptnSet(name, size));
	}


	public void deleteOptnSet(int i) {
		getOptnSets().remove(i);
	}


	public void deleteOptnSet(String name) throws IOException {
		for (int i = 0; i < getOptnSetsSize(); i++) {
			if (getOptnSet(i).getName().equals(name)) {
				deleteOptnSet(i);
			}
		}
	}


	public OptionSet createOptnSet(String name, int size) {
		return new OptionSet(name, size);
	}

	public void setOptnSet(int i, OptionSet os) {
		getOptnSets().set(i, os);
	}

	public void setOptnSet(int i, String name, int size) {
		setOptnSet(i, createOptnSet(name, size));
	}

	public int getOptnSetSize(int i) throws IOException {
		return getOptnSet(i).getOptnsListSize();
	}

	public String getOptnSetName(int i) throws IOException {
		return getOptnSet(i).getName();
	}

	public ArrayList<OptionSet.Option> getOptns(int i) throws IOException {
		return getOptnSet(i).getOptns();
	}


	public int getOptnListSize(int i) throws IOException {
		return getOptnSet(i).getOptnsListSize();
	}


	public void setOptn(int i, int j, OptionSet.Option o) throws IOException {
		getOptnSet(i).getOptns().set(j, o);
	}

	public void setOptn(int i, int j, String n, float p) throws IOException {
		getOptnSet(i).getOptn(j).setName(n);
		getOptnSet(i).getOptn(j).setPrice(p);
	}


	public void setOptnChoice(int i, int j) throws IOException {
		getOptnSet(i).setOptnChoice(j);
	}


	public OptionSet.Option getOptnChoice(int i) throws IOException {
		return getOptnSet(i).getOptnChoice();
	}

	public String getOptnChoiceName(int i) throws IOException {
		return getOptnSet(i).getOptnChoice().getName();
	}

	public float getOptnChoicePrice(int i) throws IOException {
		return getOptnSet(i).getOptnChoice().getPrice();
	}


	public void addOptionChoice(int i, int j) throws IOException {
		setOptnChoice(i, j);
		optnChoice.add(getOptnChoice(i));
	}

	public void removeOptionChoice(int i) {
		optnChoice.remove(i);
	}

	public ArrayList<OptionSet.Option> getOptnChoice() {
		return optnChoice;
	}

	//--------------------------------------------- NEW CODE USING ARRAY-LIST -----------------------------------------

	public float getTotalPrice() {
		//@TODO: calculate the total price of purchases
		float total = 0;
		for (OptionSet.Option o : optnChoice) {
			total += o.getPrice();
		}
		total += getBasePrice();
		return total;
	}


	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("\n" + getMaker() + "-" + this.getModel() + "-" + getYear() + "|" + this.getBasePrice());
		// new implementation using an array list
		for (int i = 0; i < getOptnSetsSize(); i++) {
			try {
				sb.append("\n" + this.getOptnSet(i));
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}

		return sb.toString();
	}


}
