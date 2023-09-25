package com.fssa.bitwallet.validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.bitwallet.errors.CurrencyValidatorErrors;
import com.fssa.bitwallet.errors.InvalidInputException;
import com.fssa.bitwallet.model.Currency;

/**
 * A test class for CurrencyValidator that validates the Currency validation
 * methods.
 */

public class TestCurrencyValidator {

	Currency curr = new Currency("Bitcoin", "BTC", "https://freeimage.host/i/JHmJBWX");

	Currency inValidCurrency = new Currency(null, null, null);

	/**
	 * Test the validate method with a valid Currency object.
	 *
	 * @throws InvalidInputException    If the validation fails.
	 * @throws IllegalArgumentException If an invalid argument is provided.
	 */

	@Test
	void testValidate() {

		try {
			Assertions.assertTrue(CurrencyValidator.validate(curr));
		} catch (IllegalArgumentException | InvalidInputException e) {

			e.printStackTrace();
		}

	}

	/**
	 * Test the validate method with a null Currency object.
	 */

	@Test
	void testNullCurrencyValidate() {
		Currency currrencynull = null;
		try {
			CurrencyValidator.validate(currrencynull);
			Assertions.fail("Test case failed");

		} catch (InvalidInputException e) {
			Assertions.assertEquals(CurrencyValidatorErrors.INVALID_CURRENCY_NULL, e.getMessage());
		}
	}

	@Test
	void testNegativeValidatId() {
		try {
			CurrencyValidator.validateId(inValidCurrency.getId());
			Assertions.fail("Test case failed");
		} catch (InvalidInputException e) {
			Assertions.assertEquals(CurrencyValidatorErrors.INVALID_ID, e.getMessage());
		}

	}

	/**
	 * Test the validateName method with a valid name.
	 *
	 * @throws InvalidInputException    If the validation fails.
	 * @throws IllegalArgumentException If an invalid argument is provided.
	 */

	@Test
	void testValidateName() throws Exception {

		curr.setName(curr.getName());
		Assertions.assertTrue(CurrencyValidator.validateName(curr.getName()));
	}

	/**
	 * Test the validateName method with a null name.
	 */
	@Test
	void testNullValidateName() {
		try {
			CurrencyValidator.validateName(inValidCurrency.getName());
			Assertions.fail("Test case failed");
		} catch (InvalidInputException e) {
			Assertions.assertEquals(CurrencyValidatorErrors.INVALID_NAME, e.getMessage());
		}
	}

	/**
	 * Test the validateName method with an invalid name pattern.
	 */

	@Test
	void testInvalidName() {
		try {
			CurrencyValidator.validateName("fjeii32joi");
			Assertions.fail("Test case failed");
		} catch (InvalidInputException e) {
			Assertions.assertEquals(CurrencyValidatorErrors.INVALID_NAME_PATTERN, e.getMessage());
		}
	}

	/**
	 * Test the validateSymbol method with a valid symbol.
	 *
	 * @throws InvalidInputException    If the validation fails.
	 * @throws IllegalArgumentException If an invalid argument is provided.
	 */

	@Test
	void testValidateSymbol() throws Exception {
		curr.setSymbol(curr.getSymbol());
		Assertions.assertTrue(CurrencyValidator.validateSymbol(curr.getSymbol()));

	}

	/**
	 * Test the validateSymbol method with a null symbol.
	 */

	@Test
	void testNullValidateSymbol() {
		try {
			CurrencyValidator.validateSymbol(inValidCurrency.getSymbol());
			Assertions.fail("Test case failed");
		} catch (InvalidInputException e) {
			Assertions.assertEquals(CurrencyValidatorErrors.INVALID_SYMBOL, e.getMessage());
		}
	}

	/**
	 * Test the validateSymbol method with an invalid symbol pattern.
	 */
	@Test
	void testInvalidSymbol() {
		try {
			CurrencyValidator.validateSymbol("btc");
			Assertions.fail("Test case failed");
		} catch (InvalidInputException e) {
			Assertions.assertEquals(CurrencyValidatorErrors.INVALID_SYMBOL_PATTERN, e.getMessage());
		}
	}

	@Test
	void testValidProductImageURLNull() {

		try {
			CurrencyValidator.isValidateProductImageLink(null);
			Assertions.fail("Test Invalid Product Image URL Method Is Failded");
		} catch (InvalidInputException e) {
			Assertions.assertEquals(CurrencyValidatorErrors.INVALID_LOGO_NULL, e.getMessage());
		}

	}

	@Test
	void testValidProductImageURL() {

		try {
			CurrencyValidator.isValidateProductImageLink(curr.getLogo());
			Assertions.fail("Test Invalid Product Image URL Method Is Failded");
		} catch (InvalidInputException e) {
			Assertions.assertEquals(CurrencyValidatorErrors.INVALID_LOGO_NULL, e.getMessage());
		}

	}


}
