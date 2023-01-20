package co.simplon.money_money_logiciel.vues;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.event.*;

import co.simplon.money_money_logiciel.controller.Client_Handler;
import co.simplon.money_money_logiciel.controller.Compte_Handler;
import co.simplon.money_money_logiciel.modeles.Client;
import co.simplon.money_money_logiciel.modeles.Compte;
import co.simplon.money_money_logiciel.modeles.CompteTableModel;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SelectionCompteGUI extends JFrame {
	private JScrollPane pnCompte;
	private JTable tbCompte;
    ListSelectionModel listSelectionModel;
    private JButton btnCrediter;
    private JButton btnDebiter;
    private JButton btnTransferer;
    private JButton btnModifier;
    private JButton btnDelete;
	public SelectionCompteGUI(Client myClient) {
		setTitle(myClient.getNom_client());
		setSize(900, 700);
		setResizable(false);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		addWindowFocusListener(new WindowAdapter() {
			//TODO finish refresh
//			public void windowGainedFocus(WindowEvent e)
		});
		setLocationRelativeTo(null);		
		setVisible(true);
		
		tbCompte = new JTable(Compte_Handler.getCompteTable(myClient.getId_client()));
		tbCompte.setFillsViewportHeight(true);
        listSelectionModel = tbCompte.getSelectionModel();	
        listSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listSelectionModel.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
					Compte compte = CompteTableModel.getCompte(tbCompte.getSelectedRow());
					if (compte.getID_Typecompte()==2) {
						btnCrediter.setEnabled(true);
						btnDebiter.setEnabled(true);
						btnTransferer.setEnabled(true);
						btnModifier.setEnabled(true);
						btnDelete.setEnabled(true);
					} else {
						btnCrediter.setEnabled(true);
						btnDebiter.setEnabled(true);
						btnTransferer.setEnabled(false);
						btnModifier.setEnabled(true);
						btnDelete.setEnabled(true);
					}
			}
		});
		tbCompte.setSelectionModel(listSelectionModel);
		pnCompte = new JScrollPane(tbCompte);
		pnCompte.setBounds(70, 70, 760, 200);
		getContentPane().add(pnCompte);
		
		JButton btnOpen = new JButton("Ouvrir un compte");
		btnOpen.setBounds(175, 350, 150, 40);
		btnOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//					new OpenCompteFormGUI(myClient.getId_client());
			}
		});
		getContentPane().add(btnOpen);
		
		btnCrediter = new JButton("Créditer un compte");
		btnCrediter.setBounds(175, 450, 150, 40);
		btnCrediter.setEnabled(false);
		btnCrediter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					Compte compte = CompteTableModel.getCompte(tbCompte.getSelectedRow());
					new CrediterCompteFormGUI(compte.getID_Compte());
			}
		});
		getContentPane().add(btnCrediter);
		
		btnDebiter = new JButton("Débiter un compte");
		btnDebiter.setBounds(175, 550, 150, 40);
		btnDebiter.setEnabled(false);
		btnDebiter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					Compte compte = CompteTableModel.getCompte(tbCompte.getSelectedRow());
					new DebiterCompteFormGUI(compte.getID_Compte());
			}
		});
		getContentPane().add(btnDebiter);
		
		btnTransferer = new JButton("Tranférer");
		btnTransferer.setBounds(550, 350, 150, 40);
		btnTransferer.setEnabled(false);
		btnTransferer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					Compte compte = CompteTableModel.getCompte(tbCompte.getSelectedRow());
//					new TransfererSoldeFormGUI(compte);
			}
		});
		getContentPane().add(btnTransferer);
		
		btnModifier = new JButton("Modifier");
		btnModifier.setBounds(550, 450, 150, 40);
		btnModifier.setEnabled(false);
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					Compte compte = CompteTableModel.getCompte(tbCompte.getSelectedRow());
					if (compte.getID_Typecompte() == 1) {
//						new ModifierCompteCourantGUI(compte.getID_Compte());
					} else {
//						new ModifierCompteEpargneGUI(compte.getID_Compte());
					}
			}
		});
		getContentPane().add(btnModifier);
		
		btnDelete = new JButton("Clôturer");
		btnDelete.setBounds(550, 550, 150, 40);
		btnDelete.setEnabled(false);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					final JDialog delete = new JDialog();
					JLabel lblConfirmation = new JLabel("Confirmer la clôturation?");
					JButton btnCancel = new JButton("Non");
					JButton btnConfirm = new JButton("Oui");
					JPanel pnComfirmation = new JPanel();
					btnCancel.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							delete.dispose();
					}
				});
					btnConfirm.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							Compte compte = CompteTableModel.getCompte(tbCompte.getSelectedRow());
							Compte_Handler.clotureCompteClient(compte);
							delete.dispose();
					}
				});
					pnComfirmation.add(lblConfirmation);
					pnComfirmation.add(btnCancel);
					pnComfirmation.add(btnConfirm);
					delete.add(pnComfirmation);
					delete.setSize(200, 100);
					delete.setLocationRelativeTo(null);
					delete.addWindowListener(new WindowAdapter() {
						public void windowClosed(WindowEvent e) {
							revalidate();
							repaint();
						}
					});
					delete.setVisible(true);
			}
		});
		getContentPane().add(btnDelete);
	}
}
