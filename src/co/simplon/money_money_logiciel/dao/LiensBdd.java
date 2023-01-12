package co.simplon.money_money_logiciel.dao;

import java.io.*;
import java.sql.*;
import java.util.*;

public class LiensBdd {
	public static Statement connectionBdd() {
		try {
			InputStream inputStream = new FileInputStream("MyConfigs.properties");
			Properties properties = new Properties();
			properties.load(inputStream);
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_bancaire",
					properties.getProperty("login"), properties.getProperty("password"));
			Statement st = conn.createStatement();
			return st;
		} catch (ClassNotFoundException e) {
			System.out.println("Class not found");
		} catch (SQLException e) {
			System.out.println("SQL Exception found");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static PreparedStatement connectionBddPrep(String requete) {
		try {
			InputStream inputStream = new FileInputStream("MyConfigs.properties");
			Properties properties = new Properties();
			properties.load(inputStream);
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_bancaire",
					properties.getProperty("login"), properties.getProperty("password"));
			PreparedStatement pres = conn.prepareStatement(requete);
			return pres;
		} catch (ClassNotFoundException e) {
			System.out.println("Class not found");
		} catch (SQLException e) {
			System.out.println("SQL Exception found");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void closeBdd() {
		try {
			InputStream inputStream = new FileInputStream("MyConfigs.properties");
			Properties properties = new Properties();
			properties.load(inputStream);
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_bancaire",
					properties.getProperty("login"), properties.getProperty("password"));
			conn.close();
		} catch (SQLException e) {
			System.out.println("SQL Exception found");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
