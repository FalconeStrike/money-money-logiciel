package co.simplon.money_money_logiciel.dao;

import java.sql.*;

public class DaoCompte {

	public static int getNumeroCompte(int id_compte) {
		int numeroCompte = 0;
		try {
			Statement st = LiensBdd.connectionBdd();
			ResultSet rs = st.executeQuery("SELECT Num_Compte FROM Compte WHERE ID_Compte = " + id_compte);
			rs.next();
			numeroCompte = rs.getInt(1);
			LiensBdd.closeBdd();
		} catch (SQLException e) {
			System.out.println("SQL Exception found");
		}
		return numeroCompte;
	}

	public static float getSolde(int id_compte) {
		float solde = 0;
		try {
			Statement st = LiensBdd.connectionBdd();
			ResultSet rs = st.executeQuery("SELECT Solde_Init FROM Compte WHERE ID_Compte = " + id_compte);
			rs.next();
			solde = rs.getFloat(1);
			LiensBdd.closeBdd();
		} catch (SQLException e) {
			System.out.println("SQL Exception found");
		}
		return solde;
	}

	public static void debiterCompteDao(int id_compte, float somme) {
		try {
			float solde = getSolde(id_compte);
			solde = solde - somme;
			PreparedStatement prest = LiensBdd.connectionBddPrep("UPDATE Compte SET Solde_Init = ? WHERE ID_Compte = " + id_compte);
			prest.setFloat(1, solde);
			prest.executeUpdate();
			LiensBdd.closeBdd();
		} catch (SQLException e) {
			System.out.println("SQL Exception found");
		}
	}
	
	public static void crediterCompteDao(int id_compte, float somme) {
		try {
			float solde = getSolde(id_compte);
			solde = solde + somme;
			PreparedStatement prest = LiensBdd.connectionBddPrep("UPDATE Compte SET Solde_Init = ? WHERE ID_Compte = " + id_compte);
			prest.setFloat(1, solde);
			prest.executeUpdate();
			LiensBdd.closeBdd();
		} catch (SQLException e) {
			System.out.println("SQL Exception found");
		}
	}
	
	public static ResultSet getAllCompte(int id_client) {
		try {
			Statement st = LiensBdd.connectionBdd();
			ResultSet rs = st.executeQuery("SELECT * FROM Compte\r\n"
										 + "WHERE ID_Client = " + id_client);
			LiensBdd.closeBdd();
			return rs;
		} catch (SQLException e) {
			System.out.println("SQL Exception found");
		}
		return null;
	}

}
