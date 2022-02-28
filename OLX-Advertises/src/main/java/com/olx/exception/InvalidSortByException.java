package com.olx.exception;

public class InvalidSortByException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private String message;
	
	public InvalidSortByException() {
		super();
		this.message = "";
	}

	public InvalidSortByException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String toString() {
		return "Invalid SortBy : " + message;
	}
}
