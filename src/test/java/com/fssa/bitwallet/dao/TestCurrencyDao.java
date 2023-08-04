package com.fssa.bitwallet.dao;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.bitwallet.model.Currency;

public class TestCurrencyDao {
	Currency currency = new Currency(1, "Etherieum", "sdfghj", 2, 1.0, 1, 1, 1, 1, 1, 2, LocalDate.of(2005, 3, 4));

	@Test
	public void testcreateCurrency() throws Exception {

		Assertions.assertTrue(CurrencyDao.createCurrency(currency));
	}
	
	@Test
	public void testInvalidCurrency() {
		
		Currency curr = new Currency();
		
		try {
			CurrencyDao.createCurrency(curr);
		}
		catch(Exception e) {
//			System.out.println(e.getMessage());
//			Assertions.assertEquals("Cannot invoke "java.time.LocalDate.getYear()" because "date" is null", e.getMessage());
		}
				
	}
	
	

	
}
