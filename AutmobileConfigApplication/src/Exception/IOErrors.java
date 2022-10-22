package Exception;

import java.io.File;

public class IOErrors {
	int errorNum;
	int errorMsg;

	public IOErrors() {

	}

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
