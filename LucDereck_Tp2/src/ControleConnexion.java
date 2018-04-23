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
			System.out.println("Connect\u00E9 à la BD \n\n\n");
			
		
			GestionArtiste gestionArtistes = new GestionArtiste();
			
			Artistes art = new Artistes(6,"d",true,"tessdfdfsduc.jpg");
			gestionArtistes.supprimerArtistesBD(art);
			
			
			System.out.println("\n\n");
			
			
			GestionAlbums gestionAlbums = new GestionAlbums();
			
			Albums alb = new Albums(8,"test",1333.44,"WEE",1992,"YJJ","test.pgn",3);
			gestionAlbums.modifierAlbumsBD(alb);
		


			
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




