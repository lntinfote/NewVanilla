package com.frame.qa.webpages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.frame.qa.wrappers.BaseMethod;

public class BooksAndMusicPage  extends BaseMethod {

	@FindBy(xpath = "//h1[text()='Books & Music']")
	WebElement bookAndMusicLabel;
	
	@FindBy(xpath = "//li[@class='item last']//a")
	WebElement firstProduct;
	
	@FindBy(xpath = "//span[text()='In stock']")
	WebElement isProductAvailable;
	
	@FindBy(xpath = "//button[@title='Add to Cart']")
	List <WebElement> addToCart;
	
	@FindBy(xpath = "//ul[@id='downloadable-links-list']//li//input")
	 WebElement productChecked;
	
	
	public BooksAndMusicPage() {
		PageFactory.initElements(driver_rw, this );
	}
	
	public synchronized StoreCartPage selectAndAddToCartProduct() throws InterruptedException {
		Wait(5);
//		isDisplayed(bookAndMusicLabel);
		String productName = getAttribute(firstProduct, "title");
		click(firstProduct);
		if(isDisplayed(isProductAvailable)) {
			click(productChecked);
			clickUsingIndex(addToCart, 1);
		}
		return new StoreCartPage();
		
			}
	
}
