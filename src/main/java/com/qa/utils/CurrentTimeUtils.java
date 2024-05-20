package com.qa.utils;


/**
 * Utility class to calculate current time in secs.
 * 
 * 16-May-2024
 * @author Raktim Sarkar
 * @version 1.0
 * @since 1.0
 */
public final class CurrentTimeUtils {
	
	private CurrentTimeUtils()
	{
		
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
