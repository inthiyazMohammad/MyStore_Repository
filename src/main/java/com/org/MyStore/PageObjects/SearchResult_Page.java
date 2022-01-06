package com.org.MyStore.PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.org.MyStore.BaseClass.Base;
import com.org.MyStore.Utilities.Log;

public class SearchResult_Page extends Base {

	@FindBy(xpath="//*[@id=\"center_column\"]/ul/li/div/div[1]/div/a[1]/img")
	WebElement productImg;
	
	@FindBy(xpath="//*[@id=\"quantity_wanted\"]")
	WebElement quantity;
	
	@FindBy(xpath="//*[@id=\"group_1\"]")
	WebElement sizeButton;
	
	@FindBy(xpath="//*[@id=\"add_to_cart\"]/button/span")
	WebElement addToCartButton;
	
	@FindBy(xpath="//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span")
	WebElement CheckoutButton;
	
	public SearchResult_Page() {
		PageFactory.initElements(driver, this);
	}
	
	public void Validate_Product_Image() {
	
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 330)", productImg);
	}
	
	public AddToCart_Page ClickOn_productImg() throws InterruptedException {
		
		Thread.sleep(2000);
		action = new Actions(driver);
		
		Log.info(">>>>>> Click on product image");
		action.moveToElement(productImg).click().build().perform();
		
		return new AddToCart_Page();		
	}
}