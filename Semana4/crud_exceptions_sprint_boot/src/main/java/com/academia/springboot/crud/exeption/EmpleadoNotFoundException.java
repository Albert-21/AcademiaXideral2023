package com.academia.springboot.crud.exeption;

public class EmpleadoNotFoundException extends RuntimeException {

	public EmpleadoNotFoundException() {
	}

	public EmpleadoNotFoundException(String message) {
		super(message);
	}

	public EmpleadoNotFoundException(Throwable cause) {
		super(cause);
	}

	public EmpleadoNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public EmpleadoNotFoundException(String message, Throwable cause, boolean enableSuppression,
									 boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
