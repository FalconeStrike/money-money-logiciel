import co.simplon.money_money_logiciel.controller.Compte_Handler;
import co.simplon.money_money_logiciel.dao.DaoCompte;
import co.simplon.money_money_logiciel.dao.DaoCourant;
import co.simplon.money_money_logiciel.dao.DaoEpargne;
import co.simplon.money_money_logiciel.modeles.Client;
import co.simplon.money_money_logiciel.modeles.Compte;
import co.simplon.money_money_logiciel.vues.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//new GestionBancaireGUI();
		//new CrediterCompteFormGUI(2);
		//new DaoCompte();
		//DaoCompte.crediterCompteDao(0, 0);
		//ModifierCompteCourantFormGUI frame1 = new ModifierCompteCourantFormGUI(2);
		//frame1.setVisible(true);
		//ModifierCompteEpargneFormGUI frame2 = new ModifierCompteEpargneFormGUI(1);
		//frame2.setVisible(true);
		//Compte compte = new Compte (2,2,782425,2,4118,"");
		//TransfererSoldeFormGUI frame3 = new TransfererSoldeFormGUI(compte);
		//frame3.setVisible(true);
		//new DaoCourant();
		//DaoCourant.getFraisDeTransfert(2);
		//DaoCourant.ModifierFraisDeTransfertCourantDao(1, 5);
		//DaoCourant.UpdateNomClient(1,"Lala");
		//DaoCourant.getNomClient(3);
		//new DaoEpargne();
		//DaoEpargne.getTauxInteret(2);
		//DaoEpargne.UpdateTauxInteretEpargne(2, 8);
		//DaoEpargne.UpdateNomClient(1,"Lalo");
		//DaoEpargne.getNomClient(3);
		//DaoCompte.getTypeCompte(2);
		//Compte_Handler.getCompteDestination(1, 2);
//		new ListeComptesFormGUI();
//		new CrediterCompteFormGUI(2);
//		new OuvrirCompteFormGUI(2);
		new GestionBancaireGUI();
	}
}
