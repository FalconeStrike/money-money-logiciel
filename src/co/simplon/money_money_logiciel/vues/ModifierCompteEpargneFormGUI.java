package co.simplon.money_money_logiciel.vues;

import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import co.simplon.money_money_logiciel.controller.CompteCourant_Handler;
import co.simplon.money_money_logiciel.controller.CompteEpargne_Handler;

public class ModifierCompteEpargneFormGUI extends JFrame {

	public ModifierCompteEpargneFormGUI(final int id) {

		setSize(450, 700);
		setResizable(false);
		getContentPane().setLayout(null);

		JLabel compteEpargne = new JLabel("COMPTE EPARGNE");
		compteEpargne.setFont(new Font("Tahoma", Font.PLAIN, 24));
		compteEpargne.setBounds(130, 0, 380, 59);
		getContentPane().add(compteEpargne);

		JLabel lblUtilisateur = new JLabel("Libellé utilisateur");
		lblUtilisateur.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUtilisateur.setBounds(90, 125, 240, 40);
		getContentPane().add(lblUtilisateur);

		final JTextArea txtAffichageNomDuClient = new JTextArea(CompteEpargne_Handler.affichageNomDuClient(id));
		txtAffichageNomDuClient.setFont(new Font("monospaced", Font.PLAIN, 22));
		txtAffichageNomDuClient.setBounds(300, 130, 122, 34);
		getContentPane().add(txtAffichageNomDuClient);
		txtAffichageNomDuClient.setColumns(10);

		JLabel lblFraisDeTransfert = new JLabel("Taux d'intérêt");
		lblFraisDeTransfert.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblFraisDeTransfert.setBounds(90, 250, 240, 40);
		getContentPane().add(lblFraisDeTransfert);

		final JTextArea txtModificationTauxInteret = new JTextArea(
				Double.toString(CompteEpargne_Handler.affichageTauxInteret(id)));
		txtModificationTauxInteret.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtModificationTauxInteret.setBounds(300, 250, 122, 34);
		getContentPane().add(txtModificationTauxInteret);
		txtModificationTauxInteret.setColumns(10);

		JButton btnValider = new JButton("Valider");
		btnValider.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnValider.setBounds(150, 477, 150, 40);
		getContentPane().add(btnValider);

		final JLabel confirmationTaux = new JLabel("");
		confirmationTaux.setFont(new Font("Tahoma", Font.PLAIN, 22));
		getContentPane().add(confirmationTaux);
		confirmationTaux.setBounds(80, 280, 374, 40);

		final JLabel confirmationNom = new JLabel("");
		confirmationNom.setFont(new Font("Tahoma", Font.PLAIN, 22));
		getContentPane().add(confirmationNom);
		confirmationNom.setBounds(80, 160, 374, 40);

		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String nomActuel = txtAffichageNomDuClient.getText();
				double tauxActuel = 0;

				if (txtModificationTauxInteret.getText() == null || txtModificationTauxInteret.getText().isEmpty()) {
					confirmationTaux.setText("Frais vides ou inférieur à 1 %");
					confirmationTaux.setForeground(Color.red);
					confirmationTaux.setVisible(true);
				} else {
					tauxActuel = Double.parseDouble(txtModificationTauxInteret.getText());
				}

				if ((tauxActuel < 1 || nomActuel == null || nomActuel.isEmpty())) {

					confirmationNom.setText("Le nom est vide");
					confirmationNom.setForeground(Color.red);
					confirmationNom.setVisible(true);

				} else {

					CompteEpargne_Handler.modificationNomDuClient(id, nomActuel);
					confirmationNom.setText("Le nom est maintenant " + nomActuel);
					confirmationNom.setForeground(Color.green);

					CompteEpargne_Handler.ModificationTauxInteretEpargneDao(id, tauxActuel);
					confirmationTaux.setText("Les frais sont maintenant de " + tauxActuel + " %");
					confirmationTaux.setForeground(Color.green);

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
		setLocationRelativeTo(null);
	}

}
