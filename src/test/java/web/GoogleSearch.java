package web;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import core.TestBase;
import pages.GoogleHome;
import pages.GoogleResults;

public class GoogleSearch extends TestBase {

	@Test
	public void test_1() {
		GoogleHome 		googleHome = new GoogleHome(driver);
		GoogleResults 	googleResults = new GoogleResults(driver);
		
		googleHome.suppluSearchText("selenium webdriver");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		List<WebElement> results = driver.findElements(By.cssSelector("div.r h3"));// ("div.r h3.LC20lb.DKV0Md"));
		for (WebElement element : results)
			System.out.println(element.getText());
		
		int index = googleResults.getResultIndex("What is Selenium WebDriver?");
		assertEquals(3, index);
	}
}
