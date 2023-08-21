package com.fssa.bitwallet.service;

import java.sql.SQLException;
import java.util.List;

import com.fssa.bitwallet.dao.CurrencyDao;
import com.fssa.bitwallet.errors.DaoException;
import com.fssa.bitwallet.errors.InvalidInputException;
import com.fssa.bitwallet.model.Currency;
import com.fssa.bitwallet.validtor.CurrencyValidator;

public class CurrencyServiceLayer {

	public static boolean addCurrency(Currency currency)
			throws IllegalArgumentException, InvalidInputException, SQLException, DaoException {

		if (CurrencyValidator.validate(currency)) {

			CurrencyDao.createCurrency(currency);

		}
		return true;
	}

	public static boolean updateCurrency(String name, String symbol, int rank)
			throws IllegalArgumentException, InvalidInputException, SQLException, DaoException {

		if (CurrencyValidator.validateName(name) && CurrencyValidator.validateSymbol(symbol)
				&& CurrencyValidator.validateRank(rank)) {

			CurrencyDao.update(name, symbol, rank);
		}

		return true;
	}

	public static boolean readCurrency() throws IllegalArgumentException, InvalidInputException, SQLException {
		printCurrency(CurrencyDao.readFullList());

		return true;

	}

	public static boolean deleteCurrency(String name)
			throws IllegalArgumentException, InvalidInputException, SQLException, DaoException {

		if (CurrencyValidator.validateName(name)) {
			CurrencyDao.delete(name);
		}
		return true;
	}

	public static Currency findByName(String name)
			throws IllegalArgumentException, InvalidInputException, SQLException {

		if (CurrencyValidator.validateName(name)) {
			CurrencyDao.findCurrenciesByName(name);
		}
		return null;

	}

	public static void printCurrency(List<Currency> cur) {
		for (Currency currency : cur) {
			System.out.println(currency);
		}
	}

}
