package edu.kh.common;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class JDBC_TEMPLATE {
  
	
	private static Connection conn = null;
	
	
	public static Connection getConnection() {
		
		try {
			
			if(conn == null || conn.isClosed()) {
				
				Properties prop = new Properties();
				
				String filePath = JDBC_TEMPLATE.class.getResource("/edu/kh/xmlFile/driver.xml").getPath();
				
				prop.loadFromXML(new FileInputStream(filePath));
				
				String driver = prop.getProperty("driver");
				String url = prop.getProperty("url");
				String user = prop.getProperty("user");
				String password = prop.getProperty("password");
				
				Class.forName(driver);
				
				conn = DriverManager.getConnection(url,user,password);
				
				conn.setAutoCommit(false);
				
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return conn;
		
	}
	
	public static void commit(Connection conn) {
		try {
			
			if(conn != null) {
				conn.commit();
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void rollback(Connection conn) {
		try {
			
			if(conn != null) {
				conn.rollback();
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Connection conn) {
		try {
			
			if(conn != null) {
				conn.close();
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Statement stmt) {
		try {
			
			if(stmt != null) {
				stmt.close();
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet rs) {
		try {
			
			if(rs != null) {
				rs.close();
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
