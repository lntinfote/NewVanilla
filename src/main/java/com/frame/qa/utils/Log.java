package com.frame.qa.utils;


import java.io.IOException;

//import org.apache.log4j.ConsoleAppender;
//import org.apache.log4j.FileAppender;
//import org.apache.log4j.Level;
//import org.apache.log4j.Logger;
//import org.apache.log4j.PatternLayout;
//import org.apache.log4j.PropertyConfigurator;

public class Log {
	
	/*
	<dependency>
	<groupId>org.apache.poi</groupId>
	<artifactId>openxml4j</artifactId>
	<version>1.0-beta</version>
</dependency>
	
	*/
	
/*
	private static final Logger LOGGER = Logger.getLogger("logger");
	private static PatternLayout layout = new PatternLayout("%d{dd MMM yyyy HH:mm:ss} %5p %c{1} - %m%n");
	private static FileAppender appender;
	private static ConsoleAppender consoleAppender;

	synchronized public static Logger getLogData(String className) {
		PropertyConfigurator.configure(System.getProperty("user.dir") + "/src/test/resources/Log/log4j.properties");
		
		System.out.println("classname ***********:" + className + "     "+ Logger.getLogger(className) );
		Logger.getLogger(className);
		return Logger.getLogger(className);
	}

	static {
		try { // consoleAppender = new ConsoleAppender(layout, "System.out");
			consoleAppender = new ConsoleAppender();
			appender = new FileAppender(layout, "target/LogFile.txt", true);
		} catch (IOException exception) {
			exception.printStackTrace();
		}
	}

	/**
	 * method to display errors in log.
	 * 
	 * @param className  name of class in which error occurred.
	 * @param methodName name of method in which error occurred.
	 * @param exception  stack trace of exception
	 */

	
	/*
	
	public static void logError(String className, String methodName, String exception) {
		LOGGER.addAppender(appender);
		LOGGER.setLevel((Level) Level.INFO);
		LOGGER.info("ClassName :" + className);
		LOGGER.info("MethodName :" + methodName);
		LOGGER.info("Exception :" + exception);
		LOGGER.info("-----------------------------------------------------------------------------------");
	}

	/**
	 * method to display information in logs
	 * 
	 * @param message message to be displayed
	 */

	
	/*
	public static void info(String message) {
		consoleAppender.setName("Console");
		LOGGER.addAppender(consoleAppender);
		LOGGER.addAppender(appender);
		LOGGER.setLevel((Level) Level.INFO);
		LOGGER.info(message);
	}
*/
}
