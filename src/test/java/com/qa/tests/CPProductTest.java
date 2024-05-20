package com.qa.tests;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import com.qa.annotations.CustomAnnotation;
import com.qa.enums.CategoryType;
import com.qa.pages.CPHomePage;


public class CPProductTest extends BaseTest{
	
	
	@CustomAnnotation(author={"Raktim"  , "Sarkar"}, category = {CategoryType.E2E  , CategoryType.SANITY} )
	@Test
	public void testCPProductHomePage() throws Exception
	{
	    String homePageTitle =  new CPHomePage().setUpCP().clickXicon().getTitle() ;
	    Assertions.assertThat(homePageTitle)
		
		.isEqualTo("Home | Golden State Warriors") ;	    
	}
	
	
	@CustomAnnotation(author={"Richard"  , "Levi"}, category = {CategoryType.REGRESSION  , CategoryType.SANITY} )
	@Test
	public void testCPProductArticlesPage() throws Exception
	{
	   String articlesPageTitle = new CPHomePage().setUpCP().clickXicon().navigateNewsAndArticles()
	                                                    .getTitle() ;
	   Assertions.assertThat(articlesPageTitle)
		
		.isEqualTo("News & Media | NBA.com") ;

	}
	
	@CustomAnnotation(author={"Raktim"  , "Sarkar"}, category = {CategoryType.REGRESSION  , CategoryType.SANITY} )
	@Test
	public void testCPProductVideosFeed() throws Exception
	{
	   int count = new CPHomePage().setUpCP().clickXicon().navigateNewsAndArticles()
	                                                     .getVideosCount().filteredVideosCount() ;
	   
	   Assertions.assertThat(count)
              .isPositive() ;	    
	}

}
