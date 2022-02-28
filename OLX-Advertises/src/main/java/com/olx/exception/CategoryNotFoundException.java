package com.olx.exception;

public class CategoryNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	private String message;
	
	public CategoryNotFoundException() {
		super();
		this.message = "";
	}

	public CategoryNotFoundException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String toString() {
		return "Category Not Found : " + message;
	}
	

}