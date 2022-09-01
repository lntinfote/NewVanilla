package com.frame.qa.sampleTestcases;

import org.openqa.selenium.chromium.ChromiumDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.frame.qa.base.TestBase;
import com.frame.qa.utils.BrowserUtil;
import com.frame.qa.webpages.CartPage;
import com.frame.qa.webpages.HomePage;

public class MobileAppTest extends TestBase {
	
	public MobileAppTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		
		
	}
	
	@Test(enabled =  false)   // #1. Tab Management​
    public void launchMobileApp() {
		

	}
	

}
