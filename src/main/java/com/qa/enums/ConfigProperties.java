/**
 * 
 */
package com.qa.enums;

/**
 * Enums to restrict the values used on Property files. Without using enums there can be null pointer exceptions happening
 * because of typos.
 * 
 * 16-May-2024
 * @author Raktim Sarkar
 * @version 1.0
 * @since 1.0
 * @see com.qa.utils.PropertyUtils
 */
public enum ConfigProperties {
	
	HRMURL ,
	GOOGLEURL,
	CPURL,
	DP1URL,
	BROWSER ,
	EXCELSHEETNAME,
	OVERRIDEREPORTS ,
	PASSEDSTEPSCREENSHOT ,
	FAILEDSTEPSCREENSHOT  ,
	SKIPPEDSTEPSCREENSHOT ,
	RETRYFAILEDTESTS,
	RUNMODE, SELENIUMGRIDURL , SENDRESULTSTOELK;

}
