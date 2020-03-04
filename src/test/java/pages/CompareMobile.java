package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CompareMobile {

	WebDriver driver;

	public CompareMobile(WebDriver driver) {
		this.driver = driver;

	}

	// Title of the Iphone object
	static By title_Iphone = By.xpath(" //h2[@class='product-name']//a[contains(text(),'IPhone')]");
	
	// Title of the Iphone object
	static By title_sonyXperia = By.xpath(" //h2[@class='product-name']//a[contains(text(),'IPhone')]");
	
	// Iphone Add to Compare Link object
	static By Add_to_CompareIphone = By.xpath(".//*[@id='top']/body/div[1]/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[3]/div/div[3]/ul/li[2]/a");
	
	// Sony Xperia Add to compare Link object
	static By Add_to_CompareSonyXperia = By.xpath("//li[3]//div[1]//div[3]//ul[1]//li[2]//a[1]");

	//compare product button Object
	static By clickComparebtn = By.xpath("//button[@title='Compare']");
	
	//	Heading object of the Pop up window 
	static By popUpWindowHeading = By.xpath("//body/div/div/h1");
	
	
	
	public static void compareMobile(WebDriver driver) throws InterruptedException {
        
		//wait 2 second before clicking on the Add to compare link 
		Thread.sleep(3000);
		
		//click the Add to compare button of the phone 
		driver.findElement(Add_to_CompareIphone).click();
		
		//store the title of the Iphone for comparison for verification later when popup page comes up
		String Iphonetext = driver.findElement(title_Iphone).getText();
		
		//write a message on the console that you are Adding a phone to the Compare Cart 
		System.out.println("You added " + Iphonetext + "to Compare");
		
		//click the Add to compare button of the phone 
		driver.findElement(Add_to_CompareSonyXperia).click();
		
		//store the title of the SonyXperia  for comparison for verification later when popup page comes up
		String SonyXperiatext = driver.findElement(title_sonyXperia).getText();
		
		//write a message on the console that you are Adding a phone to the Compare Cart 
		System.out.println("You added " + SonyXperiatext+ "to Compare");
		
		Thread.sleep(2000);
		//click the compareButton
		driver.findElement(clickComparebtn).click(); 
		Thread.sleep(2000);
		
		//switch to new window 
		for (String handle:driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}
		
		//Check for the title of the page at the to COMPARE PRODUCTS
		String actualPageHeading   = ("COMPARE PRODUCTS");
		String expectedPageHeading= driver.findElement(popUpWindowHeading).getText();
		System.out.println("The Heading of the pop up Window is:" + expectedPageHeading);
		try {
			 Assert.assertEquals(actualPageHeading, expectedPageHeading);
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
       

	}

}
