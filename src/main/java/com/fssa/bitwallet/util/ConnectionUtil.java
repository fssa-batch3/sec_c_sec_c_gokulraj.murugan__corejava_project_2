package com.fssa.bitwallet.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionUtil {
	public static Connection getConnection() {
		Connection con = null;

		String url;
		String userName;
		String passWord;

        url = "jdbc:mysql://localhost:3306/bitwallet";
        userName = "root";
        passWord="123456";

//		url = System.getenv("DATABASE_HOST");
//		userName = System.getenv("DATABASE_USERNAME");
//		passWord = System.getenv("DATABASE_PASSWORD");

//        if (System.getenv("CI") != null) {
//            url = System.getenv("DATABASE_HOST");
//            userName = System.getenv("DATABASE_USERNAME");
//            passWord = System.getenv("DATABASE_PASSWORD");
//        } else {
//            Dotenv env = Dotenv.load();
//            url = env.get("DATABASE_HOST");
//            userName = env.get("DATABASE_USERNAME");
//            passWord = env.get("DATABASE_PASSWORD");
//        }

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, userName, passWord);
		} catch (Exception e) {
			throw new RuntimeException("Unable to connect to the database");
		}
		return con;
	}

	public static void close(Connection conn, Statement stmt, ResultSet rs) {

		try {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// No need re throw the exception.
		}
	}

}