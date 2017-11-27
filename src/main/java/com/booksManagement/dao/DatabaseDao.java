package com.booksManagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;

import com.booksManagement.util.DatabaseUtil;

public class DatabaseDao implements DatabaseUtil{

	private static DatabaseUtil instance;
	
	public Connection getConnection() {
		Connection con = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://" + AppProps.hostname + "/" + AppProps.dbname, AppProps.username, AppProps.password);
			return con;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}

	public void close(Connection con) {
		try {
			con.close();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public synchronized static DatabaseUtil getInstance() {
		if (instance == null) {
			instance = new DatabaseDao();
		}
		return instance;
	}

}
