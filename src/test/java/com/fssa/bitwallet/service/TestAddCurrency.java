package com.fssa.bitwallet.service;

import java.sql.SQLException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.bitwallet.errors.InvalidInputException;
import com.fssa.bitwallet.model.Currency;

public class TestAddCurrency {

	Currency currency1 = new Currency("Bitcoin", "BTC", 1, 2151019.00, 41873685725465.00, 21000000.00, 21000000.00,
			1656874066516.00, 2156461.25, 2156461.25);
	Currency currency2 = new Currency("Ethereum", "ETH", 2, 251100.00, 120000000.00, 115000000.00, 115000000.00,
			328646500.00, 252543.75, 252543.75);
	Currency currency3 = new Currency("Ripple", "XRP", 3, 84.00, 100000000000.00, 45000000000.00, 45000000000.00,
			41765618400.00, 83.25, 83.25);
	Currency currency4 = new Currency("Litecoin", "LTC", 4, 10950.00, 84000000.00, 67000000.00, 67000000.00,
			7364244825.00, 109417.75, 109417.75);
	Currency currency5 = new Currency("Cardano", "ADA", 5, 159.75, 45000000000.00, 32100000000.00, 32100000000.00,
			24602584707.25, 159.00, 159.00);


//	@Test
//	void testAddCurrency1() {
//
//		try {
//			Assertions.assertTrue(CurrencyService.addCurrency(currency1));
//
//		} catch (IllegalArgumentException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InvalidInputException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
	@Test
	void testAddCurrency2() {

		try {
			Assertions.assertTrue(CurrencyService.addCurrency(currency2));

		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidInputException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Test
	void testAddCurrency3() {

		try {
			Assertions.assertTrue(CurrencyService.addCurrency(currency3));

		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidInputException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Test
	void testAddCurrency4() {

		try {
			Assertions.assertTrue(CurrencyService.addCurrency(currency4));

		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidInputException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Test
	void testAddCurrency5() {

		try {
			Assertions.assertTrue(CurrencyService.addCurrency(currency5));

		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidInputException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
