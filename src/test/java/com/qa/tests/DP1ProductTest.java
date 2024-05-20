package com.qa.tests;

import java.io.IOException;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import com.qa.annotations.CustomAnnotation;
import com.qa.enums.CategoryType;
import com.qa.pages.DP1ProductHomePage;

public class DP1ProductTest extends BaseTest{

	@CustomAnnotation(author={"Raktim"  , "Sarkar"}, category = {CategoryType.E2E  , CategoryType.SANITY} )
	@Test(priority = 2)
	public void testDPIProductSlideTitle() throws IOException, Exception
	{
		DP1ProductHomePage dp1ProductPage = new DP1ProductHomePage() ;
		List<Object> expectedSlidesTitle = dp1ProductPage
		                                            .expectedSlideTitle() ;
	  
		List<Object> actualSlidesTitle = dp1ProductPage
				                                .setUpDP1().
				                                    validateSlideTitle() ;
		Assertions.assertThat(expectedSlidesTitle)
		     .isEqualTo(actualSlidesTitle) ;
		
	}

	
	@CustomAnnotation(author={"Raktim"  , "Sarkar"}, category = {CategoryType.E2E  , CategoryType.SANITY} )
	@Test(priority = 1)
	public void testDPIProductSlideDuration() throws IOException, Exception
	{
		DP1ProductHomePage dp1ProductPage = new DP1ProductHomePage() ;
		List<Object> expectedSlidesDuration = dp1ProductPage
		                                            .expectedSlideDuration() ;
	  
		List<Object> actualSlidesTitle = dp1ProductPage
				                                .setUpDP1().
				                                    validateSlideDuration();
		Assertions.assertThat(expectedSlidesDuration)
		     .isEqualTo(actualSlidesTitle) ;
		
	}



}


