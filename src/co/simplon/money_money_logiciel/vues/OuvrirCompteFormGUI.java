package co.simplon.money_money_logiciel.vues;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import co.simplon.money_money_logiciel.controller.Client_Handler;
import co.simplon.money_money_logiciel.controller.Compte_Handler;
import javax.swing.JRadioButton;
import javax.swing.JPanel;
import java.awt.Dialog.ModalExclusionType;

/**
 * Formulaire d'ouverture d'un compte
 * 
 * @author Ondine
 *
 */
public class OuvrirCompteFormGUI extends JFrame {

	static JTextField jTextField;
	static JLabel jLabel;
	static JButton jButton;

	/**
	 * La fenêtre de création de compte s'ouvre en prenant en compte l'id du client
	 * connecté
	 * 
	 * @param id_client
	 */
	public OuvrirCompteFormGUI(final int id_client) {
		setResizable(false);
		setTitle("Ouvrir un Compte");

		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 24));
		setResizable(false);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Numéro de compte");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(50, 70, 182, 59);
		getContentPane().add(lblNewLabel);

		final JTextArea txtNumCompte = new JTextArea(Integer.toString(Compte_Handler.generateNumCompte()));
		txtNumCompte.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtNumCompte.setBounds(253, 80, 122, 34);
		txtNumCompte.setEditable(false);
		getContentPane().add(txtNumCompte);

		JLabel lblMontant = new JLabel("Nom du client");
		lblMontant.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMontant.setBounds(50, 140, 138, 59);
		getContentPane().add(lblMontant);

		final JTextArea txtClient = new JTextArea(Client_Handler.libelleClient(id_client));
		txtClient.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtClient.setBounds(253, 150, 122, 34);
		getContentPane().add(txtClient);

		final JLabel messageConfirm = new JLabel(" ");
		messageConfirm.setForeground(new Color(255, 0, 0));
		messageConfirm.setFont(new Font("Tahoma", Font.PLAIN, 22));
		getContentPane().add(messageConfirm);
		messageConfirm.setBounds(50, 580, 374, 60);

		final JButton btnNewButton = new JButton("Ouvrir un compte");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnNewButton.setBounds(123, 550, 225, 40);
		getContentPane().add(btnNewButton);

		JLabel lblSoldeInitial = new JLabel("Solde initial");
		lblSoldeInitial.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSoldeInitial.setBounds(50, 210, 138, 59);
		getContentPane().add(lblSoldeInitial);

		final JTextArea txtSoldeInit = new JTextArea("0");
		txtSoldeInit.setToolTipText("Le solde maximum est de 999999€");
		txtSoldeInit.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtSoldeInit.setBounds(253, 220, 122, 34);
		getContentPane().add(txtSoldeInit);

		final JPanel panelCompteEpargne = new JPanel();
		panelCompteEpargne.setBounds(50, 420, 356, 130);
		getContentPane().add(panelCompteEpargne);
		panelCompteEpargne.setLayout(null);

		final JPanel panelCompteCourant = new JPanel();
		panelCompteCourant.setBounds(50, 420, 356, 137);
		getContentPane().add(panelCompteCourant);
		panelCompteCourant.setLayout(null);

		final JRadioButton rdbtnCompteEpargne = new JRadioButton("Compte épargne");

		// Fenetre Compte Courant qui s'ouvre via radio button
		final JRadioButton rdbtnCompteCourant = new JRadioButton("Compte courant");
		rdbtnCompteCourant.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnCompteCourant.setBounds(253, 310, 175, 23);
		getContentPane().add(rdbtnCompteCourant);
		rdbtnCompteCourant.addActionListener(new ActionListener() {
			/**
			 * Fonction qui affiche les champs du compte courant au clic du bouton radio
			 * 
			 * @param e le clic le bouton radio compte courant
			 */
			public void actionPerformed(ActionEvent e) {
				if (rdbtnCompteCourant.isSelected() == true) {
					rdbtnCompteEpargne.setSelected(false);
					panelCompteEpargne.setVisible(false);
					panelCompteCourant.setVisible(true);
				}
			}
		});

		// Fenetre Compte Epargne qui s'ouvre via radio button
		rdbtnCompteEpargne.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnCompteEpargne.setBounds(253, 352, 175, 23);
		getContentPane().add(rdbtnCompteEpargne);
		rdbtnCompteEpargne.addActionListener(new ActionListener() {
			/**
			 * Fonction qui affiche les champs du compte épargne au clic du bouton radio
			 * 
			 * @param e le clic le bouton radio compte épargne
			 */
			public void actionPerformed(ActionEvent e) {
				if (rdbtnCompteEpargne.isSelected() == true) {
					rdbtnCompteCourant.setSelected(false);
					panelCompteCourant.setVisible(false);
					panelCompteEpargne.setVisible(true);
				}
			}
		});

		JLabel lblTypeDeCompte = new JLabel("Type de compte");
		lblTypeDeCompte.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTypeDeCompte.setBounds(50, 294, 175, 59);
		getContentPane().add(lblTypeDeCompte);

		// Composants Compte Epargne
		JLabel lblTauxDintrt = new JLabel("Taux d'intérêt");
		lblTauxDintrt.setBounds(0, 24, 150, 25);
		lblTauxDintrt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelCompteEpargne.add(lblTauxDintrt);

		JLabel lblPlafond = new JLabel("Plafond");
		lblPlafond.setBounds(0, 80, 140, 25);
		lblPlafond.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelCompteEpargne.add(lblPlafond);

		final JTextArea txtMontantPlafond = new JTextArea("0");
		txtMontantPlafond.setToolTipText("Le montant maximum est de 100000€");
		txtMontantPlafond.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtMontantPlafond.setBounds(198, 75, 122, 34);
		panelCompteEpargne.add(txtMontantPlafond);

		final JTextArea textMontantTaux = new JTextArea("0");
		textMontantTaux.setToolTipText("Le montant maximum est de 100000€");
		textMontantTaux.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textMontantTaux.setBounds(198, 19, 122, 34);
		panelCompteEpargne.add(textMontantTaux);
		panelCompteEpargne.setVisible(false);

		// Composants Compte Courant
		JLabel lblFraisTrsft = new JLabel("Frais de transfert");
		lblFraisTrsft.setBounds(0, 24, 170, 25);
		lblFraisTrsft.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelCompteCourant.add(lblFraisTrsft);

		JLabel lblSoldeMin = new JLabel("Solde minimum");
		lblSoldeMin.setBounds(0, 80, 170, 25);
		lblSoldeMin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelCompteCourant.add(lblSoldeMin);

		final JTextArea textMontantSoldeMn = new JTextArea("0");
		textMontantSoldeMn.setToolTipText("Le montant maximum est de 100000€");
		textMontantSoldeMn.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textMontantSoldeMn.setBounds(198, 75, 122, 34);
		panelCompteCourant.add(textMontantSoldeMn);

		final JTextArea textMontantFrais = new JTextArea("0");
		textMontantFrais.setToolTipText("Le montant maximum est de 100000€");
		textMontantFrais.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textMontantFrais.setBounds(198, 19, 122, 34);
		panelCompteCourant.add(textMontantFrais);

		panelCompteCourant.setVisible(false);

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Vérification champ Client pas vide et moins de 100 caractères
				String libelle = " ";
				if (!txtClient.getText().isEmpty()
						|| txtClient.getText() != null && txtClient.getText().length() < 100) {
					libelle = txtClient.getText();
				} else {
					txtClient.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
					messageConfirm.setText("Ce champ ne peut pas être vide");
					setVisible(true);
				}

				int num_compte = Integer.parseInt(txtNumCompte.getText());

				float soldeInit = 0;
				// Vérification que le champ Solde n'est pas vide
				if (!txtSoldeInit.getText().isEmpty() && txtSoldeInit.getText() != null
						&& txtSoldeInit.getText().matches("[0-9]*")) {
					soldeInit = Float.parseFloat(txtSoldeInit.getText());
				} else {
					txtSoldeInit.setText(" ");
					txtSoldeInit.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
					messageConfirm.setText("Ce champ ne peut pas être vide");
					setVisible(true);
				}
				// Vérification que le champ Frais Transfert n'est pas vide
				float solde_min = 0;
				if (!textMontantSoldeMn.getText().isEmpty() && textMontantSoldeMn.getText() != null
						&& textMontantSoldeMn.getText().matches("[0-9]*")) {
					solde_min = Float.parseFloat(textMontantSoldeMn.getText());
				} else {
					textMontantSoldeMn.setText(" ");
					textMontantSoldeMn.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
					messageConfirm.setText("Ce champ ne peut pas être vide");
					setVisible(true);
				}
				// Vérification que le champ Solde Minimum n'est pas vide
				float frais_transfert = 0;
				if (!textMontantFrais.getText().isEmpty() && textMontantFrais.getText() != null
						&& textMontantFrais.getText().matches("[0-9]*")) {
					frais_transfert = Float.parseFloat(textMontantFrais.getText());
				} else {
					textMontantFrais.setText(" ");
					textMontantFrais.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
					messageConfirm.setText("Ce champ ne peut pas être vide");
					setVisible(true);
				}
				// Vérification que le champ Taux n'est pas vide
				float taux = 0;
				if (!textMontantTaux.getText().isEmpty() && textMontantTaux.getText() != null
						&& textMontantTaux.getText().matches("[0-9]*")) {
					taux = Float.parseFloat(textMontantTaux.getText());
				} else {
					textMontantTaux.setText(" ");
					textMontantTaux.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
					messageConfirm.setText("Ce champ ne peut pas être vide");
					setVisible(true);
				}
				// Vérification que le champ plafond n'est pas vide
				float plafond = 0;
				if (!txtMontantPlafond.getText().isEmpty() && txtMontantPlafond.getText() != null
						&& txtMontantPlafond.getText().matches("[0-9]*")) {
					plafond = Float.parseFloat(txtMontantPlafond.getText());
				} else {
					txtMontantPlafond.setText(" ");
					txtMontantPlafond.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
					messageConfirm.setText("Ce champ ne peut pas être vide");
					setVisible(true);
				}
				// Création du compte selon le type de compte sélectionné

				// Vérification solde initial est inférieur au solde min
				if (rdbtnCompteCourant.isSelected() == true && soldeInit > solde_min) {
					messageConfirm.setText("Le solde doit dépasser le solde minimum");
					messageConfirm.setFont(new Font("Tahoma", Font.PLAIN, 20));
					txtSoldeInit.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
					messageConfirm.setBounds(60, 590, 374, 60);
					setVisible(true);
				}
				// Création du compte courant
				else if (rdbtnCompteCourant.isSelected() == true && soldeInit > solde_min) {
					Compte_Handler.creerCompte(num_compte, id_client, soldeInit, 2, libelle, frais_transfert,
							solde_min);
					messageConfirm.setText("Le compte n°" + num_compte + " a bien été créé");
					messageConfirm.setForeground(new Color(0, 255, 0));
					messageConfirm.setBounds(60, 590, 374, 60);
					setVisible(true);
					btnNewButton.setEnabled(false);
				}
				// Vérification solde initial est inférieur au plafond
				else if (rdbtnCompteEpargne.isSelected() == true && soldeInit > plafond) {
					messageConfirm.setText("Le solde ne doit pas dépasser le plafond");
					messageConfirm.setFont(new Font("Tahoma", Font.PLAIN, 20));
					txtSoldeInit.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
					messageConfirm.setBounds(60, 590, 374, 60);
					setVisible(true);
				}
				// Création compte épargne
				else if (rdbtnCompteEpargne.isSelected() == true && soldeInit <= plafond && taux != 0) {
					Compte_Handler.creerCompte(num_compte, id_client, soldeInit, 1, libelle, taux, plafond);
					messageConfirm.setText("Le compte n°" + num_compte + " a bien été créé");
					messageConfirm.setForeground(new Color(0, 255, 0));
					messageConfirm.setBounds(60, 590, 374, 60);
					setVisible(true);
					btnNewButton.setEnabled(false);
				} else {
					messageConfirm.setText("Tous les champs doivent être remplis");
					setVisible(true);
				}
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

		setSize(480, 780);
		setLocationRelativeTo(null);
		setVisible(true);

	}
}