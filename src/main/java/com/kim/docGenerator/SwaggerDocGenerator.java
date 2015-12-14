package com.kim.docGenerator;
  
import java.lang.reflect.Field; 
import java.util.Map; 

import com.kim.model.SwaggerField; 
import com.kim.utils.SwaggerUtils;

/**
 * Class that will take an object, and generate a json string which can be used 
 * for Swagger documentation of the object. 
 */
public class SwaggerDocGenerator {

	public static void main(String[] args){
		
		
		// the first argument will be the name of the class we want to document,
		// for example com.kim.model.Car
		if(args.length == 0){
			System.out.println(" Please enter a class name "); 
			System.exit(0);
		}
		String className = args[0]; 
		
		try {

			Class<?> myObjectClass = Class.forName(className);

			// use reflection to get the declared fields of the object
			Field[] fields = myObjectClass.getDeclaredFields();

			// build a map where the key = the field name, and value is a SwaggerField object, which
			// encapsulates all of the values needed to document the field
			Map<String, SwaggerField> objectFieldMap = SwaggerUtils.buildSwaggerFieldMap(fields);

			// build a json string representation of the object in Swagger friendly format
			String swaggerJsonStr = SwaggerUtils.buildSwaggerJson(className, objectFieldMap);

			// output the json
			System.out.println("results : ");
			System.out.println(swaggerJsonStr);
		} catch (ClassNotFoundException e) { 
			System.out.println(" Unable to load class " + className); 
		} 
	}
}
