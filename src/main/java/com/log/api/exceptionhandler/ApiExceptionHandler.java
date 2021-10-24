package com.log.api.exceptionhandler;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.log.domain.exceptions.EntityNotFoundException;
import com.log.domain.exceptions.Exceptions;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler{
	
	MessageSource messageSource;

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		List<Error.Field> fields = new ArrayList<>();
		
		for (ObjectError forError : ex.getBindingResult().getAllErrors()) {
			String name = ((FieldError) forError).getField();
			String msg = messageSource.getMessage(forError, LocaleContextHolder.getLocale());
			
			fields.add(new Error.Field(name, msg));
		}
		
		Error error = new Error();
		
		error.setStatus(status.value());
		error.setDateHour(OffsetDateTime.now());
		error.setTitle("Um ou mais campos estão inválidos.");
		error.setFields(fields);
		
		return handleExceptionInternal(ex, error, headers, status, request);
	}
	
	@ExceptionHandler(Exceptions.class)
	public ResponseEntity<Object> handleError(Exceptions ex, WebRequest request){
		HttpStatus status = HttpStatus.BAD_REQUEST;
		
		Error error = new Error();
		
		error.setStatus(status.value());
		error.setDateHour(OffsetDateTime.now());
		error.setTitle(ex.getMessage());
		
		return handleExceptionInternal(ex, error, new HttpHeaders(), status, request);
	}
	
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<Object> handleEntityNotFound(EntityNotFoundException ex, WebRequest request){
		HttpStatus status = HttpStatus.NOT_FOUND;
		
		Error error = new Error();
		
		error.setStatus(status.value());
		error.setDateHour(OffsetDateTime.now());
		error.setTitle(ex.getMessage());
		
		return handleExceptionInternal(ex, error, new HttpHeaders(), status, request);
	}
}
