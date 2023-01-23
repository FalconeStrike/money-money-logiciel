package co.simplon.money_money_logiciel.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DaoCourant {

//////////////////////////////////////////////RÉCUPÉRATION DU NOM DU CLIENT POUR L'AFFICHAGE DANS LE  FRONT///////////////////

	public static String getNomClient(int id_compte) {

		String nomDuclient = "";

		try {
			Statement st = LiensBdd.connectionBdd();
			ResultSet rs = st.executeQuery("SELECT libelle_client FROM compte WHERE id_compte = " + id_compte);
			rs.next();
			nomDuclient = rs.getString(1);
			LiensBdd.closeBdd();
		} catch (SQLException e) {
			System.out.println("SQL Exception found");
		}
		return nomDuclient;

	}

	////////////////////////////////////////// MODIFICATION DU NOM DU
	////////////////////////////////////////// CLIENT///////////////////////////////////////////////////

	public static void UpdateNomClient(int id_compte, String libelle_client) {
		try {
			PreparedStatement st = LiensBdd.connectionBddPrep("UPDATE compte SET libelle_client = ? WHERE id_compte = ? ;");
			st.setString(1, libelle_client);
			st.setInt(2, id_compte);
			st.executeUpdate();
			LiensBdd.closeBdd();
		} catch (SQLException e) {
			System.out.println("Class not found " + e);
		}
	}

	/////////////////////////////////// RÉCUPÉRATION DES FRAIS DE TRANSFERT ACTUELS
	/////////////////////////////////// DU COMPTE COURANT POUR LES AFFICHER DANS LE
	/////////////////////////////////// FRONT////////////////////////////////////

	public static double getFraisDeTransfert(int id_compte) {

		double fraisDeTransfert = 0;
		try {
			Statement st = LiensBdd.connectionBdd();
			ResultSet rs = st.executeQuery("SELECT frais_transfert FROM courant WHERE id_compte = " + id_compte);
			rs.next();
			fraisDeTransfert = rs.getDouble(1);
			LiensBdd.closeBdd();
		} catch (SQLException e) {
			System.out.println("SQL Exception found");
		}
		return fraisDeTransfert;

	}

	/////////////////////////////////// ENREGISTREMENT DES NOUVEAUX FRAIS DE
	/////////////////////////////////// TRANSFERT DU COMPTE
	/////////////////////////////////// COURANT////////////////////////////////////

	public static void UpdateFraisDeTransfertCourantDao(int id_compte, double frais_transfert) {

		try {

			PreparedStatement st = LiensBdd
					.connectionBddPrep("UPDATE courant SET frais_transfert = ? WHERE id_compte = " + id_compte);
			st.setDouble(1, frais_transfert);
			st.executeUpdate();
			LiensBdd.closeBdd();
		} catch (SQLException e) {
			System.out.println("Class not found " + e);
		}

	}

	////////////////////////////////////////////////////////////
}
