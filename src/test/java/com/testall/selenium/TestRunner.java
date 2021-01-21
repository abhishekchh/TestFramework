package com.testall.selenium;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.testall.commons.AbstractTestBaseClass;

public class TestRunner extends AbstractTestBaseClass {

	WebDriver driver;

	@BeforeClass
	public void prehook() {
		
//		
//		System.setProperty("webdriver.chrome.driver", "E:\\downloads\\webdrivers\\chromedriver_83.exe");
//		driver = new ChromeDriver();
//		
//		System.setProperty("webdriver.gecko.driver","E:/downloads/webdrivers/geckodriver_0.26.exe");
//		driver = new FirefoxDriver();
		
	}



	@AfterClass
	public void posthook() {
	}
 
}
