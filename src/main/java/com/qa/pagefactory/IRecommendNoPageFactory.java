package com.qa.pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IRecommendNoPageFactory {

	private WebDriver driver ;
	private By searchbox = By.name("q") ;
	
	
	public IRecommendNoPageFactory(WebDriver driver) {
		this.driver = driver ;
	}

	
	public void findElement10Times() {
		
		long startTime =  System.currentTimeMillis() ;
		
		for(int i =0 ; i<=10; i++)
		{
			WebElement element =  driver.findElement(searchbox);
			element.clear(); 
			element.sendKeys("selenium");
		}
		
		System.out.println(System.currentTimeMillis() - startTime);

		
	}

}
