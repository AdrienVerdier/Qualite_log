package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

import controler.Connexion;

/**
 * This class represents the frame of the Application
 * @author Pierre Savary & Adrien Verdier
 *
 */
public class appInterface extends JFrame{
	
	private static final long serialVersionUID = 9L;
	public static int windowsSizeX = 1000;
	public static int windowsSizeY = 800;

	/**
	 * This method creates the frame
	 */
	public appInterface() {
		
		try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

		this.setTitle("Ultimate Stocker 2020");
		this.setResizable(false);
		this.setSize(windowsSizeX, windowsSizeY);
		this.setLocationRelativeTo(null);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				Connexion.fermerconnexion();
				System.exit(0);
			}
		});

		JPanel authentificationPanel = new authentificationPanel(this);

		this.setVisible(true);
	}

}
