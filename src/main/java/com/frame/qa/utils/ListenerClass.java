package com.frame.qa.utils;

import java.io.IOException;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.frame.qa.extentManager.ExtentManager;

public class ListenerClass extends ExtentManager implements ITestListener  {

	 public static ThreadLocal<ExtentTest> extent_test = new ThreadLocal<ExtentTest>();
	 
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test = extent.createTest(result.getName()+" - "+caps.getBrowserName());
		
		 extent_test.set(test);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		if(result.getStatus() == ITestResult.SUCCESS) {
			extent_test.get().log(Status.PASS, "Passed test case is: " + result.getName());
//			test.log(Status.PASS, "Passed test case is: " + result.getName());
		}
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		if(result.getStatus() == ITestResult.FAILURE) {
//			extent_test.get().log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed ", ExtentColor.RED));
//			test.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed ", ExtentColor.RED));

			 extent_test.set(test);
			
//			 need to call the screenshot utility which return the screenshot path. pass tha path to below method.
			try {
				extent_test.get().addScreenCaptureFromPath(TestUtil.takeScreenshotAtEndOfTest());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			extent_test.get().log(Status.FAIL, ExceptionUtils.getStackTrace(result.getThrowable()));

			 
			
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		if(result.getStatus() == ITestResult.SKIP) {
			extent_test.get().log(Status.SKIP, "Skipped test case is: " + result.getName());
//			 extent_test.set(test);
			
		}
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
