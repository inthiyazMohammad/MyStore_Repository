package com.org.MyStore.Listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.org.MyStore.BaseClass.Base;
import com.org.MyStore.Utilities.ExtentReporter;

public class Listeners extends Base implements ITestListener {

	ExtentReports extentReport = ExtentReporter.getExtentReports();
	ExtentTest extentTest;
	
	public void onTestStart(ITestResult result) {
		
		String testName = result.getName();
		
		extentTest = extentReport.createTest(testName+" execution started");
	}

	public void onTestSuccess(ITestResult result) {
		
		extentTest.log(Status.PASS, " got passed");
	}

	public void onTestFailure(ITestResult result) {
		
		String testName = result.getName();
		
		extentTest.fail(result.getThrowable());
		
		try {
			String screenshotFilePath = getScreenshot(testName);
			
			extentTest.addScreenCaptureFromPath(screenshotFilePath, testName);
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		
	}

	public void onFinish(ITestContext context) {
		extentReport.flush();
	}

}
