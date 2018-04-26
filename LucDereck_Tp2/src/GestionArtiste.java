import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.DefaultListModel;
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
			
			
		}catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Problème rencontrr\u00E9 : " + sqle.getMessage() ,"Résultat", JOptionPane.ERROR_MESSAGE);
		}

		return liste;
	}
	
	public boolean ajouterArtistesBD(Artistes artiste) {
		boolean boolAjout = false;
		int intMembre=0;
		
		if (artiste.getMembre()) {
			intMembre=1;
		}
		
		String requete = "INSERT INTO Artistes(numero, nom, Membre, photo) VALUES ('"
				+ artiste.getNumero() + "','" 
				+ artiste.getNom() + "','" 
				+ intMembre + "','"
				+ artiste.getPhoto() + "')"; 
		
		try {
			
			Statement statement = connexion.createStatement();
			statement.executeUpdate(requete);
			listeArtistes.add(artiste);
			boolAjout = true;
			
			
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Problème rencontr\u00E9 lors de l'enregistrement de l'artiste: " + sqle.getMessage() ,"Résultat", JOptionPane.ERROR_MESSAGE);
		}
		
		

		
		return boolAjout;	
	}
	
	public boolean supprimerArtistesBD(Artistes artiste) {
		boolean boolSupp = false;

		String requete = "DELETE FROM `Artistes` WHERE numero=" + artiste.getNumero(); 
		
		try {
			
			Statement statement = connexion.createStatement();
			statement.executeUpdate(requete);
			listeArtistes.remove(artiste);
			boolSupp = true;
			
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Problème rencontr\u00E9 lors de la suppression de l'artiste: " + sqle.getMessage() ,"Résultat", JOptionPane.ERROR_MESSAGE);
		}

		
		return boolSupp;	
	}
	
	public boolean modifierArtistesBD(Artistes artiste) {
		boolean boolModif = false;
		
		int intMembre=0;
		
		if (artiste.getMembre()) {
			intMembre=1;
		}
				
		String requete = "UPDATE Artistes SET nom='" + artiste.getNom() 
						+ "',Membre=" + intMembre 
						+ ",photo='" + artiste.getPhoto()
						+"' WHERE numero=" + artiste.getNumero();
		
		try {
			
			Statement statement = connexion.createStatement();
			statement.executeUpdate(requete);
			
			for ( Artistes art : listeArtistes) {
				if ( art.getNumero() == artiste.getNumero()) {
					
					System.out.println(art.getNom() + " " + artiste.getNom());
					art = artiste;
					System.out.println(art.getNom());
				}
			}
			
			listeArtistes = obtenirListeArtistes();
			///////
			boolModif = true;
			
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Problème rencontr\u00E9 lors de la modification de l'artiste: " + sqle.getMessage() ,"Résultat", JOptionPane.ERROR_MESSAGE);
		}

		
		return boolModif;	
	}
	
	public DefaultListModel<Albums> getListeAlbum(int numArtiste) {
		
		DefaultListModel<Albums> liste = new DefaultListModel<>();

		String requete = "SELECT * FROM Album WHERE numeroArtiste = " + numArtiste;
		
		try(Statement statement = connexion.createStatement();
				ResultSet jeuResultat= statement.executeQuery(requete)){
			
			while (jeuResultat.next()) {				
				String numero = jeuResultat.getString("numero");
				String titre = jeuResultat.getString("titre");
				String prix = jeuResultat.getString("prix");
				String genre = jeuResultat.getString("genre");
				String annee = jeuResultat.getString("annee");
				String maison = jeuResultat.getString("maison");
				String image = jeuResultat.getString("image");
				String numeroArtiste = jeuResultat.getString("numeroArtiste");
				
				liste.addElement(new Albums(Integer.parseInt(numero), titre, Double.parseDouble(prix),
						genre,Integer.parseInt(annee),maison,image,Integer.parseInt(numeroArtiste)));
				
					 
		}
			
			
		}catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Problème rencontrr\u00E9 : " + sqle.getMessage() ,"Résultat", JOptionPane.ERROR_MESSAGE);
		}
	
		return liste;
		
	}
	
	public ArrayList<Artistes> rechercherArtistesBD(String numRec, String nomRec) {
		
		ArrayList<Artistes> liste = new ArrayList<>();

		String requete = "SELECT * FROM Artistes WHERE numero LIKE '%"+numRec+"%' AND nom LIKE '%"+ nomRec+"%'"; 
		
		
		try(Statement statement = connexion.createStatement();
				ResultSet jeuResultat= statement.executeQuery(requete)){
			
			while (jeuResultat.next()) {				
					String numero = jeuResultat.getString("numero");
					String nom = jeuResultat.getString("nom");
					String membre = jeuResultat.getString("Membre");
					String photo = jeuResultat.getString("photo");
					
					liste.add(new Artistes(Integer.parseInt(numero), nom, (membre.equals("1")), photo));	
			}
			
			
		}catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Problème rencontrr\u00E9 : " + sqle.getMessage() ,"Résultat", JOptionPane.ERROR_MESSAGE);
		}

		return liste;
	
	}


}
