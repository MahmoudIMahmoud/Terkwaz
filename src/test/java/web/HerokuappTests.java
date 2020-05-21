package web;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import core.TestBase;
import pages.DynamicLoading;
import pages.FileUpload;
import pages.GoogleHome;
import pages.GoogleResults;
import pages.HerokuappHome;

public class HerokuappTests extends TestBase {

	// @Test
	public void test_1() {
		HerokuappHome herokuappHome = new HerokuappHome(driver);
		FileUpload fileUpload = new FileUpload(driver);
		herokuappHome.navigateToPage("File Upload");
		fileUpload.chooseFile("./resources/quality.png");
		fileUpload.assertUpload();
	}

	@Test
	public void test_2() {
		HerokuappHome herokuappHome   = new HerokuappHome(driver);
		DynamicLoading dynamicLoading = new DynamicLoading(driver);
		herokuappHome.navigateToPage("Dynamic Loading");
		herokuappHome.navigateToPage("Example 2");
		dynamicLoading.clickStart();
		dynamicLoading.waitForLoadingToFinish();
		dynamicLoading.assertForMsgToAppear("Hello World!");
		
	}
}
