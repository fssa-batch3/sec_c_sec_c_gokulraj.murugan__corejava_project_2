package com.fssa.bitwallet.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.bitwallet.errors.CurrencyValidatorErrors;
import com.fssa.bitwallet.errors.InvalidInputException;
import com.fssa.bitwallet.model.Currency;

/**
 * The CurrencyValidator class provides methods for validating Currency objects
 * and their attributes.
 */

public class CurrencyValidator {

	/**
	 * Validates a Currency object.
	 *
	 * @param currency The Currency object to validate.
	 * @return true if the Currency object is valid, otherwise false.
	 * @throws InvalidInputException    If the Currency object is invalid.
	 * @throws IllegalArgumentException If invalid arguments are provided.
	 */
	public static boolean validate(Currency currency) throws InvalidInputException, IllegalArgumentException {

		if (currency == null) {
			throw new InvalidInputException(CurrencyValidatorErrors.INVALID_CURRENCY_NULL);
		}
		validateName(currency.getName());
		validateSymbol(currency.getSymbol());

		return true;
	}

	/**
	 * Validates a currency ID.
	 *
	 * @param id The currency ID to validate.
	 * @return true if the ID is valid, otherwise false.
	 * @throws InvalidInputException    If the ID is invalid.
	 * @throws IllegalArgumentException If an invalid argument is provided.
	 */
	public static boolean validateId(int id) throws InvalidInputException, IllegalArgumentException {

		if (id <= 0) {
			throw new InvalidInputException(CurrencyValidatorErrors.INVALID_ID);
		}
		return true;
	}

	/**
	 * Validates a currency name.
	 *
	 * @param name The currency name to validate.
	 * @return true if the name is valid, otherwise false.
	 * @throws InvalidInputException    If the name is invalid.
	 * @throws IllegalArgumentException If an invalid argument is provided.
	 */
	public static boolean validateName(String name) throws InvalidInputException, IllegalArgumentException {

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

	/**
	 * Validates a currency symbol.
	 *
	 * @param symbol The currency symbol to validate.
	 * @return true if the symbol is valid, otherwise false.
	 * @throws InvalidInputException    If the symbol is invalid.
	 * @throws IllegalArgumentException If an invalid argument is provided.
	 */
	public static boolean validateSymbol(String symbol) throws InvalidInputException, IllegalArgumentException {

		if (symbol == null || symbol.trim().equals("")) {
			throw new InvalidInputException(CurrencyValidatorErrors.INVALID_SYMBOL);
		}

		String regex = "^[A-Z]{1,10}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(symbol);
		Boolean isMatch = matcher.matches();

		if (Boolean.FALSE.equals(isMatch)) {
			throw new InvalidInputException(CurrencyValidatorErrors.INVALID_SYMBOL_PATTERN);
		}

		return true;
	}

	public static boolean isValidateProductImageLink(String url) throws InvalidInputException {
		/*
		 * Product Image URL Validation. If the product Image URL is Null or Empty It
		 * will throw the Exception.
		 */
		if (url == null || "".equals(url.trim())) {
			throw new InvalidInputException(CurrencyValidatorErrors.INVALID_LOGO_NULL);
		}
		/*
		 * Image URL Regex Pattern Validate Code
		 */
		boolean isMatch = Pattern.matches("(http)?s?:?(\\/\\/[^\"']*\\.(?:png|jpg|jpeg|gif|svg|webp))", url);
		/*
		 * If the patter is not Matched it will throw the Exception Otherwise it's True.
		 */
		if (!isMatch) {
			throw new InvalidInputException(CurrencyValidatorErrors.INVALID_LOGO_NULL);
		}
		return true;
	}
}
