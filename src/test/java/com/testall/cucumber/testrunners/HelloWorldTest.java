package com.testall.cucumber.testrunners;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.testng.annotations.AfterClass;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

@CucumberOptions(features = "classpath:feature/helloworld.feature"
					, glue = "com.testall.cucumber.stepdefination"
					, plugin = {"pretty", "json:target/cucumber-reports/Cucumber.json", "html:target/cucumber-report" })
public class HelloWorldTest extends AbstractTestNGCucumberTests {
	
	@AfterClass
	public void posthook() {
		System.out.println("Starting after class");
//		generateReport("target/cucumber-reports");
		System.out.println("Ending after class");
	}
 
	
	public static void generateReport(String karateOutputPath) {        
        Collection<File> jsonFiles = FileUtils.listFiles(new File(karateOutputPath), new String[] {"json"}, true);
        List<String> jsonPaths = new ArrayList(jsonFiles.size());
//        jsonPaths.remove(1);
        jsonFiles.forEach(file -> jsonPaths.add(file.getAbsolutePath()));
        Configuration config = new Configuration(new File("target"), "demo");
        ReportBuilder reportBuilder = new ReportBuilder(jsonPaths, config);
        reportBuilder.generateReports();        
    }

}
