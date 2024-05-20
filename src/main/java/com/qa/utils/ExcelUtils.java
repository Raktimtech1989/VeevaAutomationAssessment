package com.qa.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.qa.constants.FrameworkConstants;



/**
 * Utility class to read or write to excel.
 * 
 * 16-May-2024
 * @author Raktim Sarkar
 * @version 1.0
 * @since 1.0
 */
public final class ExcelUtils {
	
	/**
	 * Private constructor to avoid external instantiation
	 */
	private ExcelUtils() {}
		
	/**
	 * Encapsulates all the value from the mentioned excel sheet and store it in
	 * List holding HashMaps. Key for the map in the column header in the excel sheet.
	 * 
	 * 16-May-2024
	 * @author Raktim Sarkar
	 * @version 1.0
	 * @since 1.0
	 * @param sheetName
	 * @return
	 * @throws IOException
	 */
	
	public static List<Map<String, String>> getTestDetails(String sheetName) throws IOException
	{
		FileInputStream fis = new FileInputStream(FrameworkConstants.getExcelpath())  ;
		try (XSSFWorkbook wb = new XSSFWorkbook(fis)) {  //try with resources
			XSSFSheet sh = wb.getSheet(sheetName) ;
			
			
			Map<String, String> map = null;
			int lastRowNum = sh.getLastRowNum();
			int lastColNum = sh.getRow(0).getLastCellNum() ;
			
			List<Map<String, String>>  list = new ArrayList<>() ;
			
			for(int i = 1 ; i <=lastRowNum ; i++)
			{
				map = new HashMap<>() ;
				for(int j = 0 ; j < lastColNum ; j++)
				{
					String key = sh.getRow(0).getCell(j).getStringCellValue() ;
					String value = sh.getRow(i).getCell(j).getStringCellValue() ;
					map.put(key, value)  ;

				}
				
				list.add(map) ;
				
			}
			
			fis.close();
			return list;
		}
	}

}