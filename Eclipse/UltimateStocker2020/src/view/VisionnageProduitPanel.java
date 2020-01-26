package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import controler.gestionProduit;

public class VisionnageProduitPanel extends JPanel implements ActionListener {
	
	private static final long serialVersionUID = 5L;
	private JButton returnButton, modifierButton;
	private JFrame frame;
	private JLabel textLabel1, textLabel2, textLabel3, textLabel4, textLabel5, label, validateLabel;
	private boolean isChefMagasin;
	private int idUser;
	private int idRayon;
	private int idProduit;

	public VisionnageProduitPanel(JFrame frame, int idUser, boolean isChefMagasin, int idRayon, int idProduit) {
		this.isChefMagasin = isChefMagasin;
		this.idUser = idUser;
		this.frame = frame;
		this.idRayon = idRayon;
		this.idProduit = idProduit;
		
		this.setLayout(null);
		this.frame.setContentPane(this);

		label = new JLabel("Visionnage d'un produit");
		label.setLayout(null);
		label.setFont(new Font("Arial", Font.BOLD, 20));
		label.setBounds(25, 0, 300, 40);
		this.add(label);

		textLabel1 = new JLabel("id du produit : " + idProduit, SwingConstants.CENTER);
		textLabel1.setLayout(null);
		textLabel1.setFont(new Font("Arial", Font.BOLD, 20));
		textLabel1.setBounds(appInterface.windowsSizeX - 800, appInterface.windowsSizeY - 750, 300, 50);
		textLabel1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		textLabel1.setBackground(Color.LIGHT_GRAY);
		textLabel1.setOpaque(true);
		this.add(textLabel1);

		textLabel2 = new JLabel("Description du produit : " + gestionProduit.getDescription(idProduit), SwingConstants.CENTER);
		textLabel2.setLayout(null);
		textLabel2.setFont(new Font("Arial", Font.BOLD, 20));
		textLabel2.setBounds(appInterface.windowsSizeX - 800, appInterface.windowsSizeY - 550, 300, 50);
		textLabel2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		textLabel2.setBackground(Color.LIGHT_GRAY);
		textLabel2.setOpaque(true);
		this.add(textLabel2);

		textLabel3 = new JLabel("Prix du produit :" + gestionProduit.getPrix(idProduit), SwingConstants.CENTER);
		textLabel3.setLayout(null);
		textLabel3.setFont(new Font("Arial", Font.BOLD, 20));
		textLabel3.setBounds(appInterface.windowsSizeX - 800, appInterface.windowsSizeY - 450, 300, 50);
		textLabel3.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		textLabel3.setBackground(Color.LIGHT_GRAY);
		textLabel3.setOpaque(true);
		this.add(textLabel3);
		
		textLabel4 = new JLabel("Quantite de produit :" + gestionProduit.getQuantite(idProduit), SwingConstants.CENTER);
		textLabel4.setLayout(null);
		textLabel4.setFont(new Font("Arial", Font.BOLD, 20));
		textLabel4.setBounds(appInterface.windowsSizeX - 800, appInterface.windowsSizeY - 350, 300, 50);
		textLabel4.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		textLabel4.setBackground(Color.LIGHT_GRAY);
		textLabel4.setOpaque(true);
		this.add(textLabel4);
		
		textLabel5 = new JLabel("Rayon du produit :" + idRayon, SwingConstants.CENTER);
		textLabel5.setLayout(null);
		textLabel5.setFont(new Font("Arial", Font.BOLD, 20));
		textLabel5.setBounds(appInterface.windowsSizeX - 800, appInterface.windowsSizeY - 250, 300, 50);
		textLabel5.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		textLabel5.setBackground(Color.LIGHT_GRAY);
		textLabel5.setOpaque(true);
		this.add(textLabel5);

		modifierButton = new JButton("Modifier");
		modifierButton.setBounds(appInterface.windowsSizeX - 600, appInterface.windowsSizeY - 150, 175, 50);
		modifierButton.setFont(new Font("Arial", Font.BOLD, 20));
		modifierButton.setForeground(Color.BLACK);
		modifierButton.setBackground(Color.LIGHT_GRAY);
		this.add(modifierButton);
		modifierButton.addActionListener(this);

		returnButton = new JButton("RETOUR");
		returnButton.setBounds(appInterface.windowsSizeX - 225, appInterface.windowsSizeY - 125, 175, 50);
		returnButton.setFont(new Font("Arial", Font.BOLD, 20));
		returnButton.setForeground(Color.BLACK);
		returnButton.setBackground(Color.LIGHT_GRAY);
		this.add(returnButton);
		returnButton.addActionListener(this);

		validateLabel = new JLabel();
		validateLabel.setLayout(null);
		validateLabel.setForeground(Color.green.darker());
		validateLabel.setFont(new Font("Arial", Font.BOLD, 20));
		validateLabel.setBounds(appInterface.windowsSizeX - 650, appInterface.windowsSizeY - 100, 400, 40);
		this.add(validateLabel);

	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == modifierButton) {

			JPanel AjouterProduitPanel = new AjouterProduitPanel(frame, idUser, isChefMagasin, idRayon, false, idProduit);
			frame.repaint();
			frame.revalidate();
			
		}

		if (e.getSource() == returnButton) {
			JPanel AffichageProduitPanel = new AffichageProduitPanel(frame, idUser, isChefMagasin, idRayon);
			frame.repaint();
			frame.revalidate();
		}
	}
	
}
