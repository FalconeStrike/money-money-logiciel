package co.simplon.money_money_logiciel.vues;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class GestionBancaire extends JFrame {
	private JTextField textNomBanque;
	public GestionBancaire() {
		setSize(450, 700);
		setResizable(false);
		getContentPane().setLayout(null);
		
		JLabel lblTitle = new JLabel("Création de la Banque");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblTitle.setBounds(105, 11, 240, 40);
		getContentPane().add(lblTitle);
		
		JPanel panelLogo = new JPanel();
		panelLogo.setBounds(40, 80, 370, 170);
		getContentPane().add(panelLogo);
		
		JLabel lblLogo = new JLabel("New label");
		panelLogo.add(lblLogo);
		
		textNomBanque = new JTextField();
		textNomBanque.setFont(new Font("Tahoma", Font.PLAIN, 24));
		textNomBanque.setBounds(60, 339, 330, 40);
		getContentPane().add(textNomBanque);
		textNomBanque.setColumns(10);
		
		JButton btnValider = new JButton("Valider");
		btnValider.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnValider.setBounds(150, 477, 150, 40);
		getContentPane().add(btnValider);
	}
}
