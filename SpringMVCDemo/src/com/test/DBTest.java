package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBTest {
	public static void  main(String args[]){
		String driverClassName="org.sqlite.JDBC";
		String url= "jdbc:sqlite:test.db";
		   try {
			Class.forName(driverClassName);
		    Connection conn = DriverManager.getConnection(url);
		    PreparedStatement ps = conn.prepareStatement("select * from user");
		    System.out.println(ps.execute());
		    
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
