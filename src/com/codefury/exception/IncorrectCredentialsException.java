package com.codefury.exception;

public class IncorrectCredentialsException extends Exception {

	public IncorrectCredentialsException(){
		super();
	}
	
	public IncorrectCredentialsException(String message) {
		super(message);
	}
}