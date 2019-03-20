package sis.com.util.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//import java.sql.*;
public class DBConnectionUtil{
	//1. load driver
	private static final String DRIVER_CLASS_NAME="oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String USER = "system";
	private static final String PASS = "root";
		
	static{
		try{
			Class.forName(DRIVER_CLASS_NAME);
		}catch(Exception e){
			System.out.println("DB ERROR: "+e.getMessage());
		}
	}
	//2. get connection
	public static Connection getConnection(){
		Connection con=null;
		try{
			con=DriverManager.getConnection(URL,USER,PASS);
		}catch(SQLException e){
			System.out.println("DB ERROR: "+e.getMessage());
		}
	    return con;
	}
	
	//3. close connection
	public static void closeConnection(Connection con)throws SQLException{
		if(con!=null){
			con.close();
		}
	}
	
}