package com.fydp.structure;

import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * Holds all HTTP response status messages
 * @author Anthony
 *
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class Metadata {
	private String errorType;
	int code;
	private String errorMessage;
	
	public Metadata(String errorType, int code, String errorMessage) {
		this.errorType = errorType;
		this.code = code;
		this.errorMessage = errorMessage;
	}
	
	public Metadata(int code) {
		this.code = code;
	}
	
	public String getErrorType() {
		return errorType;
	}
	
	public void setErrorType(String errorType) {
		this.errorType = errorType;
	}
	
	public int getCode() {
		return code;
	}
	
	public void setCode(int code) {
		this.code = code;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
