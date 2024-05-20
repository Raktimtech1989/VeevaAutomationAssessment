package com.qa.dataprovider;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemo {

	@Test(enabled = false)
	public void test1()
	{
		String[] a = {"raktim"  , "sarkar"  , "tech" } ;

		for(int i =0 ; i<a.length ; i++)
		{
			System.out.println("entering username ");
			System.out.println("entering password ");
			System.out.println("click login");
			
			Assert.assertTrue(false);
		}
	}
	
	@Test(dataProvider = "getData2" , dataProviderClass = Employee.class)
	public void test2(String username , Object password)
	{
			System.out.println("entering username ");
			System.out.println("entering password ");
			System.out.println("click login");	
	}
	
	
		
	@DataProvider
	public String[] getData()
	{
		String[] a = {"raktim" , 
				      "sarkar" ,
				      "tech" } ; 
		return a;
	}
	
	@Test(dataProvider = "getData2" ,  dataProviderClass = Employee.class)
	public void test3(Employee emp)
	{
			System.out.print(emp.getName() + " ");
			System.out.print(emp.getId()) ;
			
			System.out.println();
	
	}
	
	
	
}
