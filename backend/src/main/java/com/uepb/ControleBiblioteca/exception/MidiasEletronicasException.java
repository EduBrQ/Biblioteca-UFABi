package com.uepb.ControleBiblioteca.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class MidiasEletronicasException extends RuntimeException {
	
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MidiasEletronicasException(String message) {
	        super(message);
	    }
	
}