package com.qa.annotations;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import com.qa.enums.CategoryType;

@Documented
@Retention(RUNTIME)
@Target(METHOD)
public @interface FrameworkAnnotation {
	
	public String[] author() ;
	public CategoryType[] category() ;

}
