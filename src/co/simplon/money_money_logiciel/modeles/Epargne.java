package co.simplon.money_money_logiciel.modeles;

public class Epargne {
	
	 private int ID_EPARGNE;
	 private int ID_COMPTE;
	 private float TAUX;
	 private float PLAFOND;
	
	public Epargne(int iD_EPARGNE, int iD_COMPTE, float tAUX, float pLAFOND) {
		this.ID_EPARGNE = iD_EPARGNE;
		this.ID_COMPTE = iD_COMPTE;
		this.TAUX = tAUX;
		this.PLAFOND = PLAFOND;
	}
	private int getID_EPARGNE() {
		return ID_EPARGNE;
	}
	private void setID_EPARGNE(int iD_EPARGNE) {
		ID_EPARGNE = iD_EPARGNE;
	}
	private int getID_COMPTE() {
		return ID_COMPTE;
	}
	private void setID_COMPTE(int iD_COMPTE) {
		ID_COMPTE = iD_COMPTE;
	}
	private float getTAUX() {
		return TAUX;
	}
	private void setTAUX(float tAUX) {
		TAUX = tAUX;
	}
	private float getPLAFOND() {
		return PLAFOND;
	}
	private void setPLAFOND(float pLAFOND) {
		PLAFOND = pLAFOND;
	}
	@Override
	public String toString() {
		return "Epargne [ID_EPARGNE=" + ID_EPARGNE + ", ID_COMPTE=" + ID_COMPTE + ", TAUX=" + TAUX + ", PLAFOND="
				+ PLAFOND + "]";
	}
	 
	
	

}
