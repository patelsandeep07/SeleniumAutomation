package com.ui.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.constant.Env;
import com.utility.JSONUtility;
import com.utility.PropertiesUtil;

public class MyRetryAnalyzer implements IRetryAnalyzer {
	// from property file
	// private static final int MAX_NUMBER_OF_ATTMEPTS = Integer
	// .parseInt(PropertiesUtil.readProperty(Env.QA, "MAX_NUMBER_OF_ATTMEPTS"));

	// from json file
	private static final int MAX_NUMBER_OF_ATTMEPTS = JSONUtility.readJSON(Env.QA).getMAX_NUMBER_OF_ATTMEPTS();

	private static int currentAttmept = 1;

	@Override
	public boolean retry(ITestResult result) {

		if (currentAttmept <= MAX_NUMBER_OF_ATTMEPTS) {
			currentAttmept++;
			return true;
		}

		return false;
	}

}
