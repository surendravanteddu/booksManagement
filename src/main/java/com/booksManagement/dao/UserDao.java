package com.booksManagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.booksManagement.entity.UserEntity;
import com.booksManagement.util.DatabaseUtil;
import com.booksManagement.util.UserUtil;

public class UserDao implements UserUtil{

	DatabaseUtil dao;
	public UserDao(){
		dao = DatabaseDao.getInstance();
	}
	
	@Override
	public String registerUser(UserEntity user) {
		Connection con = dao.getConnection();
		String result = "";
		try{
			PreparedStatement ps = con.prepareStatement("insert into user_info (email, password) values (?,?)");
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getPassword());
			
			result = (ps.executeUpdate() == 1) ? "SUCCESS" : "FAILED"; 
		}catch(Exception ex){
			System.out.println(ex.getMessage());
			result = ex.getMessage();
		}
		finally{
			dao.close(con);
		}
		return result;
	}

	@Override
	public boolean loginUser(String email, String password) {
		Connection con = dao.getConnection();
		try{
			PreparedStatement ps = con.prepareStatement("select email from user_info where email=? and password =?");
			
			ps.setString(1, email);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			return rs.next();
		}catch(Exception ex){
			System.out.println(ex.getMessage());
			return false;
		}
		finally{
			dao.close(con);
		}
	}
}
