package com.frame.qa.sampleTestcases;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.emulation.Emulation;
import org.openqa.selenium.devtools.v85.network.Network;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.frame.qa.base.TestBase;
import com.frame.qa.utils.BrowserUtil;
import com.frame.qa.webpages.CartPage;
import com.frame.qa.webpages.HomePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SamplePageTest_Sel4  extends TestBase {

	HomePage homePage;
	CartPage cartPage;
	
	public SamplePageTest_Sel4() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		homePage =new HomePage();
		cartPage = new CartPage();
		System.out.println("Driver in Test before method : "+ driver);
	}
	
	@Test
    public void getAndSwitchToNewTab() {
		System.out.println("thread id  in test 1 : " + Thread.currentThread().getId());
		driver.get("http://demo-store.seleniumacademy.com/");
        String CartUrl = homePage.getCartURL_women();
    	driver.switchTo().newWindow(WindowType.TAB).get(CartUrl);
        Assert.assertEquals(cartPage.isWomenLabelDisplayed(), true);
        }
	
	@Test
    public void performActionsUsingRelativeLocators() {
		System.out.println("thread id  in test 2 : " + Thread.currentThread().getId());
		driver.get("http://demo-store.seleniumacademy.com/");
		
		
//		driver.findElement(with(By.tagName("a")).toLeftOf(By.xpath("//a[text()='Home & Decor']")).toRightOf(By.xpath("//a[text()='Men']"))).click();
		driver.findElement(By.xpath("//a[text()='Men']")).click();
		String getTitle = homePage.verifyHomePageTitle();
		System.out.println("Title is : "+ getTitle );
		
//		Assert.assertEquals(true, driver.getTitle().contains("Men"));
	}
	
	
	@Test
    public void clickVIP() {
		System.out.println("thread id  in test 3 : " + Thread.currentThread().getId());
		driver.get("http://demo-store.seleniumacademy.com/");
		homePage.clickOnVIP();
//		Assert.assertEquals(true, homePage.IsVIPLabelDisplayed());
		
	}
	
	
	@Test
    public void clickVIP1() {
		System.out.println("thread id  in test 3 : " + Thread.currentThread().getId());
		driver.get("http://demo-store.seleniumacademy.com/");
		homePage.clickOnVIP();
//		Assert.assertEquals(true, homePage.IsVIPLabelDisplayed());
		
	}
	
	
	@Test
    public void clickVIP2() {
		System.out.println("thread id  in test 3 : " + Thread.currentThread().getId());
		driver.get("http://demo-store.seleniumacademy.com/");
		homePage.clickOnVIP();
//		Assert.assertEquals(true, homePage.IsVIPLabelDisplayed());
		
	}
	
	@Test
    public void clickVIP3() {
		System.out.println("thread id  in test 3 : " + Thread.currentThread().getId());
		driver.get("http://demo-store.seleniumacademy.com/");
		homePage.clickOnVIP();
//		Assert.assertEquals(true, homePage.IsVIPLabelDisplayed());
		
	}
	
	
	@Test
    public void clickVIP4() {
		System.out.println("thread id  in test 3 : " + Thread.currentThread().getId());
		driver.get("http://demo-store.seleniumacademy.com/");
		homePage.clickOnVIP();
//		Assert.assertEquals(true, homePage.IsVIPLabelDisplayed());
		
	}
	
	/*
	@Test
    public void clickVIP5() {
		System.out.println("thread id  in test 3 : " + Thread.currentThread().getId());
		driver.get("http://demo-store.seleniumacademy.com/");
		homePage.clickOnVIP();
//		Assert.assertEquals(true, homePage.IsVIPLabelDisplayed());
		
	}
	
	
	@Test
    public void clickVIP6() {
		System.out.println("thread id  in test 3 : " + Thread.currentThread().getId());
		driver.get("http://demo-store.seleniumacademy.com/");
		homePage.clickOnVIP();
//		Assert.assertEquals(true, homePage.IsVIPLabelDisplayed());
		
	}
	
	
	@Test
    public void clickVIP7() {
		System.out.println("thread id  in test 3 : " + Thread.currentThread().getId());
		driver.get("http://demo-store.seleniumacademy.com/");
		homePage.clickOnVIP();
//		Assert.assertEquals(true, homePage.IsVIPLabelDisplayed());
		
	} */
	
//	@AfterMethod
//	public void tearDown(){
//		driver.quit();
//	}
	
}
