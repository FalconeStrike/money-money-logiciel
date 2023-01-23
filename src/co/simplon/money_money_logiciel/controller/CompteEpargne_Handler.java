package co.simplon.money_money_logiciel.controller;

import co.simplon.money_money_logiciel.dao.DaoEpargne;

public class CompteEpargne_Handler {
	
	
	
	
//////////////////AFFICHAGE DU NOM DU CLIENT////////////////////
	
public static String affichageNomDuClient(int id_compte) {
return DaoEpargne.getNomClient(id_compte);
}






////////////////AFFICHAGE DES TAUX D'INTÉRÊTS DU COMPTE EPARGNE////////////////////

public static double affichageTauxInteret(int id_epargne) {
return DaoEpargne.getTauxInteret(id_epargne);	}







//////////////////MODIFICATION DU NOM DU CLIENT////////////////////

public static boolean modificationNomDuClient(int id_compte, String libelle_client) {
	
	if(libelle_client != null && !libelle_client.trim().isEmpty() && libelle_client.length()<50)  {
		DaoEpargne.UpdateNomClient(id_compte, libelle_client);
		
		return true;
	}
	else {
		return false;
	}


}





//////////////////MODIFICATION DES TAUX D'INTÉRÊTS DU COMPTE EPARGNE////////////////////

public static boolean ModificationTauxInteretEpargneDao(int id_epargne, double taux) {
	
	if(taux  > 0)  {
		DaoEpargne.UpdateTauxInteretEpargne(id_epargne, taux);
		
		return true;
	}
	else {
		return false;
	}

}


}
