public class Artistes {
	private int numero;
	private String nom;
	private boolean membre;
	private String photo;
	
	
	public Artistes(int numero, String nom, boolean membre, String photo) {
		super();
		this.numero = numero;
		this.nom = nom;
		this.membre = membre;
		this.photo = photo;
	}


	public int getNumero() {
		return numero;
	}


	public void setNumero(int numero) {
		this.numero = numero;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public boolean getMembre() {
		return membre;
	}


	public void setMembre(boolean membre) {
		this.membre = membre;
	}


	public String getPhoto() {
		return photo;
	}


	public void setPhoto(String photo) {
		this.photo = photo;
	}
	

	
	
	

}
