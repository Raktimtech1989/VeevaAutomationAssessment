package com.qa.driver;

import org.openqa.selenium.WebDriver;

/**
 * DriverManager class helps to achieve thread safety for the {@link org.openqa.selenium.WebDriver} instance.
 * 
 * 16-May-2024
 * @author Raktim Sarkar
 * @version 1.0
 * @since 1.0
 */

public final class DriverManager {

	private DriverManager() {} 

	public static ThreadLocal<WebDriver> dr = new ThreadLocal<>() ;

	/**
	 * Returns the thread safe {@link org.openqa.selenium.WebDriver} instance fetched from ThreadLocal variable.
	 * 
	 * 16-May-2024
	 * @author Raktim Sarkar
	 * @version 1.0
	 * @since 1.0
	 * @return
	 */

	public static WebDriver getDriver()
	{		
		return dr.get() ;
	}


	/**
	 * Set the WebDriver instance to thread local variable
	 * 
	 * 16-May-2024
	 * @author Raktim Sarkar
	 * @version 1.0
	 * @since 1.0
	 * @param driver
	 */

	public static void setDriver(WebDriver driver)
	{
		dr.set(driver);
	}


	/**
	 * Calling remove method on Threadlocal variable ensures to set the default value to Threadlocal variable.
	 * It is much safer than assigning null value to ThreadLocal variable.
	 * 16-May-2024
	 * @author Raktim Sarkar
	 * @version 1.0
	 * @since 1.0
	 */
	public static void unload()
	{
		dr.remove();
	}

}
