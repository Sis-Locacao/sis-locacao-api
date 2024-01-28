package com.sislocacao.api.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.sislocacao.api.exceptions.impl.AuthorizationException;
import com.sislocacao.api.exceptions.impl.DataIntegrityViolationExceptionApp;
import com.sislocacao.api.exceptions.impl.ResourceNotFoundException;
import com.sislocacao.api.exceptions.impl.SisLocacaoException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> entityNotFound(ResourceNotFoundException exception, HttpServletRequest request){
		StandardError err = new StandardError();
		err.setTimestamp(Instant.now());
		err.setStatus(HttpStatus.NOT_FOUND.value());
		err.setError("Recurso não encontrado.");
		err.setMessage(exception.getMessage());
		err.setPath(request.getRequestURI());

		return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(err);
	}
	
	@ExceptionHandler(DataIntegrityViolationExceptionApp.class)
	public ResponseEntity<StandardError> conflictException(DataIntegrityViolationExceptionApp exception,  HttpServletRequest request){
		StandardError err = new StandardError();
		err.setTimestamp(Instant.now());
		err.setStatus(HttpStatus.CONFLICT.value());
		err.setError("Conflito.");
		err.setMessage(exception.getMessage());
		err.setPath(request.getRequestURI());

		return ResponseEntity.status(HttpStatus.CONFLICT.value()).body(err);
	}
	
	@ExceptionHandler(SisLocacaoException.class)
	public ResponseEntity<StandardError> sisLocacaoException(SisLocacaoException exception,  HttpServletRequest request){
		StandardError err = new StandardError();
		err.setTimestamp(Instant.now());
		err.setStatus(HttpStatus.UNPROCESSABLE_ENTITY.value());
		err.setError("Entidade Não Processável.");
		err.setMessage(exception.getMessage());
		err.setPath(request.getRequestURI());

		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY.value()).body(err);
	}
	
	@ExceptionHandler(AuthorizationException.class)
	public ResponseEntity<StandardError> authorization(AuthorizationException exception, HttpServletRequest request){
		StandardError err = new StandardError();
		err.setTimestamp(Instant.now());
		err.setStatus(HttpStatus.FORBIDDEN.value());
		err.setError("Não autorizado.");
		err.setMessage(exception.getMessage());
		err.setPath(request.getRequestURI());

		return ResponseEntity.status(HttpStatus.FORBIDDEN.value()).body(err);
	}
}
