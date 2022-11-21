package Server;

import Adapter.*;
import Model.Automobile;
import Utils.FileIO;

import java.io.IOException;
import java.util.Properties;

/**
 * back-forth operation happening between client and server
 */
public class BuildCarModelOptions extends ProxyAutomobile implements AutoServer {
////////// PROPERTIES //////////

	private static final int WAITING = 0;
	private static final int REQUEST_BUILD_AUTO = 1;
	private static final int REQUEST_CONFIGURE_AUTO = 2;

	private int state = WAITING;

	private FileIO io = null;

	////////// CONSTRUCTORS //////////

	public BuildCarModelOptions() {
		io = new FileIO();
	}

	////////// INSTANCE METHODS //////////


	//Method 1)


	//accept properties object from client socket over an object stream

	//then create automobile
	public Object processRequest(Object obj) throws IOException, InterruptedException {
		System.out.println("---------------- CHECKING STATE : " + state);
		Object toClient = null;
		//use CreateAuto interface to build Automobile and handle different type of files passed in filetype
		CreateAuto a1 = null;

		/**
		 * - Build automobile using received .properties file
		 * - store automobile into linked hashmap
		 */
		if (state == REQUEST_BUILD_AUTO) {
			Properties props = (Properties) obj;
			a1 = new BuildAuto(props);
			addAuto(a1.getAuto());
			toClient = "Automobile successfully built!";
		}

		/**
		 * - Handles received automobile name
		 * - Return back an automobile for configuration
		 */
		else if (state == REQUEST_CONFIGURE_AUTO) {
			String autoName = (String) obj;
//			System.out.println(autoName);
			toClient = autos.getAuto(autoName);
		}
		/**
		 * Improper input = "Termination"
		 *
		 * Improper input should = returning error message to user if not 0
		 */
		else {
			toClient = "Invalid input";
		}
		this.state = WAITING;

		return toClient;
	}

	public String setRequest(int i) {
		String output = null;
		if (i == 1) {
			this.state = REQUEST_BUILD_AUTO;
			output = "Upload a file to create an Automobile";
		} else if (i == 2) {
			this.state = REQUEST_CONFIGURE_AUTO;
			output = "Select an Automobile from the following list to configure: \n" + getAllModels();
			//function to display all stored models in linked hashmap
			// super.getAllModels();
		} else {
			output = "Invalid request";
		}
		return output;
	}

	@Override
	public void server(int port) {

	}

	@Override
	public void addAuto(Automobile auto) {
		autos.addAuto(auto);
	}

	@Override
	public String displayAvailableModels() {
		//@TODO Handle empty linked hash map
		return autos.toString();
	}

	@Override
	public String getAllModels() {
		return autos.displayAutoNames();
	}
}
