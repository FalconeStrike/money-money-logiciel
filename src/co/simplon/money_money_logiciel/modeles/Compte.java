package co.simplon.money_money_logiciel.modeles;

public class Compte {

	private int ID_Compte;
	private int ID_Typecompte;
	private int Num_Compte;
	private int ID_Client;
	private float Solde_Init;
	private String Libelle_Client;

	public Compte() {
		
	}
	
	public Compte(int ID_Compte, int ID_Typecompte, int Num_Compte, int ID_Client, float Solde_Init, String Libelle_Client) {
		this.ID_Compte = ID_Compte;
		this.ID_Typecompte = ID_Typecompte;
		this.Num_Compte = Num_Compte;
		this.ID_Client = ID_Client;
		this.Solde_Init = Solde_Init;
		this.Libelle_Client = Libelle_Client;
	}

	// Getters et Setters

	public String getLibelle_Client() {
		return Libelle_Client;
	}

	public void setLibelle_Client(String libelle_Client) {
		Libelle_Client = libelle_Client;
	}

	public int getID_Compte() {
		return ID_Compte;
	}

	public void setID_Compte(int iD_Compte) {
		ID_Compte = iD_Compte;
	}

	public int getID_Typecompte() {
		return ID_Typecompte;
	}

	public void setID_Typecompte(int iD_Typecompte) {
		ID_Typecompte = iD_Typecompte;
	}

	public int getNum_Compte() {
		return Num_Compte;
	}

	public void setNum_Compte(int num_Compte) {
		Num_Compte = num_Compte;
	}

	public int getID_Client() {
		return ID_Client;
	}

	public void setID_Client(int iD_Client) {
		ID_Client = iD_Client;
	}

	public float getSolde_Init() {
		return Solde_Init;
	}

	public void setSolde_Init(float solde_Init) {
		Solde_Init = solde_Init;
	}
}
