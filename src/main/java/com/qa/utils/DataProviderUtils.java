package com.qa.utils;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

import com.qa.constants.FrameworkConstants;

public final class DataProviderUtils {

	/**
	 * Holds the data provider for all the test cases in the framework. 
	 *
	 * 16-May-2024
	 * @author Raktim Sarkar
	 * @version 1.0
	 * @since 1.0
	 * @param m
	 * @return
	 * @throws IOException
	 */

	/**
	 * Private constructor to avoid external instantiation
	 */
	private DataProviderUtils() {}



	/**
	 * Acts as a data provider for all the test cases.
	 * Parallel=true indicates that each of the iteration will be ran in parallel.
	 *
	 * 16-May-2024
	 * @author Raktim Sarkar
	 * @version 1.0
	 * @since 1.0
	 * @param m
	 * @return
	 * @throws IOException
	 */
	@DataProvider(parallel = true )
	public static Object[] getData(Method m) throws IOException
	{
		String testName = m.getName();
		System.out.println("testname from @test is    " + 	testName);
		List<Map<String, String>> list = ExcelUtils.getTestDetails(FrameworkConstants.getIterationdatasheet()) ;
		System.out.println(list);
		List<Map<String , String>> filteredList = new ArrayList<>() ;

		for(int i = 0 ; i<list.size();i++)
		{
			if(list.get(i).get("testname").equalsIgnoreCase(testName) )
			{
				System.out.println("testname from excel  "  + list.get(i).get("testname"));
				//System.out.println("testname from @test is    " + 	testName);
				if(list.get(i).get("execute").equalsIgnoreCase("yes"))
				{
					filteredList.add(list.get(i)) ;
				}

			}

		}

		System.out.println(filteredList);

		return filteredList.toArray();
	}


}