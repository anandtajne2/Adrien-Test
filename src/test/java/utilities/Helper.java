package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Helper {

	static Properties properties;

	public static String getProperty(String property) {
		try {
			properties = new Properties();
			FileInputStream fileInputStream = new FileInputStream("./src/test/resources/config/config.properties");
			properties.load(fileInputStream);
			return properties.getProperty(property);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "property is not present in config file";
		}
	}
}