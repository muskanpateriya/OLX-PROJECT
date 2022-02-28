package com.olx.exception;

public class InvalidsUserNameException extends RuntimeException{
	private String message;

	public InvalidsUserNameException(String message) {
		super();
		this.message = message;
	}

	public InvalidsUserNameException() {
		super();
		this.message="";
	}

	@Override
	public String toString() {
		return "InvalidStockIdException [message=" + message + "]";
	} 

}
