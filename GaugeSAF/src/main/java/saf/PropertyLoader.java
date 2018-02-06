package saf;

import java.io.IOException;
import java.util.Properties;

/*
 * Class that extracts properties from the prop file.
 * 
 * @author Panchdev Chauhan
 */
public class PropertyLoader {

	private final static String PROP_FILE = "/application.properties";

	public PropertyLoader() {
	}

	public static final String loadProperty(String name) {
		Properties props = new Properties();
		try {
			props.load(PropertyLoader.class.getResourceAsStream(PROP_FILE));
		} catch (IOException e) {
			e.printStackTrace();
		}

		String value = "";

		if (name != null) {
			value = props.getProperty(name);
		}
		return value;
	}

}