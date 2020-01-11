package model;

import java.util.List;

import javax.persistence.*;

@Entity
public class Rayon {
	@Id
	private int IDRayon;
	private String Nom;
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "IDRayon")
	private List<ChefRayon> listChefRayon;
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "IDRayon")
	private List<Produit> listProduit;
	@ManyToOne(fetch = FetchType.LAZY)
	private ChefMagasin IDChefMagasin;

	public int getIDRayon() {
		return IDRayon;
	}

	public void setIDRayon(int iDRayon) {
		IDRayon = iDRayon;
	}

	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		Nom = nom;
	}

	public List<ChefRayon> getListChefRayon() {
		return listChefRayon;
	}

	public void setListChefRayon(List<ChefRayon> listChefRayon) {
		this.listChefRayon = listChefRayon;
	}

	public List<Produit> getListProduit() {
		return listProduit;
	}

	public void setListProduit(List<Produit> listProduit) {
		this.listProduit = listProduit;
	}

	public ChefMagasin getIDChefMagasin() {
		return IDChefMagasin;
	}

	public void setIDChefMagasin(ChefMagasin iDChefMagasin) {
		IDChefMagasin = iDChefMagasin;
	}

	public Rayon(int iDRayon, String nom, List<ChefRayon> listChefRayon, List<Produit> listProduit,
			ChefMagasin iDChefMagasin) {
		super();
		IDRayon = iDRayon;
		Nom = nom;
		this.listChefRayon = listChefRayon;
		this.listProduit = listProduit;
		IDChefMagasin = iDChefMagasin;
	}

	public Rayon() {
		super();
	}

}
