package com.bank.account.GlobalException;



import java.util.HashMap;
import java.util.List;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {
	
	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<?> nullExceptionHandler(NullPointerException ex)
	{
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(AccountNotFoundException.class)
	public ResponseEntity<?> accountNotfoundHandler(AccountNotFoundException ex)
	{
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handler(MethodArgumentNotValidException ex)
	{
		List<ObjectError> allErrors = ex.getBindingResult().getAllErrors();
		
		HashMap<String, String>hashmap = new HashMap<>();
		
		for(ObjectError error: allErrors)
		{
		   String field = ((FieldError)error).getField();
			String defaultMesage = error.getDefaultMessage();
		    hashmap.put(field, defaultMesage);
		}
		return new ResponseEntity<>(hashmap,HttpStatus.BAD_REQUEST);
	}

}
