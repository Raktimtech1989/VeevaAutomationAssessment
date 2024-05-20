package com.qa.exceptions;

/**
 * Runtime Exception occurs when the key or value fetched from the property file is null
 * 
 * 16-May-2024
 * @author Raktim Sarkar
 * @version 1.0
 * @since 1.0
 * @see com.rtech.constants.FrameworkConstants
 * @see com.rtech.utils.PropertyUtils
 */

@SuppressWarnings("serial")
public class PropertyFileUsageException extends FrameworkException{

	public PropertyFileUsageException(String message) {
		super(message);

	}
	
	public PropertyFileUsageException(String message , Throwable cause) {
		super(message , cause);

	}

}