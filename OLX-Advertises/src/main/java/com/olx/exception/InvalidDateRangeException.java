package com.olx.exception;

public class InvalidDateRangeException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private String message;
	
	public InvalidDateRangeException() {
		super();
		this.message = "";
	}

	public InvalidDateRangeException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String toString() {
		return "Invalid Date Range : " + message;
	}
}
