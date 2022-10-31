package MultiThreading.TestPrograms;

import java.util.ArrayList;

public class mySet {
	//raw typed
	ArrayList myElements = new ArrayList();

	public boolean add(Object o) {
		return myElements.add(o);
	}

	public Object remove() {
//		myElements.get(0);
		if (myElements.isEmpty() == false)
			return myElements.remove(0); // removes & returns object at position 0

		return null;
	}
}
