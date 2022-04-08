package com.bruno.adsaude.exception;

public class UserAlreadyExistsException extends DataException{

	public UserAlreadyExistsException() {

	}

	public UserAlreadyExistsException(String mesage) {
		super(mesage);
	}

	public UserAlreadyExistsException(Throwable cause) {
		super(cause);
	}
	public UserAlreadyExistsException(String mesage, Throwable cause) {
		super(mesage, cause);
	}
}
