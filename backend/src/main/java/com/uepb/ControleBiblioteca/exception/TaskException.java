package com.uepb.ControleBiblioteca.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class TaskException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	private String name;
	private Boolean done;
	private Object value;
	
	public TaskException(String name, Boolean done, Object value) {
		super(String.format("%s could not found %s: %s", name, done, value));
		
		this.setDone(done);
		this.setName(name);
		this.setValue(value);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public Boolean getDone() {
		return done;
	}

	public void setDone(Boolean done) {
		this.done = done;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}
	
	
}