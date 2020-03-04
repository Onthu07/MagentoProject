package suite;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.Homepage;
import pages.loginPage;
import pages.CustomerLogin_page;
import pages.Mobile_page;
import pages.ShoppingCartpage;
import pages.CompareMobile;
import pages.listeners;
public class TestMagentoGuru99 {

	WebDriver driver;

   @Parameters("myBrowser")

	@BeforeTest
	public void setup(String myBrowser) {

		if (myBrowser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			System.out.println("Chrome launched Successfully");
		} else if (myBrowser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			System.out.println("Firefox Launched Successfully");

		}

	}

	@Test(priority = 1)
	public void testHomePage() {

		driver.get("http://live.guru99.com/index.php/");
		Homepage.verifyHomepage(driver);
	}

	@Test(priority = 2)
	public void testLogin() {

		loginPage.clickAccount_link(driver);
		loginPage.clickLogin_link(driver);

	}

	@Test(priority = 3)
	public void testCustomer_Login() throws InterruptedException {

		Thread.sleep(2000);

		CustomerLogin_page testLogin = new CustomerLogin_page(driver);

		testLogin.enterMailAddress(driver);
		testLogin.enterPassword(driver);
		testLogin.clickLogin(driver);

	}

	@Test(priority = 4)
	public void gotoMobile_page() throws InterruptedException {

		Mobile_page.clickMobilelink(driver);
		Mobile_page.selectByName(driver);
		//Mobile_page.readSonyPrice(driver);
		//Mobile_page.clickSonyXperia(driver);
		//Mobile_page.detailPageprice(driver);
		// Mobile_page.navtoCart(driver);
		// Mobile_page.viewCart(driver);
		// Mobile_page.clickAddtoCart(driver);

	}

	@Test(enabled=false)

	public void changeSonyXperiaQty() throws InterruptedException {

		ShoppingCartpage.changeQuantity(driver);

	}
	
	@Test(priority=5)
	public void CompareProducts() throws InterruptedException {
		
		CompareMobile.compareMobile(driver);
		
	}
	
	
	

	@AfterTest
	 
	 
	 public void tearDown() throws Exception { 
	 
	 driver.quit(); }
	 
	 
}
