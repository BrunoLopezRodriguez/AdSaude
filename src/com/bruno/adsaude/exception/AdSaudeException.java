package com.bruno.adsaude.exception;

public class AdSaudeException extends Exception{
	

	public AdSaudeException() {
		
	}

	public AdSaudeException(String mesage) {
		super(mesage);
	}
	
	public AdSaudeException(Throwable cause) {
		super(cause);
	}
	
	public AdSaudeException(String mesage, Throwable cause) {
		super(mesage, cause);
	}
}
