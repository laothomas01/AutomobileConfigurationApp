package Adapter;

import Model.Automobile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedHashMap;

/**
 * External API
 */

public interface CreateAuto {
	void buildAuto(String fileName) throws IOException;

	void buildAuto(String fileName, String fileType) throws IOException;

	void printAuto(String modelName);
}
