package com.testall.commons;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.time.temporal.ChronoUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.assertthat.selenium_shutterbug.core.Capture;
import com.assertthat.selenium_shutterbug.core.Shutterbug;

public class AbstractTestBaseClass extends BaseClass {

	

	public WebDriver driver;

	public AbstractTestBaseClass() {
		Utils util = new Utils();
		logger.info("logger");
	}

	public File takeSnapShot(String fileName) {
		
		fileName = fileName+java.time.LocalTime.now().truncatedTo(ChronoUnit.MILLIS).toString().replace(":", "-");
		
		try {
			String screenshotLocation = System.getProperty("screenshot.location");
			String filename = screenshotLocation + fileName + ".png";
			logger.info("Taking Screenshot");
			TakesScreenshot scrShot = ((TakesScreenshot) driver);
			File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
			File DestFile = new File(filename);
			FileUtils.copyFile(SrcFile, DestFile);
			return DestFile;
		} catch (Exception e) {
			logger.error("Failed to take Screen shot {}", fileName);
			return null;
		}
		
	}

	public byte[] getFullPageScreenShot() throws IOException {
	    BufferedImage image = Shutterbug.shootPage(driver, Capture.FULL_SCROLL).getImage();
	    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	    ImageIO.write(image, "png", outputStream);
	    return outputStream.toByteArray();
	}
	
	public void scroll(int x, int y) {
		String script = "window.scrollBy({},{})";
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript(updateStringReference(script, x, y));
	}

	public void scrollByPercent(int x, int y) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		float contentHeight = ((Number) jse.executeScript("return window.innerHeight")).intValue();
		float contentWidth = ((Number) jse.executeScript("return window.innerWidth")).intValue();
		logger.info("contentHeight" + contentHeight);
		logger.info("contentWidth" + contentWidth);

		float scrollHeight = contentHeight * ((float)y / 100);
		float scrollWidth = contentWidth * ((float)x / 100);

		String script = "window.scrollBy({},{})";
		jse = (JavascriptExecutor) driver;
		jse.executeScript(updateStringReference(script,scrollWidth ,scrollHeight ));

	}
	
	/**
	 * This will scroll the visible page based on the parameters passed.
	 * 
	 * @param x is the total page width to be scrolled horizontally
	 * @param y is the total page height to be scrolled vertically
	 */
	public void scrollByPage(int x, int y) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		float contentHeight = ((Number) jse.executeScript("return window.innerHeight")).intValue();
		float contentWidth = ((Number) jse.executeScript("return window.innerWidth")).intValue();

		float scrollHeight = contentHeight * y;
		float scrollWidth = contentWidth * x;

		String script = "window.scrollBy({},{})";
		jse = (JavascriptExecutor) driver;
		jse.executeScript(updateStringReference(script,scrollWidth ,scrollHeight ));

	}

	private String updateStringReference(String str, int... ref) {
		for (int i : ref) {
			str = str.replaceFirst("\\{\\}", String.valueOf(i));
		}
		logger.info("updated String is "+str);
		return str;
	}
	private String updateStringReference(String str, float... ref) {
		for (float i : ref) {
			str = str.replaceFirst("\\{\\}", String.valueOf(i));
		}
		logger.info("updated String is "+str);
		return str;
	}
}
