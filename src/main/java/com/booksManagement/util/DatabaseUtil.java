package com.booksManagement.util;

import java.sql.Connection;

public interface DatabaseUtil {

	public Connection getConnection();
	public void close(Connection con);
	
}
