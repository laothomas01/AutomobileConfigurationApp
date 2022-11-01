package Other;

import java.util.Arrays;

/**
 * FINISH ADV JAVA HOMEWORK TONIGHT!
 * [ ] adding custom exception and making a self-healing software
 * WORK ON VIDEO GAME PROJECT TONIGHT!
 * <p>
 * PRACTICE ORACLE SQL TONIGHT!
 * [ ] review table creation
 * [ ] review table insertion
 * [ ] review sql basic commands
 * [ ]
 */


//Custom Exception
public class FixProblems extends Exception {

	//where the error is
	private int errorno;
	//what the error is
	private String errormsg;


	public FixProblems() {
		super();
		printmyproblem();
	}

	public FixProblems(String errormsg) {
		super();
		this.errormsg = errormsg;
		printmyproblem();
	}

	public FixProblems(int errorno) {
		super();
		this.errorno = errorno;
		printmyproblem();
	}

	public FixProblems(int errorno, String errormsg) {
		super();
		this.errorno = errorno;
		this.errormsg = errormsg;
		printmyproblem();
	}

	public int getErrorno() {
		return errorno;
	}

	public void setErrorno(int errorno) {
		this.errorno = errorno;
	}

	public String getErrormsg() {
		return errormsg;
	}

	public void setErrormsg(String errormsg) {
		this.errormsg = errormsg;
	}

	//print exception
	public void printmyproblem() {
		System.out.println("Other.FixProblems [errorno=" + errorno + ", errormsg=" + errormsg);
	}

	//how is the problem "fixed"?

	//not part of custom exception


	public String fixProblemReadFromConsole() {
		/**
		 * can loop through a directory, but let's currently keep it simple
		 */

//		String a = "asdasdsad.txt";
//		System.out.println("got here --> fixProblemReadFromConsole");
		return "";
	}
}