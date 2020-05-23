package web;

import org.testng.annotations.Test;

import configs.MyConfigReader;
import core.WebTestBase;
import pages.DynamicLoading;
import pages.FileUpload;
import pages.HerokuappHome;

public class HerokuappTests extends WebTestBase {

	@Test
	public void test_FileUpload() {
		HerokuappHome herokuappHome = new HerokuappHome(driver);
		FileUpload fileUpload = new FileUpload(driver);
		herokuappHome.navigateToPage("File Upload");
		fileUpload.chooseFile(MyConfigReader.getCfgValue("Web.herokuapp.uploadimage"));
		fileUpload.assertUpload();
	}

	@Test
	public void test_DynamicLoading() {
		HerokuappHome herokuappHome   = new HerokuappHome(driver);
		DynamicLoading dynamicLoading = new DynamicLoading(driver);
		herokuappHome.navigateToPage("Dynamic Loading");
		herokuappHome.navigateToPage("Example 2");
		dynamicLoading.clickStart();
		dynamicLoading.waitForLoadingToFinish();
		dynamicLoading.assertForMsgToAppear(MyConfigReader.getCfgValue("Web.herokuapp.welcomemsg"));
		
	}
}
