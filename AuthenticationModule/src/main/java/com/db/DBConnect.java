package com.db;

import java.sql.*;

public class DBConnect {
	private static Connection conn;
	
	public static Connection getConnection() {
		
		try{
			if(conn==null) {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/loginpage2?autoReconnect=true&useSSL=false","root","Deeplahane2001#1");
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
}
