package co.simplon.money_money_logiciel.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DaoEpargne {

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

//////////////////////////////////////////MODIFICATION DU NOM DU CLIENT///////////////////////////////////////////////////

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

///////////////////////////////////RÉCUPÉRATION DES TAUX D'INTÉRÊT ACTUELS DU COMPTE EPARGNE POUR LES AFFICHER DANS LE FRONT////////////////////////////////////

	public static double getTauxInteret(int id_epargne) {

		double tauxInteret = 0;
		try {
			Statement st = LiensBdd.connectionBdd();
			ResultSet rs = st.executeQuery("SELECT taux FROM epargne WHERE id_epargne = " + id_epargne);
			rs.next();
			tauxInteret = rs.getDouble(1);
			LiensBdd.closeBdd();
		} catch (SQLException e) {
			System.out.println("SQL Exception found");
		}
		return tauxInteret;

	}

///////////////////////////////////ENREGISTREMENT DES NOUVEAUX TAUX D'INTÉRÊTS DU COMPTE EPARGNE////////////////////////////////////

	public static void UpdateTauxInteretEpargne(int id_compte, double taux) {

		try {

			PreparedStatement st = LiensBdd
					.connectionBddPrep("UPDATE epargne SET taux = ? WHERE id_compte = " + id_compte);
			st.setDouble(1, taux);
			st.executeUpdate();
			LiensBdd.closeBdd();
		} catch (SQLException e) {
			System.out.println("Class not found " + e);
		}

	}

}
