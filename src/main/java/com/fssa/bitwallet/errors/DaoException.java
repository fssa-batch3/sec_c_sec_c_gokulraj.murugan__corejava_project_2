package com.fssa.bitwallet.errors;

/**
 * The DaoException class represents an exception that may occur during Data
 * Access Object (DAO) operations.
 */
public class DaoException extends Exception {

	private static final long serialVersionUID = -8105491977357554060L;

	/**
	 * Constructs a new DaoException with the specified detail message.
	 *
	 * @param msg The detail message describing the exception.
	 */
	public DaoException(String msg) {
		super(msg);
	}
}
