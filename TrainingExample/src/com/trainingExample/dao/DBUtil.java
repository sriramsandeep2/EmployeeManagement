package com.trainingExample.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {
	
/*	private static  String DRIVER_NAME = "com.mysql.jdbc.Driver";
	private static Connection con;
	private static Properties p=null;
	
	static {
		try{
			Class.forName(DRIVER_NAME);
			p = new Properties();
			InputStream input =  DBUtil.class.getClassLoader().getResourceAsStream("database.properties");
			p.load(input);
			System.out.println(p.getProperty("PASSWORD"));
		}catch(ClassNotFoundException |IOException e){
			e.printStackTrace();
		}
			
	}
	
	public void name() throws IOException {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		Properties pp = new Properties();
		InputStream input = classLoader.getResourceAsStream("database.properties");
		pp.load(input);
		System.out.println(pp.getProperty("DB_URL"));
		assertTrue(true);
	}
	
	
	public static Connection getConnection(){
		try{
			String user = p.getProperty("USER");
			String password = p.getProperty("PASSWORD");
			//DRIVER_NAME = p.getProperty("DRIVER_NAME");
			String dbUrl = p.getProperty("DB_URL");
			System.out.println(user);
			con = DriverManager.getConnection(dbUrl, user, password);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return con;
	}*/
	
	//---------------------------------------------------------------------------------------------------
	private Connection con;
	private Properties p=null;
	
	{
		try{
			p = new Properties();
			InputStream input =  DBUtil.class.getClassLoader().getResourceAsStream("database.properties");
			p.load(input);
			Class.forName(p.getProperty("DRIVER_NAME"));
		}catch(ClassNotFoundException |IOException e){
			e.printStackTrace();
		}
			
	}
	public Connection getConnection(){
		try{
			String user = p.getProperty("USER");
			String password = p.getProperty("PASSWORD");
			String dbUrl = p.getProperty("DB_URL");
			System.out.println("user: "+user);
			con = DriverManager.getConnection(dbUrl, user, password);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return con;
	}
	
	
}
