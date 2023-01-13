package co.simplon.money_money_logiciel.dao;

import java.sql.*;

public class DaoClient {

	public static int getIdClient(String nomClient) {
		try {
			Statement st = LiensBdd.connectionBdd();
			String rq = "SELECT * FROM Client WHERE Nom_Client LIKE '" + nomClient + "'";
			ResultSet rs = st.executeQuery(rq);
			if (rs.next()) {
			} else {
				String rq2 = "INSERT INTO Client (nom_client) VALUES ('" + nomClient + "')";
				PreparedStatement pst = LiensBdd.connectionBddPrep(rq2);
				pst.executeUpdate();

				Statement st2 = LiensBdd.connectionBdd();
				rs = st2.executeQuery(rq);
				rs.next();
			}
			LiensBdd.closeBdd();
			return rs.getInt(1);
		} catch (SQLException e) {
			System.out.println("SQL Execption");
		}
		return 0;
	}

}
