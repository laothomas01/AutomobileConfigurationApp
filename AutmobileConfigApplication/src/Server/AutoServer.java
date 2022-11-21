package Server;

import Model.Automobile;

public interface AutoServer {
	/**
	 * input a port num and flow that data into the server socket?
	 *
	 * @param port server port num
	 */
	 void server(int port);

	 void addAuto(Automobile auto);

	String displayAvailableModels();
}
