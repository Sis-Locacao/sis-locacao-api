package com.sislocacao.api.exceptions.impl;

public class DataIntegrityViolationExceptionApp extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public DataIntegrityViolationExceptionApp(String msg) {
		super(msg);
	}
}
