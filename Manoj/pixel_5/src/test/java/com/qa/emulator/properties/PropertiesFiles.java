package com.qa.emulator.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.qa.emulator.constants.Constants;

public class PropertiesFiles {
	
	public static Logger logger = Logger.getLogger(PropertiesFiles.class);
	public static String value = null;

	/**
	 * This method is used to read properties from properties files
	 * 
	 * @parameter passing values
	 * @return return property from properties file
	 */
	public static String readTestData(String key) {
		try {
			value =  readProperties().getProperty(key);
		} catch (Exception exception) {
			logger.error("Key value is Not Found" + exception);
		}
		return value;
	}

	/**
	 * This method is used to read the properties file
	 * 
	 * @return properties
	 */
	public static Properties readProperties() {
		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream(Constants.configPath));
		} catch (IOException exception) {
			logger.error("File is Not Found" + exception);
		}
		return properties;
	}

}
