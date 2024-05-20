package com.qa.exceptions;

/**
 * BaseException for the framework. Extends Runtime Exception and can be thrown anywhere to terminate a program
 * 
 * 
 * 16-May-2024
 * @author Raktim Sarkar
 * @version 1.0
 * @since 1.0
 */

@SuppressWarnings("serial")
public class FrameworkException extends RuntimeException{
	
	
	public FrameworkException(String message)
	{
		super(message);
	}
	
	public FrameworkException(String message , Throwable cause)
	{
		super(message , cause);
	}
	
	

}