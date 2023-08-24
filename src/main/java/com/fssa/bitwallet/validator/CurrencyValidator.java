package com.fssa.bitwallet.validator;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.bitwallet.constants.ValidatorConstants;
import com.fssa.bitwallet.errors.CurrencyValidatorErrors;
import com.fssa.bitwallet.errors.InvalidInputException;
import com.fssa.bitwallet.model.Currency;

public class CurrencyValidator {

	// Validate a object
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
		validateCreationDate(currency.getCreationDate());
		return true;
	}

	// Validation for Id
	public static boolean validateId(int id) throws InvalidInputException, IllegalArgumentException {

		if (id <= 0) {
			throw new InvalidInputException(CurrencyValidatorErrors.INVALID_ID);
		}
		return true;
	}

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

	// Validation for Rank
	public static boolean validateRank(int rank) throws InvalidInputException, IllegalArgumentException {
		if (rank <= ValidatorConstants.constants) {
			throw new InvalidInputException(CurrencyValidatorErrors.INVALID_RANK);
		}
		return true;
	}

	// Validation for Price
	public static boolean validatePrice(double price) throws InvalidInputException, IllegalArgumentException {

		if (price <= ValidatorConstants.constants) {
			throw new InvalidInputException(CurrencyValidatorErrors.INVALID_PRICE);
		}
		return true;
	}

	public static boolean validateMarketCap(double marketCap) throws InvalidInputException, IllegalArgumentException {

		if (marketCap <= ValidatorConstants.constants) {
			throw new InvalidInputException(CurrencyValidatorErrors.INVALID_MARKET_CAP);
		}
		return true;
	}

	public static boolean validateTotalSupply(double totalSupply)
			throws InvalidInputException, IllegalArgumentException {

		if (totalSupply <= ValidatorConstants.constants) {
			throw new InvalidInputException(CurrencyValidatorErrors.INVALID_TOTAL_SUPPLY);
		}
		return true;
	}

	public static boolean validateMaximumSupply(double maximumSupply)
			throws InvalidInputException, IllegalArgumentException {

		if (maximumSupply <= ValidatorConstants.constants) {
			throw new InvalidInputException(CurrencyValidatorErrors.INVALID_MAXIMUM_SUPPLY);
		}
		return true;
	}

	public static boolean validateVolume24h(double volume24h) throws InvalidInputException, IllegalArgumentException {

		if (volume24h <= ValidatorConstants.constants) {
			throw new InvalidInputException(CurrencyValidatorErrors.INVALID_VOLUME_24H);
		}
		return true;
	}

	public static boolean validateAllTimeHigh(double allTimeHigh)
			throws InvalidInputException, IllegalArgumentException {

		if (allTimeHigh <= ValidatorConstants.constants) {
			throw new InvalidInputException(CurrencyValidatorErrors.INVALID_All_TIME_HIGH);
		} 
		return true;
	}

	public static boolean validateAllTimeLow(double allTimeLow) throws InvalidInputException, IllegalArgumentException {

		if (allTimeLow <= ValidatorConstants.constants) {
			throw new InvalidInputException(CurrencyValidatorErrors.INVALID_All_TIME_LOW);
		}
		return true;
	}

	public static boolean validateCreationDate(LocalDate date) throws InvalidInputException, IllegalArgumentException {

		LocalDate today = LocalDate.now();
		if (date == null) {
			throw new InvalidInputException(CurrencyValidatorErrors.INVALID_DATE_NULL);
		} else if (date.isAfter(today)) {
			throw new InvalidInputException(CurrencyValidatorErrors.INVALID_DATE_FORMAT);
		}
		return true;
	}

}
