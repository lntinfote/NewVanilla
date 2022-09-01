package com.frame.qa.sampleTestcases;

import org.apache.poi.ss.usermodel.Sheet;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.frame.qa.base.TestBase;
import com.frame.qa.utils.Excel;
import com.frame.qa.utils.TestUtil;
import com.frame.qa.webpages.BooksAndMusicPage;
import com.frame.qa.webpages.StoreCartPage;
import com.frame.qa.webpages.StoreHomePage;

public class StoreLandingPageTest extends TestBase  {
	
	StoreHomePage storeHomePage;
	BooksAndMusicPage bookMusicPage;
	StoreCartPage cartPage;
	
	public StoreLandingPageTest() {
		super();
	}
	
	@BeforeMethod
	public synchronized void setUp() {
		storeHomePage =new StoreHomePage();
		bookMusicPage = new BooksAndMusicPage();
		cartPage = new StoreCartPage();
	}
	
	@Test(priority = 1)
    public synchronized void b_selectWomenCatagory() {
		
		// Author and catagory 
//		test.assignAuthor("Sachin").assignCategory("Smoke");
		storeHomePage.clickOnWomenCatagory();
//		test.info("Successfullly clicked on womens catagory");
	}
	
	@Test(priority = 2)
    public synchronized  void b_SearchProduct() {
//		test.assignAuthor("Sachin").assignCategory("Regression");
		storeHomePage.searchProduct();
//		test.info("Successfullly product is searched ");
	}

	@Test(priority = 3)
    public synchronized void b_selectLanguange() throws InterruptedException {
//		test.assignAuthor("Sachin").assignCategory("Smoke");
		storeHomePage.selectLanguage();
//		test.info("Successfullly language is selected");

	}
	
	@Test(priority = 4)
    public synchronized void b_launchCatagoryInNewTab() {
//		test.assignAuthor("Sachin").assignCategory("Regression");
		storeHomePage.launchAccesoriesInSeparateTab();
//		test.info("calagory launched in a new tab ");

	}
	
	
	
	@Test(priority = 5)
    public synchronized void b_productCheckout() throws InterruptedException {
//		test.assignAuthor("Sachin").assignCategory("Regression");
		storeHomePage.selectSubCatUsingMouseHover();
		bookMusicPage.selectAndAddToCartProduct();
		cartPage.CheckOut();
//		test.info("product added to cart and cheked out ");

		
	}
	

	
	  @Test(priority = 6) public synchronized void b_SelectEachCatagory() { //
	  test.assignAuthor("Sachin").assignCategory("Regression"); String testCaseName
	  = TestUtil.getTestCaseFolderPath("Smoke")+"\\SelectEachCatagory.xlsx"; Sheet
	  catSheetObj = Excel.getDataSheet(testCaseName, "Cat"); String firstCat =
	  (String) Excel.getColumnValue(catSheetObj, "Catagories", 1);
	  storeHomePage.verifyAllCatagories(catSheetObj); //
	  test.info("verified each catagory from the test data sheet");
	  
	  }
	  
	  @Test(priority = 7) public synchronized void b_TestAngularApp() throws
	  InterruptedException {
	  
	  storeHomePage.AngularApp(); }
	  
	 
	  @Test(priority = 8)
	    public synchronized void c_selectWomenCatagory() {
			
			// Author and catagory 
//			test.assignAuthor("Sachin").assignCategory("Smoke");
			storeHomePage.clickOnWomenCatagory();
//			test.info("Successfullly clicked on womens catagory");
		}
		
		@Test(priority = 9)
	    public synchronized  void c_SearchProduct() {
//			test.assignAuthor("Sachin").assignCategory("Regression");
			storeHomePage.searchProduct();
//			test.info("Successfullly product is searched ");
		}

		@Test(priority = 10)
	    public synchronized void c_selectLanguange() throws InterruptedException {
//			test.assignAuthor("Sachin").assignCategory("Smoke");
			storeHomePage.selectLanguage();
//			test.info("Successfullly language is selected");

		}
		
		@Test(priority = 11)
	    public synchronized void c_launchCatagoryInNewTab() {
//			test.assignAuthor("Sachin").assignCategory("Regression");
			storeHomePage.launchAccesoriesInSeparateTab();
//			test.info("calagory launched in a new tab ");

		}
		
		
		
		@Test(priority = 12)
	    public synchronized void c_productCheckout() throws InterruptedException {
//			test.assignAuthor("Sachin").assignCategory("Regression");
			storeHomePage.selectSubCatUsingMouseHover();
			bookMusicPage.selectAndAddToCartProduct();
			cartPage.CheckOut();
//			test.info("product added to cart and cheked out ");

			
		}
		

		
		  @Test(priority = 13) public synchronized void c_SelectEachCatagory() { //
		  test.assignAuthor("Sachin").assignCategory("Regression"); String testCaseName
		  = TestUtil.getTestCaseFolderPath("Smoke")+"\\SelectEachCatagory.xlsx"; Sheet
		  catSheetObj = Excel.getDataSheet(testCaseName, "Cat"); String firstCat =
		  (String) Excel.getColumnValue(catSheetObj, "Catagories", 1);
		  storeHomePage.verifyAllCatagories(catSheetObj); //
		  test.info("verified each catagory from the test data sheet");
		  
		  }
		  
		  @Test(priority = 14) public synchronized void c_TestAngularApp() throws
		  InterruptedException {
		  
		  storeHomePage.AngularApp(); 
		  }
		 
		
	
}
