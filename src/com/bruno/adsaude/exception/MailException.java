package com.bruno.adsaude.exception;

public class MailException extends ServiceException{

	public MailException() {
		
	}
	
	public MailException (String message) {
		super(message);
	}

	public MailException (Throwable cause) {
		super(cause);
	}

	
	public MailException (String mesage, Throwable cause) {
		super(mesage, cause);
	}
	
}
