package com.org.MyStore.BaseClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.org.MyStore.Utilities.Log;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	public static WebDriver driver;
	public static Properties prop;
	public static Actions action;
		
	public void ConfigurationProperties() throws IOException {
		
		DOMConfigurator.configure("log4j.xml");
		
		Log.info(">>>>>> Loading properties file");
		prop = new Properties();
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+
				                               "\\src\\main\\java\\com\\org\\MyStore\\Configuration\\Config.properties");
		prop.load(file);
	}
	
	@SuppressWarnings("deprecation")
	public void launchBrowser() {
		
		Log.info(">>>>>> Loading browser");
		String browser = prop.getProperty("browser");
		
		if(browser.equalsIgnoreCase("chrome")) {
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		}else if(browser.equalsIgnoreCase("firefox")) {
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		Log.info(">>>>>> Loading Application");
		driver.get(prop.getProperty("url"));
	}

	public String getScreenshot(String testMethodName) throws IOException {
		
		TakesScreenshot takeScreenshot = (TakesScreenshot) driver;
		File sourceFile = takeScreenshot.getScreenshotAs(OutputType.FILE);

		String destFile = System.getProperty("user.dir")+"\\Screenshots\\"+testMethodName+".png";
		
		FileUtils.copyFile(sourceFile, new File(destFile));
		
		return destFile;
	}
}
