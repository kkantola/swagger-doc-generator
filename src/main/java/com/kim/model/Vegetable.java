package com.kim.model;

import java.util.Date;
import java.util.List;

import com.kim.annotations.SwaggerFieldAnnotation;

public class Vegetable {

	/**
	 * Name of Vegetable, for example, Spinach, Squash, Cabbage.
	 */
	@SwaggerFieldAnnotation(fieldDescription = "Name of Vegetable")
	private String name;
	
	/**
	 * Average weight in ounces per piece of vegetable.
	 * For example, ounces per one head of cabbage.
	 */
	@SwaggerFieldAnnotation(fieldDescription = "Average weight in ounces per piece of vegetable")
	private int averageWeight;
	
	/**
	 * List of possible colors of vegetable.  For example, an apple can be red, yellow, green
	 */
	@SwaggerFieldAnnotation(fieldDescription = "List of possible colors of vegetable")
	private List<String> colors;
	
	/**
	 * Country of origin of Vegetable
	 */
	@SwaggerFieldAnnotation(fieldDescription = "Country of origin of Vegetable")
	private String origin;
	
	/**
	 * Date of harvest 
	 */
	@SwaggerFieldAnnotation(fieldDescription = "Date of harvest")
	private Date dateHarvested;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAverageWeight() {
		return averageWeight;
	}

	public void setAverageWeight(int averageWeight) {
		this.averageWeight = averageWeight;
	}

	public List<String> getColors() {
		return colors;
	}

	public void setColors(List<String> colors) {
		this.colors = colors;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public Date getDateHarvested() {
		return dateHarvested;
	}

	public void setDateHarvested(Date dateHarvested) {
		this.dateHarvested = dateHarvested;
	} 
	
}
