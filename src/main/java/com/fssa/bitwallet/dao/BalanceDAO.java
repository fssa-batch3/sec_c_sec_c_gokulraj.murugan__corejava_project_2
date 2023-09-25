package com.fssa.bitwallet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.synth.SynthToggleButtonUI;

import com.fssa.bitwallet.errors.DaoException;
import com.fssa.bitwallet.errors.InvalidInputException;
import com.fssa.bitwallet.model.Balance;
import com.fssa.bitwallet.model.Currency;
import com.fssa.bitwallet.model.Transaction;
import com.fssa.bitwallet.service.CurrencyService;
import com.fssa.bitwallet.util.ConnectionUtil;
import com.mysql.cj.protocol.x.SyncFlushDeflaterOutputStream;

public class BalanceDAO {

	public static boolean addBalance(Balance balance) throws DaoException {

		try (Connection connection = ConnectionUtil.getConnection()) {

			String query = "insert into balance(user_id, balance, currency_id) values (?,?,?)";

			try (PreparedStatement pst = connection.prepareStatement(query)) {

				pst.setInt(1, balance.getUserId());
				pst.setDouble(2, balance.getBalance());
				pst.setInt(3, balance.getCurrency().getId());

				int rows = pst.executeUpdate();

				return rows > 0;
			}
		} catch (SQLException e) {
			throw new DaoException(e.getMessage());
		}
	}

	public static List<Balance> readBalanceByUserId(int id) throws DaoException, InvalidInputException {

		try (Connection con = ConnectionUtil.getConnection()) {

			String query = "SELECT *  FROM balance where user_id = ?;";
			ArrayList<Balance> list = new ArrayList<>();

			try (PreparedStatement pst = con.prepareStatement(query)) {

				pst.setInt(1, id);

				try (ResultSet resultSet = pst.executeQuery()) {

					while (resultSet.next()) {
						Balance balance = resultSetToBalance(resultSet);
						list.add(balance);
					}
				}

				return list;
			}
		} catch (SQLException e) {
			throw new DaoException(e.getMessage());
		}
	}

	
	public static boolean checkBalance(int id, int currencyId) throws DaoException {
		try (Connection con = ConnectionUtil.getConnection()) {
			String query = "SELECT currency_id FROM balance WHERE user_id = ? and currency_id = ?";
			try (PreparedStatement pst = con.prepareStatement(query)) {

				pst.setInt(1, id);
				pst.setInt(2, currencyId);

				ResultSet rs = pst.executeQuery();

				if (rs.next()) {

					return true;
				}

			}
		} catch (SQLException e) {
			throw new DaoException(e.getMessage());
		}
		return false;
	}


	public static double getBalance(int currencyId) throws DaoException {

		double balance = 0;

		String query = "SELECT balance FROM balance WHERE currency_id = ? ";

		try (Connection con = ConnectionUtil.getConnection()) {
			try (PreparedStatement pst = con.prepareStatement(query)) {

				pst.setInt(1, currencyId);

				ResultSet rs = pst.executeQuery();

				if (rs.next()) {
					return balance = rs.getDouble("balance");
				}

				return balance;
			}
		} catch (SQLException e) {
			throw new DaoException(e.getMessage());
		}

	}



	public static boolean updateBalance(double balance, int currencyid) throws DaoException {

		double currentbalance = getBalance(currencyid);
		
		System.out.println(currentbalance);
		double newBalance = currentbalance + balance;
		System.out.println(currentbalance + balance);
		System.out.println(newBalance);

		try (Connection con = ConnectionUtil.getConnection()) {

			String query = "update balance SET balance = ? Where currency_id = ?";

			try (PreparedStatement pst = con.prepareStatement(query)) {

				pst.setDouble(1, newBalance);
				pst.setInt(2, currencyid);

				int rows = pst.executeUpdate();

				return rows > 0;
			}
		} catch (SQLException e) {
			throw new DaoException(e.getMessage());
		}

	}

	public static Balance resultSetToBalance(ResultSet resultSet)
			throws SQLException, InvalidInputException, DaoException {

		Balance balance = new Balance();
		balance.setBalance(resultSet.getDouble("balance"));
		balance.setCurrency(CurrencyService.findById(resultSet.getInt("currency_id")));
		return balance;

	}

}
