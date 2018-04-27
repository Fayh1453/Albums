
public class Test {

	public static void main(String[] args) {

		Identification identification = new Identification();
		
		GestionQuitter.confirmerQuitter(identification);
		identification.setLocationRelativeTo(null);
		identification.setVisible(true);
		identification.setResizable(false);
	}

}
