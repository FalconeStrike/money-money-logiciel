package co.simplon.money_money_logiciel.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import co.simplon.money_money_logiciel.dao.DaoCompte;
import co.simplon.money_money_logiciel.modeles.Compte;
import co.simplon.money_money_logiciel.modeles.CompteWrapperTableModel;
import co.simplon.money_money_logiciel.modeles.WrapperCompte;

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
	
	
	
	
	
	
	public static CompteWrapperTableModel getCompteDestination(int id_client,int id_compte) {
		try {
			ResultSet rs = DaoCompte.getListComptedestination(id_client, id_compte);
			
			List<WrapperCompte> comptes = new ArrayList<WrapperCompte>();
			while (rs.next()) {
				WrapperCompte wrapperCompte = new WrapperCompte();		
				wrapperCompte.setID_Compte(rs.getInt(1));
				wrapperCompte.setID_Client(rs.getInt(5));
				wrapperCompte.setNum_Compte(rs.getInt(3));
				wrapperCompte.setSolde_Init(rs.getFloat(6));
				wrapperCompte.setNOM_TYPE(rs.getString(8));
				
				comptes.add(wrapperCompte);
				return new CompteWrapperTableModel(comptes);
			}
		} catch (SQLException e) {
			System.out.println("SQL Exception found");
		}
		return null;
	}

}
