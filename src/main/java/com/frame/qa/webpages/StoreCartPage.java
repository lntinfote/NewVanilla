package com.frame.qa.webpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.frame.qa.wrappers.BaseMethod;

public class StoreCartPage extends BaseMethod{

	@FindBy(xpath = "//h1[text()='Shopping Cart']")
	 WebElement cartLabel;
	
	@FindBy(xpath = "//button[@title='Proceed to Checkout']")
	 WebElement proceedToCheckout;
	
	@FindBy(xpath = "//span[text()='Register']")
	 WebElement buttonRegister;
	
	@FindBy(id = "login-emails")
	 WebElement userNameTextfield;
	
	@FindBy(id = "login-password")
	 WebElement passwordTextfield;
	    
	@FindBy(xpath   = "//span[text()='Login']")
	 WebElement buttonLogin;
	
	
	
	public StoreCartPage() {
		PageFactory.initElements(driver_rw, this );
	}
	
	
	public synchronized void CheckOut() {
		click(proceedToCheckout);
		isDisplayed(buttonRegister);
		isDisplayed(passwordTextfield);
//		isDisplayed(userNameTextfield);
//		isDisplayed(buttonLogin);
	}
	
	
}
