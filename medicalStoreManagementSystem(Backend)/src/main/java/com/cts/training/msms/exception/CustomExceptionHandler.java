package com.cts.training.msms.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestController
@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest web) {
		ErrorResponse errorResponse=new ErrorResponse(new Date(), ex.getMessage(), web.getDescription(false));
		return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Object> handleUserNotFound(Exception ex, WebRequest web) {
		ErrorResponse errorResponse=new ErrorResponse(new Date(), ex.getMessage(), web.getDescription(false));
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}
	
	 @Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		 ErrorResponse errorResponse = new ErrorResponse(new Date(), "Validation Failed", ex.getBindingResult().toString());
		 return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
	}

}
