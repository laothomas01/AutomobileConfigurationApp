package Adapter;

import Model.Automobile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedHashMap;

/**
 * Creates and Reads automotive methods.
 * <p>
 * How would I describe what this interface is? what is its functionality and purpose????
 * <p>
 * Why this???
 */
public interface CreateAuto {
    void buildAuto(String fileName) throws IOException;

    void printAuto(String modelName);

    void printAutos(LinkedHashMap<String, Automobile> autos);
}
