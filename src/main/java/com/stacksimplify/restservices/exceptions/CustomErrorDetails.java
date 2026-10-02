package com.stacksimplify.restservices.exceptions;

import java.util.Date;

public class CustomErrorDetails {
	
	private Date timestamp;
	private String message;
	private String errordetils;
	public CustomErrorDetails(Date timestamp, String message, String errordetils) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.errordetils = errordetils;
	}
	
	public Date getTimestamp() {
		return timestamp;
	}
	public String getMessage() {
		return message;
	}
	public String getErrordetils() {
		return errordetils;
	}
	
	

}
