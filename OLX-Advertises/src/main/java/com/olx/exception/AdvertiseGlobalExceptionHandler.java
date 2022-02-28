package com.olx.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AdvertiseGlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler({ InvalidAuthTokenException.class, CategoryNotFoundException.class,
			InvalidAdvertiseIdException.class, InvalidOnDateException.class, InvalidDateRangeException.class,
			InvalidSortByException.class, StatusNotFoundException.class,InvalidAuthTokenException.class,InvalidsUserNameException.class,
			InvalidUserIdException.class,})
	public ResponseEntity<Object> handleException(RuntimeException ex, WebRequest request) {

		return handleExceptionInternal(ex, "{\"error\": \"" + ex.toString() + "\"}", new HttpHeaders(),
				HttpStatus.BAD_REQUEST, request);

	}

}
