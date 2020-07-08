package com.testall.commons;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class AbstractTestBaseClass {

	public Logger logger = LogManager.getLogger(this.getClass());

	public WebDriver driver;

	public AbstractTestBaseClass() {
		Utils util = new Utils();
	}

	public void takeSnapShot(String fileName) {
		try {
			String screenshotLocation = System.getProperty("screenshot.location");
			logger.info("Taking Screenshot");
			TakesScreenshot scrShot = ((TakesScreenshot) driver);
			File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
			File DestFile = new File(screenshotLocation + fileName + ".png");
			FileUtils.copyFile(SrcFile, DestFile);
		} catch (Exception e) {
			logger.error("Failed to take Screen shot {}", fileName);
		}
	}

	public void scroll(int x, int y) {
		String script = "window.scrollBy({},{})";
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript(updateStringReference(script, x, y));
	}

//	public void scrollByPercent(int x, int y) {
//		JavascriptExecutor jse = (JavascriptExecutor) driver;
//		float contentHeight = ((Number) jse.executeScript("return window.innerHeight")).intValue();
//		float contentWidth = ((Number) jse.executeScript("return window.innerWidth")).intValue();
//		System.out.println("contentHeight" + contentHeight);
//		System.out.println("contentWidth" + contentWidth);
//
//		float scrollHeight = contentHeight * ((float)y / 100);
//		float scrollWidth = contentWidth * ((float)x / 100);
//
//		String script = "window.scrollBy({},{})";
//		jse = (JavascriptExecutor) driver;
//		jse.executeScript(updateStringReference(script,scrollWidth ,scrollHeight ));
//
//	}
	
	
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
		System.out.println("updated String is "+str);
		return str;
	}
	private String updateStringReference(String str, float... ref) {
		for (float i : ref) {
			str = str.replaceFirst("\\{\\}", String.valueOf(i));
		}
		System.out.println("updated String is "+str);
		return str;
	}
}
