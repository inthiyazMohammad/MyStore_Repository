package com.org.MyStore.Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {

	public static ExtentSparkReporter htmlReporter;
	public static ExtentReports extentReport;
	
	public static ExtentReports getExtentReports() {
		
		htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"\\ExtentReports\\extentreport.html");
		htmlReporter.config().setReportName("My Store Automation Extent Reports");
		htmlReporter.config().setDocumentTitle("My Store Extent Reports");
		
		extentReport = new ExtentReports();
		extentReport.attachReporter(htmlReporter);
		extentReport.setSystemInfo("Project Name", "My Store (e-Cart)");
		extentReport.setSystemInfo("Operating System", "Windows 10");
		extentReport.setSystemInfo("Browser Name", "Chrome & Firefox");
		extentReport.setSystemInfo("Tested By", "Inthiyaz Mohammad");
		
		return extentReport;
	}
}
