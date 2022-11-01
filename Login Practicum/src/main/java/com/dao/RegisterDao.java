package com.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.bean.RegisterBean;
import com.util.DBConnection;

public class RegisterDao {
	public String registerUser(RegisterBean registerBean) {
	     String fullName = registerBean.getFullName();
         String userName = registerBean.getUserName();
         String email = registerBean.getEmail();
         String password = registerBean.getPassword();
         
         Connection cnct = null;
         PreparedStatement preparedStatement = null;         
         try
         {
             cnct = DBConnection.makeConnection();
             String query = "insert into users(SlNo,fullName,email,userName,password) values (NULL,?,?,?,?)"; 
             preparedStatement = cnct.prepareStatement(query); 
             preparedStatement.setString(1, fullName);
             preparedStatement.setString(2, email);
             preparedStatement.setString(3, userName);
             preparedStatement.setString(4, password);
             
             int i= preparedStatement.executeUpdate();
             
             if (i!=0) 
             return "SUCCESS"; 
         }
         catch(SQLException e)
         {
            e.printStackTrace();
         }
         return "Something's gone wrong :(";
	}
}