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
		validateRank(currency.getRank());
		validatePrice(currency.getPrice());
		validateMarketCap(currency.getMarketCap());
		validateTotalSupply(currency.getTotalSupply());
		validateMaximumSupply(currency.getMaximumSupply());
		validateVolume24h(currency.getVolume24h());
		validateAllTimeHigh(currency.getAllTimeHigh());
		validateAllTimeLow(currency.getAllTimeLow());

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

	/**
	 * Validates the rank of a currency.
	 *
	 * @param rank The rank to validate.
	 * @return true if the rank is valid (greater than 0), otherwise false.
	 * @throws InvalidInputException    If the rank is invalid.
	 * @throws IllegalArgumentException If an invalid argument is provided.
	 */

	public static boolean validateRank(int rank) throws InvalidInputException, IllegalArgumentException {
		if (rank <= 0) {
			throw new InvalidInputException(CurrencyValidatorErrors.INVALID_RANK);
		}
		return true;
	}

	/**
	 * Validates the price of a currency.
	 *
	 * @param price The price to validate.
	 * @return true if the price is valid (greater than 0), otherwise false.
	 * @throws InvalidInputException    If the price is invalid.
	 * @throws IllegalArgumentException If an invalid argument is provided.
	 */
	public static boolean validatePrice(double price) throws InvalidInputException, IllegalArgumentException {

		if (price <= 0) {
			throw new InvalidInputException(CurrencyValidatorErrors.INVALID_PRICE);
		}
		return true;
	}

	/**
	 * Validates the market capitalization of a currency.
	 *
	 * @param marketCap The market capitalization to validate.
	 * @return true if the market capitalization is valid (greater than 0),
	 *         otherwise false.
	 * @throws InvalidInputException    If the market capitalization is invalid.
	 * @throws IllegalArgumentException If an invalid argument is provided.
	 */

	public static boolean validateMarketCap(double marketCap) throws InvalidInputException, IllegalArgumentException {

		if (marketCap <= 0) {
			throw new InvalidInputException(CurrencyValidatorErrors.INVALID_MARKET_CAP);
		}
		return true;
	}

	/**
	 * Validates the total supply of a currency.
	 *
	 * @param totalSupply The total supply to validate.
	 * @return true if the total supply is valid (greater than 0), otherwise false.
	 * @throws InvalidInputException    If the total supply is invalid.
	 * @throws IllegalArgumentException If an invalid argument is provided.
	 */

	public static boolean validateTotalSupply(double totalSupply)
			throws InvalidInputException, IllegalArgumentException {

		if (totalSupply <= 0) {
			throw new InvalidInputException(CurrencyValidatorErrors.INVALID_TOTAL_SUPPLY);
		}
		return true;
	}

	/**
	 * Validates the maximum supply of a currency.
	 *
	 * @param maximumSupply The maximum supply to validate.
	 * @return true if the maximum supply is valid (greater than 0), otherwise
	 *         false.
	 * @throws InvalidInputException    If the maximum supply is invalid.
	 * @throws IllegalArgumentException If an invalid argument is provided.
	 */
	public static boolean validateMaximumSupply(double maximumSupply)
			throws InvalidInputException, IllegalArgumentException {

		if (maximumSupply <= 0) {
			throw new InvalidInputException(CurrencyValidatorErrors.INVALID_MAXIMUM_SUPPLY);
		}
		return true;
	}

	/**
	 * Validates the 24-hour trading volume of a currency.
	 *
	 * @param volume24h The 24-hour trading volume to validate.
	 * @return true if the volume is valid (greater than 0), otherwise false.
	 * @throws InvalidInputException    If the 24-hour trading volume is invalid.
	 * @throws IllegalArgumentException If an invalid argument is provided.
	 */

	public static boolean validateVolume24h(double volume24h) throws InvalidInputException, IllegalArgumentException {

		if (volume24h <= 0) {
			throw new InvalidInputException(CurrencyValidatorErrors.INVALID_VOLUME_24H);
		}
		return true;
	}

	/**
	 * Validates the all-time high price of a currency.
	 *
	 * @param allTimeHigh The all-time high price to validate.
	 * @return true if the all-time high price is valid (greater than 0), otherwise
	 *         false.
	 * @throws InvalidInputException    If the all-time high price is invalid.
	 * @throws IllegalArgumentException If an invalid argument is provided.
	 */

	public static boolean validateAllTimeHigh(double allTimeHigh)
			throws InvalidInputException, IllegalArgumentException {

		if (allTimeHigh <= 0) {
			throw new InvalidInputException(CurrencyValidatorErrors.INVALID_All_TIME_HIGH);
		}
		return true;
	}

	/**
	 * Validates the all-time low price of a currency.
	 *
	 * @param allTimeLow The all-time low price to validate.
	 * @return true if the all-time low price is valid (greater than 0), otherwise
	 *         false.
	 * @throws InvalidInputException    If the all-time low price is invalid.
	 * @throws IllegalArgumentException If an invalid argument is provided.
	 */
	public static boolean validateAllTimeLow(double allTimeLow) throws InvalidInputException, IllegalArgumentException {

		if (allTimeLow <= 0) {
			throw new InvalidInputException(CurrencyValidatorErrors.INVALID_All_TIME_LOW);
		}
		return true;
	}

}
