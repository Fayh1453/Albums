import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class GestionQuitter {
	
	static public void confirmerQuitter(JFrame frame) {
		
	    frame.addWindowListener(new WindowAdapter() {
	        public void windowClosing(WindowEvent we) {
	          int result = JOptionPane.showConfirmDialog(frame,
	              "Voulez-vous vraiment quitter ?", "FERMER LE PROGRAMME",
	              JOptionPane.YES_NO_OPTION);
	          if (result == JOptionPane.YES_OPTION)
	        	  System.exit(0);
	          else if (result == JOptionPane.NO_OPTION)
	            frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	        }
	      });
	}
	

}
