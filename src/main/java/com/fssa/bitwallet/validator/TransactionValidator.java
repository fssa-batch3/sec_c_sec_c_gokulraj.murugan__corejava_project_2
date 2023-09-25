package com.fssa.bitwallet.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.bitwallet.errors.CurrencyValidatorErrors;
import com.fssa.bitwallet.errors.InvalidInputException;
import com.fssa.bitwallet.model.Transaction;

public class TransactionValidator {

	public static boolean validate(Transaction trans) throws InvalidInputException, IllegalArgumentException {

		if (trans == null) {
			throw new InvalidInputException(CurrencyValidatorErrors.INVALID_CURRENCY_NULL);
		}

		validateAmount(trans.getAmount());
		validateQuantity(trans.getQuantity());

		return true;

	}

	public static boolean validateTransactionType(String name) throws InvalidInputException, IllegalArgumentException {

		if (name == null || name.trim().equals("")) {
			throw new InvalidInputException(CurrencyValidatorErrors.INVALID_NAME);
		}

		String regex = "^[a-zA-Z]{3,20}+$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(name);
		Boolean isMatch = matcher.matches();

		if (Boolean.FALSE.equals(isMatch)) {
			throw new InvalidInputException(CurrencyValidatorErrors.INVALID_NAME_PATTERN);
		}

		return true;
	}

	public static boolean validateAmount(double amount) throws InvalidInputException, IllegalArgumentException {

		if (amount <= 0) {
			throw new InvalidInputException(CurrencyValidatorErrors.INVALID_NAME);
		}
		return true;
	}

	public static boolean validateQuantity(double quantity) throws InvalidInputException, IllegalArgumentException {

		if (quantity <= 0) {
			throw new InvalidInputException(CurrencyValidatorErrors.INVALID_NAME);
		}
		return true;
	}

}
