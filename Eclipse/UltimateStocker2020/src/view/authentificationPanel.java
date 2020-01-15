package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

/**
 * This class is the interface of the authentification Panel
 * 
 * @author Pierre Savary & Adrien Verdier
 */
public class authentificationPanel extends JPanel implements ActionListener{
	
	private static final long serialVersionUID = 7L;
	private JButton connexion;
	private JFrame frame;
	private JLabel textLabel1, textLabel2, titre, validateLabel;
	private JTextField textZone1;
	private JPasswordField textZone2;
	private boolean isChefMagasin;
	private int idUser;
	
	/**
	 * This method creates the panel
	 * 
	 * @param frame the frame of the interface
	 */
	public authentificationPanel(JFrame frame) {
		this.frame = frame;
		
		this.setLayout(null);
		this.frame.setContentPane(this);
		
		titre = new JLabel("Ultimate Stocker 2020 - Page d'authentification");
		titre.setLayout(null);
		titre.setFont(new Font("Arial", Font.BOLD, 20));
		titre.setBounds(25, 0, 250, 40);
		this.add(titre);
		
		validateLabel = new JLabel();
		validateLabel.setLayout(null);
		validateLabel.setForeground(Color.green.darker());
		validateLabel.setFont(new Font("Arial", Font.BOLD, 20));
		validateLabel.setBounds(appInterface.windowsSizeX - 650, appInterface.windowsSizeY - 200, 500, 40);
		this.add(validateLabel);
		
		connexion = new JButton("Connexion");
		connexion.setBounds(appInterface.windowsSizeX /2, appInterface.windowsSizeY / 2, 350, 80);
		connexion.setFont(new Font("Arial", Font.BOLD, 20));
		connexion.setForeground(Color.BLACK);
		connexion.setBackground(Color.LIGHT_GRAY);
		this.add(connexion);
		connexion.addActionListener(this);
		
		textLabel1 = new JLabel("ID Utilisateur", SwingConstants.CENTER);
		textLabel1.setLayout(null);
		textLabel1.setFont(new Font("Arial", Font.BOLD, 20));
		textLabel1.setBounds(appInterface.windowsSizeX - 850, appInterface.windowsSizeY - 700, 350, 50);
		textLabel1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		textLabel1.setBackground(Color.LIGHT_GRAY);
		textLabel1.setOpaque(true);
		this.add(textLabel1);

		textZone1 = new JTextField();
		textZone1.setFont(new Font("Arial", Font.BOLD, 20));
		textZone1.setLayout(null);
		textZone1.setBounds(appInterface.windowsSizeX - 500, appInterface.windowsSizeY - 700, 300, 50);
		this.add(textZone1);
		textZone1.setHorizontalAlignment(JTextField.CENTER);
		textZone1.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent arg0) {
				if (textZone1.getText().equals("Ex : 000")) {
					textZone1.setText("");
					textZone1.setFont(new Font("Arial", Font.BOLD, 20));
				}
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				if (textZone1.getText().isEmpty()) {
					textZone1.setText("Ex : 000");
					textZone1.setFont(new Font("Arial", Font.PLAIN, 18));
				}
			}
		});

		textLabel2 = new JLabel("Mot de passe", SwingConstants.CENTER);
		textLabel2.setLayout(null);
		textLabel2.setFont(new Font("Arial", Font.BOLD, 20));
		textLabel2.setBounds(appInterface.windowsSizeX - 850, appInterface.windowsSizeY - 600, 350, 50);
		textLabel2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		textLabel2.setBackground(Color.LIGHT_GRAY);
		textLabel2.setOpaque(true);
		this.add(textLabel2);

		textZone2 = new JPasswordField();
		textZone2.setFont(new Font("Arial", Font.BOLD, 20));
		textZone2.setLayout(null);
		textZone2.setBounds(appInterface.windowsSizeX - 500, appInterface.windowsSizeY - 600, 300, 50);
		textZone2.setHorizontalAlignment(JTextField.CENTER);
		this.add(textZone2);
		textZone2.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent arg0) {
				if (textZone2.getText().equals("Ex : password")) {
					textZone2.setText("");
					textZone2.setFont(new Font("Arial", Font.BOLD, 20));
				}
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				if (String.copyValueOf(textZone2.getPassword()).isEmpty()) {
					textZone2.setText("Ex : password");
					textZone2.setFont(new Font("Arial", Font.PLAIN, 18));
				}
			}
		});
	
	}
	
	/**
	* This method gathers the different action of the panel
	* 
	* @param e The action that is performed
	*/
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == connexion) {			
			
			// Oublie de saisie dans un des champs
			if (textZone1.getText().equals("Ex : 000") || textZone2.getText().equals("Ex : password")) {
				if (textZone1.getText().equals("Ex : 000"))
					textZone1.setBorder(new LineBorder(Color.red, 1));
				else
					textZone1.setBorder(new LineBorder(Color.GRAY, 1));

				if (textZone2.getText().equals("Ex : password"))
					textZone2.setBorder(new LineBorder(Color.red, 1));
				else
					textZone2.setBorder(new LineBorder(Color.GRAY, 1));

				validateLabel.setText("Information non rempli ou utilisation du mot de passe : \" password \" ");
				validateLabel.setForeground(Color.red.darker());
			} else {

				textZone1.setBorder(new LineBorder(Color.GRAY, 1));
				textZone2.setBorder(new LineBorder(Color.GRAY, 1));

				// Authentification de l'utilisateur 
				Object retour[] = authentification.verify(textZone1.getText(), String.copyValueOf(textZone2.getPassword()));
				isChefMagasin = (boolean)retour[0];
				idUser = (int)retour[1];
				
				if(idUser != -1) {
					JPanel AffichageRayon = new AffichageRayon(frame, isChefMagasin, idUser);
					frame.repaint();
					frame.revalidate();
				}
				else {
					validateLabel.setText(" Vous n'êtes pas enregistré dans la base de données ");
					validateLabel.setForeground(Color.red.darker());
				}
			}
				
		}	
	}

}
