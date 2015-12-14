# swagger-doc-generator
Automatically build swagger friendly json from existing java class files


## Synopsis

The Swagger framework provides a documentation tool which will document API's.  The tool requires the user to provide a son file to describe the service.  This project allows you to take a java object from your project, drop it into the file structure of this project, and after building, run the program and output swagger friendly json representation of the object.

## Code Example

The class name of the object you would like to document must be fed it as a command line argument.

An instance of the object is instantiated and inspected using reflection, the output of the program is a string representation of the object in json format.


```			
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
```

## Motivation

This project was created with time saving in mind.  Documenting Rest services with Swagger can be a task which takes a lot of time.  You need a specific json format for the documentation to work.  The Swagger documentation of a rest service will require the description of input and output objects of the service.  This project will let you automatically create snippets of json for these objects that can be plugged into your overall rest service swagger document.

## Installation

* Download the project.  
* Copy the file(s) that you want to process into the com.kim.model package.  
* Build the project using the command mvn clean install
* Run the project by using the command   java -jar swaggerJsonGen-1.0.0-SNAPSHOT.jar <path/to/classname>
  * example java -jar swaggerJsonGen-1.0.0-SNAPSHOT.jar com.kim.Car
* output of program :
```
{
	"com.kim.model.Car": {
		"properties": {
			"color": {
				"type": "string",
				"description": "Color of the car."
			},
			"hybrid": {
				"type": "boolean",
				"description": "Boolean indicator that this car is a hybrid."
			},
			"make": {
				"type": "string",
				"description": "Make of the car"
			},
			"model": {
				"type": "string",
				"description": "Model of the car"
			},
			"year": {
				"type": "integer",
				"description": "Year that the car was built"
			}
		}
	}
}
```

If you want to populate the description field, you will need to edit your java object file and annotate each field with the description text as shown below.
```
@SwaggerFieldAnnotation(fieldDescription = "Color of the car.")
``` 
