package com.kim.utils;
 
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import com.kim.annotations.SwaggerFieldAnnotation;
import com.kim.model.SwaggerField;

public class SwaggerUtils {

	/**
	 * Map where key = java data type, value = corresponding Swagger name of data type
	 */
	public static Map<String, String> javaToSwaggerMapper;
	
	static {
		javaToSwaggerMapper = new HashMap<String, String>();
		javaToSwaggerMapper.put("java.util.List", "array");
		javaToSwaggerMapper.put("java.util.Map", "array");
		javaToSwaggerMapper.put("java.util.Date", "string");
		javaToSwaggerMapper.put("java.lang.String", "string");
		javaToSwaggerMapper.put("int", "integer");
		javaToSwaggerMapper.put("long", "integer");
		javaToSwaggerMapper.put("float", "number");
		javaToSwaggerMapper.put("byte", "string");
		javaToSwaggerMapper.put("boolean", "boolean"); 
	}
	
	/**
	 * Given a list of object fields, build a map where the key = the field name, and value is a 
	 * SwaggerField object, which encapsulates all of the values needed to document the field
	 * @param fields
	 * @return Map<String, SwaggerField>
	 */
	public static Map<String, SwaggerField> buildSwaggerFieldMap(Field[] fields) {
		if (fields == null || fields.length == 0){
			// nothing to build
			return null;
		} 
		// use a tree map so that the keys will be sorted
		Map<String, SwaggerField> objectFieldMap = new TreeMap<String, SwaggerField>();

		System.out.println("fields size");
		System.out.println(fields.length); 
		for(Field field : fields){ 
			//

			System.out.println(field.getAnnotation(SwaggerFieldAnnotation.class));
			//
			String fieldClassType = field.getType().getName();
			String fieldName = field.getName();  
			SwaggerFieldAnnotation annot = field.getAnnotation(SwaggerFieldAnnotation.class);
			String fieldDescription = (annot == null ? "" : annot.fieldDescription());
			// get the 'swagger friendly' field type name
			String fieldType = javaToSwaggerMapper.get(fieldClassType);
			fieldType = (fieldType == null ? "" : fieldType);
			// build the object which will encapsulate all the information about this field
			SwaggerField swaggerField = new SwaggerField(fieldName, fieldType, fieldDescription);
			// put the swagger field in the map, keyed by the field name
			objectFieldMap.put(fieldName, swaggerField);
		}
		return objectFieldMap;
	}

	/**
	 * Given a map of SwaggerField objects, build a json string representation of the object
	 * @param className
	 * @param objectFieldMap
	 * @return
	 */
	public static String buildSwaggerJson(String className,
			Map<String, SwaggerField> objectFieldMap) {  
		if(objectFieldMap == null || objectFieldMap.isEmpty()){
			// nothing to build
			return null;
		}
		StringBuilder build = new StringBuilder();
		build.append("{\"");
		build.append(className);
		build.append("\": {");
		build.append(System.lineSeparator());
		build.append("\"properties\": {");

		Set<String> keySet = objectFieldMap.keySet();
		for(String key :keySet){
			build.append(System.lineSeparator()); 
			SwaggerField swaggerField = objectFieldMap.get(key);
			build.append("\"");
			build.append(swaggerField.getName());
			build.append("\": {");
			build.append(System.lineSeparator());
			build.append("    \"type\": \""); 
			build.append(swaggerField.getType());
			build.append("\",");
			build.append(System.lineSeparator());
			build.append("    \"description\": \"");
			build.append(swaggerField.getDescription());
			build.append("\"");
			build.append(System.lineSeparator());
			build.append("},"); 
		}
		// remove the last trailing comma
		build.deleteCharAt(build.length()-1);
		build.append("}}}");
		return build.toString();
	} 
    
}
