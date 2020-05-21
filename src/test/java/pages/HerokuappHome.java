package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import core.PageBase;


public class HerokuappHome extends PageBase{

	
	
	public HerokuappHome(WebDriver driver) {
		super(driver);
	}
	
	public void navigateToPage(String linktxt) {
		driver.findElement(By.partialLinkText(linktxt)).click();
	}

}
