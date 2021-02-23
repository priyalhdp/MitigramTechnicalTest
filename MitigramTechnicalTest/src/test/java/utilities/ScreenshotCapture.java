package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotCapture {

	public ReadConfig config = new ReadConfig();
	public Logger logger;

	public void captureScreenshot(WebDriver driver, String screenName) {
		logger = Logger.getLogger("MitigramTestLogger");
		try {
			TakesScreenshot screenShot = (TakesScreenshot) driver;
			File source = screenShot.getScreenshotAs(OutputType.FILE);
			File target = new File(config.getScreenshotPath() + screenName + ".png");
			FileUtils.copyFile(source, target);
			logger.info(screenName + "- Screenshot captured");
		} catch (IOException e) {
			logger.info("Screenshot cannot Capture");
		}
	}
}
