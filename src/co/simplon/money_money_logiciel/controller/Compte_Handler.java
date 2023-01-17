package co.simplon.money_money_logiciel.controller;

import java.util.Random;

import co.simplon.money_money_logiciel.dao.DaoCompte;
import co.simplon.money_money_logiciel.modeles.Compte;

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
		if (soldeActuel + montantACrediter < 999999) {
			DaoCompte.crediterCompteDao(idCompte, montantACrediter);
			return true;
		} else {
			return false;
		}
	}

	public static int generateNumCompte() {
		Random rand = new Random();
		int num_compte = rand.nextInt(999999);
		num_compte += 1;
		return num_compte;
	}

	// Création de compte avec vérification du solde initial, solde min, plafond,
	// taux intérêt et frais
	public static void creerCompte(int num_compte, int idClient, float solde_init, int type_compte, float param_1,
			float param_2) {
		if (solde_init >= 0 && type_compte != 0 && param_1 < 100000 && param_2 < 100000 && param_1 >= 0
				&& param_2 >= 0) {
			int idCompte = DaoCompte.creerCompteDao(num_compte, idClient, solde_init, type_compte);
			Compte myCompte = new Compte(idCompte, type_compte, num_compte, 0, idClient, solde_init);
			if (myCompte.getID_Typecompte() == 2 && solde_init >= param_1) {
				DaoCompte.creerCompteCourantDao(myCompte.getID_Compte(), param_1, param_2);
			}
			if (myCompte.getID_Typecompte() == 1 && solde_init <= param_2) {
				DaoCompte.creerCompteEpargneDao(myCompte.getID_Compte(), param_1, param_2);
			}
		}
	}

}
