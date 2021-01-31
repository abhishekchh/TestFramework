package com.testall.cucumber.testrunners;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "classpath:feature", glue = "com.testall.cucumber.stepdefination", plugin = {
		"pretty", "json:target/cucumber-reports/Cucumber.json", "html:target/cucumber-report" })
public class HelloWorldTest extends AbstractTestNGCucumberTests {

	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}

//	@AfterClass
//	public void posthook() {
//		System.out.println("Starting after class");
////		generateReport("target/cucumber-reports");
//		System.out.println("Ending after class");
//	}
// 
//	
//	public static void generateReport(String karateOutputPath) {        
//        Collection<File> jsonFiles = FileUtils.listFiles(new File(karateOutputPath), new String[] {"json"}, true);
//        List<String> jsonPaths = new ArrayList(jsonFiles.size());
////        jsonPaths.remove(1);
//        jsonFiles.forEach(file -> jsonPaths.add(file.getAbsolutePath()));
//        Configuration config = new Configuration(new File("target"), "demo");
//        ReportBuilder reportBuilder = new ReportBuilder(jsonPaths, config);
//        reportBuilder.generateReports();        
//    }

}
