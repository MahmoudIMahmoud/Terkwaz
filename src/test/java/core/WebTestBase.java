package core;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class WebTestBase extends BaseTest{
	protected WebDriver driver;


	@BeforeMethod
	@Parameters({ "url", "browser" })
	public void setup(String url, @Optional("chrome") String browser, Method m) {

		if (browser.equalsIgnoreCase("chrome"))
			driver = new ChromeDriver();
		else if (browser.equalsIgnoreCase("firefox"))
			driver = new FirefoxDriver();

		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.navigate().to(url);
		System.out.println("RUNING:" + m.getName());
		
		setupExtentReport(m);
	}

//	private void setupExtentReport(Method m) {
//		//	    ExtentHtmlReporter reporter=new ExtentHtmlReporter("./Reports/Results.html");
//			    ExtentHtmlReporter reporter=new ExtentHtmlReporter("./Results.html");
//			    reporter.setAppendExisting(true);
//				
//			    extent = new ExtentReports();
//			    
//			    extent.attachReporter(reporter);
//			    
//			    logger=extent.createTest(m.getName());
//	}

	@AfterMethod
	public void teardown(ITestResult result, Method m) throws IOException {
		String resultTxt = result.getStatus() == 1 ? "Passed" : "Failed";
		String testName = m.getName();
		System.out.println("The test " + testName + " is fishing with status "
				+ resultTxt);
		
		String imageFile = "./screenshots/"+testName+".png";
		utils.ScreenCapture.getScreenShot(driver, imageFile);
		if(result.getStatus()==ITestResult.FAILURE) {
			logger.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(imageFile).build());
		}else if(result.getStatus()==ITestResult.SUCCESS) {
			logger.pass("Test:"+testName+" passed", MediaEntityBuilder.createScreenCaptureFromPath(imageFile).build());
		}
		
		extent.flush();
		driver.quit();
	}

}