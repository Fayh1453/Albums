


import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class GestionFichier{

	private static JFileChooser chooser = new JFileChooser();

	private GestionFichier() {
		// TODO Auto-generated constructor stub
	}



	@SuppressWarnings("unchecked")
	public static String Ouvrir(JFrame panneau) {

		chooser.setCurrentDirectory(new File(System.getProperty("user.dir") + System.getProperty("file.separator") + 
								"src" + System.getProperty("file.separator") + "Images"));
		chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		
		String chemin = "";

		int returnVal2 = chooser.showOpenDialog(panneau.getParent());
		if (returnVal2 == JFileChooser.APPROVE_OPTION) {

			try {

				chemin = chooser.getSelectedFile().getName();


			} catch (NullPointerException e1) {
				JOptionPane.showMessageDialog(panneau, "ERREUR DU FICHIER");
			}
		}
		return chemin;
	}

}
