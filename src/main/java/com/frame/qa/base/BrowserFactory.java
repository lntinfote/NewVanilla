package com.frame.qa.base;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.paulhammant.ngwebdriver.NgWebDriver;
import com.sun.jna.Platform;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.netty.handler.ssl.OptionalSslHandler;

public class BrowserFactory  {
	
//	public volatile WebDriver driver  = null;
	public static  WebDriver driver = null ;   // Working 
	public static  RemoteWebDriver  driver_rw=null;
	public static NgWebDriver ngDriver = null;

	public static SessionId session;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static Capabilities caps ;
	public static String browserVersion  ;
	public static  String browserName  ;
	public static  String platformName  ;
//	ThreadLocal<WebDriver> driver =  new ThreadLocal<WebDriver>();
	public  InheritableThreadLocal<WebDriver> driverThread = new InheritableThreadLocal<WebDriver>();	
	public  InheritableThreadLocal<RemoteWebDriver> driverThread1 = new InheritableThreadLocal<RemoteWebDriver>();	
	public static ThreadLocal<Capabilities> capsThread = new ThreadLocal<Capabilities>();
	
	
	public WebDriver InitChrome(ITestResult result) throws MalformedURLException {

//		WebDriverManager.chromedriver().setup();
//		
//		Map<String, Object> prefs = new HashMap<String, Object>();
//		prefs.put("profile.default_content_setting_values.notifications", 2);
//		ChromeOptions options = new ChromeOptions();
//		options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
//		options.addArguments("start-maximized");
//		options.setExperimentalOption("prefs", prefs);
//		options.addArguments("enable-automation");
//		options.addArguments("--no-sandbox");
//		options.addArguments("--disable-infobars");
//		options.addArguments("--disable-dev-shm-usage");
//		options.addArguments("--disable-browser-side-navigation");
//		options.addArguments("--disable-gpu");
//		options.addArguments("--disable-default-apps");
//		options.addArguments("--disable-gpu");
//		options.addArguments("--disable-dev-shm-usage");
//		options.addArguments("--disable-notifications");
//		options.addArguments("chrome.switches", "--disable-extensions");
//		options.setPageLoadStrategy(PageLoadStrategy.NONE);
//		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
//		
//		driver = new ChromeDriver(options);
//		caps =  ((RemoteWebDriver)driver).getCapabilities();
//		capsThread.set(caps);
//		driverThread.set(driver);
		
		
		ChromeOptions options = new ChromeOptions();
		options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		options.addArguments("start-maximized");
//		options.setExperimentalOption("prefs", prefs);
		options.addArguments("enable-automation");
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-infobars");
		options.addArguments("--disable-dev-shm-usage");
		options.addArguments("--disable-browser-side-navigation");
		options.addArguments("--disable-gpu");
		options.addArguments("--disable-default-apps");
		options.addArguments("--disable-gpu");
		options.addArguments("--disable-dev-shm-usage");
		options.addArguments("--disable-notifications");
		options.addArguments("chrome.switches", "--disable-extensions");
		options.setPageLoadStrategy(PageLoadStrategy.NONE);
		
		DesiredCapabilities caps = new DesiredCapabilities (); 
		caps.setCapability(CapabilityType.BROWSER_NAME, BrowserType.CHROME);
		caps.setCapability("name",result.getMethod().getMethodName());
        caps.setCapability("tz", "Asia/Kolkata");
	    caps.setCapability(ChromeOptions.CAPABILITY, options);
		URL url = new URL("http://10.198.163.133:4444/wd/hub");
		
		driver_rw = new RemoteWebDriver(url, caps);
		driver_rw.manage().window().maximize();
		driver_rw.manage().deleteAllCookies();
		
//		 return driverThread1.get();   // need to check this later - parallel execution
		 return driver_rw;
		}
	
	public WebDriver InitChrome_Headless() {
		
		WebDriverManager.chromedriver().setup();
		Map<String, Object> prefs1 = new HashMap<String, Object>();
		ChromeOptions options1 = new ChromeOptions();
		options1.addArguments("start-maximized");
		options1.setExperimentalOption("prefs", prefs1);
		options1.addArguments("enable-automation");
		options1.addArguments("--no-sandbox");
		options1.addArguments("--disable-infobars");
		options1.addArguments("--disable-dev-shm-usage");
		options1.addArguments("--disable-browser-side-navigation");
		options1.addArguments("--disable-gpu");
		options1.addArguments("headless");
		options1.addArguments("--disable-default-apps");
		options1.addArguments("--disable-gpu");
		options1.addArguments("--disable-dev-shm-usage");
		options1.addArguments("--disable-notifications");
		options1.addArguments("chrome.switches", "--disable-extensions");
		driver = new ChromeDriver(options1);
		session = ((ChromeDriver) driver).getSessionId();
		System.out.println("Chrome Headless Session id: " + session.toString());
		caps =  ((RemoteWebDriver)driver).getCapabilities();
		capsThread.set(caps);
		driverThread.set(driver);
		System.out.println("returning headless chrome browser");
		 return driver;
		
	}
	
	public WebDriver InitFirefox() throws MalformedURLException {
//		WebDriverManager.firefoxdriver().setup();
		
		DesiredCapabilities caps = new DesiredCapabilities (); 
		caps.setCapability(CapabilityType.BROWSER_NAME, BrowserType.FIREFOX);
		caps.setCapability("marionette",true);  
	    caps.setCapability("tz", "Asia/Kolkata");
		URL url = new URL("http://10.198.163.133:4444/wd/hub");
		
		driver_rw = new RemoteWebDriver(url, caps);
		driver_rw.manage().window().maximize();
		driver_rw.manage().deleteAllCookies();
		
//		 return driverThread1.get();   // need to check this later - parallel execution
		driverThread1.set(driver_rw);
		 return driver_rw;
		}
		
	
	public WebDriver InitEdge() {
		WebDriverManager.edgedriver().setup();
		driver_rw = new EdgeDriver(); 
		caps =  ((RemoteWebDriver)driver_rw).getCapabilities();
		capsThread.set(caps);
		driverThread1.set(driver_rw);
		return driver_rw;
		}
	
	public WebDriver InitIE() {
		WebDriverManager.iedriver().setup();
		driver = new InternetExplorerDriver(); 
		caps =  ((RemoteWebDriver)driver).getCapabilities();
		driverThread.set(driver);
		return driver;
		}
	
	public WebDriver InitSafari() {
		WebDriverManager.safaridriver().setup();
		driver = new SafariDriver(); 
		caps =  ((RemoteWebDriver)driver).getCapabilities();
		driverThread.set(driver);
		return driver;
		}
	
	public WebDriver InitMobileDriver() {
		 System.out.println("Reading Mobile Properties ...........  ");
		  System.out.println("driver = new AppiumDriver()");
		return driver;
		}
	
	public org.openqa.selenium.remote.RemoteWebDriver RemoteWebDriver() {
		return null;
		 
		}
	
	public synchronized WebDriver getDriver() {
		return driverThread.get();
	}
	
	public synchronized RemoteWebDriver getRemoteWebDriver() {
		return driverThread1.get();
	}

}
