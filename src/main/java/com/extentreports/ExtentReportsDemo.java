package com.extentreports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportsDemo {
	
	@Test
	public void test1() throws IOException
	{
		ExtentReports extent = new ExtentReports() ;
		ExtentSparkReporter spark = new ExtentSparkReporter("index.html")  ;
		extent.attachReporter(spark);		
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("Automation Report");
		spark.config().setReportName("Test Automation Framework");
		//setUp code
		
		//create test
		ExtentTest test = extent.createTest("First Test") ;
		test.pass("Checking the logs") ;
		test.pass(MarkupHelper.createLabel("First Test Completed successfully", ExtentColor.GREEN)) ;
		
		ExtentTest test1 = extent.createTest("Second Test") ;
		test1.pass("Checking the logs in second test") ;
		test1.pass(MarkupHelper.createLabel("Second Test Completed successfully", ExtentColor.RED)) ;
		
		//teardown
		extent.flush(); 
		Desktop.getDesktop().browse(new File("index.html").toURI());  //open the file in desktop default browser
		
	}

}
