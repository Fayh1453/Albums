import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ControleConnexion {

	private static Connection laConnexion;


	private static String url = "jdbc:mysql://localhost/LucDereck_Albums";
	
	public static void main(String[] args) {
		connecter();
	}

	public static void connecter() {


		try { // Charger le pilote 

			Class.forName("org.gjt.mm.mysql.Driver");

			System.out.println("Pilote charg\u00E9");


		} catch (ClassNotFoundException cnfe) {
			System.out.println("ERREUR : Driver manquant.\n" + cnfe);
		}



		Statement statement = null;
		ResultSet jeuResultats = null;

		PreparedStatement declarationParametree = null;

		try {
			
			laConnexion = DriverManager.getConnection(url,"root","123");
			System.out.println("Connecté à la BD \n\n\n");
			
			GestionArtiste gestionArtistes = new GestionArtiste();
		
			/*Artistes art = new Artistes(6,"d",true,"tessdfdfsduc.jpg");
			gestionArtistes.modifierArtistesBD(art);*/

			
		} catch (SQLException sqle) {
			System.out.println("ERREUR: " + sqle);
		}
	}
	
	public static Connection getLaConnexion() {
		return laConnexion;
	}

	public static void setLaConnexion(Connection laConnexion) {
		ControleConnexion.laConnexion = laConnexion;
	}
}




