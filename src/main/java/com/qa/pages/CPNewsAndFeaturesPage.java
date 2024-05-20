package com.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.qa.enums.WaitStrategy;
import com.qa.factories.ExplicitWaitImplFactory;
import com.qa.reports.ExtentLogger;

public final class CPNewsAndFeaturesPage extends BasePage{

	private final By videosLink = By.xpath("//div[contains(@class , 'lowercase post-meta')]/time/span") ;
	static int totalVideosFeed ;
	 List<WebElement> videos;


	public String getTitle()
	{
		return getPageTitle() ;
	}


	public CPNewsAndFeaturesPage getVideosCount()
	{
		videos = ExplicitWaitImplFactory.performExplicitWaitForAllElements(WaitStrategy.VISIBLEALL, videosLink) ; 
		totalVideosFeed = ExplicitWaitImplFactory.performExplicitWaitForAllElements(WaitStrategy.VISIBLEALL, videosLink).size() ;
		try {
			ExtentLogger.pass("Total number of videos feed   "  + totalVideosFeed, true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	

		return this;
	}

	public int filteredVideosCount()
	{
		int counter =0;
		for(int i =0 ; i<totalVideosFeed ; i++)
		{
			videos = ExplicitWaitImplFactory.performExplicitWaitForAllElements(WaitStrategy.VISIBLEALL, videosLink) ; 
			
			System.out.println("videos size is  "  + videos.size());
			System.out.println("totalVideosFeed size is  "  + totalVideosFeed);
			
			String time = videos.get(i).getText() ;
			time = time.replaceAll("[^0-9]", "") ;
			int timeNumeric = Integer.parseInt(time) ;

			System.out.println("time is   "  + timeNumeric);

			if (timeNumeric >= 3)
			{
				counter ++;
			}
		}
		try {
			ExtentLogger.pass("count of video feeds in the page >=3d ... " + counter , true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		System.out.println("count of video feeds in the page >=3d ... "  + counter);
		
		return counter;

	}


}
