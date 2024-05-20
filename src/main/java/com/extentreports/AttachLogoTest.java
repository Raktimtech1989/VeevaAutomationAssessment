package com.extentreports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class AttachLogoTest {

	@Test
	public void attachLogoTest() throws IOException
	{
		ExtentReports extent = new ExtentReports() ;
		ExtentSparkReporter spark = new ExtentSparkReporter("index.html") ;
		ExtentSparkReporter failedSpark = new ExtentSparkReporter("failed-tests-index.html")
				.filter().statusFilter().as(new Status[]
						{
								Status.FAIL
						}).apply() ;
		failedSpark.config().setDocumentTitle("Automation Report for Failed Tests");
		spark.config().setReportName("Veeva Test Automation Dashboard");


		spark.loadXMLConfig(new File("extentconfig.xml"));	
		extent.attachReporter(spark , failedSpark);

		ExtentTest test1 = extent.createTest("First Test") ;
		test1.pass("test started") ;
		test1.pass("test finised") ;

		extent.flush(); 
		Desktop.getDesktop().browse(new File("index.html").toURI());
	}

}
