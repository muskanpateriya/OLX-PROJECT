package com.olx.exception;

public class InvalidOnDateException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private String message;
	
	public InvalidOnDateException() {
		super();
		this.message = "";
	}

	public InvalidOnDateException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String toString() {
		return "Invalid OnDate : " + message;
	}
}