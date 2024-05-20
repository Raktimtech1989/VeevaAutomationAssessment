package com.qa.listeners;


import java.util.Arrays;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.qa.annotations.CustomAnnotation;
import com.qa.reports.ExtentLogger;
import com.qa.reports.ExtentManager;
import com.qa.reports.ExtentReport;
import com.qa.utils.ELKUtils;

/**
 * Implements {@link org.testng.ITestListener} and {@link org.testng.ISuiteListener} to leverage the abstract methods
 * Mostly used to help in extent report generation
 * 
 * 
 * 16-May-2024
 * @author Raktim Sarkar
 * @version 1.0
 * @since 1.0
 */

public class Listeners implements ITestListener , ISuiteListener{
	
	
	
	/**
	 * Initialise the reports with the file name
	 * @see com.rtech.reports.ExtentReport
	 */
	@Override
	public void onStart(ISuite suite) {
		try {
			ExtentReport.initReports();
		} catch (Exception e) {

			e.printStackTrace();
		}
		
	}

	
	/**
	 * Terminate the reports
	 * @see com.rtech.reports.ExtentReport
	 */
	@Override
	public void onFinish(ISuite suite) {

		try {
			ExtentReport.flushReports();
		} catch (Exception e) {

			e.printStackTrace();
		}
		
	}

	
	/**
	 * Starts a test node for each testng test
	 * @see com.rtech.reports.ExtentReport
	 * @see com.rtech.annotations.FrameworkAnnotation
	 */
	@Override
	public void onTestStart(ITestResult result) {

		ExtentReport.createTest(result.getMethod().getMethodName());
    ExtentReport.addAuthors(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(CustomAnnotation.class) 
		         .author()) ;
	    
	ExtentReport.addCategory(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(CustomAnnotation.class) 
		         .category());
		
		
	    
	    }

	
	/**
	 * Marks the test as pass and logs it in the report
	 * @see com.rtech.reports.ExtentLogger
	 */
	@Override
	public void onTestSuccess(ITestResult result) {

		   
		ExtentLogger.pass(result.getMethod().getMethodName()  + "   is passed" ,ExtentColor.GREEN);
		  // ELKUtils.sendDetailsToElk(result.getMethod().getMethodName(), "pass");
		   
		
	}

	

	/**
	 * Marks the test as fail,append base64 screenshot and logs it in the report
	 * @see com.rtech.reports.ExtentLogger
	 * @see com.rtech.utils.ScreenshotUtils
	 */
	@Override
	public void onTestFailure(ITestResult result) {

		   ExtentLogger.fail(result.getThrowable().toString()) ;
		   ExtentLogger.fail(Arrays.toString(result.getThrowable().getStackTrace()));
		 //  ELKUtils.sendDetailsToElk(result.getMethod().getMethodName(), "fail");
		   //attach screenshot
		   try {
			ExtentLogger.fail(result.getMethod().getMethodName()  + "   is failed", true);
		} catch (Exception e) {

			e.printStackTrace();
		}
		
	}

	
	/**
	 * Marks the test as skip and logs it in the report
	 * @see com.rtech.reports.ExtentLogger
	 */
	@Override
	public void onTestSkipped(ITestResult result) {

		  ExtentLogger.skip(result.getMethod().getMethodName()  + "   is skipped"  , ExtentColor.GREY);
		 // ELKUtils.sendDetailsToElk(result.getMethod().getMethodName(), "skip");
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

		/*
		 *  For now, we are not using this 
		 */
	}

	@Override
	public void onStart(ITestContext context) {

		/*
		 *   We are having just only one Test in our suite . So we don't have any special implementation as of now .
		 */
		
	}

	@Override
	public void onFinish(ITestContext context) {

		/*
		 *  
		 */
		
	}

	


}