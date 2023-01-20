package co.simplon.money_money_logiciel.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DaoEpargne {
	
	
	
///////////////////////////////////RÉCUPÉRATION DU COMPTE EPARGNE POUR POUVOIR SÉLECTIONNER ET MANIPULER LE COMPTE////////////////////////////////////

	

public static int getNumeroCompteEpargne(int id_epargne) {
int numeroCompteEpargne = 0;
try {
Statement st = LiensBdd.connectionBdd();
ResultSet rs = st.executeQuery("SELECT id_courant FROM courant WHERE id_courant = " + id_epargne);
rs.next();
numeroCompteEpargne = rs.getInt(1);
LiensBdd.closeBdd();
} catch (SQLException e) {
System.out.println("SQL Exception found");
}
return numeroCompteEpargne;

}




//////////////////////////////////////////////RÉCUPÉRATION DU NOM DU CLIENT POUR L'AFFICHAGE DANS LE  FRONT///////////////////

public static String getNomClient(int id_client) {


String nomDuclient= "" ;

try {
Statement st = LiensBdd.connectionBdd();
ResultSet rs = st.executeQuery("SELECT nom_client FROM client WHERE id_client = " + id_client);
rs.next();
nomDuclient= rs.getString(1);
LiensBdd.closeBdd();
} catch (SQLException e) {
System.out.println("SQL Exception found");
}
return nomDuclient;


}



//////////////////////////////////////////MODIFICATION DU NOM DU CLIENT///////////////////////////////////////////////////



public static void UpdateNomClient(int id_client, String nom_client) {
try {
PreparedStatement st = LiensBdd.connectionBddPrep("UPDATE client SET nom_client = ? WHERE id_client = ? ;");
st.setString(1,nom_client);
st.setInt(2,id_client);
st.executeUpdate();
LiensBdd.closeBdd();
} 
catch (SQLException e) {
System.out.println("Class not found " + e);
} 
}



///////////////////////////////////RÉCUPÉRATION DES TAUX D'INTÉRÊT ACTUELS DU COMPTE EPARGNE POUR LES AFFICHER DANS LE FRONT////////////////////////////////////



public static double getTauxInteret(int id_epargne) {

double tauxInteret = 0;
try {
Statement st = LiensBdd.connectionBdd();
ResultSet rs = st.executeQuery("SELECT taux FROM epargne WHERE id_epargne = " + id_epargne);
rs.next();
tauxInteret = rs.getDouble(1);
LiensBdd.closeBdd();
} catch (SQLException e) {
System.out.println("SQL Exception found");
}
return tauxInteret;


}





///////////////////////////////////ENREGISTREMENT DES NOUVEAUX TAUX D'INTÉRÊTS DU COMPTE EPARGNE////////////////////////////////////



public static void UpdateTauxInteretEpargne(int id_epargne,double taux) {


try {

PreparedStatement st = LiensBdd.connectionBddPrep("UPDATE epargne SET taux = ? WHERE id_epargne = "+id_epargne);
st.setDouble(1,taux);
st.executeUpdate();
LiensBdd.closeBdd();
} 
catch (SQLException e) {
System.out.println("Class not found " + e);
} 


 }

}
