public class CatchAndFix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		boolean problemFixed = false;
		System.out.println("FIXED:" + problemFixed);
		System.out.println("Inside main");
		CreateProblem myproblem = new CreateProblem("fileDoesNotExist.txt");
		do {
			try {
				//if file can be opened
				problemFixed = myproblem.openFile();
			}
			//if file cannot be opened
			//instantation
			catch (FixProblems e) {
				//set the file name to an existing file
				myproblem.setFileName(e.fixProblemReadFromConsole());

			}
		} while (problemFixed == false);


	}

}