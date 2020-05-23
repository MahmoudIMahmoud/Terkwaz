package api;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import configs.MyConfigReader;
import core.APITestBase;
import io.restassured.response.Response;



public class TestGetRandomCat extends APITestBase{
	
		

	
	@Test
	public void test_GetRandomeCatFact() {
		String animalType = MyConfigReader.getCfgValue("API.param.animal_type");
		String amount     = MyConfigReader.getCfgValue("API.param.amount");
		
		Response response=given().queryParam("animal_type", animalType).queryParam("amount", amount).
		header("Content-Type","application/json").accept("application/json").
		get (urlPath);
		responseBody = response.body().asString();
		Assert.assertTrue(response.body().asString().matches(".+"));
	}
	
}