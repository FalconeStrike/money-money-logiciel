package co.simplon.money_money_logiciel.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.simplon.money_money_logiciel.dao.DaoClient;
import co.simplon.money_money_logiciel.modeles.Client;

/**
 * Controller du modèle Client
 * 
 * @author Julien
 * @author Ondine
 *
 */
public class Client_Handler {

	/**
	 * Méthode qui permet de récupérer un client dans la base de donnée et de
	 * l'instancier en objet client ou de le créer directement s'il n'existe pas
	 * déjà dans la base
	 * 
	 * @param nomClient
	 * @return un objet Client
	 */
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

	/**
	 * Méthode pour retourner le nom du client à partir d'un id
	 * 
	 * @param idClient
	 * @return le nom du client
	 */
	public static String libelleClient(int idClient) {
		String libelle = DaoClient.getNameById(idClient);
		return libelle;
	}

	/**
	 * Méthode qui permet de stocker tous les noms des clients dans une ArrayList de
	 * type String pour ensuite la transformer en Array
	 * 
	 * @return un tableau des noms des clients
	 */
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
