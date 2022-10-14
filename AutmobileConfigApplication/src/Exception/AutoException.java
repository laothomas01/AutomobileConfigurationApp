package Exception;

import java.io.File;

/**
 * [ ] Tracking Error No and Error Message
 */
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

    /**
     * contain an enumeration of all possible errors and messages
     */

    /**
     * Ability to log AutoException with timestamps into a log file
     */

    /**
     * Write helper class to delegate fixes for each method.
     *
     * If exception number 1 to 100 is assigned to model packaage, might author class Fix1to100
     * as helper class for AutoException for exceptions raised in model class
     */

    /**
     * Functions delegated to handling errors:
     */
    public String findFile(String name, File file) {
        File[] list = file.listFiles();
        boolean foundFile = false;
        if (list != null)
            for (File fil : list) {
                if (foundFile) {
                    break;
                }
                if (fil.isDirectory()) {
                    findFile(name, fil);
                } else if (name.equalsIgnoreCase(fil.getName())) {
                    System.out.println(fil.getName());
                    return fil.getName();
                }
            }
        return "";
    }

}
