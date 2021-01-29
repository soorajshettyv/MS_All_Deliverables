package com.ms.cat.exception;

import java.sql.SQLDataException;

import javax.persistence.PersistenceException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ms.cat.model.ErrorResponse;



@ControllerAdvice
public class GenericExceptionHandler extends ResponseEntityExceptionHandler{
 
	@ExceptionHandler(SQLDataException.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	protected ErrorResponse handleSQLException(SQLDataException e)
	{
		ErrorResponse err = new ErrorResponse();
		err.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.toString());
		err.setMsg(e.getMessage());
		return err;
	}

	
	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ErrorResponse err = new ErrorResponse(HttpStatus.BAD_REQUEST.toString(),ex.getMessage() );
		return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST );
			}
	
	@ExceptionHandler(PersistenceException.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	protected ErrorResponse handlePersistenceException(PersistenceException e)
	{
		ErrorResponse err = new ErrorResponse();
		err.setStatus("DB Persistence Exception");
		err.setMsg(e.getMessage());
		return err;
	}
	
	@ExceptionHandler(NODataFoundException.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	protected ErrorResponse handleNoDataFoundException(NODataFoundException e)
	{
		ErrorResponse err = new ErrorResponse();
		err.setStatus(e.getError_code());
		err.setMsg(e.getError_msg());
		return err;
	}
	
	
	
	
}
