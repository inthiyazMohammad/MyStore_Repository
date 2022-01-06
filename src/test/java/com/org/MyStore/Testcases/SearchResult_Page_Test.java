package com.org.MyStore.Testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.org.MyStore.BaseClass.Base;
import com.org.MyStore.PageObjects.Index_Page;
import com.org.MyStore.PageObjects.SearchResult_Page;
import com.org.MyStore.Utilities.Log;

@Listeners(com.org.MyStore.Listeners.Listeners.class)
public class SearchResult_Page_Test extends Base {

	Index_Page index_page;
	SearchResult_Page searchresult_page;
	
	@BeforeClass
	public void SetUp() throws IOException {
		
		ConfigurationProperties();
		launchBrowser();
		Log.startTestCase("SearchResult Page");
		Log.info(" ");
	}
	
	@AfterClass
	public void TearDown() throws InterruptedException {
		
		Log.info(" ");
		Log.endTestCase("SearchResult Page");
		Thread.sleep(3000);
		driver.quit();
	}
	
	@Test(priority=1)
	public void Verify_Index_Page() {
		
		index_page = new Index_Page();
		
		String actTitle = index_page.Validate_Title();
		String expTitle = "My Store";
		Assert.assertEquals(actTitle, expTitle);
		
		index_page.Valiadate_indexLogo();
		Assert.assertTrue(true);
		
		index_page.Validate_searchBox();
		index_page.ClickOn_searchButton();
	}
	
	@Test(priority=2)
	public void Verify_SearchResult_Page() throws InterruptedException {
		
		searchresult_page = new SearchResult_Page();
		
		searchresult_page.Validate_Product_Image();
		searchresult_page.ClickOn_productImg();
	}
}