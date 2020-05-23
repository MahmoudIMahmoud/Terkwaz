package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import core.PageBase;

public class GoogleResults extends PageBase {

	private By links = By.cssSelector("div.r h3");

	public GoogleResults(WebDriver driver) {
		super(driver);
	}

	public List<WebElement> getSearchResults() {
		return driver.findElements(links);
	}

	public int getResultIndex(String txt) {
		List<WebElement> results = driver.findElements(links);
		int i = 0;
		for (WebElement element : results) {
			i++;
			if(element.getText().contains(txt)) return i;
		}

			return -1;
	}
}
