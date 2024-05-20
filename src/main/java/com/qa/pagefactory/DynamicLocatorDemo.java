package com.qa.pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicLocatorDemo {
	
	private WebDriver driver ;

	public DynamicLocatorDemo(WebDriver driver) {
		
	}
	
	private String menuitem = "//div[text() = '%value%']/parent::a" ;
	
	public void clickMenu(String value)
	{
		driver.findElement(By.xpath(menuitem.replace("%value%", value))) ;
	}

}
