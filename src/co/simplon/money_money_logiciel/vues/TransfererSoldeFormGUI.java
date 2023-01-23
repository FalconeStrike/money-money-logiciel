package co.simplon.money_money_logiciel.vues;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import co.simplon.money_money_logiciel.controller.CompteCourant_Handler;
import co.simplon.money_money_logiciel.controller.Compte_Handler;
import co.simplon.money_money_logiciel.modeles.Compte;
import co.simplon.money_money_logiciel.modeles.CompteWrapperTableModel;
import co.simplon.money_money_logiciel.modeles.WrapperCompte;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TransfererSoldeFormGUI extends JFrame {
	private JTable tbTable;

	
	public TransfererSoldeFormGUI(final Compte compte) {
		
		setResizable(false);
		getContentPane().setLayout(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		JLabel compteActuel = new JLabel("Numéro du compte à débiter");
		compteActuel.setBounds(109, 71, 180, 30);
		getContentPane().add(compteActuel);
		
		JLabel sommeActuelle = new JLabel("Solde du compte à débiter");
		sommeActuelle.setBounds(118, 113, 171, 30);
		getContentPane().add(sommeActuelle);
		
		JLabel lblSommeCrditer = new JLabel("Somme à créditer");
		lblSommeCrditer.setBounds(178, 155, 111, 30);
		getContentPane().add(lblSommeCrditer);
		
		JTextArea numCompteDebit = new JTextArea(Double.toString(Compte_Handler.afficheNumCompte(compte.getID_Compte())));
		numCompteDebit.setBounds(301, 78, 111, 23);
		numCompteDebit.setEnabled(false);
		getContentPane().add(numCompteDebit);
		
		 final JTextArea soldeCompteDebit = new JTextArea(Float.toString(Compte_Handler.afficheSolde(compte.getID_Compte())));
		soldeCompteDebit.setBounds(301, 120, 111, 23);
		soldeCompteDebit.setEnabled(false);
		getContentPane().add(soldeCompteDebit);
		
		final JTextArea sommeCredit = new JTextArea("");
		sommeCredit.setBounds(301, 162, 111, 23);
		getContentPane().add(sommeCredit);
		
		final JLabel confirmationSommeCredit = new JLabel("");
		confirmationSommeCredit.setFont(new Font("Tahoma", Font.PLAIN, 22));
		getContentPane().add(confirmationSommeCredit);
		confirmationSommeCredit.setBounds(70, 599, 370,40);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(42, 241, 370, 318);
		getContentPane().add(scrollPane);
		
		tbTable = new JTable(Compte_Handler.getCompteDestination(compte.getID_Client(), compte.getID_Compte()));
		tbTable.setFillsViewportHeight(true);
		scrollPane.setViewportView(tbTable);
		
		JButton btnValider = new JButton("Valider");
		btnValider.setBounds(172, 558, 117, 29);
		getContentPane().add(btnValider);
		
		
		btnValider.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				
				
              if(tbTable.getSelectedRow()>=0) {
						
				WrapperCompte compteDest  = CompteWrapperTableModel.getWrapperCompte(tbTable.getSelectedRow());
				float sommeActuelle = 0;
					
				
				
				if(sommeCredit.getText()== null  || sommeCredit.getText().isEmpty())  {	
					
					confirmationSommeCredit.setText("Veuillez insérer une somme");
					confirmationSommeCredit.setForeground(Color.red);
					confirmationSommeCredit.setVisible(true);

				}
				
				
				else {
				 sommeActuelle = Float.parseFloat(sommeCredit.getText());
				}
///////////////////////////////////////////////////////////////////////////////////////
				
				if ((sommeActuelle <1 )) {
					confirmationSommeCredit.setText("Veuillez insérer une somme positive");
					confirmationSommeCredit.setForeground(Color.red);
					confirmationSommeCredit.setVisible(true);
						
					
				} else {
					
					boolean estDebite= Compte_Handler.debiterCompte(compte.getID_Compte(), compte.getSolde_Init(), sommeActuelle);
					
					if(estDebite) {
						
						Compte_Handler.crediterCompte(compteDest.getID_Compte(), compteDest.getSolde_Init(), sommeActuelle);
						confirmationSommeCredit.setText("Vous avez transféré  " + sommeActuelle+" Euros");
						confirmationSommeCredit.setForeground(Color.green);
						confirmationSommeCredit.setVisible(true);
						soldeCompteDebit.setText(Float.toString(Compte_Handler.afficheSolde(compte.getID_Compte())));
						tbTable.setValueAt(Compte_Handler.afficheSolde(compteDest.getID_Compte()),tbTable.getSelectedRow(),2);
						
					}
					else {
						
					}
					
	
				}
					 
				}  else {
					confirmationSommeCredit.setText("Veuillez sélectionner un compte");
					confirmationSommeCredit.setForeground(Color.red);
					confirmationSommeCredit.setVisible(true);
						
					
				}
					;
			}
		});
		
		
		
		
		
	
		setVisible(true);
		setSize(450, 700);
		setLocationRelativeTo(null);
		
	}
}
