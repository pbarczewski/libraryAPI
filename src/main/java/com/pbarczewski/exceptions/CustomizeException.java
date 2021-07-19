package com.pbarczewski.exceptions;
/**
 * 
 * @author Patryk
 * @version 0.0.1-SNAPSHOT 05/05/2019
 */
public class CustomizeException extends RuntimeException {
	public CustomizeException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}
	
	public CustomizeException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}
	
	public CustomizeException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}
}
