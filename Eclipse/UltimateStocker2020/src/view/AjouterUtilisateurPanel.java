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

import controler.gestionUtilisateur;
import controler.gestionRayon;

public class AjouterUtilisateurPanel extends JPanel implements ActionListener {
	
	private static final long serialVersionUID = 8L;
	private JButton returnButton, applyButton;
	private JFrame frame;
	private JLabel textLabel1, textLabel2, textLabel3, textLabel4, label, validateLabel;
	private JTextField textZone1, textZone2, textZone3;
	private JComboBox<String> dropDownList;
	private boolean isChefMagasin;
	private int idUser;
	private boolean isAdd;
	private int aModifier;

	public AjouterUtilisateurPanel(JFrame frame, boolean isChefMagasin, int idUser, boolean isAdd, int aModifier) {
		this.isChefMagasin = isChefMagasin;
		this.idUser = idUser;
		this.isAdd = isAdd;
		this.frame = frame;
		this.aModifier = aModifier;
		
		this.setLayout(null);
		this.frame.setContentPane(this);

		label = new JLabel("Ajout/Modification d'un utilisateur");
		label.setLayout(null);
		label.setFont(new Font("Arial", Font.BOLD, 20));
		label.setBounds(25, 0, 300, 40);
		this.add(label);

		textLabel1 = new JLabel("Nom", SwingConstants.CENTER);
		textLabel1.setLayout(null);
		textLabel1.setFont(new Font("Arial", Font.BOLD, 20));
		textLabel1.setBounds(appInterface.windowsSizeX - 800, appInterface.windowsSizeY - 750, 300, 50);
		textLabel1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		textLabel1.setBackground(Color.LIGHT_GRAY);
		textLabel1.setOpaque(true);
		this.add(textLabel1);

		textZone1 = new JTextField();
		textZone1.setFont(new Font("Arial", Font.BOLD, 20));
		textZone1.setLayout(null);
		textZone1.setBounds(appInterface.windowsSizeX - 500, appInterface.windowsSizeY - 750, 300, 50);
		this.add(textZone1);
		textZone1.setHorizontalAlignment(JTextField.CENTER);

		textLabel2 = new JLabel("Rayon", SwingConstants.CENTER);
		textLabel2.setLayout(null);
		textLabel2.setFont(new Font("Arial", Font.BOLD, 20));
		textLabel2.setBounds(appInterface.windowsSizeX - 800, appInterface.windowsSizeY - 550, 300, 50);
		textLabel2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		textLabel2.setBackground(Color.LIGHT_GRAY);
		textLabel2.setOpaque(true);
		this.add(textLabel2);
		
		dropDownList = new JComboBox<String>();
		dropDownList.setBounds(appInterface.windowsSizeX - 500, appInterface.windowsSizeY - 550, 300, 50);
		dropDownList.setFont(new Font("Arial", Font.BOLD, 20));
		this.add(dropDownList);
		dropDownList = gestionRayon.RemplirListeRayon(dropDownList);

		textLabel3 = new JLabel("Prénom", SwingConstants.CENTER);
		textLabel3.setLayout(null);
		textLabel3.setFont(new Font("Arial", Font.BOLD, 20));
		textLabel3.setBounds(appInterface.windowsSizeX - 800, appInterface.windowsSizeY - 450, 300, 50);
		textLabel3.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		textLabel3.setBackground(Color.LIGHT_GRAY);
		textLabel3.setOpaque(true);
		this.add(textLabel3);

		textZone2 = new JTextField();
		textZone2.setFont(new Font("Arial", Font.BOLD, 20));
		textZone2.setLayout(null);
		textZone2.setBounds(appInterface.windowsSizeX - 500, appInterface.windowsSizeY - 450, 300, 50);
		textZone2.setHorizontalAlignment(JTextField.CENTER);
		this.add(textZone2);
		
		textLabel4 = new JLabel("Mot de Passe", SwingConstants.CENTER);
		textLabel4.setLayout(null);
		textLabel4.setFont(new Font("Arial", Font.BOLD, 20));
		textLabel4.setBounds(appInterface.windowsSizeX - 800, appInterface.windowsSizeY - 350, 300, 50);
		textLabel4.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		textLabel4.setBackground(Color.LIGHT_GRAY);
		textLabel4.setOpaque(true);
		this.add(textLabel4);

		textZone3 = new JTextField();
		textZone3.setFont(new Font("Arial", Font.BOLD, 20));
		textZone3.setLayout(null);
		textZone3.setBounds(appInterface.windowsSizeX - 500, appInterface.windowsSizeY - 350, 300, 50);
		textZone3.setHorizontalAlignment(JTextField.CENTER);
		this.add(textZone3);

		applyButton = new JButton("APPLIQUER");
		applyButton.setBounds(appInterface.windowsSizeX - 600, appInterface.windowsSizeY - 150, 175, 50);
		applyButton.setFont(new Font("Arial", Font.BOLD, 20));
		applyButton.setForeground(Color.BLACK);
		applyButton.setBackground(Color.LIGHT_GRAY);
		this.add(applyButton);
		applyButton.addActionListener(this);

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

		if (e.getSource() == applyButton) {

			if (textZone1.getText().equals("") || (textZone2.getText().equals("")) || (textZone3.getText().equals("")) || dropDownList.getSelectedItem() == null ) {
				if (textZone1.getText().equals(""))
					textZone1.setBorder(new LineBorder(Color.red, 1));
				else
					textZone1.setBorder(new LineBorder(Color.GRAY, 1));

				if (textZone2.getText().equals(""))
					textZone2.setBorder(new LineBorder(Color.red, 1));
				else
					textZone2.setBorder(new LineBorder(Color.GRAY, 1));
				
				if (textZone3.getText().equals(""))
					textZone3.setBorder(new LineBorder(Color.red, 1));
				else
					textZone3.setBorder(new LineBorder(Color.GRAY, 1));

				validateLabel.setText("Certain champs ne sont pas rempli");
				validateLabel.setForeground(Color.red.darker());
			} else
				validateLabel.setText("");

			if (!(textZone1.getText().equals("")) && (!(textZone2.getText().equals(""))) && (!(textZone3.getText().equals("")))) {
				validateLabel.setText("La scène a été ajouté");
				validateLabel.setForeground(Color.green.darker());

				if(isAdd) {
					gestionUtilisateur.ajouterChefRayon(textZone1.getText(), textZone2.getText(), textZone3.getText(), idUser, (String)dropDownList.getSelectedItem());
					validateLabel.setText("L'Utilisateur a été créé");
					validateLabel.setForeground(Color.green.darker());
				}
				else {
					gestionUtilisateur.modifierChefRayon(aModifier, textZone1.getText(), textZone2.getText(), textZone3.getText(), idUser, (String)dropDownList.getSelectedItem());
					validateLabel.setText("L'Utilisateur a été créé");
					validateLabel.setForeground(Color.green.darker());
				}
				
			}
		}

		if (e.getSource() == returnButton) {
			JPanel GestionUtilisateurPanel = new GestionUtilisateurPanel(frame, idUser, isChefMagasin);
			frame.repaint();
			frame.revalidate();
		}
	}

}
