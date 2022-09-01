package com.frame.qa.wrappers;


import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

import javax.imageio.ImageIO;
import org.openqa.selenium.interactions.Actions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.frame.qa.base.BrowserFactory;
import com.frame.qa.base.TestBase;
import com.frame.qa.constants.Constants;
import com.frame.qa.utils.ExplicitWaiting;
import com.frame.qa.utils.Log;
import com.frame.qa.utils.WebEventListener;



@SuppressWarnings("deprecation")
public class BaseMethod extends TestBase {
	
	
	
	public static Robot re;
	public static Alert al;
	public static String robotImageName;
	public static Select se;
	public static Actions newaction;
	public static Actions ac;
	
	static final Logger logger = LogManager.getLogger(BaseMethod.class);


	/* To get the Website Name */
	/*
	 * public String getUrlTitle() throws Exception { URL aURL = new
	 * URL(WebsiteURL); String WebName = aURL.getHost(); String WebSiteName =
	 * WebName.toUpperCase(); return WebSiteName; }
	 */

	/* To Press ENTER Key using Robot */
	public synchronized void hitEnter() throws Exception {
		logger.info("Trying to hit Enter button");
		re = new Robot();
		re.keyPress(KeyEvent.VK_ENTER);
		re.keyRelease(KeyEvent.VK_ENTER);
		logger.info("Enter button hit");
		
		

	}

	/* To Press ENTER Key using Robot */
	public synchronized void enterTab() throws Exception {
		logger.info("Trying to hit Tab button");
		re = new Robot();
		re.keyPress(KeyEvent.VK_TAB);
		re.keyRelease(KeyEvent.VK_TAB);
		logger.info("Tab button hit");
	}
	
	/* To Press BACKSPACE Key using Robot */
	public synchronized void hitBackspace() throws Exception {
		logger.info("Trying to hit Backspace button");
		re = new Robot();
		re.keyPress(KeyEvent.VK_BACK_SPACE);
		re.keyRelease(KeyEvent.VK_BACK_SPACE);
		logger.info("Backspace button hit");

	}

	/* To Press DELETE Key using Robot */
	public synchronized void hitDelete() throws Exception {
		logger.info("Trying to hit Delete button using robot");

		re = new Robot();
		re.keyPress(KeyEvent.VK_DELETE);
		re.keyRelease(KeyEvent.VK_DELETE);
		logger.info("delete button hit using robot");

	}
	
	/* To open new tab Elements using ROBOT */
	public synchronized void newTabUsingRobot() throws Exception {
		logger.info("Trying to open New tab using robot");

		re = new Robot();
		re.keyPress(KeyEvent.VK_CONTROL);
		re.keyPress(KeyEvent.VK_T);
		re.keyRelease(KeyEvent.VK_CONTROL);
		re.keyRelease(KeyEvent.VK_T);
		logger.info("New tab opened using robot");

	}
	
	public synchronized org.openqa.selenium.remote.RemoteWebDriver newTab() {
		logger.info("New tab opened ");
		return (org.openqa.selenium.remote.RemoteWebDriver) driver_rw.switchTo().newWindow(WindowType.TAB);

	}

	/* To Select all the Text/Web Elements using ROBOT */
	public synchronized void selectAll() throws Exception {
		logger.info("Trying to press Cntl+A key using robot");

		re = new Robot();
		re.keyPress(KeyEvent.VK_CONTROL);
		re.keyPress(KeyEvent.VK_A);
		re.keyRelease(KeyEvent.VK_CONTROL);
		re.keyRelease(KeyEvent.VK_A);
		logger.info("Cntl+A key pressed");

		
	}

	/* To Copy all the Selected Text/Web Elements using ROBOT */
	public synchronized void copyAll() throws Exception {
		logger.info("Trying to press Cntl+C key using robot");

		re = new Robot();
		re.keyPress(KeyEvent.VK_CONTROL);
		re.keyPress(KeyEvent.VK_C);
		re.keyRelease(KeyEvent.VK_CONTROL);
		re.keyRelease(KeyEvent.VK_C);
		logger.info("Cntl+C key pressed");

	}

	/* To Paste all the Selected Text/Web Elements using ROBOT */
	public synchronized void pasteAll() throws Exception {
		logger.info("Trying to press Cntl+V key using robot");

		re = new Robot();
		re.keyPress(KeyEvent.VK_CONTROL);
		re.keyPress(KeyEvent.VK_V);
		re.keyRelease(KeyEvent.VK_CONTROL);
		re.keyRelease(KeyEvent.VK_V);
		logger.info("Cntl+V key pressed");

	}

	/* To Capture Screenshot(Replaces if already exists) */
	/*
	 * Also, Make sure that the automation in running in the foreground to capture
	 * the Image of the Browser. Else, It'll capture the open Window
	 */
	public synchronized void robotScreenCapture(String robotImageName) throws Exception {
		logger.info("Trying to capture screenshot using robot");

		re = new Robot();
		Rectangle area = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
		BufferedImage bufferedImage = re.createScreenCapture(area);
		// Save as PNG
		File file = new File(robotImageName);
		if (file.exists()) {
			file.delete();
		}
		ImageIO.write(bufferedImage, "png", file);
		logger.info("Screenshot captured using robot");

	}

	/* To ZoomOut */
	public synchronized void robotZoomOut() throws Exception {
		logger.info("Trying to zoom out using robot - Cntrl + Minus Key");

		re = new Robot();
		re.keyPress(KeyEvent.VK_CONTROL);
		re.keyPress(KeyEvent.VK_SUBTRACT);
		re.keyRelease(KeyEvent.VK_SUBTRACT);
		re.keyRelease(KeyEvent.VK_CONTROL);
		logger.info("zoom out using robot");


	}

	/* To ZoomOut */
	public synchronized void keyPress(int keycode) throws Exception {
		re = new Robot();
		re.keyPress(keycode);

	}

	/* To ZoomOut */
	public synchronized void keyRelease(int keycode) throws Exception {
		re = new Robot();
		re.keyRelease(keycode);

	}

	/* To ZoomIn */
	public synchronized void robotZoomIn() throws Exception {
		re = new Robot();
		re.keyPress(KeyEvent.VK_CONTROL);
		re.keyPress(KeyEvent.VK_ADD);
		re.keyRelease(KeyEvent.VK_ADD);
		re.keyRelease(KeyEvent.VK_CONTROL);
	}

	/* To ScrollUp using ROBOT */
	public synchronized void robotScrollUp() throws Exception {
		re = new Robot();
		re.keyPress(KeyEvent.VK_PAGE_UP);
		re.keyRelease(KeyEvent.VK_PAGE_UP);
	}

	/* To ScrollDown using ROBOT */
	public synchronized void robotScrollDown() throws Exception {
		re = new Robot();
		re.keyPress(KeyEvent.VK_PAGE_DOWN);
		re.keyRelease(KeyEvent.VK_PAGE_DOWN);
	}

	/* To ScrollUp using JavaScript Executor */
	public synchronized void scrollUp() throws Exception {
		((JavascriptExecutor) BrowserFactory.driver).executeScript("scroll(0, -100);");
	}

	/* To ScrollDown using JavaScript Executor */
	public synchronized void scrollDown()  {
		((JavascriptExecutor) BrowserFactory.driver).executeScript("scroll(0, 1000);");
	}

	/* To Move cursor to the Desired Location */
	public synchronized void moveCursor(int X_Position, int Y_Position) throws Exception {
		re.mouseMove(X_Position, Y_Position);
	}

	/* To Accept the Alert Dialog Message */
	public synchronized void alertAccept() throws Exception {
		al = BrowserFactory.driver.switchTo().alert();
		al.accept();
	}

	/* To Dismiss the Alert Dialog Message */
	public synchronized void alertDismiss() throws Exception {
		al = BrowserFactory.driver.switchTo().alert();
		al.dismiss();
	}

	/* To Get the Alert Messages */
	public String getAlertText() throws Exception {
		al = driver.switchTo().alert();
		String text = al.getText();
		Thread.sleep(2000);
		alertAccept();
		return text;
	}

	/* To Perform a WebAction of Mouse Over */
	public synchronized void mousehover(WebElement element) {
		
		newaction = new Actions(driver);
		newaction.moveToElement(element).build().perform();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {

		}
	}

	/* To Perform Select Option by Visible Text */
	public synchronized void selectByVisibleText(WebElement element, String value) {
		logger.info("Trying to select element Value from Dropdown");

		se = new Select(element);
		se.selectByVisibleText(value);
		logger.info(value +" Value selected from Dropdown: ");

	}

	/* To Perform Select Option by Index */
	public synchronized void selectByIndex(WebElement element, int value) {
		se = new Select(element);
		se.selectByIndex(value);
	}

	/* To Perform Select Option by Value */
	public synchronized void selectByValue(WebElement element, String value) {
		se = new Select(element);
		se.selectByValue(value);
	}

	/* To click a certain Web Element */
	public synchronized void click(WebElement element) {
		logger.info("Trying to click on element: " + element.toString());
		waitForJSandJQueryToLoad();
		element.click();
		logger.info("element clicked : " + element.toString());
	}
	
	
	public synchronized void clickUsingIndex(List <WebElement> element, int index) {
		logger.info("Trying to click on" +index + " element: " + element.toString());
		waitForJSandJQueryToLoad();
		element.get(index).click();
		logger.info("element clicked : " + element.toString());

	}

	public static String getText(WebElement element) {
		String text = "";
		int attempts = 0;
		while (attempts < 2) {
			try {
				text = element.getText();
				break;
			} catch (StaleElementReferenceException e) {
			}
			attempts++;
		}
		return text;
	}

	/* To click a certain Web Element using DOM/ JavaScript Executor */
	public synchronized void JSclick(WebElement element) {
		waitForJSandJQueryToLoad();
		((JavascriptExecutor) BrowserFactory.driver).executeScript("return arguments[0].click();", element);

	}

	/* To Type at the specified location */
	public synchronized void sendKeys(WebElement element, String value) {
		waitForJSandJQueryToLoad();
		element.sendKeys(value);

	}

	public synchronized void sendKeys(WebElement element, Keys keyvalue) {
		waitForJSandJQueryToLoad();
		element.sendKeys(keyvalue);

	}

	/* To Clear the content in the input location */
	public synchronized void clear(WebElement element) {
		waitForJSandJQueryToLoad();
		element.clear();
	}

	/* To Drag and Drop from Source Locator to Destination Locator */
	public synchronized void dragandDrop(WebElement Source, WebElement Destination) {
		// ac = new Actions(BrowserFactory.driver);
		newaction.dragAndDrop(Source, Destination);
	}

	/*
	 * To Drag from the given WebElement Location and Drop at the given WebElement
	 * location
	 */
	public synchronized void dragandDropTo(WebElement Source, int XOffset, int YOffset) throws Exception {
		newaction.dragAndDropBy(Source, XOffset, YOffset);
	}

	/* To Open a Page in New Tab */
	public synchronized void rightClick(WebElement element) {
		ExplicitWaiting.explicitWaitVisibilityOfElement(element, 30);
		newaction.contextClick(element).build().perform();
	}

	/* To Close Current Tab */
	public synchronized void closeCurrentTab() {
		BrowserFactory.driver.close();
	}

	/* To Perform Click and Hold Action */
	public synchronized void clickAndHold(WebElement element) {
		ac = new Actions(BrowserFactory.driver);
		ac.clickAndHold(element);
		ac.build().perform();
	}

	/* To Perform Click and Hold Action */
	public synchronized void doubleClick(WebElement element) {
		scrollToElementLoc(element);
		ac = new Actions(BrowserFactory.driver);
		ac.doubleClick(element);
		ac.build().perform();
	}

	/* To Switch To Frame By Index */
	public synchronized void switchToFrameByIndex(int index) throws Exception {
		BrowserFactory.driver.switchTo().frame(index);

	}

	/* To Switch To Frame By Frame Name */
	public synchronized void switchToFrameByFrameName(String frameName) throws Exception {
		BrowserFactory.driver.switchTo().frame(frameName);
	}

	/* To Switch To Frame By Web Element */
	public synchronized void switchToFrameByWebElement(WebElement element) throws Exception {
		BrowserFactory.driver.switchTo().frame(element);
	}

	/* To Switch out of a Frame */
	public synchronized void switchOutOfFrame() throws Exception {
		BrowserFactory.driver.switchTo().defaultContent();
	}

	/* To Get Tooltip Text */
	public String getTooltipText(WebElement element) {
		String tooltipText = element.getAttribute("title").trim();
		return tooltipText;
	}
	
	/* To Get  Text from Attribute */
	public String getAttribute(WebElement element, String Attributename) {
		logger.info("Trying to "+ Attributename +" attribute value from DOM");

		return element.getAttribute(Attributename).trim();
	}

	/* Scroll to the specific element of the page */
	public synchronized void scrollToElementLoc(WebElement element) {
		int attempts = 0;
		while (attempts < 2) {
			try {

				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
				break;
			} catch (StaleElementReferenceException e) {
				attempts++;
			}
		}
	}

	/* Wait for visibility of Element */
	public synchronized void waitUntilVisible(WebElement element) {
		new WebDriverWait(BrowserFactory.driver, Duration.ofSeconds(60)).until(ExpectedConditions.visibilityOf(element));
		explicitWait(Constants.MEDIUM_PAUSE_MILLISECONDS);
	}

	/* Wait for Element to Clickable */
	public synchronized void waitUntilClickable(WebElement airingschedule2) {
		new WebDriverWait(BrowserFactory.driver, Duration.ofSeconds(120)).until(ExpectedConditions.elementToBeClickable(airingschedule2));

	}

	public synchronized void waitForPageLoad() {
		new WebDriverWait(BrowserFactory.driver, Duration.ofSeconds(120)).until(new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver driver) {
				try {
					Thread.sleep(15000);
				} catch (InterruptedException e) {
					// e.printStackTrace();
				}
				return String.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState"))
						.equals("complete");
			}
		});
	}

	/*
	 * Scroll to the Bottom of the Page
	 */
	public synchronized void scrollToPageBottom() {

		((JavascriptExecutor) BrowserFactory.driver)
				.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	public static synchronized void waitForPageLoaded() {
		ExpectedCondition<Boolean> expectationLoad = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
						.equals("complete");
			}
		};
		try {
			Thread.sleep(2000);
//			WebDriverWait waitForLoad = new WebDriverWait(BrowserFactory.driver, 33);
			WebDriverWait waitForLoad = new WebDriverWait(BrowserFactory.driver, Duration.ofSeconds(40));
			waitForLoad.until(expectationLoad);
		} catch (Throwable error) {
			Assert.fail("Timeout waiting for Page Load Request to complete.");
		}
	}

	public static synchronized void waitForAjaxFinished() {
		ExpectedCondition<Boolean> expectationAjax = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((Boolean) ((JavascriptExecutor) driver).executeScript("return jQuery.active == 0"));
			}
		};
		try {
			Thread.sleep(2000);
//			WebDriverWait waitForAjax = new WebDriverWait(BrowserFactory.driver, 33);
			WebDriverWait waitForAjax = new WebDriverWait(BrowserFactory.driver, Duration.ofSeconds(40));
			waitForAjax.until(expectationAjax);
		} catch (Throwable error) {
			Assert.fail("Timeout waiting for Ajax Finished to complete.");
		}
	}

	protected boolean waitForJSandJQueryToLoad() {

//		WebDriverWait wait = new WebDriverWait(BrowserFactory.driver, 70);
		WebDriverWait wait = new WebDriverWait(BrowserFactory.driver_rw, Duration.ofSeconds(60));

		// wait for jQuery to load
		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					Thread.sleep(3000);

					return ((Long) ((JavascriptExecutor) driver).executeScript("return document.readyState") == 0);
				} catch (Exception e) {

					return true;
				}
			}
		};

		// wait for Javascript to load
		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {

				}
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
						.equals("complete");
			}
		};

		return wait.until(jQueryLoad) && wait.until(jsLoad);
	}

	public static synchronized void copyPaste(WebElement element, String stringtoPaste) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {

		}
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Clipboard clipboard = toolkit.getSystemClipboard();
		StringSelection strSel = new StringSelection(stringtoPaste);
		clipboard.setContents(strSel, null);
		element.sendKeys(Keys.chord(Keys.CONTROL, "v"));
	}

	public static synchronized boolean isDisplayed(WebElement element) {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e1) {
		}
		boolean status = false;

		int attempts = 0;
		while (attempts < 2) {
			try {
				status = element.isDisplayed();
				break;
			} catch (StaleElementReferenceException e) {
			}
			attempts++;
		}
		return status;
	}

	public boolean isDisplayed(List<WebElement> element) {
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e1) {
		}
		boolean status = false;

		int attempts = 0;
		while (attempts < 2) {
			try {
				status = element.size() > 0;
				break;
			} catch (StaleElementReferenceException e) {
			}
			attempts++;
		}
		return status;
	}

	/*
	 * Waits for the element to be invisible
	 */
	public synchronized void waitToInvisible(String xpathName) {
		logger.info("Waiting for the element to be invisible");
		new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpathName)));
		logger.info("Element is invisible");
	}

	public synchronized void mouseHover(WebElement parentElement, WebElement childElement) {
		logger.info("Trying to mouse hover on element "+parentElement.toString() +" using Actions class");

		Actions act = new Actions(driver_rw);
		WebDriverWait wait = new WebDriverWait(driver_rw, Duration.ofSeconds(30));
		WebElement parent = wait.until(ExpectedConditions.visibilityOf(parentElement));
		try {
		act.moveToElement(parent).moveToElement(childElement).click().build().perform();
		}
		catch (NoSuchElementException e) {
		logger.error(parentElement.toString() + " NoSuchElementException ");

	} catch (StaleElementReferenceException e) {
		logger.error(parentElement.toString() + " StaleElementReferenceException ");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("parentElement")));
		act.moveToElement(parent).moveToElement(childElement).click().build().perform();

	}
		logger.info("Mouse hovered and clicked on element");
System.out.println("Done");

	}

	public synchronized void clickXpath(WebElement element) {
		WebElement ele = element;
//		Actions action = new Actions(BrowserFactory.driver);
		Actions action = new Actions(BrowserFactory.driver);
		action.moveToElement(ele).click().perform();
	}

	public static WebElement getElement(WebElement Webelement) {
		final long startTime = System.currentTimeMillis();
//		Wait<WebDriver> wait = new FluentWait<WebDriver>(BrowserFactory.driver).withTimeout(Duration.ofSeconds(30))
//				.pollingEvery(Duration.ofSeconds(5)).ignoring(StaleElementReferenceException.class);
		Wait<WebDriver> wait = new FluentWait<WebDriver>(BrowserFactory.driver).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(StaleElementReferenceException.class);
		int tries = 0;
		boolean found = false;
		WebElement we = null;
		while ((System.currentTimeMillis() - startTime) < 91000) {
			logger.info("Searching for element. Try number " + (tries++));
			try {
				// we = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
				we = wait.until(ExpectedConditions.visibilityOf(Webelement));

				found = true;
				break;
			} catch (StaleElementReferenceException e) {
				logger.info("Stale element: \n" + e.getMessage() + "\n");
			} catch (TimeoutException e) {
				logger.info("Stale element: \n" + e.getMessage() + "\n");
			}
		}
		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		if (found) {
			logger.info("Found element after waiting for " + totalTime + " milliseconds.");
		} else {
			logger.info("Failed to find element after " + totalTime + " milliseconds.");
		}
		return we;
	}

	public static List<WebElement> getElements(List<WebElement> Webelements) {
		final long startTime = System.currentTimeMillis();
//		Wait<WebDriver> wait = new FluentWait<WebDriver>(BrowserFactory.driver).withTimeout(Duration.ofSeconds(30))
//				.pollingEvery(Duration.ofSeconds(5)).ignoring(StaleElementReferenceException.class);
		Wait<WebDriver> wait = new FluentWait<WebDriver>(BrowserFactory.driver).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(StaleElementReferenceException.class);
		int tries = 0;
		boolean found = false;
		List<WebElement> we = null;
		while ((System.currentTimeMillis() - startTime) < 91000) {
			logger.info("Searching for element. Try number " + (tries++));
			try {
				we = wait.until(ExpectedConditions.visibilityOfAllElements(Webelements));
				found = true;
				break;
			} catch (StaleElementReferenceException e) {
				logger.info("Stale element: \n" + e.getMessage() + "\n");
			}
		}
		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		if (found) {
			logger.info("Found element after waiting for " + totalTime + " milliseconds.");
		} else {
			logger.info("Failed to find element after " + totalTime + " milliseconds.");
		}
		return we;
	}

	public static synchronized void rightClickJavaScript(WebElement webElement) {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		String javaScript = "var evt = document.createEvent('MouseEvents');" + "var RIGHT_CLICK_BUTTON_CODE = 2;"
				+ "evt.initMouseEvent('contextmenu', true, true, window, 1, 0, 0, 0, 0, false, false, false, false, RIGHT_CLICK_BUTTON_CODE, null);"
				+ "arguments[0].dispatchEvent(evt)";

		js.executeScript(javaScript, webElement);
	}

	public synchronized void staleElementClick(WebElement element) {
		for (int i = 0; i <= 2; i++) {
			try {
				click(element);
				break;
			} catch (Exception e) {
				// logger.info(e.getMessage());
				try {
					Thread.sleep(2000);
					i++;
				} catch (InterruptedException e1) {

				}
			}
		}
	}

	public synchronized void waitUntilStaleElement(WebElement element) {
		for (int i = 0; i <= 2; i++) {
			try {
				new WebDriverWait(driver_rw, Duration.ofSeconds(120)).until(ExpectedConditions.visibilityOf(element));
				break;
			} catch (Exception e) {
				// logger.info(e.getMessage());
				try {
					Thread.sleep(2000);
					i++;
				} catch (InterruptedException e1) {

				}
			}
		}
	}

	public static synchronized void javascriptDoubleClick(WebElement element) {
		((JavascriptExecutor) driver_rw).executeScript("var evt = document.createEvent('MouseEvents');"
				+ "evt.initMouseEvent('dblclick',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);"
				+ "arguments[0].dispatchEvent(evt);", element);
	}

	public static boolean waitUntilVisbility(WebElement element) {
		boolean status = false;

		for (int i = 0; i <= 2; i++) {
			try {
//				WebDriverWait wait = new WebDriverWait(BrowserFactory.driver_rw, 5);
				WebDriverWait wait = new WebDriverWait(BrowserFactory.driver_rw, Duration.ofSeconds(5));
				status = wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
				break;

			} catch (Exception e) {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e1) {

				}
				i++;
			}

		}
		return status;
	}

	public synchronized void mouseHoverJScript(WebElement HoverElement) {
		try {
			if (isElementPresent(HoverElement)) {

				String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover', true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
//				((JavascriptExecutor) driver_rw).executeScript(mouseOverScript, HoverElement);
				((JavascriptExecutor) driver_rw).executeScript(mouseOverScript, HoverElement);

			} else {
				logger.info("Element was not visible to hover " + "\n");

			}
		} catch (StaleElementReferenceException e) {
			logger.info("Element with " + HoverElement + "is not attached to the page document" + e.getStackTrace());
		} catch (NoSuchElementException e) {
			logger.info("Element " + HoverElement + " was not found in DOM" + e.getStackTrace());
		} catch (Exception e) {
			// e.printStackTrace();
			logger.info("Error occurred while hovering" + e.getStackTrace());
		}
	}

	public static synchronized boolean isElementPresent(WebElement element) {
		boolean flag = false;
		try {
			new WebDriverWait(driver_rw, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(element));

			if (element.isDisplayed() || element.isEnabled())
				flag = true;
			logger.info(element.toString() + " element is displayed ");

		} catch (NoSuchElementException e) {
			flag = false;
			logger.error(element.toString() + " NoSuchElementException ");

		} catch (StaleElementReferenceException e) {
			flag = false;
			logger.error(element.toString() + " StaleElementReferenceException ");

		}
		return flag;
	}

	public static synchronized void generateAlert(WebDriver driver_rw, String message) {
		JavascriptExecutor js = ((JavascriptExecutor) driver_rw);
		js.executeScript("alert('" + message + "')");
	}

	public static synchronized void clickElementByJS(WebElement element, WebDriver driver_rw) {
		JavascriptExecutor js = ((JavascriptExecutor) driver_rw);
		js.executeScript("arguments[0].click();", element);

	}

	public static synchronized void refreshBrowserByJS(WebDriver driver_rw) {
		JavascriptExecutor js = ((JavascriptExecutor) driver_rw);
		js.executeScript("history.go(0)");
	}

	public String getTitleByJS(WebDriver driver_rw) {
		waitForJSandJQueryToLoad();
		JavascriptExecutor js = ((JavascriptExecutor) driver_rw);
		String title = js.executeScript("return document.title;").toString();
		return title;
	}
	

	public static String getPageInnerText(WebDriver driver_rw) {
		JavascriptExecutor js = ((JavascriptExecutor) driver_rw);
		String pageText = js.executeScript("return document.documentElement.innerText;").toString();
		return pageText;
	}

	public static synchronized void scrollPageDown(WebDriver driver_rw) {
		JavascriptExecutor js = ((JavascriptExecutor) driver_rw);
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}

	public static synchronized void scrollIntoView(WebElement element, WebDriver driver_rw) {
		JavascriptExecutor js = ((JavascriptExecutor) driver_rw);
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public static String getBrowserInfo(WebDriver driver_rw) {
		JavascriptExecutor js = ((JavascriptExecutor) driver_rw);
		String uAgent = js.executeScript("return navigator.userAgent;").toString();
		return uAgent;
	}

	public static synchronized void sendKeysUsingJSWithID(WebDriver driver_rw, String id, String value) {
		JavascriptExecutor js = ((JavascriptExecutor) driver_rw);
		js.executeScript("document.getElementById('" + id + "').value='" + value + "'");
	}

	public static synchronized void sendKeysUsingJSWithClassName(WebDriver driver_rw, String className, String value) {
		JavascriptExecutor js = ((JavascriptExecutor) driver_rw);
		js.executeScript("document.getElementById('" + className + "').value='" + value + "'");
	}

	public static synchronized void sendKeysUsingJSWithName(WebDriver driver_rw, String name, String value) {
		JavascriptExecutor js = ((JavascriptExecutor) driver_rw);
		js.executeScript("document.getElementById('" + name + "').value='" + value + "'");
	}

	public static synchronized void explicitWait(int waitTime) {
		try {
			Thread.sleep(waitTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public synchronized static void Iselementdisabled(WebElement ele) {
		boolean fname = ele.isEnabled();
		System.out.print("Textbox is disabled : " + fname);
	}

	/**
	 * This method is used to wait for a particular element to appear in the
	 * web-page
	 * 
	 * @param description : Description For the logger
	 * @param element     : WebElement
	 * @throws Exception
	 */
	protected static synchronized void waitForElementToBePresent(String description, WebElement element)
			throws Exception {
		logger.info("Wait for [" + description + "] to become visible");
		try {
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver_rw).withTimeout(Duration.ofSeconds(60))
					.pollingEvery(Duration.ofMillis(250)).ignoring(NoSuchElementException.class);
			wait.until(ExpectedConditions.visibilityOf(element));
			logger.info("[" + description + "] is visible now");
		} catch (Exception e) {
			logger.error("Unable to find [" + description + "]", e);
			throw e;
		}
	}

	/**
	 * This method is used to wait for a particular element to appear in the
	 * web-page
	 * 
	 * @param description : Description For the logger
	 * @param element     : WebElement
	 * @param seconds     : Time in seconds
	 * @throws Exception
	 */
	public static synchronized void waitForElementToBePresent(String description, WebElement element, long seconds)
			throws Exception {
		logger.info("Wait for [" + description + "] to become visible");
		try {
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver_rw).withTimeout(Duration.ofSeconds(seconds))
					.pollingEvery(Duration.ofMillis(250)).ignoring(NoSuchElementException.class);
			wait.until(ExpectedConditions.visibilityOf(element));
			logger.info("[" + description + "] is visible now");
		} catch (Exception e) {
			logger.error("Unable to find [" + description + "]", e);
			throw e;
		}
	}

	/**
	 * This method is used to switch between the windows
	 */
	public static synchronized void switchtoWindow() 
		{
			// It will return the parent window name as a String
			String parent = driver_rw.getWindowHandle();

			Set<String> s = driver_rw.getWindowHandles();
			
			// Now iterate using Iterator
			Iterator<String> I1 = s.iterator();

			while (I1.hasNext()) {

				String child_window = I1.next();
				System.out.println(I1);

				if (!(parent.equals(child_window))) {
					driver_rw.switchTo().window(child_window);
				}
			}
		}
	
			
		/**
		 * This method is used to switch to the parent windows
		 */
		public static synchronized void switchtoWindowParent() 
			{
				// It will return the parent window name as a String
				String parent = driver_rw.getWindowHandle();
				driver_rw.switchTo().window(parent);

			}
		
		public static synchronized void Wait(int milliSeconds) throws InterruptedException {
			Thread.sleep(milliSeconds);
		}
		
	
}