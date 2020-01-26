package controler;

import java.util.Iterator;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import model.Rayon;

public class myTableRayonManagement extends AbstractTableModel {
	
	private static final long serialVersionUID = 2L;
	private String[] columnNames;
	private JTable table;
	private int idUtilisateur;
	private boolean isChefMagasin;

	public myTableRayonManagement(String[] columnNames, int idUtilisateur, boolean isChefMagasin) {
		this.columnNames = columnNames;
		this.idUtilisateur = idUtilisateur;
		this.isChefMagasin = isChefMagasin;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public int getColumnCount() {
		return columnNames.length;
	}

	public int getRowCount() {
		return gestionRayon.nombreRayon(idUtilisateur, isChefMagasin);
	}

	public String getColumnName(int col) {
		return columnNames[col];
	}

	public void removeRow(int row) {
		gestionRayon.supprimerRayon((int) table.getValueAt(row, 0));
		
		this.fireTableDataChanged();
	}

	public Object getValueAt(int row, int col) {

		if (gestionRayon.nombreRayon(idUtilisateur, isChefMagasin) != 0) {
			Iterator<Rayon> iterator = gestionRayon.getRayon(idUtilisateur).iterator();

			for (int i = 0; i < row; i++)
				iterator.next();

			Rayon rayonSelected = iterator.next();

			switch (col) {
			case 0:
				return rayonSelected.getIDRayon();
			case 1:
				return rayonSelected.getNom();
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
