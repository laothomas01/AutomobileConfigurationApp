package Server;

import Adapter.*;
import Model.Automobile;
import Utils.FileIO;

import java.io.IOException;
import java.util.Properties;

/**
 * back-forth operation happening between client and server
 */
public class BuildCarModelOptions extends ProxyAutomobile {
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


	public Object processRequest(Object obj) throws IOException {
		Object toClient = null;
		Automobile a1 = null;
		if (state == REQUEST_BUILD_AUTO) {
			Properties props = (Properties) obj;
			//@TODO use fileIO function to parse props object
			a1 = io.loadAutomotive(props);

		} else if (state == REQUEST_CONFIGURE_AUTO) {

		} else {

		}
		this.state = WAITING;

		return toClient;
	}

	public String setRequest(int i) {
		String output = null;
		if (i == 1) {
			this.state = REQUEST_BUILD_AUTO;
			output = "Upload a file to create an Automoble";
		} else if (i == 2) {
			this.state = REQUEST_CONFIGURE_AUTO;
			output = "Select an Automobile from the following list to configure: \n";
			//function to display all stored models in linked hashmap
			// super.getAllModels();
		} else {
			output = "Invalid request";
		}
		return output;
	}

}
