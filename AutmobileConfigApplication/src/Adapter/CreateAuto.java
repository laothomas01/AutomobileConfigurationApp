package Adapter;

import Model.Automobile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedHashMap;


public interface CreateAuto {
	void buildAuto(String fileName) throws IOException;

	void printAuto(String modelName);
}
