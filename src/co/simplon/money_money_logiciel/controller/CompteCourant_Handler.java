package co.simplon.money_money_logiciel.controller;

import co.simplon.money_money_logiciel.dao.DaoCourant;

public class CompteCourant_Handler {
	
	
	
	
	//////////////////AFFICHAGE DU NOM DU CLIENT////////////////////
	
	public static String affichageNomDuClient(int id_compte) {
		return DaoCourant.getNomClient(id_compte);
	}
	
	

	
	
	////////////////AFFICHAGE DES FRAIS DE TRANSFERT DU COMPTE COURANT////////////////////

	public static double affichageFraisDeTransfert(int id_courant) {
		return DaoCourant.getFraisDeTransfert(id_courant);	}
	
	
	
	
	
	
	
	//////////////////MODIFICATION DU NOM DU CLIENT////////////////////

	public static Boolean modificationNomDuClient(int id_compte, String libelle_client) {
		
		if(libelle_client != null && !libelle_client.trim().isEmpty() && libelle_client.length()<50)  {
			DaoCourant.UpdateNomClient(id_compte, libelle_client);
			
			return true;
		}
		else {
			return false;
		}
	
	}
	
	
	
	
	
	//////////////////MODIFICATION DES FRAIS DE TRANSFERT DU COMPTE COURANT////////////////////
	
	public static boolean modificationFraisDeTransfertCourantDao(int id_compte,double frais_transfert) {
		
		if(frais_transfert > 0)  {
			DaoCourant.UpdateFraisDeTransfertCourantDao(id_compte, frais_transfert);
			
			return true;
		}
		else {
			return false;
		}
		
	}

	
	

}
