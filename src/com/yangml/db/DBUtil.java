package com.yangml.db;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


public class DBUtil {
	//2013.7.25 增加快捷菜单限制数量 by dhai
	private static int i=1;
	private DBUtil(){
		System.out.println(i++ +"<<<<<<<<<<<<<<<<<--");
	}
	public static String getStr(String str){
		Properties pr = new Properties();
		InputStream is = DBUtil.class.getResourceAsStream("/dbConn.properties");
		try {
			pr.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pr.getProperty(str);
	}
	public static Connection getConn() {
		System.out.println(i++ +"<<<<<<<<<<<<<<<<<--");
		return ConnectionManager.getInstance().getConnection();
    }
	public static void close(ResultSet rs) {
		try {
			if(rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			rs = null;
		}
	}
	
	public static void close(Statement stmt) {
		try {
			if(stmt != null) {
				stmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			stmt = null;
		}
	}
	public static void close(Connection conn) {
		try {
			if(conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			conn = null;
		}
	}
	

}
