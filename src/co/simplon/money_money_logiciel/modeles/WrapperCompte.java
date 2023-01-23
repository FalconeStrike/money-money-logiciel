package co.simplon.money_money_logiciel.modeles;

public class WrapperCompte {
	
	/////////////Classe Compte////////
	private int ID_Compte;
	private int ID_Typecompte;
	private int Num_Compte;
	private int ID_Client;
	private float Solde_Init;
	
	
	////////////Classe Courant///////
	int ID_COURANT;
	float FRAIS_TRANSFERT;
	float SOLDE_MIN;
	
	
	////////////Classe Epargne///////
	private int ID_EPARGNE;
	private float TAUX;
	private float PLAFOND;
	
	 
	////////////Classe TypeCompte///////
	 private int ID_TYPECOMPTE;
	 private String NOM_TYPE;
	 
	 
	 
	public WrapperCompte() {
		
	}



	public WrapperCompte(int iD_Compte,int num_Compte, int iD_Client, float solde_Init, String nom_type) {
		
		ID_Compte = iD_Compte;
		Num_Compte = num_Compte;
		ID_Client = iD_Client;
		Solde_Init = solde_Init;
		NOM_TYPE = nom_type;
	}


	


	public int getID_Compte() {
		return ID_Compte;
	}





	public void setID_Compte(int iD_Compte) {
		ID_Compte = iD_Compte;
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





	public String getNOM_TYPE() {
		return NOM_TYPE;
	}





	public void setNOM_TYPE(String nom_type) {
		NOM_TYPE = nom_type;
	}





	@Override
	public String toString() {
		return "Wrapper [ID_Compte=" + ID_Compte + ", ID_Typecompte=" + ID_Typecompte + ", Num_Compte=" + Num_Compte
				+  ", ID_Client=" + ID_Client + ", Solde_Init=" + Solde_Init
				+ ", ID_COURANT=" + ID_COURANT + ", FRAIS_TRANSFERT=" + FRAIS_TRANSFERT + ", SOLDE_MIN=" + SOLDE_MIN
				+ ", ID_EPARGNE=" + ID_EPARGNE + ", TAUX=" + TAUX + ", PLAFOND=" + PLAFOND + ", ID_TYPECOMPTE="
				+ ID_TYPECOMPTE + ", NOM_TYPE=" + NOM_TYPE + "]";
	}
	 
	 
	

	 
	 
	
	 



}
