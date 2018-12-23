package com.revature.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {

	private static final String filename = "connection.properties";
	public static Connection getConnection() throws SQLException, IOException {
		Properties prop = new Properties();
		InputStream in = new FileInputStream(filename);
		prop.load(in);
		System.out.println(prop);
		return DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("user"), prop.getProperty("pass"));
	}
}