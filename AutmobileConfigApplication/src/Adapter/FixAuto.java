package Adapter;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface FixAuto {
	boolean fix(int errNo) throws IOException;

}
