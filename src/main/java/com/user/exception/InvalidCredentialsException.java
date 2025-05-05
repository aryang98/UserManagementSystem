package com.user.exception;

public class InvalidCredentialsException extends RuntimeException {

	// Generated serialVersionUID to maintain serialization compatibility
	private static final long serialVersionUID = 1L;

	// Constructor for InvalidCredentialsException taking a message parameter.
	public InvalidCredentialsException(String message) {
		super(message);
	}
}

