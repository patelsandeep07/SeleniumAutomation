package com.ui.tests;

import com.constant.Browser;
import com.ui.pages.HomePage;

public class LoginTestOld {

	public static void main(String[] args) {

		HomePage homePage = new HomePage(Browser.CHROME, true);

		String userName = homePage.goToLoginPage().doLoginWith("fenihop667@joystill.com", "Test1234").getUserName();
		System.out.println(userName);

	}

}
