package co.simplon.money_money_logiciel.controller;

import co.simplon.money_money_logiciel.dao.DaoCourant;

public class CompteCourant_Handler {
	
	
	
	
	//////////////////AFFICHAGE DU NOM DU CLIENT////////////////////
	
	public static String affichageNomDuClient(int id_client) {
		return DaoCourant.getNomClient(id_client);
	}
	
	

	
	
	////////////////AFFICHAGE DES FRAIS DE TRANSFERT DU COMPTE COURANT////////////////////

	public static double affichageFraisDeTransfert(int id_courant) {
		return DaoCourant.getFraisDeTransfert(id_courant);	}
	
	
	
	
	
	
	
	//////////////////MODIFICATION DU NOM DU CLIENT////////////////////

	public static Boolean modificationNomDuClient(int id_client, String nom_client) {
		
		if(nom_client != null && !nom_client.trim().isEmpty() && nom_client.length()<50)  {
			DaoCourant.UpdateNomClient(id_client, nom_client);
			
			return true;
		}
		else {
			return false;
		}
	
	}
	
	
	
	
	
	//////////////////MODIFICATION DES FRAIS DE TRANSFERT DU COMPTE COURANT////////////////////
	
	public static boolean modificationFraisDeTransfertCourantDao(int id_courant,double frais_transfert) {
		
		if(frais_transfert > 0)  {
			DaoCourant.UpdateFraisDeTransfertCourantDao(id_courant, frais_transfert);
			
			return true;
		}
		else {
			return false;
		}
		
	}

	
	

}
