package com.qa.reports;

import java.awt.Desktop;
import java.io.File;
import java.util.Objects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.qa.constants.FrameworkConstants;
import com.qa.enums.CategoryType;

public final class ExtentReport {
	
	/**
	 * Perform initialisation and termination of {@link com.aventstack.extentreports.ExtentReports}
     * After creating an instance for {@link com.aventstack.extentreports.ExtentTest}, it is delegated to ThreadLocal 
     * variable for providing thread safety.
	 *  
	 * 
	 * 16-May-2024
	 * @author Raktim Sarkar
	 * @version 1.0
	 * @since 1.0
	 */
	
	
	/**
	 * Private constructor to avoid external instantiation
	 */
	
	private ExtentReport()  {} 
	
	private static ExtentReports extent ;
	
	
	/**
	 * Set the initial configuration for the Extent Reports and decides the report generation path.
	 * 
	 * 16-May-2024
	 * @author Raktim Sarkar
	 * @version 1.0
	 * @since 1.0
	 * @throws Exception
	 */
	public static void initReports() throws Exception
	{
		   if (Objects.isNull(extent))
		   {
			   extent = new ExtentReports() ;
				ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.getExtentReportFilePath())  ;
				
				//For logging only failed tests 
				ExtentSparkReporter failedSpark = new ExtentSparkReporter("failed-tests-index.html")
						                                  .filter().statusFilter().as(new Status[]
						                                		  {
						                                				  Status.FAIL
						                                		  }).apply() ;
				failedSpark.config().setDocumentTitle("Automation Report for Failed Tests");
				spark.config().setTheme(Theme.DARK);
				spark.config().setDocumentTitle("Raktim QA Automation Report");
				spark.config().setReportName("VEEVA TEST AUTOMATION DASHBOARD");
				//spark.loadXMLConfig(new File("extentconfig.xml"));	
				extent.attachReporter(spark , failedSpark);		
							
		   }		
		}
	
	
	/**
	 * Flushing the reports ensures extent logs are reflected properly. 
	 * Opens the report in the default desktop browser.
	 * Sets the ThreadLocal variable to default value
	 *  
	 * 16-May-2024
	 * @author Raktim Sarkar
	 * @version 1.0
	 * @since 1.0
	 * @throws Exception
	 */
	public static void flushReports() throws Exception
	{
		  if (Objects.nonNull(extent))
		  {
			  extent.flush(); 
		  }	
       Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentReportFilePath()).toURI());  //open the file in desktop default browser				   
	}
	
	
	/**
	 * Creates a test node in the extent report. Delegates to {@link ExtentManager} for providing thread safety
	 * 
	 * 16-May-2024
	 * @author Raktim Sarkar
	 * @version 1.0
	 * @since 1.0
	 * @param testCaseName
	 */
	public static void createTest(String testName)
	{
		ExtentTest test = extent.createTest(testName)  ;
		ExtentManager.setExtentTest(test);		
	}
	
	
	/**
	 * Logs the authors details in the authors view in the extent report.
	 * Gives an clear idea of Authors Vs Percentage success metrics
	 * 
	 * 16-May-2024
	 * @author Raktim Sarkar
	 * @version 1.0
	 * @since 1.0
	 * @param authors
	 */
	public static void addAuthors(String[] authors)
	{
		for(String author : authors)
		{
			ExtentManager.getExtentTest().assignAuthor(author) ;
		}
	
	}
	
	
	/**
	 * Adds the category a particular test case belongs to.
	 * Gives an clear idea of Group Vs Percentage success metrics.
	 * 
	 * 16-May-2024
	 * @author Raktim Sarkar
	 * @version 1.0
	 * @since 1.0
	 * @param categories
	 */
	public static void addCategory(CategoryType[] categories)
	{
		for(CategoryType category : categories)
		{
			ExtentManager.getExtentTest().assignCategory(category.toString()) ;
		}
	
	}

}
