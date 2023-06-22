package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;

import com.entities.User;
import com.mysql.jdbc.PreparedStatement;

public class UserDAO {

	private Connection conn;

	public UserDAO(Connection conn) {
		super(); 
		this.conn=conn;
	}
	
	public Boolean registerUser(User user) {
		boolean f=false;
		
		try {
				String query="INSERT INTO user(name,email,password) VALUES(?,?,?);";
				java.sql.PreparedStatement ps=(java.sql.PreparedStatement ) conn.prepareStatement(query);
				ps.setString(1, user.getName());
				ps.setString(2,user.getEmail());
				ps.setString(3,user.getPassword());
				
				ps.executeUpdate();
				f=true;
				
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}
	
	public User loginUser(String email,String password) {
		User user=null;
		
		try {
			
			String query="SELECT * FROM user WHERE email=? AND password=? ;";
			java.sql.PreparedStatement pst=conn.prepareStatement(query);
			pst.setString(1, email);
			pst.setString(2,password);
			
			ResultSet rs=pst.executeQuery();
			
			if(rs.next()) {
				user=new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return user;
	}
	
}
