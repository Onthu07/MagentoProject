package pages;



import static org.testng.Assert.assertEquals;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.*;

public class Mobile_page{

	static WebDriver driver;
	static String XperiaPrice;
	static String detailedPrice;

	public Mobile_page(WebDriver driver) {

	  Mobile_page.driver = driver;

	}

	static By mobilelink_Obj = By.xpath("//a[contains(text(),'Mobile')]");
	static By Sort_ByName = By.cssSelector("select[title=\"Sort By\"]");
	static By Sony_Xperia = By.xpath("//img[@id='product-collection-image-1']");
	static By Sony_Xperia_price =By.xpath("//span[contains(text(),'$100.00')]");
	static By  detailPrice = By.xpath("//span[@class='price']");
	static By AddtoCartBtn = By.xpath("//button[@class='button btn-cart']");
	static By gotoCart = By.xpath("//span[contains(@class,'label')][contains(text(),'Cart')]");
	static By ViewCart = By.xpath("//a[@innertext='View Shopping Cart']");
	
	// Click on ‘MOBILE’ menu
	public static void clickMobilelink(WebDriver driver) throws InterruptedException {

       Thread.sleep(2000);
		driver.findElement(mobilelink_Obj).click();

	}
	// In the list of all mobile , select ‘SORT BY’ dropdown as ‘name’
  	public  static void selectByName (WebDriver driver) {
		
  		new Select(driver.findElement(Sort_ByName)).selectByVisibleText("Name");
		
		
	}
  	//In the list of all mobile , read the cost of Sony Xperia mobile (which is $100) 
  	public static  void readSonyPrice(WebDriver driver) {
  		
       XperiaPrice = driver.findElement(Sony_Xperia_price).getText();
       System.out.println("The Price of the Sony Xperia is:"+XperiaPrice);
		
	}
  	
  	//Click on Sony Xperia mobile 	
  	public static  void clickSonyXperia(WebDriver driver) throws InterruptedException {
  		
  		Thread.sleep(2000);
  		driver.findElement(Sony_Xperia).click();
		
	}
  	
  	public static void detailPageprice(WebDriver drive) throws InterruptedException {
		Thread.sleep(2000);
		detailedPrice = drive.findElement(detailPrice).getText();
		System.out.println("The price from the detailed Price is:"+ detailedPrice);
		
	    //  Product price in list and details page should be equal ($100)
		try {
			
			assertEquals(XperiaPrice ,detailedPrice);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Thread.sleep(2000);
	}
  	
  	 public static void  navtoCart(WebDriver driver) throws InterruptedException {
     	
     	Thread.sleep(2000);
     	driver.findElement(gotoCart).click();
 		
 	}
  	public static void viewCart(WebDriver driver) throws InterruptedException {
  		Thread.sleep(2000);
  		driver.findElement(ViewCart).click();
  		
  	}
  	
	public static void clickAddtoCart(WebDriver driver) throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(AddtoCartBtn).click();
		
	}
  	/*
  	public static void takeScreen_Short() {
  		
  		scc = (scc+1);
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String png = ("E:\\Selenium_Projects\\MagentoProject\\src\\test\\java\\pages");
	//	FileUtils.copyFile(scrFile, new File(png));
  	}
  	*/
	
	
	
}