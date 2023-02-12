package com.spring.project.exceptions;

public class ResourceNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7952083546418599173L;
	private String resourceName;
	private String resourceField;
	private Long resourceFieldValue;

	public ResourceNotFoundException(String resourceName, String resourceField, Long resourceFieldValue) {
		super(String.format("%s is not exist with %s : %s", resourceName, resourceField, resourceFieldValue));
		this.resourceName = resourceName;
		this.resourceField = resourceField;
		this.resourceFieldValue = resourceFieldValue;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public ResourceNotFoundException() {
		super();
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public String getResourceField() {
		return resourceField;
	}

	public void setResourceField(String resourceField) {
		this.resourceField = resourceField;
	}

	public Long getResourceFieldValue() {
		return resourceFieldValue;
	}

	public void setResourceFieldValue(Long resourceFieldValue) {
		this.resourceFieldValue = resourceFieldValue;
	}

}
