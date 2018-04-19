
public class Albums {
	private int numero;
	private String titre;
	private double prix;
	private String genre;
	private int annee;
	private String maison;
	private String image;
	private int numeroArtiste;
	
	
	public Albums(int numero, String titre, double prix, String genre, int annee, String maison, String image,
			int numeroArtiste) {
		super();
		this.numero = numero;
		this.titre = titre;
		this.prix = prix;
		this.genre = genre;
		this.annee = annee;
		this.maison = maison;
		this.image = image;
		this.numeroArtiste = numeroArtiste;
	}


	public int getNumero() {
		return numero;
	}


	public void setNumero(int numero) {
		this.numero = numero;
	}


	public String getTitre() {
		return titre;
	}


	public void setTitre(String titre) {
		this.titre = titre;
	}


	public double getPrix() {
		return prix;
	}


	public void setPrix(double prix) {
		this.prix = prix;
	}


	public String getGenre() {
		return genre;
	}


	public void setGenre(String genre) {
		this.genre = genre;
	}


	public int getAnnee() {
		return annee;
	}


	public void setAnnee(int annee) {
		this.annee = annee;
	}


	public String getMaison() {
		return maison;
	}


	public void setMaison(String maison) {
		this.maison = maison;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public int getNumeroArtiste() {
		return numeroArtiste;
	}


	public void setNumeroArtiste(int numeroArtiste) {
		this.numeroArtiste = numeroArtiste;
	}
	
	
	
	
}
