package co.simplon.money_money_logiciel.vues;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import co.simplon.money_money_logiciel.controller.Client_Handler;
import co.simplon.money_money_logiciel.controller.Compte_Handler;
import co.simplon.money_money_logiciel.modeles.Client;
import co.simplon.money_money_logiciel.modeles.Compte;
import co.simplon.money_money_logiciel.modeles.CompteTableModel;

import javax.swing.JTable;
import javax.swing.BorderFactory;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectionCompteGUI extends JFrame {
	private JScrollPane pnCompte;
	private JTable tbCompte;
	public SelectionCompteGUI(Client myClient) {
		setTitle(myClient.getNom_client());
		setSize(900, 700);
		setResizable(false);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		tbCompte = new JTable(Compte_Handler.getCompteTable(myClient.getId_client()));
		tbCompte.setFillsViewportHeight(true);		
		pnCompte = new JScrollPane(tbCompte);
		pnCompte.setBounds(70, 70, 760, 200);
		getContentPane().add(pnCompte);
		
		JButton btnOpen = new JButton("Ouvrir un compte");
		btnOpen.setBounds(175, 350, 150, 40);
		getContentPane().add(btnOpen);
		
		JButton btnCrediter = new JButton("Créditer un compte");
		btnCrediter.setBounds(175, 450, 150, 40);
		btnCrediter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					Compte compte = CompteTableModel.getCompte(tbCompte.getSelectedRow());
					JFrame SelectionCompteGUI = new JFrame();
					new CrediterCompteFormGUI(compte.getID_Compte());
			}
		});
		getContentPane().add(btnCrediter);
		
		JButton btnDebiter = new JButton("Débiter un compte");
		btnDebiter.setBounds(175, 550, 150, 40);
		getContentPane().add(btnDebiter);
		
		JButton btnTransferer = new JButton("Tranférer");
		btnTransferer.setBounds(550, 350, 150, 40);
		getContentPane().add(btnTransferer);
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.setBounds(550, 450, 150, 40);
		getContentPane().add(btnModifier);
		
		JButton btnDelete = new JButton("Clôturer");
		btnDelete.setBounds(550, 550, 150, 40);
		getContentPane().add(btnDelete);
		
		
		
		setVisible(true);
	}
}
