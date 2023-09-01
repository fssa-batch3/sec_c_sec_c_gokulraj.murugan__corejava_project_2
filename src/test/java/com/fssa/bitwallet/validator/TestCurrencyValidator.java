package com.fssa.bitwallet.validator;

import java.time.LocalDateTime;

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

	Currency curr = new Currency("Bitcoin", "BTC", 1, 1.0, 1, 1, 1, 1, 1, 2,LocalDateTime.of(2005, 02, 03, 03, 03), LocalDateTime.of(2005, 02, 03, 07, 03));

	Currency inValidCurrency = new Currency(null, null, -2, -4, -2, -40, -420, -230, -1, -9, LocalDateTime.of(2555, 02, 03, 03, 03) ,
			null);

	/**
	 * Test the validate method with a valid Currency object.
	 *
	 * @throws InvalidInputException    If the validation fails.
	 * @throws IllegalArgumentException If an invalid argument is provided.
	 */

	@Test
	void testValidate() throws InvalidInputException, IllegalArgumentException {
		Assertions.assertTrue(CurrencyValidator.validate(curr));
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

	/**
	 * Test the validateId method with a valid ID.
	 *
	 * @throws InvalidInputException    If the validation fails.
	 * @throws IllegalArgumentException If an invalid argument is provided.
	 */
	@Test
	void testValidateId() throws Exception {

		curr.setId(2);
		Assertions.assertTrue(CurrencyValidator.validateId(curr.getId()));

	}

	/**
	 * Test the validateId method with a negative ID.
	 */

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
	 * Test the validateRank method with a valid rank.
	 *
	 * @throws InvalidInputException    If the validation fails.
	 * @throws IllegalArgumentException If an invalid argument is provided.
	 */
	@Test
	void testValidateRank() throws Exception {

		curr.setRank(curr.getRank());
		Assertions.assertTrue(CurrencyValidator.validateRank(curr.getRank()));

	}

	/**
	 * Test the validateRank method with a negative rank.
	 */
	@Test
	void testNegativeValidatRank() {
		try {
			CurrencyValidator.validateRank(inValidCurrency.getRank());
			Assertions.fail("Test case failed");
		} catch (InvalidInputException e) {
			Assertions.assertEquals(CurrencyValidatorErrors.INVALID_RANK, e.getMessage());
		}

	}

	/**
	 * Test the validatePrice method with a valid price.
	 *
	 * @throws InvalidInputException    If the validation fails.
	 * @throws IllegalArgumentException If an invalid argument is provided.
	 */

	@Test
	void testValidatePrice() throws Exception {

		curr.setPrice(curr.getPrice());
		Assertions.assertTrue(CurrencyValidator.validatePrice(curr.getPrice()));
	}

	/**
	 * Test the validatePrice method with a negative price.
	 */
	@Test
	void testNegativeValidatPrice() {
		try {
			CurrencyValidator.validatePrice(inValidCurrency.getPrice());
			Assertions.fail("Test case failed");
		} catch (InvalidInputException e) {
			Assertions.assertEquals(CurrencyValidatorErrors.INVALID_PRICE, e.getMessage());
		}

	}

	/**
	 * Test the validateMarketCap method with a valid market cap.
	 *
	 * @throws InvalidInputException    If the validation fails.
	 * @throws IllegalArgumentException If an invalid argument is provided.
	 */

	@Test
	void testValidateMarketCap() throws Exception {

		curr.setMarketCap(curr.getMarketCap());
		Assertions.assertTrue(CurrencyValidator.validateMarketCap(curr.getMarketCap()));
	}

	/**
	 * Test the validateMarketCap method with a negative market cap.
	 */
	@Test
	void testNegativeValidatMarketCap() {
		try {
			CurrencyValidator.validateMarketCap(inValidCurrency.getMarketCap());
			Assertions.fail("Test case failed");
		} catch (InvalidInputException e) {
			Assertions.assertEquals(CurrencyValidatorErrors.INVALID_MARKET_CAP, e.getMessage());
		}

	}

	/**
	 * Test the validateTotalSupply method with a valid total supply.
	 *
	 * @throws InvalidInputException    If the validation fails.
	 * @throws IllegalArgumentException If an invalid argument is provided.
	 */

	@Test
	void testValidateTotalSupply() throws Exception {

		curr.setTotalSupply(curr.getTotalSupply());
		Assertions.assertTrue(CurrencyValidator.validateTotalSupply(curr.getTotalSupply()));
	}

	/**
	 * Test the validateTotalSupply method with a negative total supply.
	 */
	@Test
	void testNegativeValidateTotalSupply() {
		try {
			CurrencyValidator.validateTotalSupply(inValidCurrency.getTotalSupply());

			Assertions.fail("Test case failed");

		} catch (InvalidInputException e) {
			Assertions.assertEquals(CurrencyValidatorErrors.INVALID_TOTAL_SUPPLY, e.getMessage());
		}

	}

	/**
	 * Test the validateMaximumSupply method with a valid maximum supply.
	 *
	 * @throws InvalidInputException    If the validation fails.
	 * @throws IllegalArgumentException If an invalid argument is provided.
	 */

	@Test
	void testValidateMaximumSupply() throws Exception {

		curr.setMaximumSupply(curr.getMaximumSupply());
		Assertions.assertTrue(CurrencyValidator.validateMaximumSupply(curr.getMaximumSupply()));
	}

	/**
	 * Test the validateMaximumSupply method with a negative maximum supply.
	 */
	@Test
	void testNegativeValidatMaximumSupply() {
		try {
			CurrencyValidator.validateMaximumSupply(inValidCurrency.getMaximumSupply());
			Assertions.fail("Test case failed");
		} catch (InvalidInputException e) {
			Assertions.assertEquals(CurrencyValidatorErrors.INVALID_MAXIMUM_SUPPLY, e.getMessage());
		}

	}

	/**
	 * Test the validateVolume24h method with a valid 24-hour trading volume.
	 *
	 * @throws InvalidInputException    If the validation fails.
	 * @throws IllegalArgumentException If an invalid argument is provided.
	 */

	@Test
	void testValidateVolume24h() throws Exception {

		curr.setVolume24h(curr.getVolume24h());
		Assertions.assertTrue(CurrencyValidator.validateVolume24h(curr.getVolume24h()));
	}

	/**
	 * Test the validateVolume24h method with a negative 24-hour trading volume.
	 */
	@Test
	void testNegativeValidateVolume24h() {
		try {
			CurrencyValidator.validateVolume24h(inValidCurrency.getVolume24h());
			Assertions.fail("Test case failed");
		} catch (InvalidInputException e) {
			Assertions.assertEquals(CurrencyValidatorErrors.INVALID_VOLUME_24H, e.getMessage());
		}
	}

	/**
	 * Test the validateAllTimeHigh method with a valid all-time high price.
	 *
	 * @throws InvalidInputException    If the validation fails.
	 * @throws IllegalArgumentException If an invalid argument is provided.
	 */
	@Test
	void testValidateAllTimeHigh() throws Exception {

		curr.setAllTimeHigh(curr.getAllTimeHigh());
		Assertions.assertTrue(CurrencyValidator.validateAllTimeHigh(curr.getAllTimeHigh()));
	}

	/**
	 * Test the validateAllTimeHigh method with a negative all-time high price.
	 */

	@Test
	void testNegativeValidateAllTimeHigh() {
		try {
			CurrencyValidator.validateAllTimeHigh(inValidCurrency.getAllTimeHigh());
			Assertions.fail("Test case failed");
		} catch (InvalidInputException e) {
			Assertions.assertEquals(CurrencyValidatorErrors.INVALID_All_TIME_HIGH, e.getMessage());
		}
	}

	/**
	 * Test the validateAllTimeLow method with a valid all-time low price.
	 *
	 * @throws InvalidInputException    If the validation fails.
	 * @throws IllegalArgumentException If an invalid argument is provided.
	 */

	@Test
	void testValidateAllTimeLow() throws Exception {

		curr.setAllTimeLow(curr.getAllTimeLow());
		Assertions.assertTrue(CurrencyValidator.validateAllTimeLow(curr.getAllTimeLow()));
	}

	/**
	 * Test the validateAllTimeLow method with a negative all-time low price.
	 */
	@Test
	void testNegativeValidateAllTimeLow() {
		try {

			CurrencyValidator.validateAllTimeLow(inValidCurrency.getAllTimeLow());
			Assertions.fail("Test case failed");
		} catch (InvalidInputException e) {
			Assertions.assertEquals(CurrencyValidatorErrors.INVALID_All_TIME_LOW, e.getMessage());
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

	/**
	 * Test the validateCreationDate method with a valid creation date.
	 *
	 * @throws InvalidInputException    If the validation fails.
	 * @throws IllegalArgumentException If an invalid argument is provided.
	 */

	@Test
	void testValidateCreationDate() throws Exception {

		curr.setCreationDateTime(curr.getCreationDateTime());
		Assertions.assertTrue(CurrencyValidator.validateCreationDateTime(curr.getCreationDateTime()));

	}

	/**
	 * Test the validateCreationDate method with a null creation date.
	 */
	@Test
	void testNullValidateDate() {
		try {
			CurrencyValidator.validateCreationDateTime(null);
			Assertions.fail("Test case failed");
		} catch (InvalidInputException e) {
			Assertions.assertEquals(CurrencyValidatorErrors.INVALID_DATE_NULL, e.getMessage());
		}
	}

	 /**
     * Test the validateCreationDate method with an invalid date format.
     */
	
	@Test
	void testInValidateDate() {
		try {
			CurrencyValidator.validateCreationDateTime(inValidCurrency.getCreationDateTime());
			Assertions.fail("Test case failed");
		} catch (InvalidInputException e) {
			Assertions.assertEquals(CurrencyValidatorErrors.INVALID_DATE_FORMAT, e.getMessage());
		}
	}
}
