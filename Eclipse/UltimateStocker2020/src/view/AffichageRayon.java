package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableRowSorter;

public class AffichageRayon extends JPanel implements ActionListener{
	
	private static final long serialVersionUID = 12L;
	private JButton userManagementButton, openButton, addButton, suppressButton, passwordChangementButton, searchButton;
	private JFrame frame;
	private JTextField textZone1;
	private JComboBox<String> dropDownList;
	private JTable table;
	private JLabel titre;
	private myTableRayonManagement tablemodel;
	private TableRowSorter<myTableRayonManagement> sorter;
	private boolean isChefMagasin;
	private int idUser;

	public AffichageRayon(JFrame frame, boolean isChefMagasin, int idUser) {
		this.isChefMagasin = isChefMagasin;
		this.idUser = idUser;
		this.frame = frame;

		this.setLayout(null);
		this.frame.setContentPane(this);

		titre = new JLabel("Ultimate Stocker 2020 - Visualisation des rayons");
		titre.setLayout(null);
		titre.setFont(new Font("Arial", Font.BOLD, 20));
		titre.setBounds(25, 0, 250, 40);
		this.add(titre);

		addButton = new JButton("Ajouter");
		addButton.setBounds(appInterface.windowsSizeX - 225, 75, 175, 50);
		addButton.setFont(new Font("Arial", Font.BOLD, 20));
		addButton.setForeground(Color.BLACK);
		addButton.setBackground(Color.LIGHT_GRAY);
		this.add(addButton);
		addButton.addActionListener(this);

		suppressButton = new JButton("Supprimer");
		suppressButton.setBounds(appInterface.windowsSizeX - 225, 225, 175, 50);
		suppressButton.setFont(new Font("Arial", Font.BOLD, 20));
		suppressButton.setForeground(Color.BLACK);
		suppressButton.setBackground(Color.LIGHT_GRAY);
		this.add(suppressButton);
		suppressButton.addActionListener(this);

		userManagementButton = new JButton("Gestion des utilisateurs");
		userManagementButton.setBounds(appInterface.windowsSizeX - 225, appInterface.windowsSizeY - 125, 175, 50);
		userManagementButton.setFont(new Font("Arial", Font.BOLD, 20));
		userManagementButton.setForeground(Color.BLACK);
		userManagementButton.setBackground(Color.LIGHT_GRAY);
		this.add(userManagementButton);
		userManagementButton.addActionListener(this);
		
		openButton = new JButton("Ouvrir");
		openButton.setBounds(appInterface.windowsSizeX - 225, appInterface.windowsSizeY - 110, 175, 50);
		openButton.setFont(new Font("Arial", Font.BOLD, 20));
		openButton.setForeground(Color.BLACK);
		openButton.setBackground(Color.LIGHT_GRAY);
		this.add(openButton);
		openButton.addActionListener(this);
		
		passwordChangementButton = new JButton("Changement mot de passe");
		passwordChangementButton.setBounds(appInterface.windowsSizeX - 225, appInterface.windowsSizeY - 95, 175, 50);
		passwordChangementButton.setFont(new Font("Arial", Font.BOLD, 20));
		passwordChangementButton.setForeground(Color.BLACK);
		passwordChangementButton.setBackground(Color.LIGHT_GRAY);
		this.add(passwordChangementButton);
		passwordChangementButton.addActionListener(this);
		
		searchButton = new JButton("Rechercher");
		searchButton.setBounds(appInterface.windowsSizeX - 225, appInterface.windowsSizeY - 95, 175, 50);
		searchButton.setFont(new Font("Arial", Font.BOLD, 20));
		searchButton.setForeground(Color.BLACK);
		searchButton.setBackground(Color.LIGHT_GRAY);
		this.add(searchButton);
		searchButton.addActionListener(this);

		String title[] = { "ID", "NOM DU RAYON"};

		tablemodel = new myTableRayonManagement(title);
		table = new JTable(tablemodel);
		tablemodel.setTable(table);

		table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {

			private static final long serialVersionUID = 2L;

			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
					boolean hasFocus, int row, int column) {

				Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

				c.setForeground(Color.BLACK);

				return c;
			}
		});

		JScrollPane tableContainer = new JScrollPane(table);
		table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 13));
		table.getTableHeader().setForeground(Color.white);
		table.getTableHeader().setBackground(new Color(51, 153, 255));
		table.setFont(new Font("Arial", Font.BOLD, 13));
		table.getTableHeader().setReorderingAllowed(false);
		tableContainer.setBounds(50, 200, 700, 400);
		this.add(tableContainer, BorderLayout.CENTER);
	}

	// Cette partie n'est pas faite, il faut aussi que je fasse la doc 
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == returnButton) {
			JPanel homePanel = new homePanel(frame, user);
			frame.repaint();
			frame.revalidate();
		}

		if (e.getSource() == suppressButton) {
			if (table.getSelectedRow() != -1) {

				int retour = JOptionPane.showConfirmDialog(this,
						"Etes-vous sûr de vouloir supprimer l'utilisateur " + tablemodel.getValueAt(table.getSelectedRow(), 2) + " "
								+ tablemodel.getValueAt(table.getSelectedRow(), 3) + " ?",
						"CONFIRM", JOptionPane.YES_NO_OPTION);

				if (retour == JOptionPane.OK_OPTION)
					tablemodel.removeRow(table.getSelectedRow());
			}
		}

		if (e.getSource() == addButton) {
			JPanel utilisateurAddPanel = new utilisateurAddPanel(frame, user);
			frame.repaint();
			frame.revalidate();
		}

		if (e.getSource() == searchButton) {
			if (dropDownList.getSelectedItem().equals("ID")) {
				if (textZone1.getText() != null) {
					sorter.setRowFilter(RowFilter.regexFilter("(?i)" + textZone1.getText(), 0));
					table.setRowSorter(sorter);
				} else
					table.setAutoCreateRowSorter(true);
			}

			if (dropDownList.getSelectedItem().equals("LOGIN")) {
				if (textZone1.getText() != null) {
					sorter.setRowFilter(RowFilter.regexFilter("(?i)" + textZone1.getText(), 1));
					table.setRowSorter(sorter);
				} else
					table.setAutoCreateRowSorter(true);

			}

			if (dropDownList.getSelectedItem().equals("NOM")) {
				if (textZone1.getText() != null) {
					sorter.setRowFilter(RowFilter.regexFilter("(?i)" + textZone1.getText(), 2));
					table.setRowSorter(sorter);
				} else
					table.setAutoCreateRowSorter(true);
			}

			if (dropDownList.getSelectedItem().equals("PRENOM")) {
				if (textZone1.getText() != null) {
					sorter.setRowFilter(RowFilter.regexFilter("(?i)" + textZone1.getText(), 7));
					table.setRowSorter(sorter);
				} else
					table.setAutoCreateRowSorter(true);
			}
		}
	}

}
