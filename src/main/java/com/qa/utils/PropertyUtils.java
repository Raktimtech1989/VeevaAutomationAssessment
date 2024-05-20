package com.qa.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

import com.qa.constants.FrameworkConstants;
import com.qa.enums.ConfigProperties;
import com.qa.exceptions.PropertyFileUsageException;


/**
 * Read the property file and store it in a HashMap for faster processing.
 * Users can prefer to use json instead of property file based on their requirement.
 * 
 * 16-May-2024
 * @author Raktim Sarkar
 * @version 1.0
 * @since 1.0
 */
public class PropertyUtils {

	private PropertyUtils()
	{

	}
	private static Properties prop = new Properties();
	private static final Map<String, String> CONFIGMAP = new HashMap<String , String>();

	static
	{

		try {
			FileInputStream fis = new FileInputStream(FrameworkConstants.getConfigfilepath());
			prop.load(fis);

			for(Map.Entry<Object, Object> entry : prop.entrySet())
			{
				CONFIGMAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()).trim());   //remove the trailing & leading spaces
			}

		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	//Driving the key from Enum-> which will take to config.properties file
	public static String getPropertyValue(ConfigProperties key) throws Exception
	{
		if(Objects.isNull(key) || Objects.isNull( CONFIGMAP.get(key.name())))
		{
			throw new PropertyFileUsageException("Property name  " + key +  " is not found,Please check config.properties ");
		}

		return CONFIGMAP.get(key.name());

	}

}