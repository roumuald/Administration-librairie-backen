package com.nnr.administrationBookApp.exception;

public class AdministrationBookException extends RuntimeException{

	/**
	 * exception class
	 */
	private static final long serialVersionUID = 1L;

	public AdministrationBookException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public AdministrationBookException(String message) {
		super(message);
		
	}
	
	

}
