package com.fssa.bitwallet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fssa.bitwallet.errors.DaoException;
import com.fssa.bitwallet.model.Currency;
import com.fssa.bitwallet.util.ConnectionUtil;

/**
 * A Data Access Object (DAO) class for managing Currency data in a database.
 */

public class CurrencyDao {

	/**
	 * Creates a new currency record in the database.
	 *
	 * @param currency The Currency object to be created.
	 * @return true if the currency was created successfully, false otherwise.
	 * @throws SQLException If a database access error occurs.
	 * @throws DaoException If a DAO specific error occurs.
	 */

	public static boolean createCurrency(Currency currency) throws DaoException {

		try (Connection connection = ConnectionUtil.getConnection()) {

			String query = "insert into currencies(name, symbol, logo) values (?,?,?)";

			try (PreparedStatement pst = connection.prepareStatement(query)) {

				pst.setString(1, currency.getName());
				pst.setString(2, currency.getSymbol());
				pst.setString(3, currency.getLogo());

				int rows = pst.executeUpdate();

				return rows > 0;
			}
		} catch (SQLException e) {
			throw new DaoException(e.getMessage());
		}

	}

	/**
	 * Retrieves a Currency object from the database by its name.
	 *
	 * @param name The name of the currency to find.
	 * @return The Currency object found in the database, or null if not found.
	 * @throws SQLException If a database access error occurs.
	 * @throws DaoException
	 */
	public static Currency findCurrenciesByName(String name) throws DaoException {

		int id = getIdByName(name);

		Currency currency = null;

		try (Connection connection = ConnectionUtil.getConnection()) {

			String query = "SELECT currencies.name,currencies.symbol,currencies.logo FROM currencies WHERE id = ?";

			try (PreparedStatement pst = connection.prepareStatement(query)) {

				pst.setInt(1, id);

				try (ResultSet resultSet = pst.executeQuery()) {

					if (resultSet.next()) {
						currency = resultSetToCurrency(resultSet);
					}
				}
			}
		} catch (SQLException e) {
			throw new DaoException(e.getMessage());
		}

		return currency;
	}

	public static Currency findCurrencyById(int id) throws DaoException {

		Currency currency = null;

		try (Connection connection = ConnectionUtil.getConnection()) {

			String query = "SELECT * FROM currencies WHERE id = ?";

			try (PreparedStatement pst = connection.prepareStatement(query)) {

				pst.setInt(1, id);

				try (ResultSet resultSet = pst.executeQuery()) {

					if (resultSet.next()) {
						currency = resultSetToCurrency(resultSet);
					}
				}
			}
		} catch (SQLException e) {
			throw new DaoException(e.getMessage());
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

	public static Currency resultSetToCurrency(ResultSet resultSet) throws SQLException {
		Currency currency = new Currency();
		currency.setId(resultSet.getInt("id"));
		currency.setName(resultSet.getString("name"));
		currency.setSymbol(resultSet.getString("symbol"));
		currency.setLogo(resultSet.getString("logo"));
		return currency;
	}

	/**
	 * Deletes a currency record from the database by its name.
	 *
	 * @param name The name of the currency to delete.
	 * @return true if the currency was deleted successfully, false otherwise.
	 * @throws SQLException If a database access error occurs.
	 * @throws DaoException If a DAO specific error occurs.
	 */

	public static boolean delete(int id) throws DaoException {

		String query = "DELETE FROM currencies WHERE id = ?";

		try (Connection con = ConnectionUtil.getConnection()) {

			try (PreparedStatement pst = con.prepareStatement(query)) {

				pst.setInt(1, id);

				int rows = pst.executeUpdate();

				return rows > 0;

			}
		} catch (SQLException e) {
			throw new DaoException(e.getMessage());
		}

	}

	/**
	 * Retrieves a list of all currencies from the database.
	 *
	 * @return A list of Currency objects representing all currencies in the
	 *         database.
	 * @throws SQLException If a database access error occurs.
	 * @throws DaoException
	 */

	public static List<Currency> readFullList() throws DaoException {

		try (Connection con = ConnectionUtil.getConnection()) {

			String query = "SELECT * FROM currencies;";
			ArrayList<Currency> list = new ArrayList<>();

			try (PreparedStatement pst = con.prepareStatement(query)) {

				try (ResultSet resultSet = pst.executeQuery()) {

					while (resultSet.next()) {
						Currency currency = resultSetToCurrency(resultSet);
						list.add(currency);
					}
				}

				return list;
			}
		} catch (SQLException e) {
			throw new DaoException(e.getMessage());
		}
	}

	/**
	 * Updates the symbol and rank of a currency record in the database by its name.
	 *
	 * @param name   The name of the currency to update.
	 * @param symbol The new symbol for the currency.
	 * @param rank   The new rank for the currency.
	 * @return true if the currency was updated successfully, false otherwise.
	 * @throws SQLException If a database access error occurs.
	 * @throws DaoException If a DAO specific error occurs.
	 */

	public static int getIdByName(String name) throws DaoException {
		int id = 0;
		String query = "SELECT id FROM currencies WHERE name = ? ";
		try (Connection con = ConnectionUtil.getConnection()) {
			try (PreparedStatement pst = con.prepareStatement(query)) {

				pst.setString(1, name);

				ResultSet rs = pst.executeQuery();

				if (rs.next()) {
					id = rs.getInt("id");
				}

				return id;
			}
		} catch (SQLException e) {
			throw new DaoException(e.getMessage());
		}

	}
	


	public static boolean update(Currency currency) throws DaoException {

		int id = getIdByName(currency.getName());

		try (Connection con = ConnectionUtil.getConnection()) {

			String query = "update currencies SET name = ?,symbol = ? Where id = ?";

			try (PreparedStatement pst = con.prepareStatement(query)) {

				pst.setString(1, currency.getName());
				pst.setString(2, currency.getSymbol());
			
				pst.setInt(11, id);

				int rows = pst.executeUpdate();

				return rows > 0;
			}
		} catch (SQLException e) {
			throw new DaoException(e.getMessage());
		}

	}

}
