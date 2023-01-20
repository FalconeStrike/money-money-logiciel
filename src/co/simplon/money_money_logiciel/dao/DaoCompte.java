package co.simplon.money_money_logiciel.dao;

import java.sql.*;

import co.simplon.money_money_logiciel.modeles.Compte;

/**
 * Classe DaoCompte qui regroupe les requêtes SQL qui concerne le modèle Compte
 * 
 * @author Ondine
 *
 */

public class DaoCompte {

	/**
	 * Requête SQL qui permet de trouver le numéro d'un compte par son id
	 * 
	 * @param id_compte l'id du compte
	 * @return le numéro du compte
	 */
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

	/**
	 * Requête SQL qui permet de trouver le solde d'un compte par son id
	 * 
	 * @param id_compte l'id du compte
	 * @return le solde du compte
	 */
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

	/**
	 * Requête SQL qui permet de modifier le solde d'un compte en lui soustrayant
	 * une somme précise
	 * 
	 * @param id_compte l'id du compte
	 * @param somme     la somme à enlever
	 */
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

	/**
	 * Requête SQL qui permet de modifier le solde d'un compte en lui ajoutant une
	 * somme précise
	 * 
	 * @param id_compte l'id du compte
	 * @param somme     la somme à ajouter
	 */
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

	public static ResultSet getListComptedestination(int id_compte, int id_client) {
		try {
			Statement st = LiensBdd.connectionBdd();
			ResultSet rs = st.executeQuery(
					"SELECT * FROM compte INNER JOIN type_compte ON compte.id_typecompte = type_compte.id_typecompte WHERE id_client = "
							+ id_client + " AND NOT id_compte =" + id_compte);
			LiensBdd.closeBdd();
			return rs;
		} catch (SQLException e) {
			System.out.println("SQL Exception found");
		}
		return null;
	}

	public static ResultSet getAllCompte(int id_client) {
		try {
			Statement st = LiensBdd.connectionBdd();
			ResultSet rs = st.executeQuery("SELECT * FROM Compte\r\n" + "WHERE ID_Client = " + id_client);
			LiensBdd.closeBdd();
			return rs;
		} catch (SQLException e) {
			System.out.println("SQL Exception found");
		}
		return null;
	}
	
	public static Boolean deleteCompte(Compte compte) {
		try {
			Boolean isClientDel = false;
			String rq = "";
			if (compte.getID_Typecompte() == 1) {
				rq = "DELETE FROM Epargne WHERE ID_Compte = " + compte.getID_Compte();
			} else {
				rq = "DELETE FROM Courant WHERE ID_Compte = " + compte.getID_Compte();
			}
			PreparedStatement pst = LiensBdd.connectionBddPrep(rq);
			pst.executeUpdate();
			rq = "DELETE FROM Compte WHERE ID_Compte = " + compte.getID_Compte();
			PreparedStatement pst2 = LiensBdd.connectionBddPrep(rq);
			pst2.executeUpdate();
			Statement st = LiensBdd.connectionBdd();
			ResultSet rs = st.executeQuery("SELECT ID_Compte FROM Compte WHERE ID_Client = " + compte.getID_Client());
			if (!rs.next()) {
				rq = "DELETE FROM Client WHERE ID_Client = " + compte.getID_Client();
				PreparedStatement pst3 = LiensBdd.connectionBddPrep(rq);
				pst3.executeUpdate();
				isClientDel = true;
			}
			LiensBdd.closeBdd();
			return isClientDel;
		} catch (SQLException e) {
			System.out.println("SQL Exception found: Delete impossible");
		}
		return false;
	}

	/**
	 * Méthode qui permet d'insérer un compte dans la table compte avec tous ses
	 * paramètres
	 * 
	 * @param num_compte  le numéro du compte
	 * @param id_client   l'id du client qui possède le compte
	 * @param solde_init  le solde du compte
	 * @param type_compte le type du compte, courant ou épargne
	 * @param libelle     le libellé client du compte
	 * @return l'id du compte créé
	 */
	public static int creerCompteDao(int num_compte, int id_client, float solde_init, int type_compte, String libelle) {
		try {
			String rq = "INSERT INTO Compte (ID_TypeCompte, Num_Compte, ID_Client, Solde_Init, Libelle_Client) VALUES ('"
					+ type_compte + "','" + num_compte + "','" + id_client + "','" + solde_init + "','" + libelle
					+ "')";
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

	/**
	 * Requête SQL qui permet d'insèrer un compte dans la table Compte Courant avec
	 * frais de transfert et solde minimum définis
	 * 
	 * @param id_compte       l'id du compte
	 * @param frais_transfert
	 * @param solde_min
	 */
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

	/**
	 * Requête SQL qui permet d'insèrer un compte dans la table Compte Epargne avec
	 * taux et plafond définis
	 * 
	 * @param id_compte l'id du compte
	 * @param taux
	 * @param plafond
	 */
	public static void creerCompteEpargneDao(int id_compte, float taux, float plafond) {
		try {
			String rq = "INSERT INTO epargne (ID_Compte, Taux, Plafond) VALUES ('" + id_compte + "','" + taux + "','"
					+ plafond + "')";
			PreparedStatement prest = LiensBdd.connectionBddPrep(rq);
			prest.executeUpdate();
			LiensBdd.closeBdd();
		} catch (SQLException e) {
			System.out.println("SQL Exception found");
		}

	}
}
