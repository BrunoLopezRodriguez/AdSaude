package com.bruno.adsaude.exception;

public class ServiceException extends AdSaudeException{

	public ServiceException() {
		
	}
	
	public ServiceException (String message) {
		super(message);
	}

	public ServiceException (Throwable cause) {
		super(cause);
	}

	
	public ServiceException (String mesage, Throwable cause) {
		super(mesage, cause);
	}
}
