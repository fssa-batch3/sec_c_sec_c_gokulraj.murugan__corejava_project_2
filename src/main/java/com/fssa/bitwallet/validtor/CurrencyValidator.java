package com.fssa.bitwallet.validtor;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.crypto.Cipher;

import com.fssa.bitwallet.errors.CurrencyValidatorErrors;
import com.fssa.bitwallet.errors.InvalidInputException;
import com.fssa.bitwallet.model.Currency;

public class CurrencyValidator {

	// Validate a object
	public static boolean validate(Currency currency) throws Exception {

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
	public static boolean validateId(int id) throws Exception {

		if (id <= 0) {
			throw new InvalidInputException(CurrencyValidatorErrors.INVALID_ID);
		}
		return true;
	}

	public static boolean validateName(String name) throws Exception {

		if (name == null || name.trim().equals("")) {
			throw new InvalidInputException(CurrencyValidatorErrors.INVALID_NAME);
		}

		String regex = "^[a-zA-Z]{3,20}+$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(name);
		Boolean isMatch = matcher.matches();

		if (!isMatch) {
			throw new InvalidInputException(CurrencyValidatorErrors.INVALID_NAME_PATTERN);
		}

		return true;
	}

	public static boolean validateSymbol(String symbol) throws Exception {

		if (symbol == null || symbol.trim().equals("")) {
			throw new InvalidInputException(CurrencyValidatorErrors.INVALID_SYMBOL);
		}

		String regex = "^[A-Z]{1,10}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(symbol);
		Boolean isMatch = matcher.matches();

		if (!isMatch) {
			throw new InvalidInputException(CurrencyValidatorErrors.INVALID_SYMBOL_PATTERN);
		}

		return true;
	}

	// Validation for Rank
	public static boolean validateRank(int rank) throws Exception {
		if (rank <= 0) {
			throw new InvalidInputException(CurrencyValidatorErrors.INVALID_RANK);
		}
		return true;
	}

	// Validation for Price
	public static boolean validatePrice(double price) throws Exception {

		if (price <= 0) {
			throw new InvalidInputException(CurrencyValidatorErrors.INVALID_PRICE);
		}
		return true;
	}

	public static boolean validateMarketCap(double marketCap) throws Exception {

		if (marketCap <= 0) {
			throw new InvalidInputException(CurrencyValidatorErrors.INVALID_MARKET_CAP);
		}
		return true;
	}

	public static boolean validateTotalSupply(double totalSupply) throws Exception {

		if (totalSupply <= 0) {
			throw new InvalidInputException(CurrencyValidatorErrors.INVALID_TOTAL_SUPPLY);
		}
		return true;
	}

	public static boolean validateMaximumSupply(double maximumSupply) throws Exception {

		if (maximumSupply <= 0) {
			throw new InvalidInputException(CurrencyValidatorErrors.INVALID_MAXIMUM_SUPPLY);
		}
		return true;
	}

	public static boolean validateVolume24h(double volume24h) throws Exception {

		if (volume24h <= 0) {
			throw new InvalidInputException(CurrencyValidatorErrors.INVALID_VOLUME_24H);
		}
		return true;
	}

	public static boolean validateAllTimeHigh(double allTimeHigh) throws Exception {

		if (allTimeHigh <= 0) {
			throw new InvalidInputException(CurrencyValidatorErrors.INVALID_All_TIME_HIGH);
		}
		return true;
	}

	public static boolean validateAllTimeLow(double allTimeLow) throws Exception {

		if (allTimeLow <= 0) {
			throw new InvalidInputException(CurrencyValidatorErrors.INVALID_All_TIME_LOW);
		}
		return true;
	}

	public static boolean validateCreationDate(LocalDate date) throws Exception {

		LocalDate today = LocalDate.now();
		if (date == null) {
			throw new InvalidInputException(CurrencyValidatorErrors.INVALID_DATE_NULL);
		} else if (date.isAfter(today)) {
			throw new InvalidInputException(CurrencyValidatorErrors.INVALID_DATE_FORMAT);
		}
		return true;
	}

}
