package utils;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenCapture {

	public static void getScreenShot(WebDriver driver, String fileToSave) {
		try {
			// capture screen shoot with a .png format.
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			// FileUtils.copyFile(scrFile, new File(fileToSave));
			FileHandler.copy(scrFile, new File(fileToSave));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}