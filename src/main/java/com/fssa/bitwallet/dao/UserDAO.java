package com.fssa.bitwallet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import com.fssa.bitwallet.errors.DaoException;
import com.fssa.bitwallet.model.User;
import com.fssa.bitwallet.util.ConnectionUtil;
import com.fssa.bitwallet.util.Logger;

public class UserDAO {

	public static void main(String[] args) throws DaoException {
		
		User user = new User();
		user.setEmail("bitwallet@gmail.com");
		user.setUsername("BitWallet");
		user.setDOB(LocalDate.of(2005, 4, 5));
		user.setPassword("BitWallet@123");
		
		addUser(user);
	}
	
	public static boolean addUser(User user) throws DaoException {
		try (Connection connection = ConnectionUtil.getConnection()) {

			String query = "insert into user(username,dob,email,password) values (?,?,?,?)";

			try (PreparedStatement pst = connection.prepareStatement(query)) {
				Logger.info("adduser");
				pst.setString(1, user.getUsername());
				pst.setDate(2, java.sql.Date.valueOf(user.getDOB()));
				pst.setString(3, user.getEmail());
				pst.setString(4, user.getPassword());

				int rows = pst.executeUpdate();

				Logger.info("no of rows Affected : "+rows);
				return rows > 0;
			}
		} catch (SQLException e) {

			throw new DaoException(e.getMessage());
		}
	}

	public static boolean updateUser(User user) throws DaoException {

		try (Connection con = ConnectionUtil.getConnection()) {

			int id = getIdByEmail(user.getEmail());

			String query = "update user SET username = ?,dob = ? where id = ?";

			try (PreparedStatement pst = con.prepareStatement(query)) {

				pst.setString(1, user.getUsername());
				pst.setDate(2, java.sql.Date.valueOf(user.getDOB()));
				
				pst.setInt(3, id);

				int rowsAffected = pst.executeUpdate();

				return rowsAffected > 0;
			}
		} catch (SQLException e) {

			throw new DaoException(e.getMessage());

		}

	}

	public static boolean deleteUser(User user) throws DaoException {

		try (Connection con = ConnectionUtil.getConnection()) {

			int id = getIdByEmail(user.getEmail());

			String query = "update user Set is_active = ? Where id = ?";

			try (PreparedStatement pst = con.prepareStatement(query)) {

				pst.setBoolean(1, false);
				pst.setInt(2, id);

				int rowsAffected = pst.executeUpdate();

				return rowsAffected > 0;
			}
		} catch (SQLException e) {

			throw new DaoException(e.getMessage());

		}

	}

	public static int getIdByEmail(String name) throws DaoException {

		int userId = 0;
		try (Connection con = ConnectionUtil.getConnection()) {
			String query = "SELECT id FROM user where email = ?";

			try (PreparedStatement pst = con.prepareStatement(query)) {
				pst.setString(1, name);
				ResultSet rs = pst.executeQuery();
				if (rs.next()) {

					userId = rs.getInt("id");
				}
			}
		} catch (SQLException e) {
			throw new DaoException(e.getMessage());
		}

		return userId;

	}

	static User resultbyUser(ResultSet resultSet) throws SQLException {

		User user = new User();
		user.setId(resultSet.getInt("id"));
		user.setUsername(resultSet.getString("username"));
		user.setEmail(resultSet.getString("email"));
		user.setPassword(resultSet.getString("password"));
		user.setDOB(resultSet.getDate("dob").toLocalDate());

		return user;
	}

	public static User getUserByEmail(String email) throws DaoException {
		
		int id  = getIdByEmail(email);

		User user = null;

		try (Connection con = ConnectionUtil.getConnection()) {
			String query = "SELECT id, username, email, password, dob  FROM user where id = ?";

			try (PreparedStatement pst = con.prepareStatement(query)) {
				pst.setInt(1, id);
				ResultSet rs = pst.executeQuery();
				if (rs.next()) {

					user = resultbyUser(rs);

				}
			}
		} catch (SQLException e) {
			throw new DaoException(e.getMessage());
		}

		return user;

	}
	


	public static boolean checkMailAvailable(String email) throws DaoException {
		try (Connection con = ConnectionUtil.getConnection()) {
			String query = "SELECT email FROM user WHERE email = ? ";
			try (PreparedStatement pst = con.prepareStatement(query)) {

				pst.setString(1, email);
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

	public static boolean checkMailAndPassword(String email,String password) throws  DaoException {
		try (Connection con = ConnectionUtil.getConnection()) {
			String query = "SELECT email FROM user WHERE email = ? and password = ? ";
			try (PreparedStatement pst = con.prepareStatement(query)) {
				
				pst.setString(1, email);
				pst.setString(2, password);
				ResultSet rs = pst.executeQuery();
				
			if(rs.next()) {
				
				return true;
			}
				
			}
		} catch (SQLException e) {
			throw new DaoException(e.getMessage());
		}
		return false;
	}
	
}
