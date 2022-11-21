package Model;

import java.util.LinkedHashMap;
import java.util.Set;
/**
 * Why am i learning how to make template classes?
 * <p>
 * What is this classes used for?
 * - gain experience writing custom template classes
 * - integrating the linked hashmap api into this class
 * - using this instance to add any class that is or is derived from Automobile
 */


/**
 * -Template class
 * -Instantiate in proxy auto class
 */
public class LHMAuto<T extends Automobile> {
	/**
	 * @TODO CRUD operations for LHM using LinkedHashMap API
	 */

	private LinkedHashMap<String, T> cacheAuto;

	public LHMAuto() {
		cacheAuto = new LinkedHashMap<>();
	}

	private LinkedHashMap<String, T> getCacheAuto() {
		return cacheAuto;
	}

	public void addAuto(T a) {
		getCacheAuto().put(a.getModel(), a);
	}

	public String displayAutoNames() {
		Set<String> keys = cacheAuto.keySet();
		StringBuilder sb = new StringBuilder();
		int i = 1;
		for (String key : keys) {
			sb.append(key + "\n");
		}
		return sb.toString();
	}

	public void removeAuto(String name) {
		getCacheAuto().remove(name);
	}

	public Automobile getAuto(String name) {
		return getCacheAuto().get(name);
	}


	public void updateAuto(String name, String setName, float setPrice) {
		getAuto(name).updateAutomobile(setName, setPrice);
	}

	public boolean isEmpty() {
		return cacheAuto.isEmpty();
	}

	public String toString() {
		return cacheAuto.toString();
	}


}
