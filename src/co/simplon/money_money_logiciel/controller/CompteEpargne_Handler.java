package co.simplon.money_money_logiciel.controller;

import co.simplon.money_money_logiciel.dao.DaoEpargne;

public class CompteEpargne_Handler {
	
	
	
	
//////////////////AFFICHAGE DU NOM DU CLIENT////////////////////
	
public static String affichageNomDuClient(int id_client) {
return DaoEpargne.getNomClient(id_client);
}






////////////////AFFICHAGE DES TAUX D'INTÉRÊTS DU COMPTE EPARGNE////////////////////

public static double affichageTauxInteret(int id_epargne) {
return DaoEpargne.getTauxInteret(id_epargne);	}







//////////////////MODIFICATION DU NOM DU CLIENT////////////////////

public static boolean modificationNomDuClient(int id_client, String nom_client) {
	
	if(nom_client != null && !nom_client.trim().isEmpty() && nom_client.length()<50)  {
		DaoEpargne.UpdateNomClient(id_client, nom_client);
		
		return true;
	}
	else {
		return false;
	}


}





//////////////////MODIFICATION DES TAUX D'INTÉRÊTS DU COMPTE EPARGNE////////////////////

public static boolean ModificationTauxInteretEpargneDao(int id_courant,double taux) {
	
	if(taux  > 0)  {
		DaoEpargne.UpdateTauxInteretEpargne(id_courant, taux);
		
		return true;
	}
	else {
		return false;
	}

}


}
