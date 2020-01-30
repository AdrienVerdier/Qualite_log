package model;
import javax.persistence.*;

@Entity
public class Produit {
	@Id
	private int IDProduit;
	private int Prix;
	private int Quantite;
	private String Description;
	@ManyToOne(fetch = FetchType.LAZY)
	private Rayon IDRayon;
	public int getIDProduit() {
		return IDProduit;
	}
	public void setIDProduit(int iDProduit) {
		IDProduit = iDProduit;
	}
	public int getPrix() {
		return Prix;
	}
	public void setPrix(int prix) {
		Prix = prix;
	}
	public int getQuantite() {
		return Quantite;
	}
	public void setQuantite(int quantite) {
		Quantite = quantite;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public Rayon getIDRayon() {
		return IDRayon;
	}
	public void setIDRayon(Rayon iDRayon) {
		IDRayon = iDRayon;
	}
	public Produit(int iDProduit, int prix, int quantite, String description, Rayon iDRayon) {
		super();
		IDProduit = iDProduit;
		Prix = prix;
		Quantite = quantite;
		Description = description;
		IDRayon = iDRayon;
	}

	public Produit() {
		super();
	}
}
