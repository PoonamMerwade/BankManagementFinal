package com.cts.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AccountException extends ResponseEntityExceptionHandler {
	@ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorResponse> handleAllExceptions(Exception ex, WebRequest request) {
        List<String> account = new ArrayList<>();
        account.add(ex.getLocalizedMessage());
        ErrorResponse error = new ErrorResponse("Account Not Found with that username", account);
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
 
    @ExceptionHandler(AccountNotFoundException.class)
    public final ResponseEntity<ErrorResponse> handleUserNotFoundException(AccountNotFoundException ex, WebRequest request) {
        List<String> account = new ArrayList<>();
        account.add(ex.getLocalizedMessage());
        ErrorResponse error = new ErrorResponse("Account Not Found with that username", account);
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
} 


