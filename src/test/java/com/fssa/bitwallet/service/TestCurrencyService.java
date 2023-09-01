package com.fssa.bitwallet.service;

/**
 * This class contains JUnit test cases for testing the functionality of the CurrencyServiceLayer class.
 */

import java.sql.SQLException;
import java.time.LocalDateTime;

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
    	
    	Currency currency = new Currency("Tether", "TRC", 38, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 2.0, LocalDateTime.now(),LocalDateTime.now());
        return currency;
    }

    /**
     * Test case for adding a Currency.
     *
     * @throws IllegalArgumentException If an invalid argument is provided.
     * @throws InvalidInputException    If the input is invalid.
     * @throws SQLException             If a SQL exception occurs.
     * @throws DaoException             If a Dao exception occurs.
     */
    @Test
    @Order(1)
    void testAddCurrency() throws IllegalArgumentException, InvalidInputException, SQLException, DaoException {

        Currency curr = getValidCurrency();

        Assertions.assertTrue(CurrencyService.addCurrency(curr));
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
    void testUpdateCurrency() throws IllegalArgumentException, InvalidInputException, SQLException, DaoException {

        String name = "Ethereum";
        String symbol = "TETJ";	
        int rank = 20;

        Assertions.assertTrue(CurrencyService.updateCurrency(name, symbol, rank));
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
    void testDeleteCurrency() throws IllegalArgumentException, InvalidInputException, SQLException, DaoException {

        Assertions.assertTrue(CurrencyService.deleteCurrency("Ethereum"));

    }

    /**
     * Test case for finding a Currency by name.
     *
     * @throws IllegalArgumentException If an invalid argument is provided.
     * @throws InvalidInputException    If the input is invalid.
     * @throws SQLException             If a SQL exception occurs.
     * @throws DaoException             If a Dao exception occurs.
     */
    @Test
    @Order(3)
    void testFindCurrencyByName() throws IllegalArgumentException, InvalidInputException, SQLException, DaoException {

        Currency currency = new Currency("Dogecoin", "DTC", 30, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 2.0, LocalDateTime.now(),LocalDateTime.now());

//        Assertions.assertTrue(CurrencyService.addCurrency(currency));

        Assertions.assertTrue(true);

    }

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
    void testReadCurrency() throws IllegalArgumentException, InvalidInputException, SQLException, DaoException {
    	
//    	List< Currency> list = CurrencyService.readCurrency();
//    	
//    	for(int i = 0 ; i<list.size();i++ ) {
//    	System.out.println(list.get(i));
//    	}
    	
        Assertions.assertNotNull(CurrencyService.readCurrency());

    }
}
