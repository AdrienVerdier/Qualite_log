package controler;

import java.util.Iterator;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import model.Produit;

public class myTableProduitManagement extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	private String[] columnNames;
	private JTable table;
	private int idRayon;

	public myTableProduitManagement(String[] columnNames, int idRayon) {
		this.columnNames = columnNames;
		this.idRayon = idRayon;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public int getColumnCount() {
		return columnNames.length;
	}

	public int getRowCount() {
		return gestionProduit.nombreProduit(idRayon);
	}

	public String getColumnName(int col) {
		return columnNames[col];
	}

	public void removeRow(int row) {
		gestionProduit.supprimerSetup((int) table.getValueAt(row, 0));
		
		this.fireTableDataChanged();
	}

	public Object getValueAt(int row, int col) {

		if (gestionProduit.nombreProduit(idRayon) != 0) {
			Iterator<Produit> iterator = gestionProduit.getProduit(idRayon).iterator();

			for (int i = 0; i < row; i++)
				iterator.next();

			Produit produitSelected = iterator.next();

			switch (col) {
			case 0:
				return produitSelected.getIDProduit();
			case 1:
				return produitSelected.getPrix()();
			case 2:
				return produitSelected.getQuantite();
			case 3:
				return produitSelected.getDescription();
			}
		}
		return null;
	}

	public Class<? extends Object> getColumnClass(int c) {
		if (getValueAt(0, c) != null)
			return getValueAt(0, c).getClass();
		else
			return null;
	}
	
}
