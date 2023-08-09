package com.fssa.bitwallet.errors;

public class InvalidInputException extends Exception {

	private static final long serialVersionUID = -8105491977357554060L;

	// Calling each super constructors for each of the types
	public InvalidInputException(String msg) {
		super(msg);
	}


}
