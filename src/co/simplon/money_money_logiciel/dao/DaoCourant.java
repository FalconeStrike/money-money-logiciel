package co.simplon.money_money_logiciel.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DaoCourant {
	
	
	///////////////////////////////////RÉCUPÉRATION DU COMPTE COURANT POUR POUVOIR SÉLECTIONNER ET MANIPULER LE COMPTE////////////////////////////////////

	

	public static int getNumeroCompteCourant(int id_courant) {
		int numeroCompteCourant = 0;
		try {
			Statement st = LiensBdd.connectionBdd();
			ResultSet rs = st.executeQuery("SELECT id_courant FROM courant WHERE id_courant = " + id_courant);
			rs.next();
			numeroCompteCourant = rs.getInt(1);
			LiensBdd.closeBdd();
		} catch (SQLException e) {
			System.out.println("SQL Exception found");
		}
		return numeroCompteCourant;
		
	}
	
	
	
	
//////////////////////////////////////////////RÉCUPÉRATION DU NOM DU CLIENT POUR L'AFFICHAGE DANS LE  FRONT///////////////////
	
public static String getNomClient(int id_client) {
	
	
		String nomDuclient= "" ;
		
		try {
			Statement st = LiensBdd.connectionBdd();
			ResultSet rs = st.executeQuery("SELECT nom_client FROM client WHERE id_client = " + id_client);
			rs.next();
			nomDuclient= rs.getString(1);
			LiensBdd.closeBdd();
		} catch (SQLException e) {
			System.out.println("SQL Exception found");
		}
		return nomDuclient;
		
		
	}
	
	
	
	//////////////////////////////////////////MODIFICATION DU NOM DU CLIENT///////////////////////////////////////////////////
	
	
	
	public static void UpdateNomClient(int id_client, String nom_client) {
		try {
		PreparedStatement st = LiensBdd.connectionBddPrep("UPDATE client SET nom_client = ? WHERE id_client = ? ;");
		st.setString(1,nom_client);
		st.setInt(2,id_client);
		st.executeUpdate();
		LiensBdd.closeBdd();
		} 
		catch (SQLException e) {
		System.out.println("Class not found " + e);
		} 
	}

	
	
	///////////////////////////////////RÉCUPÉRATION DES FRAIS DE TRANSFERT ACTUELS DU COMPTE COURANT POUR LES AFFICHER DANS LE FRONT////////////////////////////////////
	
	
	
	public static double getFraisDeTransfert(int id_courant) {
		
		double fraisDeTransfert = 0;
		try {
			Statement st = LiensBdd.connectionBdd();
			ResultSet rs = st.executeQuery("SELECT frais_transfert FROM courant WHERE id_courant = " + id_courant);
			rs.next();
			fraisDeTransfert = rs.getDouble(1);
			LiensBdd.closeBdd();
		} catch (SQLException e) {
			System.out.println("SQL Exception found");
		}
		return fraisDeTransfert;
		
		
	}
	
	

	
	
	///////////////////////////////////ENREGISTREMENT DES NOUVEAUX FRAIS DE TRANSFERT DU COMPTE COURANT////////////////////////////////////

	
	
	public static void UpdateFraisDeTransfertCourantDao(int id_courant,double frais_transfert) {
		
		
		try {
			
		PreparedStatement st = LiensBdd.connectionBddPrep("UPDATE courant SET frais_transfert = ? WHERE id_courant = "+id_courant);
		st.setDouble(1,frais_transfert);
		st.executeUpdate();
		LiensBdd.closeBdd();
		} 
		catch (SQLException e) {
		System.out.println("Class not found " + e);
		} 
	
		
	}
	
	
	////////////////////////////////////////////////////////////
	
	
	
	
	//SELECT * id_courant,id_epargne From compte + id_compte WHERE id

}
