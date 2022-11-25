package com.example.schoolRegistrationSystem.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class NotFoundExceptionHandler {
	
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<?> notFoundExcepiton(NotFoundException notFoundException){
		List<String> detail = new ArrayList<>();
		detail.add(notFoundException.getMessage());
		
		ErrorResponse errorResponse = new ErrorResponse("Not Found Exception", detail);
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}

}
