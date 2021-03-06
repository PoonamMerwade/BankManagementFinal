package com.cts.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.NOT_FOUND)
public class FundNotFoundException extends RuntimeException{
	public FundNotFoundException(String exception){
		super(exception);
	}

}
