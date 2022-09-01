package com.frame.qa.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.frame.qa.base.TestBase;

public class CartPage extends TestBase {
	
	@FindBy(xpath = "//h2[contains(text(),'Your Amazon Basket is empty')]")
	WebElement amazonBasketEmptyLabel;
	
	
	@FindBy(xpath = "//h1[text()='Women']")
	WebElement womenLabel;
	
	// Initializing the Page Objects:
	public CartPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean isAmazonBasketisEmpty() {
		return amazonBasketEmptyLabel.isDisplayed();
	}
	
	public boolean isWomenLabelDisplayed() {
		return womenLabel.isDisplayed();
	}

}
