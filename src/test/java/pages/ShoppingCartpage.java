package pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;

public class ShoppingCartpage {

	WebDriver driver;

	public ShoppingCartpage(WebDriver driver) {
		this.driver = driver;
	}

	static By QtyTxtbox = By.xpath(".//*[@id='shopping-cart-table']/tbody/tr/td[4]/input");
	static By UpdateButton = By.xpath(".//*[@id='shopping-cart-table']/tbody/tr/td[4]/button");
	// static By errorMessge = By.xpath(".//*[@id='shopping-cart-table']/tbody/tr/td[2]/p");
	static By emptyCartlink = By.xpath("//span[contains(text(),'Empty Cart')]");
	static By emptyCartmsg = By.xpath("//div[@class='cart-empty']//p[contains(text(),'You have no items in your shopping cart.')]");

	// Change ‘QTY’ value to 1000 and click ‘UPDATE’ button
	public static void changeQuantity(WebDriver driver) throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(QtyTxtbox).clear();
		driver.findElement(QtyTxtbox).sendKeys("1000");
		driver.findElement(UpdateButton).click();
		// String reqQty=driver.findElement(errorMessge).getText();
		// String msgQty = ("* The requested quantity for \"Sony Xperia\" is not
		// available.");
		/*
		 * try { assertEquals(reqQty, msgQty); } catch (Exception e) {
		 * e.printStackTrace(); }
		 */

		// Click on ‘EMPTY CART’ link in the footer of list of all mobiles. A message
		// "SHOPPING CART IS EMPTY" is shown.
		Thread.sleep(2000);
		driver.findElement(emptyCartlink).click();

		// Verify cart is empty
		String noItemsStg = ("You have no items in your shopping cart.");
		String noItemsmsg = driver.findElement(emptyCartmsg).getText();
		System.out.println(noItemsmsg);
		try {
			assertEquals(noItemsStg, noItemsmsg);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
