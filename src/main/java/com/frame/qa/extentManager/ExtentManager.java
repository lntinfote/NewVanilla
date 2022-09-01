package com.frame.qa.extentManager;

import java.io.IOException;
import java.net.InetAddress;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentKlovReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.frame.qa.base.BrowserFactory;
import com.frame.qa.utils.DateAndTime;

public  class ExtentManager extends BrowserFactory {
	
	
	public static ExtentSparkReporter htmlReporter;
//	public static ExtentReports extent;
//	public static ExtentTest test;
	
	
	public static void setExtent() throws IOException {
	 htmlReporter = new ExtentSparkReporter("target/ExecutionReport_"+DateAndTime.getRunNumber()+".html");
	 htmlReporter.loadXMLConfig(System.getProperty("user.dir")+ "/extent-config.xml");
	 
	 
//	   ExtentKlovReporter klovReporter = new ExtentKlovReporter();
//	   klovReporter.initMongoDbConnection("localhost", 27017);
//	   klovReporter.setProjectName("Test 04");
//	   klovReporter.setReportName("4.0");
//	 
//	   klovReporter.initKlovServerConnection("http://localhost:8077");
//	   extent = new ExtentReports();
//		 extent.attachReporter(klovReporter);
	 
	 
	 extent = new ExtentReports();
	 extent.attachReporter(htmlReporter);
	 
	 
	 
	 
	}
	
	public static void EndReport() {
		  
		extent.flush();
	}
	

}
