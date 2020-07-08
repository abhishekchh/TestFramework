package com.testall.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.testall.commons.AbstractTestBaseClass;

public class TestRunner extends AbstractTestBaseClass {

	WebDriver driver;

	@BeforeClass
	public void prehook() {
		System.setProperty("webdriver.chrome.driver", "E:\\downloads\\webdrivers\\chromedriver_83.exe");
		driver = new ChromeDriver();
		
		System.setProperty("webdriver.gecko.driver","E:/downloads/webdrivers/geckodriver_0.26.exe");
		driver = new FirefoxDriver();
		
	}

//	@Test
	public void run() throws InterruptedException {
		driver.get("https://www.google.com");
		String title = driver.getTitle();
		logger.error("title {}", driver.getTitle());
		Assert.assertEquals(title, "Google");
//		Thread.wait(4000);
	}

	@AfterClass
	public void posthook() {
//		driver.close();
	}
 
}
