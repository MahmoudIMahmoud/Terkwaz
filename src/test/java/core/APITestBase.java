package core;

import static io.restassured.RestAssured.baseURI;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import configs.MyConfigReader;

public class APITestBase extends BaseTest{

	protected String 		urlPath;
	protected String 		responseBody;

	@BeforeMethod
	public void setup(Method m) {
		baseURI = MyConfigReader.getCfgValue("API.baseUrl");
		urlPath = MyConfigReader.getCfgValue("API.uri");

		setupExtentReport(m);
	}



	@AfterMethod
	public void teardown(ITestResult result, Method m) throws IOException {
		String resultTxt = result.getStatus() == 1 ? "Passed" : "Failed";
		String testName = m.getName();
		System.out.println("The test " + testName + " is fishing with status " + resultTxt);

		if (result.getStatus() == ITestResult.FAILURE) {
			logger.fail("Test:" + testName + " <b> <font style='color:red'>failed</b></font> with message:<br>"
					+ result.getThrowable().getMessage());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			logger.pass("Test:" + testName
					+ " <b> <font class=\"test-status right pass\"'>passed</b></font> with response:<br>"
					+ responseBody);
		}
		extent.flush();
	}

}
