package com.qa.constants;

import com.qa.enums.ConfigProperties;
import com.qa.utils.PropertyUtils;

public final class FrameworkConstants {

	private FrameworkConstants() {} ;

	private static final String RESOURCEPATH = System.getProperty("user.dir")+ "/src/test/resources" ;
	private static final String CHROMEDRIVERPATH =  RESOURCEPATH +  "/executables/chromedriver.exe" ;
	private static final String CONFIGFILEPATH =    RESOURCEPATH +  "/config/config.properties" ;
	private static final int  EXPLICIT_WAIT = 10;
	private static final int SLEEP = 10  ;
	private static final String EXCELPATH = RESOURCEPATH + "/excel/testdata.xlsx" ;
	private static final String EXTENTREPORTFOLDERPATH = System.getProperty("user.dir") + "/extent-test-output/" ;
	private static String extentReportFilePath = "" ;
	private static final String RUNMANAGERSHEET = "RUNMANAGER" ;
	private static final String ITERATIONDATASHEET = "DATA"  ;


	public static String getExtentReportFilePath() throws Exception {

		if (extentReportFilePath.isEmpty())
		{
			extentReportFilePath = getExtentreportpath() ;
		}
		return extentReportFilePath;
	}

	public static String getExtentreportpath() throws Exception {
		if (PropertyUtils.getPropertyValue(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("no"))
		{
			return EXTENTREPORTFOLDERPATH  + System.currentTimeMillis() + "/index.html" ;
		}
		else
		{
			return EXTENTREPORTFOLDERPATH + "/" + "index.html" ;
		}		
	}


	public static String getChromedriverpath() {
		return CHROMEDRIVERPATH;
	}


	public static String getConfigfilepath() {
		return CONFIGFILEPATH;
	}


	public static int getExplicitWait() {
		return EXPLICIT_WAIT;
	}
	
	public static int getSleep() {
		return SLEEP;
	}


	public static String getExcelpath() {
		return EXCELPATH;
	}


	public static String getRunmanagersheet() {
		return RUNMANAGERSHEET;
	}

	public static String getIterationdatasheet() {
		return ITERATIONDATASHEET;
	}




}
