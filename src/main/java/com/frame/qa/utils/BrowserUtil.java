package com.frame.qa.utils;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;

import com.frame.qa.base.TestBase;

public class BrowserUtil extends TestBase  {
	Actions action;
	
//	public  BrowserUtil (WebDriver driver) {
//		action = new Actions(driver);
//	}
	public  BrowserUtil () {
		action = new Actions(driver);
	}
	
	public void moveToElement(WebElement ele) {
		action.moveToElement(ele).build().perform();
	}
	
	public void clickOnElement(WebElement ele) {
		action.click(ele).build().perform();
	}

	public void clickOnElement() {
		action.click().build().perform();
	}
	
	public void clickAndHoldOnElement(WebElement ele) {
		action.clickAndHold(ele).build().perform();
	}

	public void doubleClickOnElement(WebElement ele) {
		action.doubleClick(ele).build().perform();
	}
	
	public void rightClickOnElement(WebElement ele) {
		action.contextClick(ele).build().perform();
	}

	public void scrollDownElementsAfterRightClick() {
		action.sendKeys(Keys.chord(Keys.SHIFT, Keys.ARROW_DOWN)).build().perform();
	}
	
	public void switchToCurrentOpenWindow() {
		String window = driver.getWindowHandle();
		driver.switchTo().window(window);
	}
	
	public String getTextPresentOnElement(WebElement ele) {
		return ele.getText();
	}
	
	public boolean isElementDisplayed(WebElement ele) {
		return ele.isDisplayed();
    }
}
