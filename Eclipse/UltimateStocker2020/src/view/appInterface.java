package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

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

		this.setTitle("Application de gestion de fichier");
		this.setResizable(false);
		this.setSize(windowsSizeX, windowsSizeY);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel authentificationPanel = new authentificationPanel(this);

		this.setVisible(true);
	}

}
