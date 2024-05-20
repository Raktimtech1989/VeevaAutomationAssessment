package com.qa.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.qa.driver.Driver;

/**
 * Acts as a parent class for all the test classes in this framework. All the
 * test classes needs to extend this class. This class is responsible for
 * invoking and terminating browser under test.
 * 
 * 16-May-2024
 * 
 * @author Raktim Sarkar
 * @version 1.0
 * @since 1.0
 */

public class BaseTest {
	
	protected BaseTest() {}
	
	
	
	/**
	 * Invokes a new browser instance and loads the respective URL.
	 *
	 * 16-May-2024
	 * 
	 * @author Raktim Sarkar
	 * @version 1.0
	 * @since 1.0
	 * @param data Have all the data feeded to the corresponding test method from
	 *             data provider.In our case,it is a hashmap containing all the
	 *             values from the excel sheet
	 * @throws Exception
	 */
	
	@BeforeMethod
	protected void setUp() throws Exception
	{
		Driver.initDriver();
	}
	


	/**
	 * Terminates the browser instance
	 * @author Raktim Sarkar
	 * 16-May-2024
	 */
	@AfterMethod
	protected void tearDown()
	{
		Driver.quitDriver();
	}
	
	
	
	
}
