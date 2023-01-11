package co.simplon.money_money_logiciel.dao;

import java.sql.*;

public class Dao {

	public static void connectionBdd() {
		try {
			Statement st = LiensBdd.connectionBdd();
			ResultSet rs = st.executeQuery("SELECT * FROM Banque");
			while (rs.next()) {
				rs.getString(2);
				System.out.println(rs.getString(2));
			}
			;
			LiensBdd.closeBdd();
		} catch (SQLException e) {
			System.out.println("Class not found");
		}
	}

}
