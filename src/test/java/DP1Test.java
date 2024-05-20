


import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.constants.FrameworkConstants;


public class DP1Test {


	static WebDriver driver;
	@Test
	public void DP1Test()
	{
		//https://www.nba.com/sixers/  

		System.setProperty("webdriver.chrome.driver", FrameworkConstants.getChromedriverpath()) ;
		ChromeOptions options = new ChromeOptions() ;
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-shm-usage");
		driver = new ChromeDriver(options) ;

		driver.get("https://www.nba.com/sixers/");
		driver.manage().window().maximize() ;
		//○ Get the title of each Slide and validate with expected test data
		List<Object> expectedTitle = Arrays.asList(new String[] {
				"Tyrese Maxey Wins 2023-24 NBA Sportsmanship Award" ,
				"Sixers 2023-24 Season Memorable Moments",
				"Watch Daryl Morey 23-24 Season End Press Conference" ,
				"Tyrese Maxey Named 2023-24 Kia NBA Most Improved Player"

		}) ;

		List<Object> actualList = new ArrayList<>() ;


		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10)) ;
		wait1.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@role='tablist']/button"))) ;

		List<WebElement> list =  driver.findElements(By.xpath("//div[@role='tablist']/button")) ;
		//List<WebElement> list = driver.findElements(By.xpath("//div[@class='TileHero_tileHeroContent__F78te']/div/h1")) ;
		System.out.println(list.size());
		for(WebElement l : list)
		{
			String slideTitle = l.getText();			
			System.out.println("Ttile of each slide is   -->"   + slideTitle);
			actualList.add(slideTitle) ;
		}

		Assert.assertEquals(actualList, expectedTitle) ;

		driver.quit() ;

	}


	@Test
	public void DP1TestCalculateDuration()
	{
		System.setProperty("webdriver.chrome.driver", FrameworkConstants.getChromedriverpath()) ;
		ChromeOptions options = new ChromeOptions() ;
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-shm-usage");
		driver = new ChromeDriver(options) ;

		driver.get("https://www.nba.com/sixers/");
		driver.manage().window().maximize() ;

		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10)) ;
		wait1.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@role='tablist']//button"))) ;


		List<WebElement> slides = driver.findElements(By.xpath("//div[@role='tablist']//button")) ;
		for(int i =0 ; i<slides.size() ; i++)
		{
			long currentTime = currentTime() ;
			long nextTime = 0 ;
			//System.out.println("current time is   " + currentTime + "  "  + i);
			System.out.println(slides.get(i).getAttribute("aria-selected"));
			boolean flag = true;
			
			while(flag)
			{
				boolean val = Boolean.valueOf(slides.get(i).getAttribute("aria-selected"));
				if (val == false)
				{
					nextTime = currentTime() ;
					flag = false;
				}
				
				//System.out.println("next time is   "  + System.currentTimeMillis()   + "  "  + i);
			}
			
			System.out.println("difference is   "  + (nextTime-currentTime)   + "   "  + i);
			
//			while(slide.getAttribute("aria-selected") == "true" )
//			{
//				long nextTime = System.currentTimeMillis() ;
//				long duration = nextTime - currentTime ;
//				
//				System.out.println("duration is   "  + duration);
//			}
			
		}



	}
	
	public static long currentTime()
	{
		long m = System.currentTimeMillis(); // that's our input
		long s = (long) Math.max(
		  .18 * (Math.toRadians(m)/Math.PI),
		  Math.pow( Math.E, Math.log(m)-Math.log(1000) )
		);
		System.out.println( "seconds: "+s );
		
		return s;
		
		
	}



}


