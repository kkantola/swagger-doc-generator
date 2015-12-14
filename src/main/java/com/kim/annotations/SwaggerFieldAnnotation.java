package com.kim.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Custom annotation for field of objects to be documented in Swagger 
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface SwaggerFieldAnnotation {
	
	/**
	 * Description of the field to be annotated
	 */
	String fieldDescription();
}
