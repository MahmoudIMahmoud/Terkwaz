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
		return driver.findElements(By.cssSelector("div.r h3"));// ("div.r h3.LC20lb.DKV0Md"));
	}

	public int getResultIndex(String txt) {
		List<WebElement> results = driver.findElements(By.cssSelector("div.r h3"));// ("div.r h3.LC20lb.DKV0Md"));
		int i = 0;
		for (WebElement element : results) {
			// System.out.println(element.getText());
			i++;
			if(element.getText().contains(txt)) return i;
		}

			return -1;
	}
}
