package com.fssa.bitwallet.service;

import java.sql.SQLException;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;


import com.fssa.bitwallet.errors.DaoException;
import com.fssa.bitwallet.errors.InvalidInputException;
import com.fssa.bitwallet.model.Currency;

public class TestCurrencyServiceLayer {

	public static Currency getValidCurrency() {
		Currency currency = new Currency(5, "Tether", "TRC", 38, 1.0, 1, 1, 1, 1, 1, 2, LocalDate.of(2005, 3, 4));
		return currency;
	}

	@Test
	@Order(1)
	void testAddCurrency() throws IllegalArgumentException, InvalidInputException, SQLException, DaoException {

		Currency curr = getValidCurrency();

		Assertions.assertTrue(CurrencyServiceLayer.addCurrency(curr));
	}
 
	@Test
	@Order(2)
	void testUpdateCurrency() throws IllegalArgumentException, InvalidInputException, SQLException, DaoException {

		String name = getValidCurrency().getName();
		String symbol = "TETJ";
		int rank = 20;

		Assertions.assertTrue(CurrencyServiceLayer.updateCurrency(name, symbol, rank));
	}

	@Test
	@Order(4)
	void testDeleteCurreny() throws IllegalArgumentException, InvalidInputException, SQLException, DaoException {

		Assertions.assertTrue(CurrencyServiceLayer.deleteCurrency("Dogecoin"));

	}

	@Test
	@Order(3)
	void testFindCurrenyByName() throws IllegalArgumentException, InvalidInputException, SQLException, DaoException {

		Currency currency = new Currency(5, "Dogecoin", "DTC", 10, 1.0, 1, 1, 1, 1, 1, 2, LocalDate.of(2005, 3, 4));

//		Currency cu = getValidCurrency();
		
		CurrencyServiceLayer.addCurrency(currency);

		
		Assertions.assertEquals(CurrencyServiceLayer.findByName(currency.getName()).getSymbol(),currency.getSymbol());
 
	}
	
	@Test
	@Order(3)
	void testReadCurrency() throws IllegalArgumentException, InvalidInputException, SQLException, DaoException {


		Assertions.assertTrue(CurrencyServiceLayer.readCurrency());

	}

}
