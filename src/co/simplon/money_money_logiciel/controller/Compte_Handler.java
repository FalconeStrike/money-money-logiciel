package co.simplon.money_money_logiciel.controller;

import co.simplon.money_money_logiciel.dao.DaoCompte;

public class Compte_Handler {

	public static float afficheSolde(int idCompte) {
		return DaoCompte.getSolde(idCompte);
	}

	public static int afficheNumCompte(int idCompte) {
		return DaoCompte.getNumeroCompte(idCompte);
	}

	public static boolean debiterCompte(int idCompte, float soldeActuel, float montantADebiter) {
		soldeActuel = DaoCompte.getSolde(idCompte);
		if (soldeActuel >= montantADebiter && montantADebiter > 0) {
			DaoCompte.debiterCompteDao(idCompte, montantADebiter);
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean crediterCompte(int idCompte, float soldeActuel, float montantACrediter) {
		soldeActuel = DaoCompte.getSolde(idCompte);
		if ( soldeActuel + montantACrediter < 999999) {
			DaoCompte.crediterCompteDao(idCompte, montantACrediter);
			return true;
		} else {
			return false;
		}
	}

}
