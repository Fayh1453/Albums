import java.awt.Dimension;

public class Test {

	public static void main(String[] args) {
		ControleConnexion.connecter();
		Identification identification = new Identification();
		
		identification.setLocationRelativeTo(null);
		identification.setVisible(true);
		identification.setResizable(false);


	}

}
