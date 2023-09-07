package com.fssa.bitwallet.service;

import java.sql.SQLException;
import java.util.List;

import com.fssa.bitwallet.dao.CurrencyDao;
import com.fssa.bitwallet.errors.DaoException;
import com.fssa.bitwallet.errors.InvalidInputException;
import com.fssa.bitwallet.model.Currency;
import com.fssa.bitwallet.validator.CurrencyValidator;

/**
 * Service layer for managing Currency operations.
 */

public class CurrencyService {

	/**
	 * Adds a new Currency to the database.
	 *
	 * @param currency The Currency object to be added.
	 * @return true if the currency was added successfully, false otherwise.
	 * @throws IllegalArgumentException If the input arguments are invalid.
	 * @throws InvalidInputException    If the input Currency is invalid.
	 * @throws SQLException             If a database access error occurs.
	 * @throws DaoException             If a DAO specific error occurs.
	 */

	public static boolean addCurrency(Currency currency) throws InvalidInputException, DaoException {

		if (CurrencyValidator.validate(currency)) {

			CurrencyDao.createCurrency(currency);

		}
		return true;
	}

	/**
	 * Updates the details of a Currency in the database.
	 *
	 * @param name   The name of the Currency to update.
	 * @param symbol The new symbol for the Currency.
	 * @param rank   The new rank for the Currency.
	 * @return true if the Currency was updated successfully, false otherwise.
	 * @throws IllegalArgumentException If the input arguments are invalid.
	 * @throws InvalidInputException    If the input details are invalid.
	 * @throws SQLException             If a database access error occurs.
	 * @throws DaoException             If a DAO specific error occurs.
	 */
	public static boolean updateCurrency(Currency currency) throws InvalidInputException, DaoException {

		if (CurrencyValidator.validate(currency)) {

			CurrencyDao.update(currency);
		}

		return true;
	}

	/**
	 * Reads and prints all Currency records from the database.
	 *
	 * @return true if the operation was successful, false otherwise.
	 * @throws IllegalArgumentException If the input arguments are invalid.
	 * @throws InvalidInputException    If the input is invalid.
	 * @throws SQLException             If a database access error occurs.
	 */

	public static List<Currency> readCurrency() throws DaoException {

		return CurrencyDao.readFullList();

	}

	/**
	 * Deletes a Currency record from the database by its name.
	 *
	 * @param name The name of the Currency to delete.
	 * @return true if the Currency was deleted successfully, false otherwise.
	 * @throws IllegalArgumentException If the input arguments are invalid.
	 * @throws InvalidInputException    If the input name is invalid.
	 * @throws SQLException             If a database access error occurs.
	 * @throws DaoException             If a DAO specific error occurs.
	 */

	public static boolean deleteCurrency(int id) throws InvalidInputException, DaoException {

		if (CurrencyValidator.validateId(id)) {
			CurrencyDao.delete(id);
		}
		return true;
	}

	/**
	 * Finds a Currency by its name in the database.
	 *
	 * @param name The name of the Currency to find.
	 * @return The Currency object found, or null if not found.
	 * @throws IllegalArgumentException If the input arguments are invalid.
	 * @throws InvalidInputException    If the input name is invalid.
	 * @throws SQLException             If a database access error occurs.
	 * @throws DaoException
	 */
	public static Currency findByName(String name) throws InvalidInputException, DaoException {

		Currency cuu = null;
		if (CurrencyValidator.validateName(name)) {
			cuu = CurrencyDao.findCurrenciesByName(name);
		}
		return cuu;

	}

	public static Currency findById(int id) throws InvalidInputException, DaoException {

		Currency cuu = null;
		if (CurrencyValidator.validateId(id)) {
			cuu = CurrencyDao.findCurrencyById(id);
		}
		return cuu;

	}

}
