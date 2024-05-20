package com.qa.dataprovider;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.constants.FrameworkConstants;

public class DataProviderWithExcel {


	@Test(dataProvider = "getDataExcel")
	public void test2(Map<String, String> map)
	{
		System.out.print(map.get("username")  + "  "  + map.get("password")  + "  " + map.get("fName")) ;	
		System.out.println();
	}


	@DataProvider
	public Object[] getDataExcel() throws IOException
	{
		FileInputStream fis = new FileInputStream(FrameworkConstants.getExcelpath()) ;
		XSSFWorkbook wb = new XSSFWorkbook(fis) ;
		XSSFSheet sh = wb.getSheetAt(0) ;

		int rowNum = sh.getLastRowNum() ;
		int colNum = sh.getRow(0).getLastCellNum() ;
		Object[] data = new Object[rowNum] ;
		Map<String, String>  map ;

		for(int i =1 ; i<=rowNum ; i++)		
		{
			map =  new HashMap<>() ; //header

			for(int j = 0 ; j<colNum; j++)
			{
				String key = sh.getRow(0).getCell(j).getStringCellValue() ;			
				String value = sh.getRow(i).getCell(j).getStringCellValue() ;

				map.put(key, value) ;
				data[i-1] = map;

			}
		}

		return data ;

	}

	@DataProvider
	public Object[][] getDataExcelWithoutMap() throws IOException
	{
		FileInputStream fis = new FileInputStream(FrameworkConstants.getExcelpath()) ;
		XSSFWorkbook wb = new XSSFWorkbook(fis) ;
		XSSFSheet sh = wb.getSheetAt(0) ;

		int rowNum = sh.getLastRowNum() ;
		int colNum = sh.getRow(0).getLastCellNum() ;
		Object[][] data = new Object[rowNum][colNum] ;
		for(int i =1 ; i<=rowNum ; i++)		
		{
			for(int j = 0 ; j<colNum; j++)
			{
				data[i-1][j] = sh.getRow(i).getCell(j).getStringCellValue() ;

			}
		}

		return data ;

	}

}
