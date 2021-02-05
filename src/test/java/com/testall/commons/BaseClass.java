package com.testall.commons;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.testall.customreport.Report;

public class BaseClass {

	public Logger logger = LogManager.getLogger(this.getClass());

	public Report reportbuilder;


}
