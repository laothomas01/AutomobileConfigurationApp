package Exception;

public class AutoException extends Exception {


	private int errorNo;
	private String errorMsg;

	public AutoException() {
		super();
	}

	public AutoException(int errorNo) {
		super();
		this.errorNo = errorNo;
	}

	public AutoException(String errorMsg) {
		super();
		this.errorMsg = errorMsg;
	}

	public AutoException(int errorNo, String errorMsg) {
		super();
		this.errorNo = errorNo;
		this.errorMsg = errorMsg;
	}

	public int getErrorNo() {
		return errorNo;
	}

	public void setErrorNo(int errorNo) {
		this.errorNo = errorNo;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public void printmyproblem() {
		System.out.println("FixProblems [errorno=" + errorNo + ", errormsg=" + errorMsg);
	}

}
