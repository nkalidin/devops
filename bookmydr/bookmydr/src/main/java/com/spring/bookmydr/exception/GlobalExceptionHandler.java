package com.spring.bookmydr.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@RestController
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	// @ExceptionHandler(MethodArgumentNotValidException.class)

	@Override
	   protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,

	                 HttpHeaders headers, HttpStatus status, WebRequest request) {

		Map<String, String> errors = new HashMap<>();
	     ex.getBindingResult().getAllErrors().forEach((error) -> {
	         String fieldName = ((FieldError) error).getField();
	         String errorMessage = error.getDefaultMessage();
	         errors.put(fieldName, errorMessage);
	    });
	          return new ResponseEntity<>(errors, status);

	   }
}
