package com.tech314.DDDataService.exceptions;

import org.springframework.http.HttpStatus;

public class DnDException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6808374822154566192L;
	
	private String errorType;
	private HttpStatus errorCode;
	
	public DnDException(String errorType, HttpStatus errorCode, String message) {
		super(message);
		this.errorType = errorType;
		this.errorCode = errorCode;
	}

	public String getErrorType() {
		return this.errorType;
	}
	
	public HttpStatus getErrorCode() {
		return this.errorCode;
	}
}
