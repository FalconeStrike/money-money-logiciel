package co.simplon.money_money_logiciel.modeles;

public class Courant {
	
	private int ID_COURANT;
	private int ID_COMPTE;
	private float FRAIS_TRANSFERT;
	private float SOLDE_MIN;
	
	public Courant(int iD_COURANT, int iD_COMPTE, float fRAIS_TRANSFERT, float sOLDE_MIN) {
		this.ID_COURANT = ID_COURANT;
		this.ID_COMPTE = ID_COMPTE;
		this.FRAIS_TRANSFERT = fRAIS_TRANSFERT;
		this.SOLDE_MIN = SOLDE_MIN;
	}

	private int getID_COURANT() {
		return ID_COURANT;
	}

	private void setID_COURANT(int iD_COURANT) {
		ID_COURANT = iD_COURANT;
	}

	private int getID_COMPTE() {
		return ID_COMPTE;
	}

	private void setID_COMPTE(int iD_COMPTE) {
		ID_COMPTE = iD_COMPTE;
	}

	private float getFRAIS_TRANSFERT() {
		return FRAIS_TRANSFERT;
	}

	private void setFRAIS_TRANSFERT(float fRAIS_TRANSFERT) {
		FRAIS_TRANSFERT = fRAIS_TRANSFERT;
	}

	private float getSOLDE_MIN() {
		return SOLDE_MIN;
	}

	private void setSOLDE_MIN(float sOLDE_MIN) {
		SOLDE_MIN = sOLDE_MIN;
	}

	@Override
	public String toString() {
		return "Courant [ID_COURANT=" + ID_COURANT + ", ID_COMPTE=" + ID_COMPTE + ", FRAIS_TRANSFERT=" + FRAIS_TRANSFERT
				+ ", SOLDE_MIN=" + SOLDE_MIN + "]";
	}
	
	
	
	
	
	

}
