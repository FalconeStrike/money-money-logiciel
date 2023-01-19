package co.simplon.money_money_logiciel.dao;

import java.sql.*;

/**
 *  Classe DaoClient qui regroupe les requêtes SQL qui concerne le modèle Client
 * @author Julien
 * @author Ondine
 *
 */
public class DaoClient {

	/**
	 * Requête SQL qui permet de trouver un client par son nom et d'en créer un si le client n'existe pas dans la base
	 * @param nomClient
	 * @return l'id du client
	 */
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

	/**
	 * Requête qui permet de récupérer le nom d'un client par son id
	 * @param idClient
	 * @return le nom du client
	 */
	public static String getNameById(int idClient) {
		String libelleClient = " ";
		try {
			Statement st = LiensBdd.connectionBdd();
			String rq = "SELECT * FROM Client WHERE ID_Client LIKE '" + idClient + "'";
			ResultSet rs = st.executeQuery(rq);
			rs.next();
			LiensBdd.closeBdd();
			libelleClient = rs.getString(2);
		} catch (SQLException e) {
			System.out.println("SQL Exception");
		}
		return libelleClient;
	}

	/**
	 * Requête pour récupérer la liste de tous les clients existants
	 * @return la liste des clients en type ResultSet
	 */
	public static ResultSet getAllClients() {
		try {
			Statement st = LiensBdd.connectionBdd();
			String rq = "SELECT * FROM Client";
			ResultSet rs = st.executeQuery(rq);
			LiensBdd.closeBdd();
			return rs;
		} catch (SQLException e) {
			System.out.println("SQL Exception");
		}
		return null;

	}

}
