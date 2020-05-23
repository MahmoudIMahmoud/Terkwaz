package core;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseTest {
	
	protected ExtentReports extent;
	protected ExtentTest 	logger;
	protected void setupExtentReport(Method m) {
		ExtentHtmlReporter reporter = new ExtentHtmlReporter("./Results.html");
		reporter.setAppendExisting(true);
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		logger = extent.createTest(m.getName());
		logger=extent.createTest(m.getName());
	}
	

}
