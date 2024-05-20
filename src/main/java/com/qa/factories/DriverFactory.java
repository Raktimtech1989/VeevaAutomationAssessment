package com.qa.factories;


import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.*;

import com.qa.enums.ConfigProperties;
import com.qa.utils.PropertyUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * 
 * 17-Dec-2022
 * @author Raktim Sarkar
 * @version 1.0
 * @since 1.0
 */

public class DriverFactory {
	
	private DriverFactory() {}
	
	public static WebDriver getDriver(String browser,String version) throws Exception {

		WebDriver driver=null;

		String runmode = PropertyUtils.getPropertyValue(ConfigProperties.RUNMODE);
		if(browser.equalsIgnoreCase("chrome")) {
			if(runmode.equalsIgnoreCase("remote")) {
				DesiredCapabilities cap = new DesiredCapabilities();
				cap.setBrowserName(browser);
				cap.setVersion(version);
				driver =new RemoteWebDriver(new URL(PropertyUtils.getPropertyValue(ConfigProperties.SELENIUMGRIDURL)), cap);
			}
			else {
				//WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}
			
					}
		else if(browser.equalsIgnoreCase("firefox")) {

			if(runmode.equalsIgnoreCase("remote")) {
				DesiredCapabilities cap = new DesiredCapabilities();
				cap.setBrowserName(browser);
				cap.setVersion(version);
				driver =new RemoteWebDriver(new URL(PropertyUtils.getPropertyValue(ConfigProperties.SELENIUMGRIDURL)), cap);
			} else {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}
		}
		return driver;
	}

}