import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;

public class GestionArtiste {
	
	private Connection connexion = (Connection) ControleConnexion.getLaConnexion();
	
	private ArrayList<Artistes> listeArtistes;
	

	public GestionArtiste() {
		listeArtistes = obtenirListeArtistes();
	}
	
	public ArrayList<Artistes> getListeArtistes() {
		return listeArtistes;
	}
	
	private ArrayList<Artistes> obtenirListeArtistes(){
		
		ArrayList<Artistes> liste = new ArrayList<>();
		
		String requete = "Select * from Artistes";
		
		try(Statement statement = connexion.createStatement();
				ResultSet jeuResultat= statement.executeQuery(requete)){
			
			while (jeuResultat.next()) {				
					String numero = jeuResultat.getString("numero");
					String nom = jeuResultat.getString("nom");
					String membre = jeuResultat.getString("Membre");
					String photo = jeuResultat.getString("photo");
					
					liste.add(new Artistes(Integer.parseInt(numero), nom, (membre.equals("1")), photo));	
			}
			
			
			for(Artistes art : liste) {
				System.out.println( art.getNumero()+ "   "+ art.getNom()  + " " +art.getMembre() + " " + art.getPhoto());	
			}
			
		}catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Problème rencontrr\u00E8 : " + sqle.getMessage() ,"Résultat", JOptionPane.ERROR_MESSAGE);
		}

		return liste;
	}
	
	


}
