package com.academia.springboot.crud.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmpleadoRestExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<EmpladoErrorResponse> handleException(EmpleadoNotFoundException exc) {
		EmpladoErrorResponse error = new EmpladoErrorResponse(
											HttpStatus.NOT_FOUND.value(),
											exc.getMessage(),
											System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<EmpladoErrorResponse> handleException(Exception exc) {
		EmpladoErrorResponse error = new EmpladoErrorResponse(
											HttpStatus.BAD_REQUEST.value(),
											exc.getMessage(),
											System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
}





