package pages;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Homepage {
	
	WebDriver driver;
	
	public Homepage(WebDriver driver){
		
		this.driver=driver;
	}
	
public static void verifyHomepage(WebDriver driver) {
		
		String title = driver.getTitle();
		System.out.println("The title of the page is:" + title);
		Assert.assertTrue(title.contains("Home page"));
		
	}
	
	
	
	
}
