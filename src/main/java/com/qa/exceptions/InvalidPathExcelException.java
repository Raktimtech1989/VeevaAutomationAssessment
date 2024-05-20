package com.qa.exceptions;

/**
 * Runtime Exception occurs when the path given for excel sheet is incorrect.
 * 
 * 16-May-2024
 * @author Raktim Sarkar
 * @version 1.0
 * @since 1.0
 * @see com.rtech.constants.FrameworkConstants
 */

@SuppressWarnings("serial")
public class InvalidPathExcelException extends FrameworkException{

	public InvalidPathExcelException(String message) {
		super(message);

	}
	
	public InvalidPathExcelException(String message , Throwable cause) {
		super(message , cause);

	}

}