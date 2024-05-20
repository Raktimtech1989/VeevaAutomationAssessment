package com.qa.factories;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.enums.WaitStrategy;
import com.qa.constants.FrameworkConstants;
import com.qa.driver.DriverManager;

/**
 * Explicit wait factory produces different waits before operating on webelement
 * 
 * 16-May-2024
 * @author Raktim Sarkar
 * @version 1.0
 * @since 1.0
 */

public class ExplicitWaitImplFactory {
	
	private ExplicitWaitImplFactory()
	{
		
	}
	
	/**
	 * @param waitstrategy Strategy to be applied to find a webelement {@link com.rtech.enums.WaitStrategy}
	 * @param by By locator of the webelement
	 * @return webelement Locates and return the webelement
	 * 
	 * 15-Dec-2022
	 * @author Raktim Sarkar
	 * @version 1.0
	 * @since 1.0
	 * @param waitStrategy
	 * @param by
	 * @return
	 */
	
	
	public static WebElement performExplicitWait(WaitStrategy waitStrategy , By by)
	{
		WebElement element = null;
		if(waitStrategy == WaitStrategy.CLICKABLE)
		{			
			   element =  new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait()))
			    .until(ExpectedConditions.elementToBeClickable(by));
		}
		else if (waitStrategy == WaitStrategy.PRESENCE)
		{
			  element =  new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait()))
			   .until(ExpectedConditions.presenceOfElementLocated(by));
		}
		else if (waitStrategy == WaitStrategy.VISIBLE)
		{
			element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait()))
			   .until(ExpectedConditions.visibilityOfElementLocated(by));
		}
		
		else if (waitStrategy == WaitStrategy.NONE)
		{
			element = DriverManager.getDriver().findElement(by);
		}
		
		return element;
		
	}
	
	public static List<WebElement> performExplicitWaitForAllElements(WaitStrategy waitStrategy , By by)
	{
		List<WebElement> element = null;
		
		 if (waitStrategy == WaitStrategy.VISIBLEALL)
		{
			element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait()))
			   .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
		}
		
		else if (waitStrategy == WaitStrategy.NONE)
		{
			element = DriverManager.getDriver().findElements(by);
		}
		
		return element;
		
	}
	
	
	

}