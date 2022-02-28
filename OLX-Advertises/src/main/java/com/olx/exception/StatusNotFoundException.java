package com.olx.exception;

public class StatusNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private String message;
	
	public StatusNotFoundException() {
		super();
		this.message = "";
	}

	public StatusNotFoundException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String toString() {
		return "Status Not Found : " + message;
	}


}
