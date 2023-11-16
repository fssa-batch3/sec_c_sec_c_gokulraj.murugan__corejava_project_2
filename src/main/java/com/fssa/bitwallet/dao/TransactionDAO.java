package com.fssa.bitwallet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fssa.bitwallet.errors.DaoException;
import com.fssa.bitwallet.model.Transaction;
import com.fssa.bitwallet.util.ConnectionUtil;

public class TransactionDAO {


	public static boolean addTransaction(Transaction trans) throws DaoException {

		try (Connection connection = ConnectionUtil.getConnection()) {

			String query = "insert into transactions(amount, quantity,user_id,currency_id,transaction_method,seller_id) values (?,?,?,?,?,?)";

			try (PreparedStatement pst = connection.prepareStatement(query)) {

				
				pst.setDouble(1, trans.getAmount());
				pst.setDouble(2, trans.getQuantity());
				pst.setInt(3, trans.getUserId());
				pst.setInt(4, trans.getCurrencyId());
				pst.setString(5,trans.getTransactionMethod());
				pst.setInt(6, trans.getSellerId());

				int rows = pst.executeUpdate();

				return rows > 0;
			}
		} catch (SQLException e) {
			throw new DaoException(e.getMessage());
		}

	}
	
	public static Transaction resultSetToTransactions(ResultSet resultSet) throws SQLException {
		Transaction trans = new Transaction();
		trans.setTransactionType(resultSet.getString("transaction_type"));
		trans.setAmount(resultSet.getDouble("amount"));
		trans.setQuantity(resultSet.getDouble("quantity"));
		trans.setSellerId(resultSet.getInt("seller_id"));
		trans.setTransactionTime(resultSet.getDate("transaction_time").toLocalDate());
		trans.setTransactionMethod(resultSet.getString("transaction_method"));
		return trans;
	}
	

	
	public static List<Transaction> readTransatByUserId(int id) throws DaoException {

		try (Connection con = ConnectionUtil.getConnection()) {

			String query = "SELECT transactions.transaction_type,transactions.amount,transactions.quantity,transactions.currency_id,transactions.seller_id,transaction_time,transaction_method  FROM transactions where user_id = ?;";
			ArrayList<Transaction> list = new ArrayList<>();

			try (PreparedStatement pst = con.prepareStatement(query)) {

					pst.setInt(1, id);
					
				try (ResultSet resultSet = pst.executeQuery()) {

					
					
					while (resultSet.next()) {
						Transaction trans = resultSetToTransactions(resultSet);
						list.add(trans);
					}
				}

				return list;
			}
		} catch (SQLException e) {
			throw new DaoException(e.getMessage());
		}
	} 
	
	
	

	
	
}
