package com.kim.test;
 
import java.lang.reflect.Field; 
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
 
import com.kim.model.SwaggerField;
import com.kim.model.Vegetable;
import com.kim.utils.SwaggerUtils;

public class SwaggerFieldMapTest {
 
	@Test
	public void tesMapBuilder() {
		Class<Vegetable> myObjectClass = Vegetable.class;

		// get the declared fields of the object 
		Field[] fields = myObjectClass.getDeclaredFields();
 
		Map<String, SwaggerField> objectFieldMap = SwaggerUtils.buildSwaggerFieldMap(fields);
		
		Assert.assertNotNull(objectFieldMap);
		if(objectFieldMap != null && !objectFieldMap.isEmpty()) {
			Assert.assertEquals(5, objectFieldMap.size());
			String key = objectFieldMap.keySet().iterator().next();
			Assert.assertEquals("averageWeight", key);
			SwaggerField field = objectFieldMap.get(key);
			Assert.assertEquals("Average weight in ounces per piece of vegetable", field.getDescription());
			Assert.assertEquals("integer",field.getType());
		}else {
			Assert.fail("Field Map is null or empty");
		}
		
	}
	
	@Test
	public void tesJsonBuilder() {
		Class<Vegetable> myObjectClass = Vegetable.class;

		// get the declared fields of the object 
		Field[] fields = myObjectClass.getDeclaredFields();
 
		Map<String, SwaggerField> objectFieldMap = SwaggerUtils.buildSwaggerFieldMap(fields);
		String jsonString = SwaggerUtils.buildSwaggerJson(myObjectClass.getName(), objectFieldMap);
		if(jsonString !=null && !jsonString.isEmpty()){
		System.out.println(jsonString); 
		Assert.assertTrue(jsonString.contains("com.kim.model.Vegetable"));
		Assert.assertTrue(jsonString.contains("\"description\": \"Average weight in ounces per piece of vegetable\""));
		Assert.assertTrue(jsonString.contains("\"type\": \"array\""));
		Assert.assertTrue(jsonString.contains("\"description\": \"Date of harvest\""));
		Assert.assertTrue(jsonString.contains("\"type\": \"string\"")); 
		} else {
			Assert.fail("json is null or empty");
		}
		
	}
}
