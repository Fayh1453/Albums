import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Locale;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;

public class GestionAlbums {
	
	private Connection connexion = (Connection) ControleConnexion.getLaConnexion();
	
	private ArrayList<Albums> listeAlbums;
	

	public GestionAlbums() {
		listeAlbums = obtenirListeAlbums();
	}

	public ArrayList<Albums> getListeAlbums() {
		return listeAlbums;
	}
	
	
	private ArrayList<Albums> obtenirListeAlbums() {
		ArrayList<Albums> liste = new ArrayList<>();
		
		String requete = "Select * from Album";
		
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
					
					liste.add(new Albums(Integer.parseInt(numero), titre, Double.parseDouble(prix),
							genre,Integer.parseInt(annee),maison,image,Integer.parseInt(numeroArtiste)));
					
					
						
			}
		
		}catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Problème rencontr\u00E9 : " + sqle.getMessage() ,"Résultat", JOptionPane.ERROR_MESSAGE);
		}

		return liste;

	}
	
	public boolean ajouterAlbumsBD(Albums album) {
		boolean boolAjout = false;
		
		String requete = "INSERT INTO Album(titre, prix, genre,annee,maison,image,numeroArtiste) VALUES ('"
				+ album.getTitre() + "','" 
				+ album.getPrix() + "','" 
				+ album.getGenre() + "','"
				+ album.getAnnee() + "','"
				+ album.getMaison() + "','"
				+ album.getImage() + "','"
				+ album.getNumeroArtiste() + "')"; 
		
		try {
			
			Statement statement = connexion.createStatement();
			statement.executeUpdate(requete);
			listeAlbums.add(album);
			boolAjout = true;
			
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Problème rencontr\u00E9 lors de l'enregistrement de l'album: " + sqle.getMessage() ,"Résultat", JOptionPane.ERROR_MESSAGE);
		}

		
		return boolAjout;	
	}
	
	public boolean supprimerAlbumBD(Albums album) {
		boolean boolSupp = false;

		String requete = "DELETE FROM Album WHERE numero=" + album.getNumero(); 
		
		try {
			
			Statement statement = connexion.createStatement();
			statement.executeUpdate(requete);
			listeAlbums.remove(album);
			boolSupp = true;
			
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Problème rencontr\u00E9 lors de la suppression de l'album: " + sqle.getMessage() ,"Résultat", JOptionPane.ERROR_MESSAGE);
		}

		
		return boolSupp;	
	}
	
	public boolean modifierAlbumsBD(Albums album) {
		boolean boolModif = false;
		
				
		String requete = "UPDATE Album SET titre='" + album.getTitre() 
						+ "',prix=" + String.format (Locale.US,"%.2f", album.getPrix()) 
						+ ",genre='" + album.getGenre()
						+ "',annee=" + String.valueOf(album.getAnnee())
						+ ",maison='" + album.getMaison()
						+ "',image='" + album.getImage()
						+ "',numeroArtiste=" + String.valueOf(album.getNumeroArtiste())
						+" WHERE numero=" + album.getNumero();
		
		try {
			
			Statement statement = connexion.createStatement();
			statement.executeUpdate(requete);
			listeAlbums = obtenirListeAlbums();
			boolModif = true;
			
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Problème rencontr\u00E9 lors de la modification de l'album: " + sqle.getMessage() ,"Résultat", JOptionPane.ERROR_MESSAGE);
		}

		
		return boolModif;	
	}
	
	public String getNomArtiste(int numArtiste) {
		

		String requete = "SELECT * FROM Artistes WHERE numero = " + numArtiste;
		String nom = "";
		
		try(Statement statement = connexion.createStatement();
				ResultSet jeuResultat= statement.executeQuery(requete)){
			
			while (jeuResultat.next()) {				
				nom = jeuResultat.getString("nom");						 
		}
			
			
		}catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Problème rencontr\u00E9: " + sqle.getMessage() ,"Résultat", JOptionPane.ERROR_MESSAGE);
		}
	
		return nom;
		
	}
	public ArrayList<Albums> rechercherAlbumsBD(String numRec, String titreRec, String artRec) {
		
		ArrayList<Albums> liste = new ArrayList<>();

		String requete = "SELECT * FROM Album WHERE numero LIKE '%"+numRec+"%' AND titre LIKE '%"+ titreRec+"%' and numeroArtiste LIKE '%"+artRec+"%'"; 
		
		
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
					
					liste.add(new Albums(Integer.parseInt(numero), titre, Double.parseDouble(prix),
							genre,Integer.parseInt(annee),maison,image,Integer.parseInt(numeroArtiste)));
						
			}
			
			
		}catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Problème rencontr\u00E9 : " + sqle.getMessage() ,"Résultat", JOptionPane.ERROR_MESSAGE);
		}

		return liste;
	
	}
	
	
	
}
