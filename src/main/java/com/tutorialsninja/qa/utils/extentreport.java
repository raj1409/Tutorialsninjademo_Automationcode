package com.tutorialsninja.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class extentreport {
	public static ExtentReports generateextentreport() {
		ExtentReports extentreport=new ExtentReports(); 
		File extentreportfile=new File(System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentreport.html");
		
	ExtentSparkReporter sparkreporter=new ExtentSparkReporter(extentreportfile);
	sparkreporter.config().setTheme(Theme.DARK);
	sparkreporter.config().setReportName("Tutorials ninja test automaation");
	sparkreporter.config().setDocumentTitle("TN Automation Report");
	sparkreporter.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");
	extentreport.attachReporter(sparkreporter);
	
	Properties configprop=new Properties();
	File configpropfile=new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialsninja\\qa\\config\\config.properties");
	try {
	FileInputStream fisconfigprop=new FileInputStream(configpropfile);
	configprop.load(fisconfigprop);
	}catch(Throwable e) {
		e.printStackTrace();
	}
	extentreport.setSystemInfo("Application url", configprop.getProperty("url"));
	extentreport.setSystemInfo("Browsername", configprop.getProperty("Browser"));
	extentreport.setSystemInfo("Email", configprop.getProperty("vaidemail"));
	extentreport.setSystemInfo("Password", configprop.getProperty("validpassword"));
	
	return extentreport;
	}

}
