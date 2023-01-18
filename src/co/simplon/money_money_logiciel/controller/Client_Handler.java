package co.simplon.money_money_logiciel.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import co.simplon.money_money_logiciel.dao.DaoClient;
import co.simplon.money_money_logiciel.modeles.Client;

public class Client_Handler {

	public static Client connectClient(String nomClient) {
		if (nomClient != null && !nomClient.trim().isEmpty() && nomClient.length() < 50) {
			int idClient = DaoClient.getIdClient(nomClient);
			Client myClient = new Client();
			myClient.setId_client(idClient);
			myClient.setNom_client(nomClient);
			return myClient;
		} else {
			return null;
		}
	}

	public static String libelleClient(int idClient) {
		String libelle = DaoClient.getNameById(idClient);
		return libelle;
	}

	public static String[] ListeNomClients() {
		List<String> clients = new ArrayList<>();
		try {
			ResultSet rs = DaoClient.getAllClients();

			while (rs.next()) {
				String myclient = rs.getString(2);
				clients.add(myclient);
			}
			return clients.toArray(new String[0]);
		} catch (SQLException e) {
			System.out.println("SQL Exception");
		}
		return null;
	}

}
