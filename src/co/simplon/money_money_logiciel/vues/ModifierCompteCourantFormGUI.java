package co.simplon.money_money_logiciel.vues;

import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import javax.swing.JLabel;
import java.awt.*;
import java.awt.event.*;

import javax.swing.JPanel;
import javax.swing.JTextField;

import co.simplon.money_money_logiciel.controller.Client_Handler;
import co.simplon.money_money_logiciel.controller.CompteCourant_Handler;
import co.simplon.money_money_logiciel.controller.Compte_Handler;
import co.simplon.money_money_logiciel.dao.DaoCompte;
import co.simplon.money_money_logiciel.dao.DaoCourant;
import co.simplon.money_money_logiciel.modeles.Client;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ModifierCompteCourantFormGUI extends JFrame {

	public ModifierCompteCourantFormGUI(final int id) {

		setResizable(false);
		getContentPane().setLayout(null);

		JLabel compteCourant = new JLabel("COMPTE COURANT");
		compteCourant.setFont(new Font("Tahoma", Font.PLAIN, 24));
		compteCourant.setBounds(130, 0, 380, 59);
		getContentPane().add(compteCourant);

		JLabel lblUtilisateur = new JLabel("Libellé utilisateur");
		lblUtilisateur.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUtilisateur.setBounds(90, 125, 240, 40);
		getContentPane().add(lblUtilisateur);

		final JTextArea txtAffichageNomDuClient = new JTextArea(CompteCourant_Handler.affichageNomDuClient(id));
		txtAffichageNomDuClient.setFont(new Font("monospaced", Font.PLAIN, 22));
		txtAffichageNomDuClient.setBounds(300, 130, 122, 34);
		getContentPane().add(txtAffichageNomDuClient);
		txtAffichageNomDuClient.setColumns(10);

		JLabel lblFraisDeTransfert = new JLabel("Frais de transfert");
		lblFraisDeTransfert.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblFraisDeTransfert.setBounds(90, 250, 240, 40);
		getContentPane().add(lblFraisDeTransfert);

		final JTextArea txtModificationFrais = new JTextArea(
				Double.toString(CompteCourant_Handler.affichageFraisDeTransfert(id)));
		txtModificationFrais.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtModificationFrais.setBounds(300, 250, 122, 34);
		getContentPane().add(txtModificationFrais);
		txtModificationFrais.setColumns(10);

		JButton btnValider = new JButton("Valider");
		btnValider.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnValider.setBounds(150, 477, 150, 40);
		getContentPane().add(btnValider);

		final JLabel confirmationFrais = new JLabel("");
		confirmationFrais.setFont(new Font("Tahoma", Font.PLAIN, 22));
		getContentPane().add(confirmationFrais);
		confirmationFrais.setBounds(80, 280, 374, 40);

		final JLabel confirmationNom = new JLabel("");
		confirmationNom.setFont(new Font("Tahoma", Font.PLAIN, 22));
		getContentPane().add(confirmationNom);
		confirmationNom.setBounds(80, 160, 374, 40);

		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String nomActuel = txtAffichageNomDuClient.getText();
				double fraisActuel = 0;

				if (txtModificationFrais.getText() == null || txtModificationFrais.getText().isEmpty()) {
					confirmationFrais.setText("Frais vides ou inférieur à 1 %");
					confirmationFrais.setForeground(Color.red);
					confirmationFrais.setVisible(true);

				}

				else {
					fraisActuel = Double.parseDouble(txtModificationFrais.getText());
				}

				if ((fraisActuel < 1 || nomActuel == null || nomActuel.isEmpty())) {

					confirmationNom.setText("Le nom est vide");
					confirmationNom.setForeground(Color.red);
					confirmationNom.setVisible(true);

				} else {

					CompteCourant_Handler.modificationNomDuClient(id, nomActuel);
					confirmationNom.setText("Le nom est maintenant " + nomActuel);
					confirmationNom.setForeground(Color.green);
					confirmationNom.setVisible(true);

					CompteCourant_Handler.modificationFraisDeTransfertCourantDao(id, fraisActuel);
					confirmationFrais.setText("Les frais sont maintenant de " + fraisActuel + " %");
					confirmationFrais.setForeground(Color.green);
					confirmationFrais.setVisible(true);

				}
				;
			}
		});

		JButton btnRetour = new JButton("Retour");
		btnRetour.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnRetour.setBounds(10, 11, 100, 33);
		getContentPane().add(btnRetour);

		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		setVisible(true);
		setSize(450, 700);
		setLocationRelativeTo(null);

	}

}
