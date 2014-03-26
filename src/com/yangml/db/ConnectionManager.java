package com.yangml.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	private ConnectionManager(){
		//System.out.println("---"+i);
	}
	private static ConnectionManager instance;
	private static Connection conn = null;

	public static final ConnectionManager getInstance(){
		if(instance == null){
			synchronized (ConnectionManager.class) {
				if(instance ==null){
					instance = new ConnectionManager();
				}
			}
		}
		return instance;
	}
	static{
		try {
			Class.forName(DBConfig.DB_DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public Connection getConnection(){
		try {
			conn = DriverManager.getConnection(DBConfig.DB_URL,DBConfig.DB_USER,DBConfig.DB_PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
}
