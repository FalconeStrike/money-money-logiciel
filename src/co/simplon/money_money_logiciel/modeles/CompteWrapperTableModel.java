package co.simplon.money_money_logiciel.modeles;

import java.util.*;

import javax.swing.table.AbstractTableModel;

public class CompteWrapperTableModel extends AbstractTableModel {

	private String[] columnNames =
		{
				"Type de compte",
				"Numéro du compte",
				"Solde : (€)"
		};
	
	private static List<WrapperCompte> wrapperComptes;
	
	public CompteWrapperTableModel() {
		wrapperComptes = new ArrayList<WrapperCompte>();
	}
	
	public CompteWrapperTableModel(List<WrapperCompte> wrapperComptes) {
		this.wrapperComptes = wrapperComptes;
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}
	
	@Override
	public int getRowCount() {
		return wrapperComptes.size();
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
		case 1: return int.class;
		case 2: return float.class;
		default: return String.class;
		}
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		WrapperCompte compte = getWrapperCompte(rowIndex);
		
		switch (columnIndex)
		{
		case 0: return compte.getNOM_TYPE();
		case 1: return compte.getNum_Compte();
		case 2: return compte.getSolde_Init();
		}
		return null;
	}
	
	@Override
	public void setValueAt(Object value, int rowIndex, int columnIndex) {
		WrapperCompte compte = getWrapperCompte(rowIndex);
		
		switch (columnIndex)
		{
		case 0: compte.setNOM_TYPE((String)value); break;
		case 1: compte.setNum_Compte((int)value); break;
		case 2: compte.setSolde_Init((Float)value); break;
		}
		
		fireTableCellUpdated(rowIndex, columnIndex);
	}

	public static WrapperCompte getWrapperCompte(int rowIndex) {
		return wrapperComptes.get(rowIndex);
	}
	
	
}