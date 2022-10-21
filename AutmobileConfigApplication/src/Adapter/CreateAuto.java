package Adapter;

import Model.Automobile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedHashMap;

/**
 * Why use an interface????
	 * unrelated classes implement the interfaces
	 * specify behavior of a particular data type(not concerned who implements)
	 *
 */
public interface CreateAuto {
	void buildAuto(String fileName) throws IOException;
	void printAuto(String modelName);

}
