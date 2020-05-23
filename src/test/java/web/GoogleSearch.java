package web;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import configs.MyConfigReader;
import core.WebTestBase;
import pages.GoogleHome;
import pages.GoogleResults;

public class GoogleSearch extends WebTestBase {

	@Test
	public void test_SearchGoogle() {
		GoogleHome 		googleHome = new GoogleHome(driver);
		GoogleResults 	googleResults = new GoogleResults(driver);
		
		googleHome.suppluSearchText(MyConfigReader.getCfgValue("Web.googlesearch.txt"));
		
		int index = googleResults.getResultIndex(MyConfigReader.getCfgValue("Web.googlesearch.result"));
		Assert.assertEquals((index+""),MyConfigReader.getCfgValue("Web.googlesearch.resultnum"));
	}
}
