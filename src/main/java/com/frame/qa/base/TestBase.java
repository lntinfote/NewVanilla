package com.frame.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.frame.qa.extentManager.ExtentManager;
import com.frame.qa.utils.TestUtil;
import com.frame.qa.utils.WebEventListener;
import com.paulhammant.ngwebdriver.NgWebDriver;



public class TestBase extends BrowserFactory {
	
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	static int   count ;
	public int no ;
	
	
	
	public TestBase(){
		try {
			System.out.println("");
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "\\src\\main\\java\\com\\frame\\qa\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	@BeforeSuite
	public void SettingReportEnv() throws IOException {
		ExtentManager.setExtent();
	}
	
	
	@BeforeMethod(alwaysRun = true)
	@Parameters({ "platform", "browser"})
	public synchronized void initialization(String platform, String browserName, ITestResult result ) throws MalformedURLException{
		if(platform.equals("web")) {
			System.setProperty("java.net.preferIPv4Stack" , "true");

			  if(browserName.equals("Chrome")){
				 InitChrome(result);
				}
			  else if(browserName.equals("ChromeHeadless")){
					InitChrome_Headless();
				}
				else if(browserName.equals("FF")){
					InitFirefox();
				}
				else if(browserName.equals("IE")){
					InitIE();
				}
				else if(browserName.equals("Edge")){
					InitEdge();
				}
				else if(browserName.equals("Safari")){
					InitSafari();
				}
			  
		  }
		  else if(platform.equals("Mobile")) {
			  System.out.println("Reading Mobile Properties ...........  ");
			  System.out.println("driver = new AppiumDriver()");
		  }
		
//		
//		e_driver = new EventFiringWebDriver(driver);
//		// Now create object of EventListerHandler to register it with EventFiringWebDriver
//		eventListener = new WebEventListener();
//		e_driver.register(eventListener);
//		driver = e_driver;
		driver_rw.manage().window().maximize();
		driver_rw.manage().deleteAllCookies();
		driver_rw.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver_rw.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver_rw.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		
		System.out.println("Driver in Before methos is "+ driver_rw);

		driver_rw.get(prop.getProperty("url"));
		
		
		ngDriver = new NgWebDriver((JavascriptExecutor) driver);
		
		
	}
	
	
	
	   @AfterMethod
		public synchronized void tearDown(ITestResult rslt) throws InterruptedException {
			System.out.println("thread id  Tear down  : " + Thread.currentThread().getId());
		        Cookie cookie = null;
		        System.out.println("Status of method=========="+rslt.getStatus());
		        if(rslt.getStatus()==1)
		        {
		        cookie = new Cookie("zaleniumTestPassed", "true");
		            }
		        if(rslt.getStatus()==2)
		        {
		        cookie = new Cookie("zaleniumTestPassed", "false");
		            }
		        
		        driver_rw.manage().addCookie(cookie);
		        
		        System.out.println("****************After each Test********************");
		        System.out.println("**Test ends on **====="+System.currentTimeMillis());
		        
		        System.out.println("****************Inside CLOSE driver = "+driver_rw.toString()+"********************" );
//		        driver.close();
		        
		    
//			driver.quit();
//			driver_rw.quit();
			
		}
	   
	   @AfterSuite
	   public void TearDownReportEnv () throws UnknownHostException {
		   extent.setSystemInfo("HostName", InetAddress.getLocalHost().toString()  );
			  extent.setSystemInfo("Projectname", prop.getProperty("Projectname"));
			  extent.setSystemInfo("Tester", prop.getProperty("Tester") );
//			  extent.setSystemInfo("OS", caps.getPlatform().toString());
//			  extent.setSystemInfo("Browser", caps.getBrowserName());
//			  extent.setSystemInfo("Browser Version", caps.getBrowserVersion());
			  ExtentManager.EndReport();
		   
	   }
	   
//	   @AfterClass
//	   public synchronized void tearDown11() throws InterruptedException {
//			System.out.println("thread id  Tear down 11 : " + Thread.currentThread().getId());
//			driver.quit();
////			Thread.currentThread().stop();
//		}
	
		

}
