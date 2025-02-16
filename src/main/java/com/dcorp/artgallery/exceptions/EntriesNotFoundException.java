package com.dcorp.artgallery.exceptions;

public class EntriesNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public EntriesNotFoundException(String message) {
		super(message);
	}

}