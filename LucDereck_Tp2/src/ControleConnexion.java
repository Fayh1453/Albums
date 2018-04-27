import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ControleConnexion {

	private static Connection laConnexion;


	private static String url = "jdbc:mysql://localhost/LucDereck_Albums";


	public static void connecter() {


		try { // Charger le pilote 

			Class.forName("org.gjt.mm.mysql.Driver");

			System.out.println("Pilote charg\u00E9");


		} catch (ClassNotFoundException cnfe) {
			System.out.println("ERREUR : Driver manquant.\n" + cnfe);
		}


		try {
			
			laConnexion = DriverManager.getConnection(url, "root", "123");
			System.out.println("Connect\u00E9 à la BD \n\n\n");
			
			
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




