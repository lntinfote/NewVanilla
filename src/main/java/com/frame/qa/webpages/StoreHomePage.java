package com.frame.qa.webpages;

import java.time.Duration;
import java.util.List;

import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.frame.qa.utils.Excel;
import com.frame.qa.wrappers.BaseMethod;
import com.paulhammant.ngwebdriver.ByAngular;

public class StoreHomePage extends BaseMethod {

	
	@FindBy(xpath = "//a[text()='Women']")
	WebElement womenCatagory;
	
	@FindBy(xpath = "//h1[text()='Women']")
	WebElement womenLabel;
	
	@FindBy(xpath = "//a[text()='Home & Decor']")
	WebElement homedecorCatagory;
	
	@FindBy(xpath = "//a[text()='Books & Music']")
	WebElement booksMusicSubCatagory;
	
	
	@FindBy(className = "welcome-msg")
	WebElement WelcomeMgs;
	
	@FindBy(xpath = "//a[text()='Accessories']")
	WebElement accessoriesCatagory;
	
	@FindBy(id = "select-language")
	WebElement selectLanguage;
	
	@FindBy(xpath = "//label[text()='Show']")
	WebElement showLabel;
	
	@FindBy(xpath = "//nav[@id='nav']//a[contains(@class,'level0')]")
	List <WebElement>  catagories;
	
	@FindBy(id = "search")
	WebElement searchField;
	
	@FindBy(xpath = "//button[@title='Search']")
	WebElement searchButton;
	
	@FindBy(xpath = "//h1[contains(text(),'shirts')]")
	WebElement shirtsLabel;
	
	
	public StoreHomePage() {
		PageFactory.initElements(driver_rw, this );
	}
	
	public void clickOnWomenCatagory() {
		click(womenCatagory);
		isDisplayed(womenLabel);
		}
	
	public synchronized void selectLanguage() throws InterruptedException {
		Wait(2000);
		selectByVisibleText(selectLanguage, "German");
		isDisplayed(WelcomeMgs);
		
		
		
		
		
	}
	
	public void launchAccesoriesInSeparateTab()  {
		String URL = getAttribute(accessoriesCatagory, "href");
		newTab().get(URL);
	}
	
	public synchronized  BooksAndMusicPage selectSubCatUsingMouseHover()   {
		mouseHover(homedecorCatagory, booksMusicSubCatagory);
		
//		waitForPageLoaded();

		//		scrollDown();
		
//		isElementPresent(showLabel);
		return new BooksAndMusicPage();
		
	}
	
	public synchronized void verifyAllCatagories(Sheet sheetObj) {
		
		int rows = sheetObj.getLastRowNum();
		for (int rowIndex = 1; rowIndex <= rows; rowIndex++) {
			String catValue = (String) Excel.getColumnValue(sheetObj, "Catagories", rowIndex);
//			Assert.assertEquals(true, catValue.equalsIgnoreCase(catagories.get(rowIndex-1).getText()));
	}
		
		
	}
	
	public synchronized void searchProduct() {
		sendKeys(searchField, "shirts");
		click(searchButton);
		isDisplayed(shirtsLabel);
		}
	
	
	public void AngularApp() throws InterruptedException {
		driver_rw.get("http://juliemr.github.io/protractor-demo/");
//		ngDriver.waitForAngularRequestsToFinish();
//		ngDriver.waitForAngular2RequestsToFinish();
		Thread.sleep(10000);

		driver_rw.findElement(ByAngular.model("first")).sendKeys("2");
		

		Thread.sleep(2000);

		driver_rw.findElement(ByAngular.model("second")).sendKeys("2");
		Thread.sleep(2000);

		driver_rw.findElement(ByAngular.buttonText ("Go!")).click();
		Thread.sleep(2000);
		
	}
	
	
}
