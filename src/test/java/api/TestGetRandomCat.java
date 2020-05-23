package api;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import configs.MyConfigReader;
import core.APITestBase;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertTrue;



public class TestGetRandomCat extends APITestBase{
	
		
	@Test
	public void test_1() {
		
		given().
		header("Content-Type","application/json").accept("application/json").
		get ("https://cat-fact.herokuapp.com/facts/random?animal_type=cat&amount=1") .
		then ().
		statusCode (200).
		body (matchesRegex(".+")).log().body();
	}
	
	@Test
	public void test_2() {
		String animalType = MyConfigReader.getCfgValue("API.param.animal_type");
		String amount     = MyConfigReader.getCfgValue("API.param.amount");
		
		Response response=given().queryParam("animal_type", animalType).queryParam("amount", amount).
		header("Content-Type","application/json").accept("application/json").
		get (urlPath);
		assertTrue(response.body().asString().matches(".+"));
		System.out.println("******************************************************************\n"+response.body().asString());
		responseBody = response.body().asString();

	}
	
}