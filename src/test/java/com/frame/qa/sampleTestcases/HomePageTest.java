package com.frame.qa.sampleTestcases;


import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.frame.qa.base.TestBase;

public class HomePageTest extends TestBase {

	
	ChromeDriver driver1;
	public HomePageTest() {
		super();
	}

	//test cases should be separated -- independent with each other
	//before each test case -- launch the browser and login
	//@test -- execute test case
	//after each test case -- close the browser
	
//	@BeforeMethod
//	public void setUp() {
//		initialization();
//		testUtil = new TestUtil();
//		contactsPage = new ContactsPage();
//		loginPage = new LoginPage();
//		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
//	}
	
	
	@Test(priority=1)
    public void getAndSwitchToNewTab() {
		
		
        String CartUrl = driver.findElement(By.xpath("//a[contains(@id,'cart')]")).getAttribute("href");

    	
    	// Selenium 3 Approach 
    	((JavascriptExecutor)driver).executeScript("window.open()");
    	 ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        
        driver.get(CartUrl);
        driver.findElement(By.xpath("//h2[contains(text(),'Your Amazon Basket is empty')]")).isDisplayed();
        
     }
	
	@Test
    public void getAndSwitchToNewWindow() {
		
		
        String CartUrl = driver.findElement(By.xpath("//a[contains(@id,'cart')]")).getAttribute("href");
       
        driver1 = new ChromeDriver();
	   	driver1.get(CartUrl);
		
	   	driver = driver1;
        driver.findElement(By.xpath("//h2[contains(text(),'Your Amazon Basket is empty')]")).isDisplayed();
        
	   	 ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
	   	 System.out.println(tabs.size());
		
	}
	
	@Test
    public void performActionsUsingRelativeLocators() {
		driver.findElement(By.xpath("//a[text()='Mobiles']")).click();
	   	String getTitle=driver.getTitle();
	   	Assert.assertEquals(true, getTitle.contains("Mobile"));
		
	}
	
	
	
//	@AfterMethod
//	public void tearDown(){
//		driver.quit();
//	}
	
	

}
