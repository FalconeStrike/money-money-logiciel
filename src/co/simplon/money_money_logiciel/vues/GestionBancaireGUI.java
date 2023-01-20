package co.simplon.money_money_logiciel.vues;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JTextField;

import co.simplon.money_money_logiciel.controller.Client_Handler;
import co.simplon.money_money_logiciel.modeles.Client;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

/**
 * Formulaire de connection/création d'un client
 * 
 * @author Julien
 * @author Ondine
 *
 */
public class GestionBancaireGUI extends JFrame {

	/**
	 * La fenêtre de connection/création de client grâce à son nom
	 */
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

		// Liste déroulante des clients existants
		String[] nomsClients = Client_Handler.ListeNomClients();
		final JComboBox comboBox = new JComboBox(nomsClients);
		comboBox.setEditable(true);
		comboBox.setBounds(60, 390, 330, 34);
		getContentPane().add(comboBox);

		JButton btnValider = new JButton("Valider");
		btnValider.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnValider.setBounds(150, 477, 150, 40);
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Vérification si le client a été selectionné dans la liste de clients
				// existants puis ouverture de la page
				if (comboBox.getSelectedIndex() != -1) {
					String clientSelected = comboBox.getItemAt(comboBox.getSelectedIndex()).toString();
					Client myClient = Client_Handler.connectClient(clientSelected);
					if (myClient != null) {
						new ListeComptesFormGUI(myClient);
						dispose();
					}
					// Vérification si le nom du client a été saisi manuellement puis création du
					// client et ouverture de la page
				} else if (comboBox.getEditor().getItem().toString() != null
						&& comboBox.getEditor().getItem().toString().isEmpty() != true) {
					String clientCreated = comboBox.getEditor().getItem().toString();
					Client myClient = Client_Handler.connectClient(clientCreated);
					if (myClient != null) {
						new ListeComptesFormGUI(myClient);
						dispose();
					} else {
						comboBox.setToolTipText("Max 50 characters");
						comboBox.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
					}
					// Message d'erreur si le champ est laissé vide

				} else {
					comboBox.setToolTipText("Le champ ne peut pas être vide");
					comboBox.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
				}
			}
		});

		getContentPane().add(btnValider);

		setLocationRelativeTo(null);
		setVisible(true);
	}
}
