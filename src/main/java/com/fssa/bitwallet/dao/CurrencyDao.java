package com.fssa.bitwallet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fssa.bitwallet.errors.CurrencyDaoErrors;
import com.fssa.bitwallet.errors.DaoException;
import com.fssa.bitwallet.model.Currency;

public class CurrencyDao {

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

				if (rows == 0) {
					throw new DaoException(CurrencyDaoErrors.ROWS_AFFECTED);
				}
			}
		}

		return true;
	}

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

	public static String toString(Currency currency) {
		return "id :" + currency.getId() + "\nName :" + currency.getName() + "\nRank :" + currency.getRank()
				+ "\nPrice:" + currency.getPrice() + "\nMarket Supply:" + currency.getTotalSupply()
				+ "\nMaximum Supply: " + currency.getMaximumSupply() + "\nVolume 24h: " + currency.getVolume24h()
				+ "\nAll Time High: " + currency.getAllTimeHigh() + "\nAll Time Low: " + currency.getAllTimeLow()
				+ "\nCreation Date: " + currency.getCreationDate();

	}

	public static boolean delete(String name) throws SQLException, DaoException {

		String query = "DELETE FROM currency WHERE name = ?";

		try (Connection con = ConnectionUtil.getConnection()) {

			try (PreparedStatement pst = con.prepareStatement(query)) {

				pst.setString(1, name);
				System.out.println(pst);

				int rows = pst.executeUpdate();
				System.out.println(rows + "jj");
				if (rows == 0) {
					
					throw new DaoException(CurrencyDaoErrors.ROWS_AFFECTED); // if no rows are affected, throw an
																				// exception
				}

			}
		}
		return true;
	}

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

	public static boolean update(String name, String symbol, int rank) throws SQLException, DaoException {

		try (Connection con = ConnectionUtil.getConnection()) {

			String query = "update currency SET symbol = ?,  ranking = ? WHERE name = ?";

			try (PreparedStatement pst = con.prepareStatement(query)) {

				pst.setString(1, symbol);
				pst.setInt(2, rank);
				pst.setString(3, name);

				int rows = pst.executeUpdate();

				if (rows == 0) {

					throw new DaoException(CurrencyDaoErrors.ROWS_AFFECTED); // if no rows are affected, throw an //
																				// exception
				}
			}
		}

		return true;
	}

}
