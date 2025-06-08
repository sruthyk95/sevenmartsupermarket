package com.sevenmartsupermarket.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
	int counter=0;
	int retrylimit;
	public boolean retry(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE && counter < retrylimit) {
			counter++;
			return true;
		} else {
			return false;
		}
	}

}
