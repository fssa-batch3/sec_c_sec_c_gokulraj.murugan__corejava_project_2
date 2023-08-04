package com.fssa.bitwallet.service;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import com.fssa.bitwallet.errors.CurrencyValidatorErrors;
import com.fssa.bitwallet.model.Currency;

public class TestCurrencyServiceLayer {

	public static Currency getValidCurrency() {
		Currency currency = new Currency(5, "Tether", "TRC", 78, 1.0, 1, 1, 1, 1, 1, 2, LocalDate.of(2005, 3, 4));
		return currency;
	}

	public static Currency getInValidCurrency() {
		Currency currency = new Currency(1, "Bitcoin", "BTC", 1, 1.0, 1, 1, 1, 1, 1, 2, LocalDate.of(2005, 3, 4));
		return currency;
	}

	@Test
	@Order(1)
	public void testAddCurrency() throws Exception {

		Currency curr = getValidCurrency();
		Assertions.assertTrue(CurrencyServiceLayer.addCurrency(curr));
	}

	@Test
	@Order(1)
	public void testAddCurrencyNull() {

		Currency curr = null;
		try {

			CurrencyServiceLayer.addCurrency(curr);
		} catch (Exception e) {

			Assertions.assertEquals(e.getMessage(), CurrencyValidatorErrors.INVALID_CURRENCY_NULL);
		}
	}

//	@Test
//	public void testAddCurrencyInvalid() {
//		try {
//			Currency curr = getInValidCurrency();
//			Assertions.assertFalse(CurrencyServiceLayer.addCurrency(curr));
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//
//	}

	@Test
	@Order(2)
	public void testUpdateCurrency() throws Exception {

		Assertions.assertTrue(CurrencyServiceLayer.updateCurrency("Tether", "ABC", 5));
	}

	@Test
	@Order(2)
	public void testUpdateCurrencyInVaild() {

		try {
			CurrencyServiceLayer.updateCurrency("  ", "ABC", 5);
		} catch (Exception e) {

			Assertions.assertEquals(e.getMessage(), CurrencyValidatorErrors.INVALID_NAME);
		}
	}

	@Test
	@Order(3)
	public void testDeleteCurreny() throws Exception {

		Assertions.assertTrue(CurrencyServiceLayer.deleteCurrency("Tether"));

	}

	@Test
	@Order(3)
	public void testDeleteCurrencyInvalid() {

		Currency curr = getValidCurrency();
		try {
			CurrencyServiceLayer.deleteCurrency(null);
		} catch (Exception e) {
			Assertions.assertEquals(e.getMessage(), CurrencyValidatorErrors.INVALID_NAME);
		}

	}

}
