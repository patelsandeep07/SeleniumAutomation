package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constant.Browser;
import static com.constant.Env.*;
import com.utility.BrowserUtility;
import com.utility.JSONUtility;

import static com.utility.PropertiesUtil.*;

public final class HomePage extends BrowserUtility {

	public HomePage(WebDriver driver) {
		super(driver);
		// goToWebsite(readProperty(QA, "URL"));
		goToWebsite(JSONUtility.readJSON(QA).getUrl());
	}

	public HomePage(Browser browserName, boolean isHeadless) {
		super(browserName, isHeadless);
		// goToWebsite(readProperty(QA, "URL"));
		goToWebsite(JSONUtility.readJSON(QA).getUrl());
	}

	private static final By SIGN_IN_LINK_LOCATOR = By.xpath("//a[contains(text(),'Sign in')]");

	public LoginPage goToLoginPage() {
		clickOn(SIGN_IN_LINK_LOCATOR);
		LoginPage loginPage = new LoginPage(getDriver());
		return loginPage;

	}

	public void quit() {
		// TODO Auto-generated method stub

	}

}
