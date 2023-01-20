package co.simplon.money_money_logiciel.modeles;

import java.util.*;

import javax.swing.table.AbstractTableModel;

public class CompteTableModel extends AbstractTableModel {

	private String[] columnNames =
		{
				"Numéro compte",
				"Libelle client",
				"Solde : (€)"
		};
	
	private static List<Compte> comptes;
	
	public CompteTableModel() {
		comptes = new ArrayList<Compte>();
	}
	
	public CompteTableModel(List<Compte> comptes) {
		this.comptes = comptes;
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}
	
	@Override
	public int getRowCount() {
		return comptes.size();
	}

	@Override
	public String getColumnName(int column)
	{
		return columnNames[column];
	}
	
	@Override
	public Class getColumnClass(int column) {
		switch (column)
		{
		case 1: return String.class;
		case 2: return Float.class;
		default: return int.class;
		}
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Compte compte = getCompte(rowIndex);
		
		switch (columnIndex)
		{
		case 0: return compte.getNum_Compte();
		case 1: return compte.getLibelle_Client();
		case 2: return compte.getSolde_Init();
		}
		return null;
	}
	
	@Override
	public void setValueAt(Object value, int rowIndex, int columnIndex) {
		Compte compte = getCompte(rowIndex);
		
		switch (columnIndex)
		{
		case 0: compte.setNum_Compte((int)value); break;
		case 1: compte.setLibelle_Client((String)value); break;
		case 2: compte.setSolde_Init((Float)value); break;
		}
		
		fireTableCellUpdated(rowIndex, columnIndex);
	}

	public static Compte getCompte(int rowIndex) {
		return comptes.get(rowIndex);
	}
	
	public void addCompte(Compte compte) {
		insertCompte(getRowCount(), compte);
	}
	
	public void insertCompte(int rowIndex, Compte compte) {
		comptes.add(rowIndex, compte);
		fireTableRowsInserted(rowIndex, rowIndex);
	}
	
	public void removeCompte(int rowIndex) {
		comptes.remove(rowIndex);
		fireTableRowsDeleted(rowIndex, rowIndex);
	}
}
