package Adapter;

import Model.Automobile;
import Model.LHMAuto;
import Scale.EditOptions;
import Scale.EditThread;
import Server.AutoServer;
import Utils.FileIO;
import Exception.Fix1to100;

import java.io.IOException;
import java.util.Properties;

public class BuildAuto
		extends
		ProxyAutomobile
		implements
		CreateAuto,
		ReadAuto,
		UpdateAuto,
		FixAuto,
		AutoServer,
		EditThread {
	FileIO io = null;

	public BuildAuto(String fileName, String fileType) throws IOException, InterruptedException {
		buildAuto(fileName, fileType);
	}

	public BuildAuto(String fileName) throws IOException, InterruptedException {
		buildAuto(fileName);
	}

	public BuildAuto() {

	}

	@Override
	public void buildAuto(String fileName) throws IOException {
//		FileIO io = new FileIO(fileName);
		io = new FileIO(fileName);
		a1 = io.loadAutomotive();
		setAutoLHM(new LHMAuto<>());
		addAuto(a1);
	}

	//carconfig     .properties
	@Override
	public void buildAuto(String fileName, String fileType) throws IOException {
		io = new FileIO(fileName + fileType);
		Properties prop = (Properties) io.loadProperties(io.getFileName());
		a1 = io.loadAutomotive(prop);

	}

	public LHMAuto<Automobile> getAutos() {
		return autos;
	}

	public Automobile getAuto(String modelName) {
		return autos.getAuto(modelName);
	}

	public void addAuto(Automobile a1) {
		getAutos().addAuto(a1);
	}

	public void removeAuto(String modelName) {
		getAutos().removeAuto(modelName);
	}

	public void setAutoLHM(LHMAuto lhm) {
		autos = lhm;
	}

	@Override
	public void printAuto(String modelName) {
		System.out.println(getAuto(modelName));
	}

	@Override
	public void setOptnSetName(String modelName, int i, String newName) throws IOException {
		getAuto(modelName).setOptnSetName(i, newName);
	}

	@Override
	public void setOptnSetName(String modelName, String OptionSetName, String newName) {

	}

	@Override
	public void setOptnPrice(String modelName, String OptionSetName, String OptionName, float newPrice) {

	}

	@Override
	public void setOptnPrice(String modelName, int i, int j, float newPrice) throws IOException {
		getAuto(modelName).setOptnPrice(i, j, newPrice);
	}

	@Override
	public void setOptnName(String modelName, int i, int j, String newName) throws IOException {
		getAuto(modelName).updateOptnName(i, j, newName);
	}

	@Override
	public float getTotalPrice() {
		return a1.getTotalPrice();
	}

	@Override
	public void addOptnChoice(int i, int j) throws IOException {
		a1.addOptionChoice(i, j);
	}

	@Override
	public void removeOptnChoice(int i) {
		a1.removeOptionChoice(i);
	}

	@Override
	public void setOptnChoice(int i, int j) throws IOException {
		a1.setOptnChoice(i, j);
	}

	@Override
	public void setOptnChoice(String optSetName, String optionName) {

	}

	@Override
	public void printOptionChoices() {
		System.out.println(a1.getOptnChoices().toString());
	}

	/**
	 * catch 5 errors, fix 1
	 *
	 * @param errNo logged error number
	 * @return
	 * @throws IOException
	 */
	@Override
	public boolean fix(int errNo) throws IOException {
		Fix1to100 f1 = new Fix1to100();
		switch (errNo) {
			case 0:
				break;
			case 1:
				f1.fixMissingPriceFromTextFile();
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;

			default:
				break;
		}
		return true;
	}

	/**
	 * Modification of automobile instance over multiple threads created by different instances of class EditOption
	 *
	 * @param ModelName
	 * @param operation
	 * @param args
	 * @throws IOException
	 * @throws InterruptedException
	 */
	@Override
	public void editThread(String ModelName, int operation, String[] args)
			throws IOException, InterruptedException {
		//thread 1
		EditOptions eo = new EditOptions(ModelName, operation, args);
		eo.start();
		System.out.println("ID:" + eo.t.getId());
		System.out.println("STATE:" + eo.t.getState());
	}

	@Override
	public void server(int port) {

	}
}

