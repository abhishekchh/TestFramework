package com.testall.customreport;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Base64;

import com.testall.commons.Utils;
import com.testall.customreport.model.Step;

public class Report {

	String htmlString;
	String reportLocation;

	public Report() {
		htmlString = Utils.readResourceFile("reportFormat.html");
	}

	Report(String reportFileName) {
		this();
		setReportFileName(reportFileName);
	}
	
	public void setReportName(String reporName) {
		htmlString= htmlString.replace("<!-- REPORT_NAME -->", reporName);
	}

	public static void main(String a[]) {
		System.out.println(java.time.LocalTime.now().truncatedTo(ChronoUnit.MILLIS).toString().replace(":", "-"));
//		Report reportbuilder = new Report();
//		Utils u = new Utils();
//		reportbuilder.setReportFileName("areport.html");
//
//		
//		Step step = new Step();
//		Step stepresult = new Step("name", true, new File("E:\\code\\selinium\\testall\\selenium\\target\\report\\abc.png"), "comment");
//		reportbuilder.addStep(stepresult);
//		System.out.println("done");
//		reportbuilder.writeReport();
	}

	public void setReportFileName(String reportFileName) {
		String reportPath = System.getProperty("report.location") + reportFileName;
		File file = new File(reportPath);
		File theDir = new File(file.getParent());
		if (!theDir.exists()) {
			theDir.mkdirs();
		}
		this.reportLocation = reportPath.trim() + ".html";
	}

	
	
	
	public void addStep(Step step) {

		htmlString = htmlString.replace("<!-- INSERT_RESULTS -->", step.toHtmlTableString());

	}

	public void writeReport() {
		try {
			Utils.writeFile(htmlString, reportLocation);
		} catch (Exception e) {
		}

		System.out.println("closing report builder");

	}

}
