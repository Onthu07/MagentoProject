package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginPage {
	
	WebDriver driver;

	public loginPage(WebDriver driver) {
		this.driver = driver;

	}

	static By Accountlink_Obj = By.xpath("//span[@class='label'][contains(text(),'Account')]");

	static By Loginlink_Obj = By.xpath("//a[contains(text(),'Log In')]");

	public static void clickAccount_link(WebDriver driver) {

		driver.findElement(Accountlink_Obj).click();
	}

	public static void clickLogin_link(WebDriver driver) {

		driver.findElement(Loginlink_Obj).click();

	}
	
	public void name() {
		
		
		
	}

}
