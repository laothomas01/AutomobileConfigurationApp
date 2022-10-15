package Adapter;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Creates and Reads automotive methods.
 *
 * How would I describe what this interface is? what is its functionality and purpose????
 *
 * Why this???
 */
public interface CreateAuto {
	void buildAuto(String fileName) throws IOException;

	void printAuto(String modelName);
}
