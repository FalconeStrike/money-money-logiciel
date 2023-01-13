package co.simplon.money_money_logiciel.vues;

import javax.swing.JFrame;

import co.simplon.money_money_logiciel.modeles.Client;

public class SelectionCompteGUI extends JFrame {
	public SelectionCompteGUI(Client myClient) {
		setTitle(myClient.getNom_client());
		setSize(450, 700);
		setResizable(false);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setVisible(true);
	}

}
