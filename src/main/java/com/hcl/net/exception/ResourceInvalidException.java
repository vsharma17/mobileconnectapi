package com.hcl.net.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ResourceInvalidException extends RuntimeException{
	 public ResourceInvalidException() {
	        super();
	    }
	    public ResourceInvalidException(String message, Throwable cause) {
	        super(message, cause);
	    }
	    public ResourceInvalidException(String message) {
	        super(message);
	    }
	    public ResourceInvalidException(Throwable cause) {
	        super(cause);
	    }
}
