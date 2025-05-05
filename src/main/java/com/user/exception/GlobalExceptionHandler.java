package com.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.user.dto.GeneralResponseDTO;

public class GlobalExceptionHandler {
	@ExceptionHandler(InvalidCredentialsException.class)
	public ResponseEntity<GeneralResponseDTO> handleInvalidCredentialsException(InvalidCredentialsException ex) {
		/*
		 * Create a response with the exception message and an empty string for
		 * additional information
		 */
		GeneralResponseDTO responseDTO = new GeneralResponseDTO(ex.getMessage(), "");
		// Return ResponseEntity with UNAUTHORIZED status
		return new ResponseEntity<GeneralResponseDTO>(responseDTO, HttpStatus.UNAUTHORIZED);
	}

}
