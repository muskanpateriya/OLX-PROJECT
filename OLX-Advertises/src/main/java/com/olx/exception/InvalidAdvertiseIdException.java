package com.olx.exception;

public class InvalidAdvertiseIdException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private String message;
	
	public InvalidAdvertiseIdException() {
		super();
		this.message = "";
	}

	public InvalidAdvertiseIdException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String toString() {
		return "Invalid AdvertiseId : " + message;
	}

}

