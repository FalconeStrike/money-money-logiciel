package co.simplon.money_money_logiciel.vues;

import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.JLabel;
import javax.swing.JTextField;

import co.simplon.money_money_logiciel.controller.Compte_Handler;
import co.simplon.money_money_logiciel.dao.DaoCompte;

import javax.swing.JButton;
import javax.swing.JTextArea;

public class CrediterCompteFormGUI extends JFrame {

	static JTextField jTextField;
	static JLabel jLabel;
	static JButton jButton;

	public CrediterCompteFormGUI(final int id) {
		setTitle("Créditer");

		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 24));
		setResizable(false);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Solde actuel");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(86, 235, 146, 59);
		getContentPane().add(lblNewLabel);

		JLabel lblMontant = new JLabel("Montant");
		lblMontant.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblMontant.setBounds(86, 310, 102, 59);
		getContentPane().add(lblMontant);

		JLabel lblDbiterLeCompte = new JLabel("Créditer le compte n°" + DaoCompte.getNumeroCompte(id));
		lblDbiterLeCompte.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblDbiterLeCompte.setBounds(86, 50, 380, 59);
		getContentPane().add(lblDbiterLeCompte);

		final JTextArea txtSolde = new JTextArea(Float.toString(Compte_Handler.afficheSolde(id)));
		txtSolde.setFont(new Font("Monospaced", Font.PLAIN, 22));
		txtSolde.setBounds(253, 244, 122, 34);
		txtSolde.setEnabled(false);
		getContentPane().add(txtSolde);

		final JTextArea textMontant = new JTextArea("0");
		textMontant.setFont(new Font("Monospaced", Font.PLAIN, 22));
		textMontant.setBounds(253, 320, 122, 34);
		textMontant.setToolTipText("Le solde maximum est de 999999€");
		getContentPane().add(textMontant);

		final JLabel messageConfirm = new JLabel(" ");
		messageConfirm.setFont(new Font("Tahoma", Font.PLAIN, 22));
		getContentPane().add(messageConfirm);
		messageConfirm.setBounds(70, 513, 374, 40);

		JButton btnNewButton = new JButton("Valider");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnNewButton.setBounds(150, 437, 150, 40);
		getContentPane().add(btnNewButton);

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				float soldeActuel = Float.parseFloat(txtSolde.getText());
				float montantACrediter = 0;
				if (textMontant.getText().equals("0") || !textMontant.getText().matches("[0-9]*")) {
					textMontant.setText(" ");
					textMontant.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
					messageConfirm.setText("Entrer un montant à créditer");
					setVisible(true);
				} else {
					montantACrediter = Float.parseFloat(textMontant.getText());
					boolean estDebite = Compte_Handler.crediterCompte(id, soldeActuel, montantACrediter);
					if (estDebite) {
						messageConfirm.setText("Le compte a été crédité de " + montantACrediter + "€");
						messageConfirm.setForeground(new Color(0, 255, 0));
						setVisible(true);
						txtSolde.setText(Float.toString(Compte_Handler.afficheSolde(id)));
					} else {
						textMontant.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
						messageConfirm.setText("Le compte n'a pas été crédité");
						messageConfirm.setForeground(new Color(255, 0, 0));
						setVisible(true);
					}
					;
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

		setSize(480, 700);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
