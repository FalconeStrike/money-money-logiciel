package co.simplon.money_money_logiciel.modeles;

public class Client {
	
	private int id_client;
	private String nom_client;
	
	public Client(int id_client, String nom_client) {
		super();
		this.id_client = id_client;
		this.nom_client = nom_client;
	}
	
	public int getId_client() {
		return id_client;
	}

	public void setId_client(int id_client) {
		this.id_client = id_client;
	}
	public String getNom_client() {
		return nom_client;
	}
	public void setNom_client(String nom_client) {
		this.nom_client = nom_client;
	}

}
