package com.yangml.db;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DBConfig {
	public static String DB_DRIVER;
	public static String DB_URL;
	public static String DB_USER;
	public static String DB_PASSWORD;
	static{
		Properties prop = new Properties();
		InputStream is = DBConfig.class.getResourceAsStream("/dbConn.properties");
		try {
			prop.load(is);
			is.close();
		} catch (IOException e) {
		}
		DB_DRIVER = prop.getProperty("driver");
		DB_URL = prop.getProperty("url");
		DB_USER = prop.getProperty("username");
		DB_PASSWORD = prop.getProperty("password");
	}
}
