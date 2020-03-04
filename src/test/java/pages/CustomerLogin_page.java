package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CustomerLogin_page {

	WebDriver driver;

	public CustomerLogin_page(WebDriver driver) {
		this.driver = driver;

	}

	// Objects to login to the Customer login page

	By emailAddress = By.xpath("//input[@id='email']");
	By password = By.xpath("//input[@id='pass']");
	By LoginButton = By.xpath("//button[@id='send2']");

	public void enterMailAddress(WebDriver driver) {

		driver.findElement(emailAddress).sendKeys("onthusitsei.tumeleng@gmail.com");

	}

	public void enterPassword(WebDriver driver) {

		driver.findElement(password).sendKeys("Onthu@007");

	}

	public void clickLogin(WebDriver driver) {

		driver.findElement(LoginButton).click();
	}

}
