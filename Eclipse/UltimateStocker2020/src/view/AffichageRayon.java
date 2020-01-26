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

import controler.gestionRayon;
import controler.gestionUtilisateur;
import controler.myTableRayonManagement;

public class AffichageRayon extends JPanel implements ActionListener{
	
	private static final long serialVersionUID = 12L;
	private JButton addButton, suppressButton, modifier, changerMotDePasse, gestionDesUtilisateurs, ouvrir;
	private JFrame frame;
	private JTable table;
	private myTableRayonManagement tablemodel;
	private JLabel label;
	private TableRowSorter<myTableRayonManagement> sorter;
	private int idUser;
	private boolean isChefMagasin;

	public AffichageRayon(JFrame frame, boolean isChefMagasin ,int idUser) {
		this.idUser = idUser;
		this.isChefMagasin = isChefMagasin;
		this.frame = frame;

		this.setLayout(null);
		this.frame.setContentPane(this);

		label = new JLabel("Choix du Rayon");
		label.setLayout(null);
		label.setFont(new Font("Arial", Font.BOLD, 20));
		label.setBounds(25, 0, 250, 40);
		this.add(label);

		addButton = new JButton("Ajouter");
		addButton.setBounds(appInterface.windowsSizeX - 225, 150, 175, 50);
		addButton.setFont(new Font("Arial", Font.BOLD, 20));
		addButton.setForeground(Color.BLACK);
		addButton.setBackground(Color.LIGHT_GRAY);
		this.add(addButton);
		addButton.addActionListener(this);

		String title[] = { "ID Rayon", "Nom du rayon"};

		tablemodel = new myTableRayonManagement(title, idUser, isChefMagasin);
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

		sorter = new TableRowSorter<myTableRayonManagement>(tablemodel);

		suppressButton = new JButton("Supprimer");
		suppressButton.setBounds(appInterface.windowsSizeX - 225, 225, 175, 50);
		suppressButton.setFont(new Font("Arial", Font.BOLD, 20));
		suppressButton.setForeground(Color.BLACK);
		suppressButton.setBackground(Color.LIGHT_GRAY);
		this.add(suppressButton);
		suppressButton.addActionListener(this);

		modifier = new JButton("Modifier");
		modifier.setBounds(appInterface.windowsSizeX - 225, appInterface.windowsSizeY - 250, 175, 50);
		modifier.setFont(new Font("Arial", Font.BOLD, 20));
		modifier.setForeground(Color.BLACK);
		modifier.setBackground(Color.LIGHT_GRAY);
		this.add(modifier);
		modifier.addActionListener(this);
		
		changerMotDePasse = new JButton("Changer Mot de Passe");
		changerMotDePasse.setBounds(appInterface.windowsSizeX - 450, appInterface.windowsSizeY - 125, 400, 50);
		changerMotDePasse.setFont(new Font("Arial", Font.BOLD, 20));
		changerMotDePasse.setForeground(Color.BLACK);
		changerMotDePasse.setBackground(Color.LIGHT_GRAY);
		this.add(changerMotDePasse);
		changerMotDePasse.addActionListener(this);
		
		ouvrir = new JButton("Accéder au rayon");
		ouvrir.setBounds(appInterface.windowsSizeX - 275, 75, 225, 50);
		ouvrir.setFont(new Font("Arial", Font.BOLD, 20));
		ouvrir.setForeground(Color.BLACK);
		ouvrir.setBackground(Color.LIGHT_GRAY);
		this.add(ouvrir);
		ouvrir.addActionListener(this);
		
		gestionDesUtilisateurs = new JButton("Gestion des utilisateurs");
		gestionDesUtilisateurs.setBounds(appInterface.windowsSizeX - 225, 50, 175, 50);
		gestionDesUtilisateurs.setFont(new Font("Arial", Font.BOLD, 20));
		gestionDesUtilisateurs.setForeground(Color.BLACK);
		gestionDesUtilisateurs.setBackground(Color.LIGHT_GRAY);
		this.add(gestionDesUtilisateurs);
		gestionDesUtilisateurs.addActionListener(this);
		if(isChefMagasin) {
			gestionDesUtilisateurs.setVisible(true);
		}
		else {
			gestionDesUtilisateurs.setVisible(false);
		}
	}

	/**
	 * This method gathers the different action of the panel
	 * 
	 * @param e The action that is performed
	 */
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == addButton) {

			if(isChefMagasin) {
				String nom = JOptionPane.showInputDialog(null, "Nom du rayon", "Ajout d'un rayon", JOptionPane.QUESTION_MESSAGE);
				gestionRayon.ajouterRayon(nom, idUser);
				JPanel AffichageRayon = new AffichageRayon(frame, isChefMagasin, idUser);
				frame.repaint();
				frame.revalidate();
			}
			else {
				int retour = JOptionPane.showConfirmDialog(this,
						"Seul le chef de magasin peut ajouter des rayons",
						"CONFIRM", JOptionPane.YES_OPTION);
			}
			
		}

		if (e.getSource() == suppressButton) {
			if (table.getSelectedRow() != -1) {
				int retour = JOptionPane.showConfirmDialog(this,
						"Êtes-vous sûr de vouloir supprimer ce rayon",
						"CONFIRM", JOptionPane.YES_NO_OPTION);

				if (retour == JOptionPane.OK_OPTION)
					tablemodel.removeRow(table.getSelectedRow());
			}
		}
		
		if (e.getSource() == ouvrir) {
			JPanel affichageProduitPanel = new AffichageProduitPanel(frame, idUser, isChefMagasin, (int)table.getValueAt(table.getSelectedRow(), 0));
			frame.repaint();
			frame.revalidate();
		}
		
		if(e.getSource() == modifier) {
			if (table.getSelectedRow() != -1) {
				String retour = JOptionPane.showInputDialog(null,
						"Nouveau nom du rayon",
						"Modifier", JOptionPane.QUESTION_MESSAGE);

				if (!retour.isEmpty())
					gestionRayon.modifierRayon((int)table.getValueAt(table.getSelectedRow(), 0), retour);
				
				JPanel AffichageRayon = new AffichageRayon(frame, isChefMagasin, idUser);
				frame.repaint();
				frame.revalidate();
			}
		}
		
		if (e.getSource() == gestionDesUtilisateurs) {
			JPanel GestionUtilisateurPanel = new GestionUtilisateurPanel(frame, idUser, isChefMagasin);
			frame.repaint();
			frame.revalidate();
		}
		
		if (e.getSource() == changerMotDePasse) {
			String newPasswd = JOptionPane.showInputDialog(null, "Entrer votre nouveau mot de passe", "Changement mot de passe", JOptionPane.QUESTION_MESSAGE);
			gestionUtilisateur.changerMDP(idUser, isChefMagasin, newPasswd);
			JOptionPane.showMessageDialog(null, "Mot de passe changé");
		}
	}
}
