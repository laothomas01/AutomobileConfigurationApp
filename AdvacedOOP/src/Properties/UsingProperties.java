package Properties;

import java.io.*;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

public class UsingProperties {
	public static void main(String args[]) {
		Properties prop = (Properties) loadPropsFile("testing.properties");
		String carModel = prop.getProperty("carmodel");
		float carPrice = Float.parseFloat(prop.getProperty("carprice"));
		String[] transmissions = prop.getProperty("transmission").split("\\|");
		System.out.println(transmissions[0]);
		System.out.println(transmissions[1]);
//		String[] transmissions = prop.getProperty("transmission").toString().split("\\|");
		String[] brakes = prop.getProperty("brakes").split("\\|");
		System.out.println(brakes[0]);
		System.out.println(brakes[1]);
		String[] colors = prop.getProperty("colors").split("\\|");
		System.out.println(colors[0]);
		System.out.println(colors[1]);
		String[] airbags = prop.getProperty("airbags").split("\\|");
		System.out.println(airbags[0]);
		System.out.println(airbags[1]);
		String[] powermoonroof = prop.getProperty("powermoonroof").split("\\|");
		System.out.println(powermoonroof[0]);
		System.out.println(powermoonroof[1]);
		//		System.out.println(transmissions[0]);
//		Set<Object> keys = p.keySet();
//		String[] transmission;
//		String[] brakes;
//		String[] colors;
//		String[] airbags;
//		String[] powermoonroof;
//		String carModel = "";
//		float carprice = 0;
//		for (Object obj : keys) {
//			if (obj.equals("carmodel")) {
//				carModel = p.getProperty((String) obj);
//			} else if (obj.equals("carprice")) {
//				String price = p.getProperty((String) obj);
//				carprice = Float.parseFloat(price);
//			} else {
//
//			}
//		}
//		System.out.println(p.getProperty("transmission"));
//		String[] transmission = p.getProperty("transmission").split("\\|");
//
//		wroteToProperties("testing.properties");
//		loading a properties file from class path
//		Properties prop = loadProperties("testing.properties");
//		String[] colors = prop.getProperty("auto.colors").toString().split(",");
//
//		//printing everything from a properties file
//		prop.forEach((key, value) -> System.out.println("Key : " + key + ", Value : " + value));
//		//get all keys
//		prop.keySet().forEach(x -> System.out.println(x));
	}

	public static void wroteToProperties(String fileName) {
		try (OutputStream output = new FileOutputStream(fileName)) {
			Properties prop = new Properties();
			// set the properties value

			prop.setProperty("db.url", "localhost");
			prop.setProperty("db.user", "mkyong");
			prop.setProperty("db.password", "password");
			// save properties to project root folder
			prop.store(output, null);
			System.out.println(prop);
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			System.out.println("IMPROPER FILE FORMAT!");
			throw new RuntimeException(e);
		}
	}

	//	public static Properties loadProperties(String fileName) {
//		try (InputStream input = new FileInputStream(fileName)) {
//			Properties prop = new Properties();
//			prop.load(input);
//			return prop;
//		} catch (FileNotFoundException e) {
//			throw new RuntimeException(e);
//		} catch (IOException e) {
//			throw new RuntimeException(e);
//		}
//	}
	public static Object loadPropsFile(String fname) {
		Properties props = new Properties();
		try {
			FileInputStream in = new FileInputStream(fname);
			props.load(in);
		} catch (FileNotFoundException e) {
			System.err.println("Err in file directory  ... ");
			System.exit(1);
		} catch (IOException e) {
			System.err.println("Error reading file from director ... ");
			System.exit(1);
		}

		return props;
	}
}
