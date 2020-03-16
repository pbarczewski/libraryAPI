package com.pbarczewski.exception;

/**
 * 
 * @author Patryk
 * @version 0.0.1-SNAPSHOT 05/05/2019
 */
public class ISBNErrorResponse {
	
	private int status;
	private String message;
	private long timeStamp;
	
	public ISBNErrorResponse() {
		
	}

	public ISBNErrorResponse(int status, String message, long timeStamp) {

		this.status = status;
		this.message = message;
		this.timeStamp = timeStamp;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	
	
	

}
