package com.org.MyStore.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.org.MyStore.BaseClass.Base;
import com.org.MyStore.Utilities.Log;

public class Index_Page extends Base {

	@FindBy(xpath="//*[@id=\"header_logo\"]/a/img")
	WebElement indexLogo;
	
	@FindBy(xpath="//*[@id=\"search_query_top\"]")
	WebElement searchBox;
	
	@FindBy(xpath="//*[@id=\"searchbox\"]/button")
	WebElement searchButton;
	
	@FindBy(xpath="//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")
	WebElement signinButton;
	
	public Index_Page() {
		PageFactory.initElements(driver, this);
	}
	
	public String Validate_Title() {
		
		Log.info(">>>>>>Validating Index page title");
		return driver.getTitle();
	}
	
	public boolean Valiadate_indexLogo() {
		
		Log.info(">>>>>>Validating Index page logo");
		return indexLogo.isDisplayed();
	}
	
	public void Validate_searchBox() {
		
		Log.info(">>>>>>Entering product name");
		searchBox.sendKeys(prop.getProperty("product"));
	}
	
	public void ClickOn_searchButton() {
		
		Log.info(">>>>>>Clicking on search button");
		searchButton.click();
	}
	
	public void ClickOn_signinButton() {
		
		Log.info(">>>>>>Clicking on signin button");
		signinButton.click();
	}
}
