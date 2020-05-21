package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import core.PageBase;


public class DynamicLoading extends PageBase{

	private By btnStart	  = By.cssSelector("div#start button");
	private By imgLoading = By.xpath("//*[@id='loading']");
	private By lblWelcome = By.cssSelector("div#finish h4");
	
	public DynamicLoading(WebDriver driver) {
		super(driver);
	}
	
	public void clickStart() {
		driver.findElement(btnStart).click();
	}

	public void waitForLoadingToFinish() {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.attributeToBe(imgLoading, "style","display: none;"));
	}
	
	public void assertForMsgToAppear(String msg) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.textToBe(lblWelcome, msg));
	}
}
