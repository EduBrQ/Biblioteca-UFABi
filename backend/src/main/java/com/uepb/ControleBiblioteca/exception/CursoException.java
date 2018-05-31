package com.uepb.ControleBiblioteca.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CursoException extends RuntimeException {
	
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CursoException(String message) {
	        super(message);
	    }
	
}