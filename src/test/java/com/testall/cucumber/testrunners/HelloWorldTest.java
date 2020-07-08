package com.testall.cucumber.testrunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "classpath:feature/helloworld.feature", glue = "com.testall.cucumber.stepdefination", plugin = {
		"pretty", "html:target/cucumber-reports" })
public class HelloWorldTest extends AbstractTestNGCucumberTests {

}
