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
			PreparedStatement prest = LiensBdd
					.connectionBddPrep("UPDATE Compte SET Solde_Init = ? WHERE ID_Compte = " + id_compte);
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
			PreparedStatement prest = LiensBdd
					.connectionBddPrep("UPDATE Compte SET Solde_Init = ? WHERE ID_Compte = " + id_compte);
			prest.setFloat(1, solde);
			prest.executeUpdate();
			LiensBdd.closeBdd();
		} catch (SQLException e) {
			System.out.println("SQL Exception found");
		}
	}

	public static int creerCompteDao(int num_compte, int id_client, float solde_init, int type_compte) {
		try {
			String rq = "INSERT INTO Compte (ID_TypeCompte, Num_Compte, ID_Client, Solde_Init) VALUES ('" + type_compte
					+ "','" + num_compte + "','" + id_client + "','" + solde_init + "')";
			PreparedStatement prest = LiensBdd.connectionBddPrep(rq);
			prest.executeUpdate();
			Statement st = LiensBdd.connectionBdd();
			String rq2 = "SELECT * FROM Compte WHERE Num_Compte LIKE '" + num_compte + "'";
			ResultSet rs = st.executeQuery(rq2);
			rs.next();
			LiensBdd.closeBdd();
			return rs.getInt(1);

		} catch (SQLException e) {
			System.out.println("SQL Exception found");
		}
		return 0;
	}

	public static void creerCompteCourantDao(int id_compte, float frais_transfert, float solde_min) {
		try {
			String rq = "INSERT INTO courant (ID_Compte, Frais_Transfert, Solde_Min) VALUES ('" + id_compte + "','"
					+ frais_transfert + "','" + solde_min + "')";
			PreparedStatement prest = LiensBdd.connectionBddPrep(rq);
			prest.executeUpdate();
			LiensBdd.closeBdd();
		} catch (SQLException e) {
			System.out.println("SQL Exception found");
		}

	}

	public static void creerCompteEpargneDao(int id_compte, float taux, float plafond) {
		try {
			String rq = "INSERT INTO courant (ID_Compte, Taux, Plafond) VALUES ('" + id_compte + "','" + taux + "','"
					+ plafond + "')";
			PreparedStatement prest = LiensBdd.connectionBddPrep(rq);
			prest.executeUpdate();
			LiensBdd.closeBdd();
		} catch (SQLException e) {
			System.out.println("SQL Exception found");
		}

	}
}
