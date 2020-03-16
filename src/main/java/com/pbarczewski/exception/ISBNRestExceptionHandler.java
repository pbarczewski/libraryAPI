package com.pbarczewski.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 
 * @author Patryk
 * @version 0.0.1-SNAPSHOT 05/05/2019
 */
@ControllerAdvice
public class ISBNRestExceptionHandler {

	
	@ExceptionHandler
	public ResponseEntity<ISBNErrorResponse> handleException(CustomizeException e) {
		
		ISBNErrorResponse error = 
				new ISBNErrorResponse(HttpStatus.NOT_FOUND.value(), e.getMessage(), 
						System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ISBNErrorResponse> handleException(Exception e) {
		
		ISBNErrorResponse error = 
				new ISBNErrorResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage(), 
						System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
}
