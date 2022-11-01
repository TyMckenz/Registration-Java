package com.util;

import java.sql.Connection; 
import java.sql.DriverManager;

public class DBConnection {
	public static Connection makeConnection() {
		Connection cnct = null;
		String url = "jbdc:mysql://localhost:3306/practicum";
		String username = "root";
		String password = "";
		
		try {
				try {
					Class.forName("com.mysql.jdbc.Driver");
				}
				catch (ClassNotFoundException e)
		         {
		            
		         }
				cnct = DriverManager.getConnection(url, username, password);
		}
		catch (Exception e) {
			
		}
		return cnct;
	}
}