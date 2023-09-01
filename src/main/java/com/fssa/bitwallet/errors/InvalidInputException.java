package com.fssa.bitwallet.errors;

/**
 * The InvalidInputException class represents an exception that is thrown when
 * invalid input is encountered.
 */

public class InvalidInputException extends Exception {

	private static final long serialVersionUID = -8105491977357554060L;

	/**
	 * Constructs a new InvalidInputException with the specified detail message.
	 *
	 * @param msg The detail message describing the exception.
	 */
	public InvalidInputException(String msg) {
		super(msg);
	}
}
