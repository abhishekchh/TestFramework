package com.testall.customreport.model;

import java.io.File;

import com.testall.commons.Utils;

public class Step {

	String stepName="";
	
	boolean isPassed;
	
	String screenShotData="";
	
	String comment="";
	
	public Step(){
		
	}
	
	public Step(String stepName, boolean isPassed, String screenShotPath, String comment){
		this.stepName = stepName;
		this.isPassed = isPassed;
		this.screenShotData =screenShotPath;
		this.comment = comment;
	}
	
	public Step(String stepName, boolean isPassed, File screenShotPath, String comment){
		this.stepName = stepName;
		this.isPassed = isPassed;
		this.screenShotData =Utils.encodeFileToBase64Binary(screenShotPath);
		this.comment = comment;
	}
	
	public String getStepName() {
		return stepName;
	}
	
	public void setStepName(String stepName) {
		this.stepName = stepName;
	}
	
	public boolean isPassed() {
		return isPassed;
	}
	
	public void setResult(boolean result) {
		this.isPassed = isPassed;
	}
	
	public String getScreenShotLocation() {
		return screenShotData;
	}
	
	public void setScreenShotLocation(String screenShotLocation) {
		this.screenShotData = screenShotLocation;
	}
	
	public void setScreenShotLocation(File screenShotPath) {
		this.screenShotData = Utils.encodeFileToBase64Binary(screenShotPath);
	}
	
	public String getComment() {
		return comment;
	}
	
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public String toHtmlTableString() {
		String htmltablerow = "<tr>\r\n"
				+ "				<td width=\"10%\">"+stepName+"</td>\r\n"
				+ "				<td width=\"10%\" class=\""+getRunStatus().toLowerCase()+"\">"+getRunStatus()+"</td>\r\n"
				+ "				<td width=\"70%\"><a href=\""
				+""//Href data goes here
				+"\"><img src=\"data:image/png;base64,"+screenShotData+"\"\r\n"
				+ "						style=\"width: 500px;\"></a></td>\r\n"
				+ "				<td width=\"20%\">"+comment+"</td>\r\n"
				+ "			</tr>"
				+ "<!-- INSERT_RESULTS -->";
		
		
		
		return htmltablerow;
	}
	
	
	
	
	
	
	
	

	private String getRunStatus() {
		
		if(isPassed()) {
			return "Passed";
		}
		return "Failed";
		
	}
	
	
}
