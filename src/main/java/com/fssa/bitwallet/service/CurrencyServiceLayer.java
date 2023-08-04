package com.fssa.bitwallet.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.fssa.bitwallet.dao.CurrencyDao;
import com.fssa.bitwallet.model.Currency;
import com.fssa.bitwallet.validtor.CurrencyValidator;

public class CurrencyServiceLayer {

	public static boolean addCurrency(Currency currency) throws Exception {

		if (CurrencyValidator.validate(currency)) {

			return CurrencyDao.createCurrency(currency);
 
		}
		return false;
	}

	public static boolean updateCurrency(String name, String symbol, int rank) throws Exception {

		if (CurrencyValidator.validateName(name) && CurrencyValidator.validateSymbol(symbol)
				&& CurrencyValidator.validateRank(rank)) {

			boolean result = CurrencyDao.update(name, symbol, rank);
			return result;
		}

		return false;
	}

	public static ArrayList readCurrency() throws SQLException {

		return CurrencyDao.readFullList();

	}

	public static boolean deleteCurrency(String name) throws Exception {

		if (CurrencyValidator.validateName(name)) {
			return CurrencyDao.delete(name);
		}
		return false;
	}

}
