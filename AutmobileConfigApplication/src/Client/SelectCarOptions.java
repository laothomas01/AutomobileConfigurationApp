package Client;

import Model.*;

import java.io.IOException;
import java.util.*;

/**
 * 1. prompt user for available models
 * 2. allows user to select model and enter its respective options
 * 3. displays the selected options for a class
 */
public class SelectCarOptions {

	////////// PROPERTIES //////////
	private Scanner in = new Scanner(System.in);

	////////// CONSTRUCTORS //////////

	public SelectCarOptions() {

	}

	////////// INSTANCE METHODS //////////

	public void configureAuto(Object obj) throws IOException {
		System.out.println("-------------------\n BEGIN CONFIGURATION \n-------------------\n");

		//@TODO: fill in with code to select configurations for automobile
		Automobile a1 = (Automobile) obj;
		System.out.println("CONFIGURATION OPTIONS\n-------------------" + a1);
		System.out.println("Select option.....");
		int optnSetName = in.nextInt();
		int optnName = in.nextInt();

		System.out.println("TESTING WITH INDEX ACCESS!");
		a1.addOptionChoice(optnSetName, optnName);
		a1.printOptionChoices();
	}

	public boolean isAutomobile(Object obj) {
		boolean isAutomobile = false;
		try {
			Automobile a1 = (Automobile) obj;
			isAutomobile = true;
		} catch (ClassCastException e) {
			isAutomobile = false;
		}

		return isAutomobile;
	}

}