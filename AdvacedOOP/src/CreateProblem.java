import java.io.*;

public class CreateProblem {
	private String fileName;

	CreateProblem() {

	}

	public CreateProblem(String fileName) {
		super();
		this.fileName = fileName;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	boolean openFile() throws FixProblems {
		BufferedReader br = null;
		boolean flag = false;
		try {
			br = new BufferedReader(new FileReader(fileName));
			//if file exist, print out the first line
			System.out.println(br.readLine());
			System.out.println("Now it is done!");
			flag = true;

		}
		//if file not exist, go to file not found exception and instantiate custom exception
		catch (FileNotFoundException f) {
			throw new FixProblems();
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {

		}
		return flag;
	}

}
