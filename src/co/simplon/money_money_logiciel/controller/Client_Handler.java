package co.simplon.money_money_logiciel.controller;

import co.simplon.money_money_logiciel.dao.DaoClient;
import co.simplon.money_money_logiciel.modeles.Client;

public class Client_Handler {

	public static Client connectClient(String nomClient) {
		if (nomClient != null && !nomClient.trim().isEmpty() && nomClient.length()<50) {
			int idClient = DaoClient.getIdClient(nomClient);
			Client myClient = new Client(idClient, nomClient);
			return myClient;
		}
		else {
			return null;
		}
	}
	
}
