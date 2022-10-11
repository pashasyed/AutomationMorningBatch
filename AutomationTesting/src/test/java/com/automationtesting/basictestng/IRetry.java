package com.automationtesting.basictestng;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class IRetry implements IRetryAnalyzer {

	private int retrycount = 0;

	private static final int maxretrycount = 3;

	public boolean retry(ITestResult result) {

		if (retrycount < maxretrycount) {
			retrycount++;
			return true;
		}
		return false;
	}

}
