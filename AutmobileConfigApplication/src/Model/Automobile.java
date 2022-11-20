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

	public ArrayList<OptionSet> getOptnSets() {
		return optnSets;
	}

	public OptionSet createOptnSet(String name, int size) {
		//updates the option set instance to a blank option set with N option instances
		return new OptionSet(name, size);
	}

	/**
	 * to handle multiple user access to an option set object
	 *
	 * @param i option set index
	 * @return return an option set object
	 * @throws IOException index does not find searched object
	 */
	public OptionSet getOptnSet(int i) throws IOException {
		try {
			if (getOptnSets().get(i) == null) {
				throw new AutoException(3);
			}
		} catch (AutoException e) {
			e.setErrorMsg("Option Set does not exist!");
			e.printMyProblem();
			String exception = e.getErrorNo() + "|" + e.getErrorMsg();
			FileIO.writeToFile("listOfErrors.txt", exception);
			FileIO.writeToLogFile(exception);
		}
		return getOptnSets().get(i);
	}

	//WORKS
	public OptionSet getOptnSet(String optnSetName) throws IOException {
		for (int i = 0; i < getOptnSets().size(); i++) {
			if (getOptnSet(i).getName().equals(optnSetName)) {
				return getOptnSets().get(i);
			}
		}
		return null;
	}

	//WORKS
	public void setOptnSetName(int i, String name) throws IOException {
		getOptnSet(i).setName(name);
	}

	//WORKS
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


	public void updateOptnSet(int i, OptionSet os) {
		getOptnSets().set(i, os);
	}

	public void updateOptnSet(int i, String name, int size) {
		updateOptnSet(i, createOptnSet(name, size));
	}

	public void updateOptnSetName(int i, String newName) throws IOException {
		getOptnSet(i).setName(newName);
	}

	public void updateOptnSetPrice(int i, float newPrice) throws IOException {
		getOptnSet(i).setOptnPrice(i, newPrice);
	}

	public int getOptnSetSize(int i) throws IOException {
		return getOptnSet(i).getOptnsListSize();
	}

	//WORKS
	public String getOptnSetName(int i) throws IOException {
		return getOptnSet(i).getName();
	}

	/**
	 * @param i option set object index
	 * @return ArrayList<OptionSet.Option> options
	 * @throws IOException invalid index search
	 */
	public ArrayList<OptionSet.Option> getOptnList(int i) throws IOException {
		return getOptnSet(i).getOptns();
	}


	public int getOptnListSize(int i) throws IOException {
		return getOptnSet(i).getOptnsListSize();
	}

	/**
	 * there can be multiple access to same Option Instance
	 *
	 * @param i option set index
	 * @param j option index
	 * @return option object
	 * @throws IOException invalid index
	 */
	public OptionSet.Option getOptn(int i, int j) throws IOException {
		return getOptnSet(i).getOptn(j);
	}

	public String getOptnName(int i, int j) throws IOException {
		return getOptnSet(i).getOptnName(j);
	}

	public String getOptnName(String optnSetName, String optnName) throws IOException {
		for (int i = 0; i < this.getOptnSetsSize(); i++) {
			for (int j = 0; j < this.getOptnSetSize(i); j++) {
				if (this.getOptnSetName(i).equals(optnSetName)) {
					if (this.getOptnName(i, j).equals(optnName)) {
						return this.getOptnName(i, j);
					}
				}
			}
		}
		return null;
	}

	/**
	 * for multi-threaded editing
	 *
	 * @param i option set index
	 * @param j option index
	 * @param n new name
	 * @param p new price
	 * @throws IOException
	 */
	public void updateOptn(int i, int j, String n, float p) throws IOException {
		getOptnSet(i).getOptn(j).setName(n);
		getOptnSet(i).getOptn(j).setPrice(p);
	}

	public void updateOptn(int i, int j, OptionSet.Option o) throws IOException {
		getOptnSet(i).getOptns().set(j, o);
	}

	/**
	 * for multi-threaded editing
	 *
	 * @param i option set index
	 * @param j option index
	 * @param n new name
	 * @throws IOException
	 */
	public void updateOptnName(int i, int j, String n) throws IOException {
		getOptnSet(i).getOptn(j).setName(n);
	}

	public void updateOptnName(String optionSetName, String optionName, String newName) throws IOException {
		for (int i = 0; i < this.getOptnSetsSize(); i++) {
			for (int j = 0; j < this.getOptnSetSize(i); j++) {
				if (this.getOptnSetName(i).equals(optionSetName)) {
					if (this.getOptnName(i, j).equals(optionName)) {
						this.updateOptnName(i, j, newName);
					}
				}
			}
		}
	}

	/**
	 * for multi-threaded editing
	 *
	 * @param i option set index
	 * @param j option index
	 * @param p new price
	 * @throws IOException
	 */
	public void setOptnPrice(int i, int j, float p) throws IOException {
		getOptnSet(i).getOptn(j).setPrice(p);
	}


	public OptionSet.Option getOptnChoices(int i) throws IOException {
		return getOptnSet(i).getOptnChoice();
	}

	public void setOptnChoice(int i, int j) throws IOException {
		getOptnSet(i).setOptnChoice(j);
	}

	public void setOptnChoice(String optnSetName, String optnName) {
	}


	public String getOptnChoiceName(int i) throws IOException {
		return getOptnSet(i).getOptnChoice().getName();
	}

	public float getOptnChoicePrice(int i) throws IOException {
		return getOptnSet(i).getOptnChoice().getPrice();
	}

	public void addOptionChoice(int i, int j) throws IOException {
		setOptnChoice(i, j);
		optnChoice.add(getOptnChoices(i));
	}

	public void addOptionChoice(String optnSetName, String optnName) {

	}


	public void removeOptionChoice(int i) {
		optnChoice.remove(i);
	}

	public ArrayList<OptionSet.Option> getOptnChoices() {
		return optnChoice;
	}

	public void printOptionChoices() {
		System.out.println(getOptnChoices().toString());
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
//		sb.append("\n" + getMaker() + "-" + this.getModel() + "-" + getYear() + "|" + this.getBasePrice());
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
