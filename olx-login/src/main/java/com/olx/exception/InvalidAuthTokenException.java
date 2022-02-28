package com.olx.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidAuthTokenException extends RuntimeException{
	private String message;

	public InvalidAuthTokenException() {
		super();
	}

	public InvalidAuthTokenException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String toString() {
		return "Invalid Stock Auth Token" + message;
	}
	
	

}
