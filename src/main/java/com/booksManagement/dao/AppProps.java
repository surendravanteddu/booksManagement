package com.booksManagement.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppProps {

	public static String hostname;
	public static String username;
	public static String password;
	public static String dbname;
	public static String tokenSecret;
  
	static {
		try {
			new AppProps().setProps();
		} catch (IOException e) {
            System.out.println(e.getMessage());
		}
	}
	
	public void setProps() throws IOException {
		Properties prop = new Properties();
		InputStream input = null;

		input = this.getClass().getClassLoader().getResourceAsStream("config.properties");
		// load a properties file
		prop.load(input);

		hostname = prop.getProperty("hostname");
		username = prop.getProperty("dbusername");
		password = prop.getProperty("dbpassword");
		dbname = prop.getProperty("dbname");
		tokenSecret = prop.getProperty("tokensecret");

	}


}
