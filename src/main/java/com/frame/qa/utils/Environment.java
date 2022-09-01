package com.frame.qa.utils;


import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



public class Environment {

	static final Logger logger = LogManager.getLogger(Environment.class);

	private static String RUNNUMBER_VALUE = "";
	private static String PROJECT_DIR = "";
	private static String MACHINE_NAME = "";
	private static String USER_NAME = "";

	private static String TEST_ID_NAME = "";
	private static String TEST_ID_VALUE = "";

	private static String suiteType;
	private static String testCase_Name;
	private static String DATASHEET_NAME = "";

	private static String ITERATION_VALUE = "";
	private static String RUNNUMBER_COLUMN_NAME = "RUNNUMBER";

	private static String FIELD_NAME = "";

	private static String currentExecutionTestScript = "";

	private static Boolean isGrid = false;
	private static String hubURL = "";

	/**
	 * <p>
	 * This method sets the project directory path in the <br>
	 * 'Environment' class object. <br>
	 * </p>
	 * 
	 * @param projectDir
	 *            Pass the 'Project directory' path as a String. <br>
	 * <br>
	 *            Example: In a d: drive, if 'seleniumWorkspace' is created in
	 *            which <br>
	 *            'seleniumProject' is created then pass the 'seleniumProject'
	 *            location.<br>
	 * <br>
	 *            In this example, pass the value as
	 *            d:\\seleniumWorkspace\\seleniumProject
	 * 
	 * @see #getProjectDir()
	 */
	public static void setProjectDir(String projectDir) {
		PropertyManager.setResourceDir(projectDir);
		Environment.PROJECT_DIR = projectDir;
		Environment.setMachineName();
		Environment.setUserName();
		Environment.setTestIdColumnName();
		Environment.setRunNumberColumnName();
		Environment.setRunNumber(new DateAndTime());
		isGrid = Boolean.valueOf(PropertyManager.getApplicationProperty("application.grid.on"));
		hubURL = PropertyManager.getApplicationProperty("application.grid.hubURL");
	}

	public static String getProjectDir() {
		if(PROJECT_DIR.equals("") || PROJECT_DIR.equals(null)) {
			PROJECT_DIR = System.getProperty("user.dir");
		}
		return Environment.PROJECT_DIR;
	}

	/**
	 * <p>
	 * This method returns the machine user name on which the scripts <br>
	 * are running/executing.
	 * </p>
	 * 
	 * @return Returns the machine user name as String.
	 */
	public static String getUserName() {
		if (isGrid) {
			return "On Grid";
		}
		return Environment.USER_NAME;
	}

	private static void setUserName() {
		Environment.USER_NAME = System.getProperty("user.name");
	}

	/**
	 * <p>
	 * This method returns the machine name on which the scripts <br>
	 * are running/executing.
	 * </p>
	 * 
	 * @return Returns the machine name as String.
	 */
	/*
	 * public static String getMachineName() { if (isGrid) { URL hostURL; try {
	 * hostURL = new URL(hubURL); String[] hostAndPort =
	 * GridInfoExtracter.getHostNameAndPort(hostURL.getHost(), hostURL.getPort(),
	 * BaseTest.getSessionId()); return "[" + hostAndPort[0] + "," + hostAndPort[1]
	 * + "]"; } catch (MalformedURLException e) { e.printStackTrace(); }
	 * 
	 * } return Environment.MACHINE_NAME; }
	 */

	private static void setMachineName() {
		try {
			Environment.MACHINE_NAME = InetAddress.getLocalHost().getHostName();
		} catch (UnknownHostException e) {
			Environment.MACHINE_NAME = "UnKnowHost";
			// TestResults.Log(e);
		}
	}

	private static void setRunNumberColumnName() {

		// Environment.RUNNUMBER_COLUMN_NAME =
		// PropertyManager.getEnvProperty(Constants.RUNNUMBER_COLUMN_NAME);

	}

	protected static String getRunNumberColumnName() {
		return Environment.RUNNUMBER_COLUMN_NAME;
	}

	/**
	 * <p>
	 * This method returns the run number value that has been set <br>
	 * for the current batch run execution or test script execution.
	 * </p>
	 * 
	 * @return Returns the run number as String.
	 */
	public static String getRunNumber() {
		return Environment.RUNNUMBER_VALUE;
	}

	private static void setRunNumber(DateAndTime runObj) {
		Environment.RUNNUMBER_VALUE = runObj.getRunNumber();

		logger.info("--> Setting RunNumber value in Environment as :" + Environment.RUNNUMBER_VALUE);

	}

	protected static String getTestIdColumnName() {
		return Environment.TEST_ID_NAME;
	}

	private static void setTestIdColumnName() {
		Environment.TEST_ID_NAME = PropertyManager.getTestCaseProperty(Constants.TESTID_COLUMNNAME);

	}

	public static void setCurrentExecutionTestScript(String testScriptName) {
		currentExecutionTestScript = testScriptName;
	}

	public static String getCurrentExecutionTestScript() {
		return currentExecutionTestScript;
	}

	protected static String getIterationValue() {
		return Environment.ITERATION_VALUE;
	}

	protected static void setIterationValue(String iterationValue) {
		Environment.ITERATION_VALUE = iterationValue;
	}

	protected static String getFieldName() {
		return Environment.FIELD_NAME;
	}

	protected static void setFieldName(String fieldName) {
		Environment.FIELD_NAME = fieldName;
	}

	protected static void setTestIDValue(String testIdValue) {
		Environment.TEST_ID_VALUE = testIdValue;
	}

	protected static String getTestIDValue() {
		return Environment.TEST_ID_VALUE;
	}

	protected static String getDatasheetName() {
		return Environment.DATASHEET_NAME;
	}

	protected static void setDatasheetName(String dataShtName) {
		Environment.DATASHEET_NAME = dataShtName;
	}

	public static String getSuiteType() {
		return suiteType;
	}

	public static void setSuiteType(String suiteType) {
		Environment.suiteType = suiteType;
	}

	public static String getTestCase_Name() {
		return testCase_Name;
	}

	public static void setTestCase_Name(String testCase_Name) {
		Environment.testCase_Name = testCase_Name;
	}

}
