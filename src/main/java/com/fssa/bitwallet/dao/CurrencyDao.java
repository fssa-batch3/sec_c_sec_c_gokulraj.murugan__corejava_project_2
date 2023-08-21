package com.fssa.bitwallet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fssa.bitwallet.errors.DaoException;
import com.fssa.bitwallet.model.Currency;

/**
 * A Data Access Object (DAO) class for managing Currency data in a database.
 */


public class CurrencyDao {

	
	/**
     * Creates a new currency record in the database.
     *
     * @param currency The Currency object to be created.
     * @return true if the currency was created successfully, false otherwise.
     * @throws SQLException  If a database access error occurs.
     * @throws DaoException If a DAO specific error occurs.
     */
	
	public static boolean createCurrency(Currency currency) throws SQLException, DaoException {

		try (Connection connection = ConnectionUtil.getConnection()) {

			String query = "insert into currency(name, symbol, ranking, price, market_cap, total_supply, maximum_supply, volume_24h, all_time_high, all_time_low, creationdate) values (?,?,?,?,?,?,?,?,?,?,?)";

			try (PreparedStatement pst = connection.prepareStatement(query)) {

				pst.setString(1, currency.getName());
				pst.setString(2, currency.getSymbol());
				pst.setInt(3, currency.getRank());
				pst.setDouble(4, currency.getPrice());
				pst.setDouble(5, currency.getMarketCap());
				pst.setDouble(6, currency.getTotalSupply());
				pst.setDouble(7, currency.getMaximumSupply());
				pst.setDouble(8, currency.getVolume24h());
				pst.setDouble(9, currency.getAllTimeHigh());
				pst.setDouble(10, currency.getAllTimeLow());
				pst.setDate(11, java.sql.Date.valueOf(currency.getCreationDate()));

				int rows = pst.executeUpdate();

				return rows > 0;
			}
		}

	}

	/**
     * Retrieves a Currency object from the database by its name.
     *
     * @param name The name of the currency to find.
     * @return The Currency object found in the database, or null if not found.
     * @throws SQLException If a database access error occurs.
     */
	public static Currency findCurrenciesByName(String name) throws SQLException {

		Currency currency = null;

		try (Connection connection = ConnectionUtil.getConnection()) {

			String query = "SELECT * FROM currency WHERE name = ?";

			try (PreparedStatement pst = connection.prepareStatement(query)) {

				pst.setString(1, name);

				try (ResultSet resultSet = pst.executeQuery()) {

					if (resultSet.next()) {
						currency = mapResultSetToCurrency(resultSet);
					}
				}
			}
		}

		return currency;
	}

	 /**
     * Maps a ResultSet to a Currency object.
     *
     * @param resultSet The ResultSet containing currency data.
     * @return The Currency object mapped from the ResultSet.
     * @throws SQLException If a database access error occurs.
     */
	
	public static Currency mapResultSetToCurrency(ResultSet resultSet) throws SQLException {
		Currency currency = new Currency();
		currency.setId(resultSet.getInt("id"));
		currency.setName(resultSet.getString("name"));
		currency.setSymbol(resultSet.getString("symbol"));
		currency.setRank(resultSet.getInt("ranking"));
		currency.setPrice(resultSet.getDouble("price"));
		currency.setMarketCap(resultSet.getDouble("market_cap"));
		currency.setTotalSupply(resultSet.getDouble("total_supply"));
		currency.setMaximumSupply(resultSet.getDouble("maximum_supply"));
		currency.setVolume24h(resultSet.getDouble("volume_24h"));
		currency.setAllTimeHigh(resultSet.getDouble("all_time_high"));
		currency.setAllTimeLow(resultSet.getDouble("all_time_low"));
		currency.setCreationDate(resultSet.getDate("creationdate").toLocalDate());
		return currency;
	}

	 /**
     * Deletes a currency record from the database by its name.
     *
     * @param name The name of the currency to delete.
     * @return true if the currency was deleted successfully, false otherwise.
     * @throws SQLException  If a database access error occurs.
     * @throws DaoException If a DAO specific error occurs.
     */
	
	public static boolean delete(String name) throws SQLException, DaoException {

		String query = "DELETE FROM currency WHERE name = ?";

		try (Connection con = ConnectionUtil.getConnection()) {

			try (PreparedStatement pst = con.prepareStatement(query)) {

				pst.setString(1, name);

				int rows = pst.executeUpdate();

				return rows > 0;

			}
		}

	}
	
	/**
     * Retrieves a list of all currencies from the database.
     *
     * @return A list of Currency objects representing all currencies in the database.
     * @throws SQLException If a database access error occurs.
     */
	
	public static List<Currency> readFullList() throws SQLException {

		try (Connection con = ConnectionUtil.getConnection()) {

			String query = "SELECT * FROM currency;";
			ArrayList<Currency> list = new ArrayList<>();

			try (PreparedStatement pst = con.prepareStatement(query)) {

				try (ResultSet resultSet = pst.executeQuery()) {

					while (resultSet.next()) {
						Currency currency = mapResultSetToCurrency(resultSet);
						list.add(currency);
					}
				}

				return list;
			}
		}
	}

	/**
     * Updates the symbol and rank of a currency record in the database by its name.
     *
     * @param name   The name of the currency to update.
     * @param symbol The new symbol for the currency.
     * @param rank   The new rank for the currency.
     * @return true if the currency was updated successfully, false otherwise.
     * @throws SQLException  If a database access error occurs.
     * @throws DaoException If a DAO specific error occurs.
     */
	
	public static boolean update(String name, String symbol, int rank) throws SQLException, DaoException {

		try (Connection con = ConnectionUtil.getConnection()) {

			String query = "update currency SET symbol = ?,  ranking = ? WHERE name = ?";

			try (PreparedStatement pst = con.prepareStatement(query)) {

				pst.setString(1, symbol);
				pst.setInt(2, rank);
				pst.setString(3, name);

				int rows = pst.executeUpdate();

				return rows > 0;

			}
		}

	}

}
