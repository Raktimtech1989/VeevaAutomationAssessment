package com.qa.dataprovider;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

public class Employee {
	
	private String name ;
	private String id ;
	
	public Employee(String name, String id) {
		super();
		this.name = name;
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	//customised dataprovider where multiple tests can refer a single dataprovider

	@DataProvider
	public static Object[] getData2(Method m)
	{
		if(m.getName().equalsIgnoreCase("test3"))
		{
			return new Employee[]  {
					new Employee("docker", "1") ,
					new Employee("k8s", "2") 				
			} ;
			
		}
		
		else if(m.getName().equalsIgnoreCase("test2"))
		{
			return new Object[][]
					{
				{"rak" , "sar"} ,
				{"rak1" , 1} ,
				{"rak2" , "sar2"}
					} ;
		}
		return null ;
		
	}
	
	
}
