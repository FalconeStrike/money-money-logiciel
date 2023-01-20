package co.simplon.money_money_logiciel.vues;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.*;
import java.awt.event.*;

import javax.swing.JPanel;
import javax.swing.JTextField;

import co.simplon.money_money_logiciel.controller.Client_Handler;
import co.simplon.money_money_logiciel.modeles.Client;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class GestionBancaireGUI extends JFrame {
	private JTextField txtNomClient;

	public GestionBancaireGUI() {
		setTitle("Money-Money-Logiciel");
		setSize(450, 700);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		JLabel lblTitle = new JLabel("Accès aux comptes du client");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblTitle.setBounds(65, 11, 320, 40);
		getContentPane().add(lblTitle);

		ImageIcon imageIcon = new ImageIcon("images/MoneyMoneyLogiciel.png");
		Image image = imageIcon.getImage();
		Image newimage = image.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
		JLabel lblLogo = new JLabel(new ImageIcon(newimage));
		lblLogo.setBounds(80, 35, 300, 300);
		getContentPane().add(lblLogo);

		txtNomClient = new JTextField();
		txtNomClient.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtNomClient.setBounds(60, 339, 330, 40);
		txtNomClient.setToolTipText("Max 50 character");
		getContentPane().add(txtNomClient);
		txtNomClient.setColumns(10);

		JButton btnValider = new JButton("Valider");
		btnValider.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnValider.setBounds(150, 477, 150, 40);
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Client myClient = Client_Handler.connectClient(txtNomClient.getText());
				if (myClient != null) {
					new SelectionCompteGUI(myClient);
					setVisible(false);
				} else {
					txtNomClient.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
				}
			}
		});
		getContentPane().add(btnValider);

		setLocationRelativeTo(null);
		setVisible(true);
	}

}
