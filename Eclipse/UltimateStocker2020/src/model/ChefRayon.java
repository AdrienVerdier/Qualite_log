package model;
import javax.persistence.*;

@Entity
public class ChefRayon {
	@Id
	private int IDChefRayon;
	private String Nom;
	private String prenom;
	private String MotDePasse;
	@ManyToOne(fetch = FetchType.LAZY)
	private ChefMagasin IDChefMagasin;
	@ManyToOne(fetch = FetchType.LAZY)
	private Rayon IDRayon;
	public int getIDChefRayon() {
		return IDChefRayon;
	}
	public void setIDChefRayon(int iDChefRayon) {
		IDChefRayon = iDChefRayon;
	}
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getMotDePasse() {
		return MotDePasse;
	}
	public void setMotDePasse(String motDePasse) {
		MotDePasse = motDePasse;
	}
	public ChefMagasin getIDChefMagasin() {
		return IDChefMagasin;
	}
	public void setIDChefMagasin(ChefMagasin iDChefMagasin) {
		IDChefMagasin = iDChefMagasin;
	}
	public Rayon getIDRayon() {
		return IDRayon;
	}
	public void setIDRayon(Rayon iDRayon) {
		IDRayon = iDRayon;
	}
	public ChefRayon(int iDChefRayon, String nom, String prenom, String motDePasse, ChefMagasin iDChefMagasin,
			Rayon iDRayon) {
		super();
		IDChefRayon = iDChefRayon;
		Nom = nom;
		this.prenom = prenom;
		MotDePasse = motDePasse;
		IDChefMagasin = iDChefMagasin;
		IDRayon = iDRayon;
	}

	public ChefRayon() {
		super();
	}
}
