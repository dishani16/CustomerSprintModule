package com.cg.main.exception;
/**
 * @author DISHANI BASAK
 *Exception class that handles all the exception raised by the online customer management
 */
@SuppressWarnings("serial")
public class CustomerNotFoundException extends RuntimeException {
	public CustomerNotFoundException() {

	}

	public CustomerNotFoundException(String message) {
		super(message);
	}
}
