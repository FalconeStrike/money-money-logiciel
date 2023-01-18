package co.simplon.money_money_logiciel.controller;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import co.simplon.money_money_logiciel.dao.DaoCompte;
import co.simplon.money_money_logiciel.modeles.Compte;
import co.simplon.money_money_logiciel.modeles.CompteTableModel;

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

	public static CompteTableModel getCompteTable(int id_client) {
		try {
			ResultSet rs = DaoCompte.getAllCompte(id_client);
			
			List<Compte> comptes = new ArrayList<Compte>();
			while (rs.next()) {
				Compte compteAtRow = new Compte();		
				compteAtRow.setID_Compte(rs.getInt(1));
				compteAtRow.setID_Typecompte(rs.getInt(2));
				compteAtRow.setNum_Compte(rs.getInt(3));
				compteAtRow.setID_Client(rs.getInt(4));
				compteAtRow.setSolde_Init(rs.getFloat(5));
				compteAtRow.setLibelle_Client(rs.getString(6));
				comptes.add(compteAtRow);
			}
			return new CompteTableModel(comptes);
		} catch (SQLException e) {
			System.out.println("SQL Exception found");
		}
		return null;
	}
}
