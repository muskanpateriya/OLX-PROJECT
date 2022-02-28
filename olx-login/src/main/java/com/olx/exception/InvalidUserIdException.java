package com.olx.exception;

public class InvalidUserIdException extends RuntimeException {
		private String message;

		public InvalidUserIdException(String message) {
			super();
			this.message = message;
		}

		public InvalidUserIdException() {
			super();
			this.message="";
		}

		@Override
		public String toString() {
			return "InvalidStockIdException [message=" + message + "]";
		}
	}
