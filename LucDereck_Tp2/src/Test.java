import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Images.GestionQuitter;

public class Test {

	public static void main(String[] args) {

		Identification identification = new Identification();
		
		GestionQuitter.confirmerQuitter(identification);
		identification.setLocationRelativeTo(null);
		identification.setVisible(true);
		identification.setResizable(false);
	}

}
