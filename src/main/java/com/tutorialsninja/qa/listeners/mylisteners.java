package com.tutorialsninja.qa.listeners;

import java.awt.Desktop;
import java.io.File;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.tutorialsninja.qa.utils.extentreport;

public class mylisteners implements ITestListener {
	ExtentReports extentreports;
	ExtentTest extentTest;
	@Override
	public void onTestStart(ITestResult result) {
		
		
		
		String testname=result.getName();
	    extentTest=extentreports.createTest(testname);
		extentTest.log(Status.INFO, testname+" started executing");
		
		
		
		
	
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String testname= result.getName();
		extentTest.log(Status.PASS, testname+" got successfully executed");
		
		
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
        String testname= result.getName();
        extentTest.log(Status.INFO,result.getThrowable());

        extentTest.log(Status.FAIL, testname+" got failed");
		
		
		
		
		
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String testname= result.getName();
		extentTest.log(Status.INFO,result.getThrowable());
		extentTest.log(Status.SKIP, testname+" got skipped");
		
		
		
	}

	@Override
	public void onStart(ITestContext context) {
		
		extentreports=extentreport.generateextentreport();
		
		
		
		
	}

	@Override
	public void onFinish(ITestContext context) {
		 extentreports.flush();
		 String pathofextentreport=System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentReport.html";
		 File extentReport=new File(pathofextentreport);
		 try {
		 Desktop.getDesktop().browse(extentReport.toURI());
		 }catch(Throwable e) {
			 e.printStackTrace();
		 }
		 
		
	}
	

}
