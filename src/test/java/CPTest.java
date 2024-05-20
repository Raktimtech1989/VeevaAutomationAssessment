

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.qa.constants.FrameworkConstants;
import com.qa.enums.WaitStrategy;
import com.qa.factories.DriverFactory;
import com.qa.factories.ExplicitWaitImplFactory;


public class CPTest {
	
	public static WebDriver driver ;
	
	@Test
	public void testCPProduct() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", FrameworkConstants.getChromedriverpath()) ;
		ChromeOptions options = new ChromeOptions() ;
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-shm-usage");
		driver = new ChromeDriver(options) ;
		
		driver.get("https://www.nba.com/warriors");
		driver.manage().window().maximize() ;
		driver.manage().deleteAllCookies() ;
		Thread.sleep(10000) ;
		driver.navigate().refresh() ;
		
		if (driver.findElements(By.xpath("//button[contains(text() , 'I Accept')]")).size() != 0)
		{
			driver.findElement(By.xpath("//button[contains(text() , 'I Accept')]")).click() ;
		}
	
		WebElement l = driver.findElement(By.xpath("//div[@role='dialog']/div/div")) ;
		
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("arguments[0].click();", l);
		
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10)) ;
		wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='nba-nav']//div[@class='relative dark-primary-background']/nav/div/nav[2]/ul/li/a/span"))) ;
		
		WebElement threeDotsIcon = driver.findElement(By.xpath("//div[@id='nba-nav']//div[@class='relative dark-primary-background']/nav/div/nav[2]/ul/li/a/span")) ;
		Actions action = new Actions(driver) ;
		action.moveToElement(threeDotsIcon).build().perform() ;
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)) ;
		WebElement e = driver.findElement(By.xpath("//a[@title='News & Features']")) ;
		j.executeScript("arguments[0].scrollIntoView();", e) ;

		WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='News & Features']"))) ;
				ele.click() ;
				
				WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10)) ;
				wait2.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[contains(@class , 'lowercase post-meta')]/time/span"))) ;
				
				List<WebElement> videos = driver.findElements(By.xpath("//div[contains(@class , 'lowercase post-meta')]/time/span")) ;
				
				System.out.println("total number of videos feed   "   + videos.size());
				int counter =0;
				for(int i =0 ; i<videos.size() ; i++)
				{
					String time = videos.get(i).getText() ;
					time = time.replaceAll("[^0-9]", "") ;
					int timeNumeric = Integer.parseInt(time) ;
					
					System.out.println("time is   "  + timeNumeric);
					
					  if (timeNumeric >= 3)
					  {
						  counter ++;
					  }
				}
				

				
				System.out.println("count of video feeds in the page >=3d ... "  + counter);
		//driver.quit() ;
		
	}

}
