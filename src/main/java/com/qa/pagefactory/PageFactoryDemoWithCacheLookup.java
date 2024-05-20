package com.qa.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageFactoryDemoWithCacheLookup {

	private WebDriver driver ;
	
	@CacheLookup
	@FindBy(name = "q")
	private WebElement searchbox ;
	
	public PageFactoryDemoWithCacheLookup(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		this.driver = driver ;
		
	}
	public void findElement10Times() {
		
		long startTime =  System.currentTimeMillis() ;
		
		for(int i =0 ; i<=10 ; i++)
		{
			searchbox.clear(); 
			searchbox.sendKeys("selenium");
			
		}
		
		System.out.println(System.currentTimeMillis() - startTime);		
	}

}
