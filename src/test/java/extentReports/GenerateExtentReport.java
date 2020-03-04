package extentReports;

import java.io.File;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports; //package coming from the extended report JAR
import com.aventstack.extentreports.ExtentTest; //package coming from the extended report JAR
import com.aventstack.extentreports.Status; /*Report contains 2 sections:1 is the environment/configuration/ 2.TestCase passed/skipped/failed*/
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import pages.CompareMobile;
import pages.CustomerLogin_page;
import pages.Homepage;
import pages.Mobile_page;
import pages.ShoppingCartpage;
import pages.loginPage;

public class GenerateExtentReport {

	WebDriver driver;

	ExtentReports reports; // specify the location of the report(Create an object of ExtentReports called
							// reports)
	ExtentTest testInfo; // what details should be in the report(Create an object of ExtentTest called
							// reports)
	ExtentHtmlReporter htmlReporter;

	@Parameters("myBrowser")

	@BeforeTest

	public void startReport(String myBrowser) {

		if (myBrowser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			System.out.println("Chrome launched Successfully");

		} else if (myBrowser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			System.out.println("Firefox Launched Successfully");

		}

		htmlReporter = new ExtentHtmlReporter(new File(System.getProperty("user.dir") + "AutomationReport.html"));
		htmlReporter.loadXMLConfig(new File(System.getProperty("user.dir") + "/extent-report.xml"));

		reports = new ExtentReports();
		reports.setSystemInfo("Host Name", "DESKTOP-19MCO0V");
		reports.setSystemInfo("Environment", "QA");
		reports.setSystemInfo("UserName", "Onthusitse Itumeleng");
		reports.attachReporter(htmlReporter);

	}

	@Test(priority = 1)

	public void testHomePage() {

		driver.get("http://live.guru99.com/index.php/");
		Homepage.verifyHomepage(driver);
		testInfo.log(Status.INFO, "Test Report  Passed");
	}

	@Test(priority = 2)

	public void testLogin() {

		loginPage.clickAccount_link(driver);
		loginPage.clickLogin_link(driver);
		testInfo.log(Status.INFO, "Test  Report Failed");
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
		// Mobile_page.readSonyPrice(driver);
		// Mobile_page.clickSonyXperia(driver);
		// Mobile_page.detailPageprice(driver);
		// Mobile_page.navtoCart(driver);
		// Mobile_page.viewCart(driver);
		// Mobile_page.clickAddtoCart(driver);

	}

	@Test(enabled = false)

	public void changeSonyXperiaQty() throws InterruptedException {

		ShoppingCartpage.changeQuantity(driver);

	}

	@Test(priority = 5)
	public void CompareProducts() throws InterruptedException {

		CompareMobile.compareMobile(driver);

	}

	@BeforeMethod
	public void Register(Method method) {
		String testName = method.getName();
		testInfo = reports.createTest(testName);

	}

	@AfterMethod
	public void captureStatus(ITestResult result) {

		if (result.getStatus() == ITestResult.SUCCESS) {
			testInfo.log(Status.PASS, "The Test Method name as: " + result.getName() + "PASSED");

		} else if (result.getStatus() == ITestResult.FAILURE) {

			testInfo.log(Status.FAIL, "The Test Method name as: " + result.getName() + "FAILED");
			testInfo.log(Status.FAIL, "Test Failure: " + result.getThrowable());

		} else if (result.getStatus() == ITestResult.SKIP) {
			testInfo.log(Status.SKIP, "The Test Method name as: " + result.getName() + "SKIPPED");

		}

	}

	@AfterTest
	public void CleanUp() {
		reports.flush();
		driver.quit();
	}

}
