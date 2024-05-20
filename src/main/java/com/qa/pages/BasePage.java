package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;

import com.qa.driver.DriverManager;
import com.qa.enums.WaitStrategy;
import com.qa.factories.ExplicitWaitImplFactory;
import com.qa.reports.ExtentLogger;

public class BasePage {
	//wait strategy reusable methods 


	public BasePage() {
		// TODO document why this constructor is empty
	}
	
	/**
	 * Locates element by given wait strategy, performs the clicking operation on webelement and
	 * writes the pass even to the extent report.
	 * 
	 * 
	 * 16-May-2024
	 * @author Raktim Sarkar
	 * @version 1.0
	 * @since 1.0
	 * @param by
	 * @param waitstrategy Strategy to find webElement. Known  strategies {@link com.rtech.enums.WaitStrategy}
	 * @param elementName
	 * @throws Exception
	 */

	protected void click(By by  , WaitStrategy waitstrategy , String elementName)
	{		
		ExplicitWaitImplFactory.performExplicitWait(waitstrategy, by).click();	
		try {
			ExtentLogger.pass(elementName + " is clicked"  , true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	protected void hover(By by  , WaitStrategy waitstrategy , String elementName )
	{
		Actions action = new Actions(DriverManager.getDriver()) ;
		action.moveToElement(ExplicitWaitImplFactory.performExplicitWait(waitstrategy, by)).build().perform() ;
		try {
			ExtentLogger.pass(elementName + " is hovered"  , true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
		
	
	/**
	 * Locates element by given wait strategy, sends the value to located webelement and
	 * writes the pass even to the extent report.
	 * 
	 * 16-May-2024
	 * @author Raktim Sarkar
	 * @version 1.0
	 * @since 1.0
	 * @param by
	 * @param value
	 * @throws Exception
	 */

	protected void sendKeys(By by , String value , WaitStrategy waitstrategy , String elementName) 	{
		ExplicitWaitImplFactory.performExplicitWait(waitstrategy, by).sendKeys(value);
		try {
			ExtentLogger.pass(value + " is entered successfully in " + elementName , true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	protected String getPageTitle()
	{
		return  DriverManager.getDriver().getTitle() ;
	}

}
