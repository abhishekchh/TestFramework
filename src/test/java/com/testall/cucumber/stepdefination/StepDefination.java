package com.testall.cucumber.stepdefination;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import com.testall.commons.AbstractTestBaseClass;
import com.testall.selenium.objectrepository.wikipedia.Darjeeling;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefination extends AbstractTestBaseClass {

	
	String scenarioName;
	static int scenarioNumber;

	@Before
	public void setupTest(Scenario scenario) {
		scenarioName = scenario.getName();
		scenarioNumber++;
	}

	@Given("I have {word} open")
	public void i_have_browser_open(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("I go to {string}")
	public void i_go_to(String url) {
		driver.get(url);
	}

	@Then("the title of the webpage should be {string}")
	public void the_title_of_the_webpage_should_be_success(String titleExpected) {
		takeSnapShot(scenarioNumber + "_" + scenarioName.substring(0, 25));
		logger.error("title {}", driver.getTitle());
		Assert.assertEquals(driver.getTitle(), titleExpected);
	}


	@Then("the page should contain {string} link text")
	public void the_search_result_should_contain_link(String linkText) {
		Darjeeling darjPage = new Darjeeling(driver);
		WebElement loginLink = darjPage.getLogin();
		Assert.assertTrue(loginLink.isDisplayed());
	}
	
	@Then("when i scroll the page")
	public void when_i_scroll_the_page() throws InterruptedException {
		Thread.sleep(1000);
//	    scroll(0,250);
//	    scrollByPercent(0, 100);
	    scrollByPage(0, 1);
	    Thread.sleep(3000);
	}


	@After
	public void teardown() {
		driver.close();
	}

}
