package com.qa.pages;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.google.common.util.concurrent.Uninterruptibles;
import com.qa.constants.FrameworkConstants;
import com.qa.driver.DriverManager;
import com.qa.enums.ConfigProperties;
import com.qa.enums.WaitStrategy;
import com.qa.factories.ExplicitWaitImplFactory;
import com.qa.reports.ExtentLogger;
import com.qa.utils.CurrentTimeUtils;
import com.qa.utils.ExcelUtils;
import com.qa.utils.PropertyUtils;

public final class DP1ProductHomePage extends BasePage {


	private final static By allSlidesLink = By.xpath("//div[@role='tablist']/button") ;
	List<Object> actualList = new ArrayList<>() ;
	static List<Map<String, String>> expectedData ;
	//static List<WebElement> slides ;
    
	static
	{
		try {
			 expectedData = ExcelUtils.getTestDetails(PropertyUtils.getPropertyValue(ConfigProperties.EXCELSHEETNAME)) ;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// slides = ExplicitWaitImplFactory.performExplicitWaitForAllElements(WaitStrategy.VISIBLEALL, allSlidesLink) ;
		
		
	}
	public DP1ProductHomePage setUpDP1() throws Exception
	{
		DriverManager.getDriver().get(PropertyUtils.getPropertyValue(ConfigProperties.DP1URL));
		//DriverManager.getDriver().manage().window().maximize() ;	
		ExtentLogger.pass("DP1-Product is correctly setUp"  , true );

		return this;
	}

	public List<Object> validateSlideTitle()
	{
      
	List<WebElement> allElements = ExplicitWaitImplFactory.performExplicitWaitForAllElements(WaitStrategy.VISIBLEALL, allSlidesLink) ;
		for(WebElement l : allElements)
		{
			String slideTitle = l.getText();			
			System.out.println("Ttile of each slide is   -->"   + slideTitle);
			actualList.add(slideTitle) ;
		}
		ExtentLogger.pass(actualList,  "Actual Title coming from UI product -> ");

		return actualList ;
	}
	
	public List<Object> expectedSlideTitle() throws IOException, Exception
	{
		 ExtentLogger.pass(expectedData);
		 List<Object> expectedList = new ArrayList<>() ;
		 
		 for(int i =0 ; i<expectedData.size() ; i++)
		 {
			 expectedList.add(expectedData.get(i).get("SlideTitle"));
		 }
		 
		 return expectedList;
	}

	public List<Object> expectedSlideDuration() throws IOException, Exception
	{
		 ExtentLogger.pass(expectedData);
		 List<Object> expectedList = new ArrayList<>() ;
		 
		 for(int i =0 ; i<expectedData.size() ; i++)
		 {
			 expectedList.add(expectedData.get(i).get("Duration"));
		 }
		 
		 return expectedList;
	}
   
	
	public List<Object> validateSlideDuration()
	{
		List<WebElement> slides =ExplicitWaitImplFactory.performExplicitWaitForAllElements(WaitStrategy.VISIBLEALL, allSlidesLink) ;
		
		List<Object> actualDuration = new ArrayList<>() ;
		for(int i =0 ; i<slides.size() ; i++)
		{
			long currentTime = CurrentTimeUtils.currentTime() ;
			long nextTime = 0 ;
			System.out.println(slides.get(i).getAttribute("aria-selected"));
			boolean flag = true;
			
			while(flag)
			{
				boolean val = Boolean.valueOf(slides.get(i).getAttribute("aria-selected"));
				if (val == false)
				{
					nextTime = CurrentTimeUtils.currentTime() ;
					flag = false;
				}

			}
			
			System.out.println("difference is   "  + (nextTime-currentTime)   + "   "  + i);
			actualDuration.add((nextTime-currentTime) );
			
		}
		
		ExtentLogger.pass(actualDuration  , "Duration for each slides are-> ");
		
		return actualDuration;
			
	}
	
	
	public String getTitle()
	{
		return getPageTitle() ;
	}



}
