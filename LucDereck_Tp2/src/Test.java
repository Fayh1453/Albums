import java.awt.Dimension;

public class Test {

	public static void main(String[] args) {
		ControleConnexion.connecter();
		artistesFrame artistes = new artistesFrame();
		
		artistes.setLocationRelativeTo(null);
		artistes.setVisible(true);
		artistes.setResizable(false);


	}

}
