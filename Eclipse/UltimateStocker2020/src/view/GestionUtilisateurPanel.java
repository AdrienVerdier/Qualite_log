package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableRowSorter;

import controler.gestionUtilisateur;
import controler.myTableUtilisateurManagement;

public class GestionUtilisateurPanel extends JPanel implements ActionListener{
	
	private static final long serialVersionUID = 6L;
	
	private JButton returnButton, modifierButton, addButton, suppressButton;
	private JFrame frame;
	private JTable table;
	private myTableUtilisateurManagement tablemodel;
	private JLabel label;
	private TableRowSorter<myTableUtilisateurManagement> sorter;
	private int idUser;
	private boolean isChefMagasin;

	public GestionUtilisateurPanel(JFrame frame, int idUser, boolean isChefMagasin) {
		this.idUser = idUser;
		this.frame = frame;
		this.isChefMagasin = isChefMagasin;

		this.setLayout(null);
		this.frame.setContentPane(this);

		label = new JLabel("Gestion des utilisateurs");
		label.setLayout(null);
		label.setFont(new Font("Arial", Font.BOLD, 20));
		label.setBounds(25, 0, 250, 40);
		this.add(label);

		modifierButton = new JButton("Modifier");
		modifierButton.setLayout(new BorderLayout());
		modifierButton.setFont(new Font("Arial", Font.BOLD, 20));
		modifierButton.setBounds(50, 75, 100, 50);
		modifierButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		modifierButton.setBackground(Color.LIGHT_GRAY);
		modifierButton.setOpaque(true);
		this.add(modifierButton);
		modifierButton.addActionListener(this);

		addButton = new JButton("Ajouter");
		addButton.setBounds(appInterface.windowsSizeX - 225, 75, 175, 50);
		addButton.setFont(new Font("Arial", Font.BOLD, 20));
		addButton.setForeground(Color.BLACK);
		addButton.setBackground(Color.LIGHT_GRAY);
		this.add(addButton);
		addButton.addActionListener(this);

		String title[] = { "IdUtilisateur", "Nom Utilisateur", "Prénom Utilisateur"};

		tablemodel = new myTableUtilisateurManagement(title);
		table = new JTable(tablemodel);
		tablemodel.setTable(table);
		JScrollPane tableContainer = new JScrollPane(table);
		table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 13));
		table.getTableHeader().setForeground(Color.blue);
		table.getTableHeader().setBackground(new Color(51, 153, 255));
		table.setFont(new Font("Arial", Font.BOLD, 13));
		table.setAutoCreateRowSorter(true);
		table.getTableHeader().setReorderingAllowed(false);
		tableContainer.setBounds(50, 200, 700, 400);
		this.add(tableContainer, BorderLayout.CENTER);

		sorter = new TableRowSorter<myTableUtilisateurManagement>(tablemodel);

		suppressButton = new JButton("Supprimer");
		suppressButton.setBounds(appInterface.windowsSizeX - 225, 225, 175, 50);
		suppressButton.setFont(new Font("Arial", Font.BOLD, 20));
		suppressButton.setForeground(Color.BLACK);
		suppressButton.setBackground(Color.LIGHT_GRAY);
		this.add(suppressButton);
		suppressButton.addActionListener(this);

		returnButton = new JButton("RETOUR");
		returnButton.setBounds(appInterface.windowsSizeX - 225, appInterface.windowsSizeY - 125, 175, 50);
		returnButton.setFont(new Font("Arial", Font.BOLD, 20));
		returnButton.setForeground(Color.BLACK);
		returnButton.setBackground(Color.LIGHT_GRAY);
		this.add(returnButton);
		returnButton.addActionListener(this);
		
	}

	/**
	 * This method gathers the different action of the panel
	 * 
	 * @param e The action that is performed
	 */
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == returnButton) {
			JPanel AffichageRayon = new AffichageRayon(frame, isChefMagasin, idUser);
			frame.repaint();
			frame.revalidate();
		}

		if (e.getSource() == modifierButton) {
			if (table.getSelectedRow() != -1) {
				JPanel AjouterUtilisateurPanel = new AjouterUtilisateurPanel(frame, isChefMagasin, idUser, false, (int)table.getValueAt(table.getSelectedRow(), 0));
				frame.repaint();
				frame.revalidate();
			}
		}

		if (e.getSource() == addButton) {
			JPanel AjouterUtilisateurPanel = new AjouterUtilisateurPanel(frame, isChefMagasin, idUser, true, 0);
			frame.repaint();
			frame.revalidate();
		}

		if (e.getSource() == suppressButton) {
			if (table.getSelectedRow() != -1) {

				int retour = JOptionPane.showConfirmDialog(this,
						"Êtes-vous sûr de vouloir supprimer ce clap",
						"TITRE", JOptionPane.YES_NO_OPTION);

				if (retour == JOptionPane.OK_OPTION)
					tablemodel.removeRow(table.getSelectedRow());
			}
		}
	}

}
