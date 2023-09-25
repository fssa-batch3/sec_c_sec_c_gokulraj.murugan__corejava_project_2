package com.fssa.bitwallet.validator;

import com.fssa.bitwallet.errors.CurrencyValidatorErrors;
import com.fssa.bitwallet.errors.InvalidInputException;
import com.fssa.bitwallet.model.Balance;

public class BalanceValidator {

	public static boolean validate(Balance balance) throws InvalidInputException, IllegalArgumentException {

		if (balance == null) {
			throw new InvalidInputException(CurrencyValidatorErrors.INVALID_CURRENCY_NULL);
		}
		validateBalance(balance.getBalance());
		
		return true;
	}

	
	public static boolean validateBalance(double balance) throws InvalidInputException, IllegalArgumentException {

		if (balance <= 0) {
			throw new InvalidInputException(CurrencyValidatorErrors.INVALID_ID);
		}
		return true;
	}

}
