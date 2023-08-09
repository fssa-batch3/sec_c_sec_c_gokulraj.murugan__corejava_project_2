package com.fssa.bitwallet.validator;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.bitwallet.errors.CurrencyValidatorErrors;
import com.fssa.bitwallet.errors.InvalidInputException;
import com.fssa.bitwallet.model.Currency;
import com.fssa.bitwallet.validtor.CurrencyValidator;

public class TestCurrencyValidator {

	Currency curr = new Currency(1, "Bitcoin", "BTC", 1, 1.0, 1, 1, 1, 1, 1, 2, LocalDate.of(2005, 3, 4));
	Currency inValidCurrency = new Currency(-3, null, null, -2, -4, -2, -40, -420, -230, -1, -9,
			LocalDate.of(2025, 3, 4));

	@Test
	public void testValidate() throws InvalidInputException, IllegalArgumentException {
		Assertions.assertTrue(CurrencyValidator.validate(curr));
	}

	@Test
	public void testNullCurrencyValidate() {
		Currency currrencynull = null;
		try {
			CurrencyValidator.validate(currrencynull);
			Assertions.fail("Test case failed");

		} catch (InvalidInputException e) {
			Assertions.assertEquals(CurrencyValidatorErrors.INVALID_CURRENCY_NULL, e.getMessage());
		}
	}

	@Test
	public void testValidateId() throws Exception {

		curr.setId(curr.getId());
		Assertions.assertTrue(CurrencyValidator.validateId(curr.getId()));

	}

	@Test
	public void testNegativeValidatId() {
		try {
			CurrencyValidator.validateId(inValidCurrency.getId());
			Assertions.fail("Test case failed");
		} catch (InvalidInputException e) {
			Assertions.assertEquals(CurrencyValidatorErrors.INVALID_ID, e.getMessage());
		}

	}

	@Test
	public void testValidateRank() throws Exception {

		curr.setRank(curr.getRank());
		Assertions.assertTrue(CurrencyValidator.validateRank(curr.getRank()));

	}

	@Test
	public void testNegativeValidatRank() {
		try {
			CurrencyValidator.validateRank(inValidCurrency.getRank());
			Assertions.fail("Test case failed");
		} catch (InvalidInputException e) {
			Assertions.assertEquals(CurrencyValidatorErrors.INVALID_RANK, e.getMessage());
		}

	}

	@Test
	public void testValidatePrice() throws Exception {

		curr.setPrice(curr.getPrice());
		Assertions.assertTrue(CurrencyValidator.validatePrice(curr.getPrice()));
	}

	@Test
	public void testNegativeValidatPrice() {
		try {
			CurrencyValidator.validatePrice(inValidCurrency.getPrice());
			Assertions.fail("Test case failed");
		} catch (InvalidInputException e) {
			Assertions.assertEquals(CurrencyValidatorErrors.INVALID_PRICE, e.getMessage());
		}

	}

	@Test
	public void testValidateMarketCap() throws Exception {

		curr.setMarketCap(curr.getMarketCap());
		Assertions.assertTrue(CurrencyValidator.validateMarketCap(curr.getMarketCap()));
	}

	@Test
	public void testNegativeValidatMarketCap() {
		try {
			CurrencyValidator.validateMarketCap(inValidCurrency.getMarketCap());
			Assertions.fail("Test case failed");
		} catch (InvalidInputException e) {
			Assertions.assertEquals(CurrencyValidatorErrors.INVALID_MARKET_CAP, e.getMessage());
		}

	}

	@Test
	public void testValidateTotalSupply() throws Exception {

		curr.setTotalSupply(curr.getTotalSupply());
		Assertions.assertTrue(CurrencyValidator.validateTotalSupply(curr.getTotalSupply()));
	}

	@Test
	public void testNegativeValidateTotalSupply() {
		try {
			CurrencyValidator.validateTotalSupply(inValidCurrency.getTotalSupply());

			Assertions.fail("Test case failed");

		} catch (InvalidInputException e) {
			Assertions.assertEquals(CurrencyValidatorErrors.INVALID_TOTAL_SUPPLY, e.getMessage());
		}

	}

	@Test
	public void testValidateMaximumSupply() throws Exception {

		curr.setMaximumSupply(curr.getMaximumSupply());
		Assertions.assertTrue(CurrencyValidator.validateMaximumSupply(curr.getMaximumSupply()));
	}

	@Test
	public void testNegativeValidatMaximumSupply() {
		try {
			CurrencyValidator.validateMaximumSupply(inValidCurrency.getMaximumSupply());
			Assertions.fail("Test case failed");
		} catch (InvalidInputException e) {
			Assertions.assertEquals(CurrencyValidatorErrors.INVALID_MAXIMUM_SUPPLY, e.getMessage());
		}

	}

	@Test
	public void testValidateVolume24h() throws Exception {

		curr.setVolume24h(curr.getVolume24h());
		Assertions.assertTrue(CurrencyValidator.validateVolume24h(curr.getVolume24h()));
	}

	@Test
	public void testNegativeValidateVolume24h() {
		try {
			CurrencyValidator.validateVolume24h(inValidCurrency.getVolume24h());
			Assertions.fail("Test case failed");
		} catch (InvalidInputException e) {
			Assertions.assertEquals(CurrencyValidatorErrors.INVALID_VOLUME_24H, e.getMessage());
		}
	}

	@Test
	public void testValidateAllTimeHigh() throws Exception {

		curr.setAllTimeHigh(curr.getAllTimeHigh());
		Assertions.assertTrue(CurrencyValidator.validateAllTimeHigh(curr.getAllTimeHigh()));
	}

	@Test
	public void testNegativeValidateAllTimeHigh() {
		try {
			CurrencyValidator.validateAllTimeHigh(inValidCurrency.getAllTimeHigh());
			Assertions.fail("Test case failed");
		} catch (InvalidInputException e) {
			Assertions.assertEquals(CurrencyValidatorErrors.INVALID_All_TIME_HIGH, e.getMessage());
		}
	}

	@Test
	public void testValidateAllTimeLow() throws Exception {

		curr.setAllTimeLow(curr.getAllTimeLow());
		Assertions.assertTrue(CurrencyValidator.validateAllTimeLow(curr.getAllTimeLow()));
	}

	@Test
	public void testNegativeValidateAllTimeLow() {
		try {

			CurrencyValidator.validateAllTimeLow(inValidCurrency.getAllTimeLow());
			Assertions.fail("Test case failed");
		} catch (InvalidInputException e) {
			Assertions.assertEquals(CurrencyValidatorErrors.INVALID_All_TIME_LOW, e.getMessage());
		}
	}

	@Test
	public void testValidateName() throws Exception {

		curr.setName(curr.getName());
		Assertions.assertTrue(CurrencyValidator.validateName(curr.getName()));
	}

	@Test
	public void testNullValidateName() {
		try {
			CurrencyValidator.validateName(inValidCurrency.getName());
			Assertions.fail("Test case failed");
		} catch (InvalidInputException e) {
			Assertions.assertEquals(CurrencyValidatorErrors.INVALID_NAME, e.getMessage());
		}
	}

	@Test
	public void testInvalidName() {
		try {
			CurrencyValidator.validateName("fjeii32joi");
			Assertions.fail("Test case failed");
		} catch (InvalidInputException e) {
			Assertions.assertEquals(CurrencyValidatorErrors.INVALID_NAME_PATTERN, e.getMessage());
		}
	}

	@Test
	public void testValidateSymbol() throws Exception {
		curr.setSymbol(curr.getSymbol());
		Assertions.assertTrue(CurrencyValidator.validateSymbol(curr.getSymbol()));

	}

	@Test
	public void testNullValidateSymbol() {
		try {
			CurrencyValidator.validateSymbol(inValidCurrency.getSymbol());
			Assertions.fail("Test case failed");
		} catch (InvalidInputException e) {
			Assertions.assertEquals(CurrencyValidatorErrors.INVALID_SYMBOL, e.getMessage());
		}
	}

	@Test
	public void testInvalidSymbol() {
		try {
			CurrencyValidator.validateSymbol("btc");
			Assertions.fail("Test case failed");
		} catch (InvalidInputException e) {
			Assertions.assertEquals(CurrencyValidatorErrors.INVALID_SYMBOL_PATTERN, e.getMessage());
		}
	}

	@Test
	public void testValidateCreationDate() throws Exception {

		curr.setCreationDate(curr.getCreationDate());
		Assertions.assertTrue(CurrencyValidator.validateCreationDate(curr.getCreationDate()));

	}

	@Test
	public void testNullValidateDate() {
		try {
			CurrencyValidator.validateCreationDate(null);
			Assertions.fail("Test case failed");
		} catch (InvalidInputException e) {
			Assertions.assertEquals(CurrencyValidatorErrors.INVALID_DATE_NULL, e.getMessage());
		}
	}

	@Test
	public void testInValidateDate() {
		try {
			CurrencyValidator.validateCreationDate(inValidCurrency.getCreationDate());
			Assertions.fail("Test case failed");
		} catch (InvalidInputException e) {
			Assertions.assertEquals(CurrencyValidatorErrors.INVALID_DATE_FORMAT, e.getMessage());
		}
	}
}
