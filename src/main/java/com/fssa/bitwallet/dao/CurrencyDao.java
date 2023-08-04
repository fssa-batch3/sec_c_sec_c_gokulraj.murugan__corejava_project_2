package com.fssa.bitwallet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import com.fssa.bitwallet.model.Currency;
import com.fssa.bitwallet.validtor.CurrencyValidator;

public class CurrencyDao {

	public static boolean createCurrency(Currency currency) throws Exception {

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
				return (rows > 0) ? true : false;
			}
		}

		catch (SQLException e) {
			throw new Exception("Cannot add");
		}
	}

	public static Currency findCurrenciesByName(String name) throws SQLException {

		Currency currency = null;

		try (Connection connection = ConnectionUtil.getConnection()) {
			String query = "SELECT * FROM currency WHERE name = ?";
			try (PreparedStatement pst = connection.prepareStatement(query)) {
				pst.setString(1, name);

				try (ResultSet resultSet = pst.executeQuery()) {
					while (resultSet.next()) {
						currency = new Currency();
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

					}
				}
			}
		}

		return currency;
	}

	public static String toString(Currency currency) {
		return "id :" + currency.getId() + "\nName :" + currency.getName() + "\nRank :" + currency.getRank()
				+ "\nPrice:" + currency.getPrice() + "\nMarket Supply:" + currency.getTotalSupply()
				+ "\nMaximum Supply: " + currency.getMaximumSupply() + "\nVolume 24h: " + currency.getVolume24h()
				+ "\nAll Time High: " + currency.getAllTimeHigh() + "\nAll Time Low: " + currency.getAllTimeLow()
				+ "\nCreation Date: " + currency.getCreationDate();

	}

	public static boolean delete(String name) throws Exception {

		String query = "DELETE FROM currency WHERE name = ?";
		int rows;
		try (Connection con = ConnectionUtil.getConnection()) {
			PreparedStatement pst = con.prepareStatement(query);

			pst.setString(1, name);
			rows = pst.executeUpdate();

			if (rows == 0) {
				throw new Exception("Deleted");
			}
		}

		return (rows > 0) ? true : false;
	}

	public static ArrayList readFullList() throws SQLException {

		try (Connection con = ConnectionUtil.getConnection()) {

			String query = "SELECT * FROM currency;";
			ArrayList<Currency> list = new ArrayList<>();
			try (PreparedStatement pst = con.prepareStatement(query)) {
				ResultSet resultSet = pst.executeQuery();
				while (resultSet.next()) {
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

				}
				return list;
			}
		}
	}

	public static boolean update(String name, String symbol, int rank) throws SQLException {

		try (Connection con = ConnectionUtil.getConnection()) {

			String query = "UPDATE currency SET  symbol = ?, rank = ? WHERE name = ?;";
			try (PreparedStatement pst = con.prepareStatement(query)) {

				pst.setString(1, symbol);
				pst.setInt(2, rank);
				pst.setString(3, name);
//				pst.setInt(3, currency.getRank());
//				pst.setDouble(4, currency.getPrice());
//				pst.setDouble(5, currency.getMarketCap());
//				pst.setDouble(6, currency.getTotalSupply());
//				pst.setDouble(7, currency.getMaximumSupply());
//				pst.setDouble(8, currency.getVolume24h());
//				pst.setDouble(9, currency.getAllTimeHigh());
//				pst.setDouble(10, currency.getAllTimeLow());
//				pst.setDate(11, java.sql.Date.valueOf(currency.getCreationDate()));

				int rows = pst.executeUpdate();

				System.out.println("no of affected:" + rows);

				return (rows > 0) ? true : false;

			}
		}

	}

	public static void main(String[] args) throws Exception {

//		Currency currency = new Currency(1, "Etherieum", "sdfghj", 2, 1.0, 1, 1, 1, 1, 1, 2, LocalDate.of(2005, 3, 4));

//		Currency currency = new Currency();

//		createCurrency(currency);
		System.out.println(toString(findCurrenciesByName("Bitcoin")));

//		update("E","Bitcoin");
//		delete("Etherieum");
	}
}
