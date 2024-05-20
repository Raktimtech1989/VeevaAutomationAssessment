package com.qa.reports;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.qa.driver.DriverManager;
import com.qa.enums.ConfigProperties;
import com.qa.utils.PropertyUtils;

public final class ExtentLogger {
	
	private ExtentLogger() {}
	
	public static void pass(String message , ExtentColor color)
	{
		ExtentManager.getExtentTest().pass( MarkupHelper.createLabel(message, color))  ;
	}
	public static void pass(String message)
	{
		ExtentManager.getExtentTest().pass( message)  ;
	}
	
	public static void pass(List<Map<String,String>> list)
	{
		ExtentManager.getExtentTest().pass(MarkupHelper.createLabel("Expected Data coming from external datasource as following ", ExtentColor.PINK)) ;
		ExtentManager.getExtentTest().pass(MarkupHelper.createUnorderedList(list).getMarkup())  ;
	}
	
	public static void pass(List<Object> list, String message)
	{
		ExtentManager.getExtentTest().pass(MarkupHelper.createLabel(message, ExtentColor.CYAN)) ;
		ExtentManager.getExtentTest().pass(MarkupHelper.createUnorderedList(list).getMarkup())  ;
	}
	
	public static void fail(String message , ExtentColor color)
	{
		ExtentManager.getExtentTest().fail( MarkupHelper.createLabel(message, color))  ;
	}
	
	public static void fail(String message)
	{
		ExtentManager.getExtentTest().fail( message)  ;
	}
	
	
	public static void skip(String message , ExtentColor color)
	{
		ExtentManager.getExtentTest().pass( MarkupHelper.createLabel(message, color))  ; 
	}
	
	public static void skip(String message)
	{
		ExtentManager.getExtentTest().skip( message)  ;
	}
	public static void pass(String message , boolean isScreenshotNeeded) throws Exception
	{
	    if (PropertyUtils.getPropertyValue(ConfigProperties.PASSEDSTEPSCREENSHOT).equalsIgnoreCase("yes") &&
	    		    isScreenshotNeeded   )
	    {
	    	ExtentManager.getExtentTest().pass(message,
	   MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Image()).build()) ;
	    }
	    else
	    {
	    	pass(message);
	    }
	    
	}
	
	public static void fail(String message , boolean isScreenshotNeeded) throws Exception
	{
	    if (PropertyUtils.getPropertyValue(ConfigProperties.FAILEDSTEPSCREENSHOT).equalsIgnoreCase("yes") &&
	    		    isScreenshotNeeded   )
	    {
	    	ExtentManager.getExtentTest().fail(message,
	   MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Image()).build()) ;
	    }
	    else
	    {
	    	fail(message);
	    }
	    
	}
	
	
	public static void skip(String message , boolean isScreenshotNeeded) throws Exception
	{
	    if (PropertyUtils.getPropertyValue(ConfigProperties.SKIPPEDSTEPSCREENSHOT).equalsIgnoreCase("yes") &&
	    		    isScreenshotNeeded   )
	    {
	    	ExtentManager.getExtentTest().skip(message,
	   MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Image()).build()) ;
	    }  
	    else
	    {
	    	skip(message);
	    }
	}
	
	public static String getBase64Image()
	{
	    return ((TakesScreenshot)DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64) ;
	}
	
}
