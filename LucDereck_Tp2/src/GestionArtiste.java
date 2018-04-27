
import java.sql.*;
import java.util.ArrayList;
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
			JOptionPane.showMessageDialog(null, "Problème rencontr\u00E9 : " + sqle.getMessage() ,"Résultat", JOptionPane.ERROR_MESSAGE);
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
					art = artiste;
				}
			}

			listeArtistes = obtenirListeArtistes();
			
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
			JOptionPane.showMessageDialog(null, "Problème rencontr\u00E9 : " + sqle.getMessage() ,"Résultat", JOptionPane.ERROR_MESSAGE);
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
			JOptionPane.showMessageDialog(null, "Problème rencontr\u00E9 : " + sqle.getMessage() ,"Résultat", JOptionPane.ERROR_MESSAGE);
		}

		return liste;
	
	}
	
	public boolean confirmerAjout(ArtistesFrame frame) {
		boolean changement = false;
		
		try {
			int numero = Integer.parseInt(frame.getTextField().getText());
			
			String nom = frame.getTextField_1().getText();
			
			boolean membre = false;
			
			if ( frame.getCheckBox().isSelected()) {
				membre = true;
			}
			
			String iconfilename = frame.getLblImageAlbum().getIcon().toString();
			String fileName = iconfilename.substring(iconfilename.lastIndexOf("/"  ) + 1);
			
			Artistes artiste = new Artistes(numero,nom,membre,fileName);
			
			ajouterArtistesBD(artiste);
			frame.setArtistesTable(getListeArtistes());
			
			changement = true;
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Problème rencontr\u00E9 lors de l'ajout d'un artiste:"
					+ " Assurez vous de bien remplir les informations et l'image "  ,"Ajouté un artiste", JOptionPane.ERROR_MESSAGE);
		}
		
		return changement;
	}
	
	
	public boolean confirmerModif(ArtistesFrame frame) {
		boolean changement = false;
		String fileName;
		
		try {
		int numero = Integer.parseInt(frame.getTextField().getText());
		
		String nom = frame.getTextField_1().getText();
		
		boolean membre = false;
		
		if ( frame.getCheckBox().isSelected()) {
			membre = true;
		}
		
		String iconfilename = frame.getLblImageAlbum().getIcon().toString();
		fileName = iconfilename.substring(iconfilename.lastIndexOf("/"  ) + 1);
		
		
			Artistes artiste = new Artistes(numero,nom,membre,fileName);
			
			modifierArtistesBD(artiste);
			frame.setArtistesTable(getListeArtistes());
			
			changement = true;
		} catch (Exception e) {
			fileName = "";
			JOptionPane.showMessageDialog(null, "Problème rencontr\u00E9 lors de la modification d'un artiste : Assurez vous de bien remplir les informations et l'image" ,"Ajouté un artiste", JOptionPane.ERROR_MESSAGE);
		}


		return changement;
	}


}
