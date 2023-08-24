package com.fssa.bitwallet.service;

/**
 * This class contains JUnit test cases for testing the functionality of the CurrencyServiceLayer class.
 */

import java.sql.SQLException;
import java.time.LocalDate;

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
    	
    	Currency currency = new Currency(1,"Tether", "TRC", 38, 1.0, 1, 1, 1, 1, 1, 2, LocalDate.of(2005, 3, 4));
//        Currency currency = new Currency("Tether", "TRC", 38, 1.0, 1, 1, 1, 1, 1, 2, LocalDate.of(2005, 3, 4));
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

        String name = getValidCurrency().getName();
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

        Assertions.assertTrue(CurrencyService.deleteCurrency("Dogecoin"));

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

        Currency currency = new Currency(5,"Dogecoin", "DTC", 10, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 2.0, LocalDate.of(2005, 3, 4));

//        CurrencyServiceLayer.addCurrency(currency);

        Assertions.assertEquals(CurrencyService.findByName(currency.getName()).getSymbol(), currency.getSymbol());

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

        Assertions.assertTrue(CurrencyService.readCurrency());

    }
}
