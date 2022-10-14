package Exception;

import java.io.File;

public class AutoException extends Exception {
	private int errorNo;
	private String errorMsg;

	public AutoException() {
		super();
	}

	public AutoException(int errorNo) {
		super();
		this.errorNo = errorNo;
		printMyProblem();
	}

	public AutoException(String errorMsg) {
		super();
		this.errorMsg = errorMsg;
		printMyProblem();

	}

	public AutoException(int errorNo, String errorMsg) {
		super();
		this.errorNo = errorNo;
		this.errorMsg = errorMsg;
		printMyProblem();
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

	public void printMyProblem() {
		System.out.println("AutoException [errorno=" + errorNo + ", errormsg=" + errorMsg);
	}


}
