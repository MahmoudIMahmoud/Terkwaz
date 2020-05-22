package api;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import configs.MyConfigReader;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class TestGetRandomCat {
	private String animalType;
	private String amount;
	private String urlPath;
	
	@BeforeMethod
	public void setup() {
		animalType = MyConfigReader.getCfgValue("API.param.animal_type");
		baseURI    = MyConfigReader.getCfgValue("API.baseUrl");		
		amount     = MyConfigReader.getCfgValue("API.param.amount");
		urlPath    = MyConfigReader.getCfgValue("API.uri");
	}
	
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
		given().queryParam("animal_type", animalType).queryParam("amount", amount).
		header("Content-Type","application/json").accept("application/json").
		get (urlPath) .
		then ().
		statusCode (200).
		body (matchesRegex(".+")).log().body();
	}
}