package co.simplon.money_money_logiciel.controller;

import java.util.Random;

import co.simplon.money_money_logiciel.dao.DaoCompte;
import co.simplon.money_money_logiciel.modeles.Compte;

/**
 * Controller du modèle Compte
 * 
 * @author Ondine
 *
 */
public class Compte_Handler {

	/**
	 * Méthode qui permet d'afficher le solde d'un compte grâce à son id
	 * 
	 * @param idCompte l'id du compte
	 * @return le solde du compte
	 */
	public static float afficheSolde(int idCompte) {
		return DaoCompte.getSolde(idCompte);
	}

	/**
	 * Méthode qui permet d'afficher le numéro d'un compte grâce à son id
	 * 
	 * @param idCompte l'id du compte
	 * @return le numéro du compte
	 */
	public static int afficheNumCompte(int idCompte) {
		return DaoCompte.getNumeroCompte(idCompte);
	}

	/**
	 * Méthode qui permet de débiter un compte
	 * 
	 * @param idCompte        l'id du compte
	 * @param soldeActuel     le solde du compte
	 * @param montantADebiter le montant que l'on veut enlever au solde
	 * @return un boolean, si le débit a été vérifié return true, sinon return false
	 */
	public static boolean debiterCompte(int idCompte, float soldeActuel, float montantADebiter) {
		soldeActuel = DaoCompte.getSolde(idCompte);
		if (soldeActuel >= montantADebiter && montantADebiter > 0) {
			DaoCompte.debiterCompteDao(idCompte, montantADebiter);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Méthode qui permet de créditer un compte
	 * 
	 * @param idCompte         l'id du compte
	 * @param soldeActuel      le solde du compte
	 * @param montantACrediter le montant que l'on veut ajouter au solde
	 * @return un boolean, si le crédit a été vérifié return true, sinon return
	 *         false
	 */
	public static boolean crediterCompte(int idCompte, float soldeActuel, float montantACrediter) {
		soldeActuel = DaoCompte.getSolde(idCompte);
		if (soldeActuel + montantACrediter < 999999) {
			DaoCompte.crediterCompteDao(idCompte, montantACrediter);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Méthode qui permet de renvoyer un numéro généré aléatoirement de 1 à 999999
	 * 
	 * @return un numéro de compte
	 */
	public static int generateNumCompte() {
		Random rand = new Random();
		int num_compte = rand.nextInt(999999);
		num_compte += 1;
		return num_compte;
	}

	/**
	 * Fonction qui permet de créer un compte avec tous les paramètres et de
	 * spécifier son type de compte Vérifie que les paramètres passés sont valides
	 * 
	 * @param num_compte  le numéro du compte
	 * @param idClient    l'id du client
	 * @param solde_init  le solde du compte
	 * @param type_compte le type de compte, courant ou épargne
	 * @param libelle     le libellé du client
	 * @param param_1     le premier paramètre du type de compte, frais transfert ou
	 *                    taux
	 * @param param_2     le deuxième paramètre du type de compte, solde minimum et
	 *                    plafond
	 */
	public static void creerCompte(int num_compte, int idClient, float solde_init, int type_compte, String libelle,
			float param_1, float param_2) {
		if (solde_init >= 0 && type_compte != 0 && param_1 < 100000 && param_2 < 100000 && param_1 >= 0
				&& param_2 >= 0) {
			int idCompte = DaoCompte.creerCompteDao(num_compte, idClient, solde_init, type_compte, libelle);
			Compte myCompte = new Compte();
			myCompte.setID_Compte(idCompte);
			myCompte.setID_Typecompte(type_compte);
			myCompte.setNum_Compte(num_compte);
			myCompte.setID_Client(idClient);
			myCompte.setSolde_Init(solde_init);
			myCompte.setLibelle_Client(libelle);
			if (myCompte.getID_Typecompte() == 2 && solde_init >= param_1) {
				DaoCompte.creerCompteCourantDao(myCompte.getID_Compte(), param_1, param_2);
			}
			if (myCompte.getID_Typecompte() == 1 && solde_init <= param_2) {
				DaoCompte.creerCompteEpargneDao(myCompte.getID_Compte(), param_1, param_2);
			}
		}
	}

}
