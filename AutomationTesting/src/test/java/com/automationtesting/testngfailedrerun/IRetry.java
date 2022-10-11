package com.automationtesting.testngfailedrerun;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class IRetry implements IRetryAnalyzer {

	  public static int retrycount=0;
	  
	  public static int maxretrycount= 3;
	
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		
		if(retrycount<maxretrycount) {
			retrycount++;
			return true;  //pass
		}
		return false;
	}

}
