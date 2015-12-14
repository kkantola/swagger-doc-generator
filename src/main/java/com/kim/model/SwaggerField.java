package com.kim.model;

public class SwaggerField {

	/**
	 * Name of the field
	 */
	private String name;
	
	/**
	 * Type of field, for example, "string, date, boolean"
	 */
	private String type;
	
	/**
	 * Description of the field
	 */
	private String description;

	/**
	 * Constructor
	 * @param name
	 * @param type
	 * @param description
	 */
	public SwaggerField(String name, String type, String description){
		this.name = name;
		this.type = type;
		this.description = description;	
	}
	
	/**
	 * Default constructor
	 */
	public SwaggerField(){
		
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	} 
}
