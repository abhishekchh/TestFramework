package com.testall.selenium.objectrepository.wikipedia;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Darjeeling {
	
	private WebDriver driver;
	
	private String login_linkText = "Log in";
	
	public Darjeeling(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getLogin() {
		return driver.findElement(By.linkText(login_linkText));
	}
	

}
