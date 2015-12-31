package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * TIMESTEN学习
 * @author guoyl
 *
 */
public class TimesTenTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//远程连接需要的url，程序和TT不在一台服务器。需要按照上节的方法，提前定义好DSN
		//String URL = "jdbc:timesten:client:dsn=tt1122_32";
		//本地连接需要的url，程序和TT在同一台服务器
		String URL = "jdbc:timesten:direct:dsn=tt1122_32";
        Connection con;  
        ResultSet rs;  
        try {  
        	//设置用户密码
            con = DriverManager.getConnection(URL,"timesten","timesten");  
            Statement stmt = con.createStatement();  
            stmt.execute("select * from test1 ");  
            rs = stmt.getResultSet();  
            while (rs.next()) {
                System.out.println(rs.getString("A")+"--->"+rs.getString("B"));  
            }  
            rs.close();  
            stmt.close();  
            con.close();  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
	}

}
