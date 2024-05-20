package com.qa.annotations;

import static java.lang.annotation.ElementType.METHOD;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import com.qa.enums.CategoryType;

/**
 * * Framework Annotation is user built annotation which is annotated on top of test methods to log the author details and 
 * category details to the extent report.<p>
 * 
 * Runtime retention value indicate that this annotation will be available at run time for reflection operations.
 * 
 * 16-May-2024
 * @author Raktim Sarkar
 * @version 1.0
 * @since 1.0
 */


@Retention(RUNTIME)
@Target(METHOD)
@Documented
public @interface CustomAnnotation {
	
	
	/**
	 * Store the authors who created the tests in String[]
	 * Manadatory to enter atleast a value
	 * 16-May-2024
	 * @author Raktim Sarkar
	 * @version 1.0
	 * @since 1.0
	 * @return
	 */	
	public String[] author() ;
	
	
	/**
	 * Stores the category in form of Enum Array. Include the possible values in {@link com.tmb.enums.CategoryType}
	 * 16-May-2024
	 * @author Raktim Sarkar
	 * @version 1.0
	 * @since 1.0
	 * @return
	 */	
	public CategoryType[] category() ;

}