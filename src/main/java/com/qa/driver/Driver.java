package com.qa.driver;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.google.common.util.concurrent.Uninterruptibles;
import com.qa.constants.FrameworkConstants;
import com.qa.enums.ConfigProperties;
import com.qa.utils.PropertyUtils;

/**
 *  Driver class is responsible for invoking and closing the browsers.
 * 
 * <p>
 * It is also responsible for 
 * setting the driver variable to DriverManager which handles the thread safety for the 
 * webdriver instance.
 * 
 * 16-May-2024 
 * @author Raktim Sarkar
 * @version 1.0
 * @param browser value is driven from Base class
 * @see DriverManager
 * @see com.qa.tests.BaseTest
 * @since 1.0
 */

public final class Driver {

	private Driver() {}

	private static WebDriver driver;

	public static void initDriver() throws Exception
	{
		if(Objects.isNull(DriverManager.getDriver()))  
		{
			System.setProperty("webdriver.chrome.driver", FrameworkConstants.getChromedriverpath()) ;
			ChromeOptions options = new ChromeOptions() ;
			options.addArguments("--remote-allow-origins=*");
			options.addArguments("--no-sandbox");
			options.addArguments("--disable-dev-shm-usage");
			driver = new ChromeDriver(options) ;
			DriverManager.setDriver(driver);
			//DriverManager.getDriver().get(PropertyUtils.getPropertyValue(ConfigProperties.GOOGLEURL)) ; //devUrl
//			DriverManager.getDriver().manage().window().maximize(); 
//			DriverManager.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
//			DriverManager.getDriver().manage().deleteAllCookies() ;
//			Uninterruptibles.sleepUninterruptibly(FrameworkConstants.getSleep(), TimeUnit.SECONDS);
		}
	}

	public static void quitDriver()
	{
		if(Objects.nonNull(DriverManager.getDriver()))
		{
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
	}
}
