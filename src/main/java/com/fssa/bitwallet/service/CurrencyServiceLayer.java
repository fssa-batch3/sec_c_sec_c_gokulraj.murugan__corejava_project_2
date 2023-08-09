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

			return CurrencyDao.createCurrency(currency);

		}
		return true;
	}

	public static boolean updateCurrency(String name, String symbol, int rank)
			throws IllegalArgumentException, InvalidInputException, SQLException, DaoException {

		if (CurrencyValidator.validateName(name) && CurrencyValidator.validateSymbol(symbol)
				&& CurrencyValidator.validateRank(rank)) {

			return CurrencyDao.update(name, symbol, rank);
		}

		return true;
	}

	public static List<Currency> readCurrency()
			throws IllegalArgumentException, InvalidInputException, SQLException {

		return CurrencyDao.readFullList();

	}  

	public static boolean deleteCurrency(String name)
			throws IllegalArgumentException, InvalidInputException, SQLException, DaoException {

		if (CurrencyValidator.validateName(name)) {
			return CurrencyDao.delete(name);
		}
		return true;
	} 

	public static Currency findByName(String name)
			throws IllegalArgumentException, InvalidInputException, SQLException {
		
		if (CurrencyValidator.validateName(name)) {
			return CurrencyDao.findCurrenciesByName(name);
		}
		return null;

		
	}
	
	public static void main(String[] args) throws IllegalArgumentException, InvalidInputException, SQLException, DaoException {
		
		System.out.println(findByName("Dogecoin"));
		
	}

}
