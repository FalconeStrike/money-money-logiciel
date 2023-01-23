package co.simplon.money_money_logiciel.modeles;

public class TypeCompte {
	
	private int ID_TYPECOMPTE;
	private String NOM_TYPE;
	
	
	public TypeCompte(int iD_TYPECOMPTE, String NOM_TYPE) {
		this.ID_TYPECOMPTE = iD_TYPECOMPTE;
		this.NOM_TYPE = NOM_TYPE;
	}


	private int getID_TYPECOMPTE() {
		return ID_TYPECOMPTE;
	}


	private void setID_TYPECOMPTE(int iD_TYPECOMPTE) {
		ID_TYPECOMPTE = iD_TYPECOMPTE;
	}


	private String getNOM_TYPE() {
		return NOM_TYPE;
	}


	private void setNOM_TYPE(String NOM_TYPE) {
		NOM_TYPE = NOM_TYPE;
	}


	@Override
	public String toString() {
		return "TypeCompte [ID_TYPECOMPTE=" + ID_TYPECOMPTE + ", NOM_TYPE=" + NOM_TYPE + "]";
	}
	
	
	
	
	
	

}
