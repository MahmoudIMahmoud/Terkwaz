package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import core.PageBase;


public class GoogleHome extends PageBase{

	private By txtSearchBox = By.name("q");
	
	public GoogleHome(WebDriver driver) {
		super(driver);
	}
	
	public void suppluSearchText(String searchText) {
		driver.findElement(txtSearchBox).sendKeys(searchText+"\n");
	}

}
