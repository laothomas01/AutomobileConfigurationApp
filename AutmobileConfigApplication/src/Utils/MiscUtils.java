package Utils;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class MiscUtils {

	public static String currentTImeStamp() {
		Calendar c = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
		DateFormat f = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM);
		return f.format(c.getTime());
	}

	public static String getPrimitiveDataTypeForNumberString(String str) {
		try {
			if (str.matches("^[\\p{Nd}]+[Ll]$")) {
				str = str.substring(0, str.length() - 1);
				long l = Long.parseLong(str);
				if (l <= Long.MAX_VALUE) {
					return "Long";
				}
			} else if (str.matches("^[\\p{Nd}]+[.][\\p{Nd}Ee]+[Ff]$")) {
				str = str.substring(0, str.length() - 1);
				float f = Float.parseFloat(str);
				if (f <= Float.MAX_VALUE) {
					return "Float";
				}
			} else if (str.matches("^[\\p{Nd}]+[.][\\p{Nd}Ee]+[Dd]$")) {
				str = str.substring(0, str.length() - 1);
				double d = Double.parseDouble(str);
				if (d <= Double.MAX_VALUE) {
					return "Double";
				}
			} else if (str.matches("^[\\p{Nd}]+$")) {
				double d = Double.parseDouble(str);
				if (d <= Integer.MAX_VALUE) {
					return "Integer";
				} else if (d <= Long.MAX_VALUE) {
					return "Long";
				} else if (d <= Float.MAX_VALUE) {
					return "Float";
				} else if (d <= Double.MAX_VALUE) {
					return "Double";
				}
			} else if (str.matches("^[\\p{Nd}]+[.][\\p{Nd}Ee]+$")) {
				double d = Double.parseDouble(str);
				if (d > Float.MAX_VALUE) {
					return "Double";
				}
				return "Float";
			}
		} catch (NumberFormatException e) {
		}

		return "Unknown";
	}

}
