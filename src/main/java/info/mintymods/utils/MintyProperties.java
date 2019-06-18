package info.mintymods.utils;

import java.util.Enumeration;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MintyProperties {

	public static final String MSS_PROPERTIES = "application.properties";
	private static final Logger log = LoggerFactory.getLogger(MintyProperties.class);
	private static Properties properties = new Properties();
	private static MintyProperties instance = null;

	private MintyProperties() {
	}

	public static MintyProperties getInstance() {
		if (instance == null) {
			instance = new MintyProperties();
			instance.load();
		}
		return instance;
	}

	public Properties getProperties() {
		return properties;
	}

	public Properties load() {
		properties = MintyFileUtils.getApplicationProperties();
		log.debug("properties loaded @" + MssPathUtils.getApplicationPropertiesFilename() + " #" + properties);
		return properties;
	}

	public boolean getBoolean(String name) {
		return "true".equalsIgnoreCase(properties.getProperty(name));
	}

	public String[] getArray(String key) {
		String value = getString(key);
		return value.split("\\|");
	}

	public String getString(String key) {
		String value = properties.getProperty(key);
		if (value == null || value.isEmpty()) {
			log.debug("Unable to find property key @" + key + " #Values:" + getPropertyKeyValues());
			return null;
		}
		return value.trim();
	}

	private String getPropertyKeyValues() {
		StringBuilder out = new StringBuilder();
		Enumeration<Object> keys = properties.keys();
		while (keys.hasMoreElements()) {
			String key = (String) keys.nextElement();
			out.append(key + ":" + properties.getProperty(key));
		}
		return out.toString();
	}

	public int getInt(String name) {
		return Integer.parseInt(getString(name));
	}

	public void reset() {
		properties.clear();
		load();
	}

}
