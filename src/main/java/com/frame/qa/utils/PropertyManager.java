package com.frame.qa.utils;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * This class is defined to access the property files in 'TestData' folder.
 * 
 */
public class PropertyManager {

	static final Logger logger = LogManager.getLogger(PropertyManager.class);
	private static String resourceDirectory = "";

	/**
	 * Sets the Resources directory at starting of test run
	 * 
	 * @param projectDir
	 */
	protected static void setResourceDir(String projectDir) {
		resourceDirectory = projectDir + Constants.PROPERTY_FILES_PATH;
	}

	/**
	 * This method returns the property value from 'Env.properties' file.
	 * 
	 * @param propertyName
	 *            Pass {@link Constants} variables.
	 * @return returns the property value as string.
	 */
	public static String getEnvProperty(String propertyName) {
		Properties p = new Properties();
		try {
			p.load(PropertyManager.getPropertyFile(Constants.ENVPROPERTIESFILENAME));
		} catch (Exception e) {
			logger.error("Can't able locate the 'Env.properties' file.");
		}

		return p.getProperty(propertyName);
	}

	/**
	 * This method returns the property value from 'TestDataSheet.properties'
	 * file.
	 * 
	 * @param propertyName
	 *            Pass {@link Constants} variables.
	 * @return returns the property value as string.
	 */
	public static String getTestCaseProperty(String propertyName) {
		Properties p = new Properties();
		try {
			p.load(PropertyManager.getPropertyFile(Constants.TESTDA_TASHEET_FILE_NAME));
		} catch (Exception e) {
			logger.error(e);
		}
		return p.getProperty(propertyName);
	}

	/**
	 * This method returns the property value from 'Application.properties'
	 * file.
	 * 
	 * @param propertyName
	 *            Pass {@link Constants} variables.
	 * @return returns the property value as string.
	 */
	public static String getApplicationProperty(String propertyName) {
		Properties p = new Properties();
		try {
			p.load(PropertyManager.getPropertyFile(Constants.APPLICATION_DETAILS_FILE_NAME));
		} catch (Exception e) {
			logger.error(e);
		}
		return p.getProperty(propertyName);
	}
	
	public static String getApiProperty(String propertyName) {
		Properties p = new Properties();
		try {
			p.load(PropertyManager.getPropertyFile(Constants.API_FILE_NAME));
		} catch (Exception e) {
			logger.error(e);
		}
		return p.getProperty(propertyName);
	}

	/**
	 * This method load the properties file
	 * 
	 * @param fileName
	 * @return {@link InputStream}
	 */
	private static InputStream getPropertyFile(String fileName) {
		FileInputStream fi = null;
		try {
			fi = new FileInputStream(new File(Environment.getProjectDir() + Constants.PROPERTY_FILES_PATH + fileName));
		} catch (FileNotFoundException e) {
			logger.error("Can't able locate the '" + fileName + "' file.");
		}
		return fi;
	}

	/**
	 * This method returns the property value from the given properties
	 * fileName.
	 * 
	 * @param fileName
	 *            -- .properties file Name
	 * @param propertyName
	 *            -- name of the property
	 * @return returns the property value as string.
	 */
	public static String getPropertyFileValue(String fileName, String propertyName) {
		FileInputStream fi = null;
		Properties properties = new Properties();
		String returnValueString = null;
		try {
			fi = new FileInputStream(new File(resourceDirectory + fileName));
			properties.load(fi);
			returnValueString = properties.getProperty(propertyName);
		} catch (FileNotFoundException fe) {
			logger.error("Can't able locate the  '" + fileName + "' file.");
		} catch (Exception e) {
			logger.error(e);
		}

		return returnValueString;
	}
}
