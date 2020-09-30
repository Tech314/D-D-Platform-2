package com.tech314.DDDataService.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandler {

	@ExceptionHandler(Throwable.class)
	public ResponseEntity<ErrorResponse> handleAnyException(Throwable t) {
		ErrorResponse response = new ErrorResponse("internal_server_error",
				"We are currently experiencing issues with our servers, please try again later");
		return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(DnDException.class)
	public ResponseEntity<ErrorResponse> handleDnDException(DnDException e) {
		ErrorResponse response = new ErrorResponse(e.getErrorType(), e.getMessage());
		return new ResponseEntity<>(response, e.getErrorCode());
	}
}

class ErrorResponse {
	String error;
	String error_description;
	
	ErrorResponse() {}
	
	ErrorResponse(String error, String error_description) {
		this.error = error;
		this.error_description = error_description;
	}
}
