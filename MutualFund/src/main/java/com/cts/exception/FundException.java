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
public class FundException extends ResponseEntityExceptionHandler {
	@ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorResponse> handleAllExceptions(Exception ex, WebRequest request) {
        List<String> fund = new ArrayList<>();
        fund.add(ex.getLocalizedMessage());
        ErrorResponse error = new ErrorResponse("fund Not Found for this user", fund);
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
 
    @ExceptionHandler(FundNotFoundException.class)
    public final ResponseEntity<ErrorResponse> handleUserNotFoundException(FundNotFoundException ex, WebRequest request) {
        List<String> fund = new ArrayList<>();
        fund.add(ex.getLocalizedMessage());
        ErrorResponse error = new ErrorResponse("Fund Not Found", fund);
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

}
