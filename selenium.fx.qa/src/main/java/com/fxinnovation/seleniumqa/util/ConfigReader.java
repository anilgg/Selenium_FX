package com.fxinnovation.seleniumqa.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ConfigReader {
	private static ConfigReader instance;

	private Map<String, Properties> propertiesFiles;

	private ConfigReader() {
		propertiesFiles = new HashMap<String, Properties>();
	}

	public static ConfigReader getInstance() {
		if (instance == null) {
			instance = new ConfigReader();
		}

		return instance;
	}

	public Properties getProperties(String configFileName) {
		if (!propertiesFiles.containsKey(configFileName)) {
			propertiesFiles.put(configFileName, loadPropsFromFile(configFileName));
		}

		return propertiesFiles.get(configFileName);
	}

	private Properties loadPropsFromFile(String fileName) {
		try {
			InputStream inputStream = this.getClass().getResourceAsStream("/" + fileName);

			Properties props = new Properties();
			props.load(inputStream);

			return props;
		} catch (IOException e) {
			throw new RuntimeException("Error loading properties file.", e);
		}
	}
}