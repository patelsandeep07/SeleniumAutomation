package com.ui.tests;

import static com.constant.Browser.CHROME;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.ui.pages.HomePage;
import com.utility.BrowserUtility;
import com.utility.LambdaTestUtility;

public class TestBase {
	protected static HomePage homePage;

	private boolean isLambdaTest = true;
	private boolean isHeadless = true;

	@BeforeMethod(description = "Load the homepage of the website")
	public void setUp(ITestResult result) {
		WebDriver lambdaDriver;
		if (isLambdaTest) {

			lambdaDriver = LambdaTestUtility.initializeLambdaTestSession("Chrome", result.getMethod().getMethodName());
			homePage = new HomePage(lambdaDriver);
		} else {
			// Running the test in local machine
			homePage = new HomePage(CHROME, isHeadless);
		}
	}

	public BrowserUtility getInstance() {
		return homePage;
	}

	@AfterMethod(description = "Tear down the browser")
	public void tearDown() {
		if (isLambdaTest) {
			LambdaTestUtility.quiteSession();
		} else {
			homePage.quit();
		}
	}

}
