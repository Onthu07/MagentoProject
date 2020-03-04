package pages;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class listeners extends TestListenerAdapter {

	public void onTestStart(ITestResult tr) {
		System.out.println("Test Started");
	}

	public void onTestSuccess(ITestResult tr) {
		System.out.println("Test passed");
	}

	public void onTestFailure(ITestResult tr) {
		System.out.println("Test failed");
	}

	public void onTestSkipped(ITestResult tr) {
		System.out.println("Test Skipped");
	}

}
