package com.kim.model;

import com.kim.annotations.SwaggerFieldAnnotation;

public class Car {

	/**
	 * Make of the car
	 */
	@SwaggerFieldAnnotation(fieldDescription = "Make of the car")
	private String make;

	/**
	 * Model of the car
	 */
	@SwaggerFieldAnnotation(fieldDescription = "Model of the car")
	private String model;
	
	/**
	 * Year that the car was built
	 */
	@SwaggerFieldAnnotation(fieldDescription = "Year that the car was built")
	private int year;
	
	/**
	 * Color of the car.
	 */
	@SwaggerFieldAnnotation(fieldDescription = "Color of the car.")
	private String color;
	
	/**
	 * Boolean indicator that this car is a hybrid.
	 */
	@SwaggerFieldAnnotation(fieldDescription = "Boolean indicator that this car is a hybrid.")
	private boolean hybrid;

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public boolean isHybrid() {
		return hybrid;
	}

	public void setHybrid(boolean hybrid) {
		this.hybrid = hybrid;
	}
	
}
