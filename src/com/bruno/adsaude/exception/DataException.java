package com.bruno.adsaude.exception;

public class DataException extends AdSaudeException{

	public DataException() {
		
	}
	
	public DataException(String mesage) {
		super(mesage);
	}
	
	public DataException(Throwable cause) {
		super(cause);
	}
	public DataException(String mesage, Throwable cause) {
		super(mesage, cause);
	}
}
