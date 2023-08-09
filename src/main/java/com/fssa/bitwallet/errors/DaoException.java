package com.fssa.bitwallet.errors;

public class DaoException extends Exception{

	private static final long serialVersionUID = -8105491977357554060L;

	// Calling each super constructors for each of the types
	public DaoException(String msg) {
			super(msg);
		}

}
