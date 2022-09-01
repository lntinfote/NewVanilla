package com.frame.qa.webpages;

import org.apache.poi.poifs.property.Parent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.frame.qa.base.BrowserFactory;
import com.frame.qa.base.TestBase;
import com.frame.qa.wrappers.BaseMethod;

public class HomePage extends BaseMethod {

	// Page Factory

	@FindBy(xpath = "//a[text()='Mobiles']")
	WebElement mobileCatagory;
	
	@FindBy(xpath = "//a[contains(@id,'cart')]")
	WebElement cart;
	
	@FindBy(xpath = "//a[text()='Women']")
	WebElement women;
	
	@FindBy(xpath = "//span[contains(@class,'nav-cart-icon nav-sprite')]")
	public WebElement cartIcon;

	@FindBy(xpath = "//div[contains(@class, 'your-amazon-cart-is-empty')]//h2")
	public WebElement cartEmptyMessage;

	@FindBy(xpath = "//span[contains(@id,'accountList') and text()='Hello, Sign in']")
	public WebElement accountList;

	@FindBy(xpath = "//div[contains(@id,'signin')]//span[text()='Sign in']")
	public WebElement signInButton;

	@FindBy(xpath = "//input[@name='email']")
	public WebElement emailTextBox;

	@FindBy(xpath = "//div[contains(@id,'your-account')]//span[text()='Your Recommendations']")
	public WebElement recommendationLink;

	@FindBy(xpath = "//div[contains(@class,'card-title')]//h2")
	public WebElement recommendationPageTitle;

	@FindBy(xpath = "//a[text()='VIP']")
	WebElement vip;
	
	@FindBy(xpath = "//h1[text()='VIP']")
	WebElement viplabel;
	
	
		
	// Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this );
		System.out.println("driver in homepage is "+ driver);
	}
	
	public String verifyHomePageTitle(){
//		return driver.getTitle();
		return getTitleByJS(driver);
	}
	
	public void clickOnMobilecatagory(){
//		mobileCatagory.click();
		click(mobileCatagory);
		}
	
	public String getCartURL(){
//		return cart.getAttribute("href");
		
		return getAttribute(cart, "href");
	}
	
	public String getCartURL_women(){
//		return women.getAttribute("href");
		return getAttribute(women, "href");

	}
	
	public void clickOnVIP(){
//		vip.click();
		click(vip);
	}
	
	public boolean IsVIPLabelDisplayed() {
//		return viplabel.isDisplayed();
		return isDisplayed(viplabel);
	}
	
	public void clickOnCartIcon(){
//		cartIcon.click();
		click(cartIcon);
		}
		
	
}
