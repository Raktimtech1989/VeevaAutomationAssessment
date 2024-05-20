package com.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.google.common.util.concurrent.Uninterruptibles;
import com.qa.constants.FrameworkConstants;
import com.qa.driver.DriverManager;
import com.qa.enums.ConfigProperties;
import com.qa.enums.WaitStrategy;
import com.qa.reports.ExtentLogger;
import com.qa.utils.PropertyUtils;

public final class CPHomePage extends BasePage {


	private final By dialog = By.xpath("//div[@role='dialog']/div/div") ;
	private final By threeDotsIcon = By.xpath("//div[@id='nba-nav']//div[@class='relative dark-primary-background']/nav/div/nav[2]/ul/li/a/span") ;
	private final By newsAndFeatures = By.xpath("//a[@title='News & Features']") ;

	static JavascriptExecutor j ;
	public CPHomePage setUpCP() throws Exception
	{
		DriverManager.getDriver().get(PropertyUtils.getPropertyValue(ConfigProperties.CPURL));
		DriverManager.getDriver().manage().window().maximize() ;
		DriverManager.getDriver().manage().deleteAllCookies() ;
		Uninterruptibles.sleepUninterruptibly(FrameworkConstants.getSleep(), TimeUnit.SECONDS);
		DriverManager.getDriver().navigate().refresh() ;

		if (DriverManager.getDriver().findElements(By.xpath("//button[contains(text() , 'I Accept')]")).size() != 0)
		{
			DriverManager.getDriver().findElement(By.xpath("//button[contains(text() , 'I Accept')]")).click() ;
		}
		
		ExtentLogger.pass("CP-Product is correctly setUp"  , true);

		return this;
	}

	public CPHomePage clickXicon()
	{
		WebElement l = DriverManager.getDriver().findElement(dialog) ;		
		j = (JavascriptExecutor) DriverManager.getDriver();
		j.executeScript("arguments[0].click();", l);
		
		try {
			ExtentLogger.pass("X-icon is clicked"  , true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		return this ;
	}

	public CPNewsAndFeaturesPage navigateNewsAndArticles()
	{

		hover(threeDotsIcon, WaitStrategy.CLICKABLE, "ThreeDotsIcon");

		WebElement e = DriverManager.getDriver().findElement(By.xpath("//a[@title='News & Features']")) ;
		j.executeScript("arguments[0].scrollIntoView();", e) ;
		click(newsAndFeatures, WaitStrategy.CLICKABLE, "News & Features") ;

		return new CPNewsAndFeaturesPage() ;
	}


	public String getTitle()
	{
		return getPageTitle() ;
	}



}
