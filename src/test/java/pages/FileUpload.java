package pages;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import core.PageBase;


public class FileUpload extends PageBase{

	private By btnChooseFile   = By.id("file-upload");
	private By btnUpload       = By.id("file-submit");
	private By lblUploaded     = By.cssSelector(".example h3");//By.xpath("//*[@id='content']//h3");
	private By lblFileUploaded = By.id("uploaded-files");
	
	public FileUpload(WebDriver driver) {
		super(driver);
	}
	
	public void chooseFile(String filePath) {
		File f = new File(filePath);
		String absolutePath = f.getAbsolutePath();
		driver.findElement(btnChooseFile).sendKeys(absolutePath);
		WebDriverWait wait = new WebDriverWait(driver, 60);
//		f.getName();
//		wait.until(ExpectedConditions.textToBePresentInElementValue(btnChooseFile, absolutePath));
//		wait.until(ExpectedConditions.textMatches(b, pattern));
		wait.until(ExpectedConditions.attributeContains(btnChooseFile, "value", f.getName()));
	}
	
	public void assertUpload() {
		driver.findElement(btnUpload).click();
		WebDriverWait wait = new WebDriverWait(driver, 60);
//		wait.until(ExpectedConditions.textToBePresentInElementValue(lblUploaded, "File Uploaded!"));
		wait.until(ExpectedConditions.textToBe(lblUploaded, "File Uploaded!"));
	}

}
