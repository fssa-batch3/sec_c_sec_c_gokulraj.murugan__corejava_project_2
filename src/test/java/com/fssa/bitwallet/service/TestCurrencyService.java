package com.fssa.bitwallet.service;

/**
 * This class contains JUnit test cases for testing the functionality of the CurrencyServiceLayer class.
 */

import java.sql.SQLException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import com.fssa.bitwallet.errors.DaoException;
import com.fssa.bitwallet.errors.InvalidInputException;
import com.fssa.bitwallet.model.Currency;

/**
 * JUnit test cases for testing the CurrencyServiceLayer class.
 */
public class TestCurrencyService {

	/**
	 * Returns a valid Currency object for testing.
	 *
	 * @return A valid Currency object.
	 */
	public static Currency getValidCurrency() {

		Currency currency = new Currency("Tether", "TRC","https://freeimage.host/i/JHmJBWX");
		return currency;
	}

	public static Currency getUpdateCurrency() {
		Currency currency = new Currency("Tether", "ETH","https://freeimage.host/i/JHmJBWX");
		return currency;

	}

	/**
	 * Test case for adding a Currency.
	 *
	 * @throws IllegalArgumentException If an invalid argument is provided.
	 * @throws InvalidInputException    If the input is invalid.
	 * @throws SQLException             If a SQL exception occurs.
	 * @throws DaoException             If a Dao exception occurs.x`x`
	 */

	@Test
	@Order(1)
	void testAddCurrency() {

		Currency curr = getValidCurrency();

		try {
			Assertions.assertTrue(CurrencyService.addCurrency(curr));

		} catch (IllegalArgumentException | InvalidInputException | DaoException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test case for updating a Currency.
	 *
	 * @throws IllegalArgumentException If an invalid argument is provided.
	 * @throws InvalidInputException    If the input is invalid.
	 * @throws SQLException             If a SQL exception occurs.
	 * @throws DaoException             If a Dao exception occurs.
	 */
	@Test
	@Order(2)
	void testUpdateCurrency() {

		try {
			Assertions.assertTrue(CurrencyService.updateCurrency(getUpdateCurrency()));

		} catch (InvalidInputException | DaoException e) {

			e.printStackTrace();
		}
	}

	/**
	 * Test case for deleting a Currency.
	 *
	 * @throws IllegalArgumentException If an invalid argument is provided.
	 * @throws InvalidInputException    If the input is invalid.
	 * @throws SQLException             If a SQL exception occurs.
	 * @throws DaoException             If a Dao exception occurs.
	 */
	@Test
	@Order(4)
	void testDeleteCurrency() {

		try {
			Assertions.assertTrue(CurrencyService.deleteCurrency(1));

		} catch (InvalidInputException | DaoException e) {

			e.printStackTrace();
		}

	}

	/**
	 * Test case for finding a Currency by name.
	 *
	 * @throws IllegalArgumentException If an invalid argument is provided.
	 * @throws InvalidInputException    If the input is invalid.
	 * @throws SQLException             If a SQL exception occurs.
	 * @throws DaoException             If a Dao exception occurs.
	 */
//	@Test
//	@Order(3)
//	void testFindCurrencyByName() throws IllegalArgumentException, InvalidInputException, SQLException, DaoException {
//
//		Assertions.assertTrue();
//
//	}

	/**
	 * Test case for reading Currency data.
	 *
	 * @throws IllegalArgumentException If an invalid argument is provided.
	 * @throws InvalidInputException    If the input is invalid.
	 * @throws SQLException             If a SQL exception occurs.
	 * @throws DaoException             If a Dao exception occurs.
	 */
	@Test
	@Order(3)
	void testReadCurrency() {

		try {
			Assertions.assertNotNull(CurrencyService.readCurrency());

		} catch (DaoException e) {

			e.printStackTrace();
		}

	}
}
