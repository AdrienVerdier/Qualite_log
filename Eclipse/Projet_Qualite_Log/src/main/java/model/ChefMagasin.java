package model;

import java.util.List;

import javax.persistence.*;

@Entity
public class ChefMagasin {
	@Id
	private int IDChefMagasin;
	private String Nom;
	private String prenom;
	private String MotDePasse;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "IDChefMagasin")
	private List<ChefRayon> listChefRayon;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "IDChefMagasin")
	private List<Rayon> listRayon;

	public int getIDChefMagasin() {
		return IDChefMagasin;
	}

	public void setIDChefMagasin(int iDChefMagasin) {
		IDChefMagasin = iDChefMagasin;
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

	public List<ChefRayon> getListChefRayon() {
		return listChefRayon;
	}

	public void setListChefRayon(List<ChefRayon> listChefRayon) {
		this.listChefRayon = listChefRayon;
	}

	public List<Rayon> getListRayon() {
		return listRayon;
	}

	public void setListRayon(List<Rayon> listRayon) {
		this.listRayon = listRayon;
	}

	public ChefMagasin(int iDChefMagasin, String nom, String prenom, String motDePasse, List<ChefRayon> listChefRayon,
			List<Rayon> listRayon) {
		super();
		IDChefMagasin = iDChefMagasin;
		Nom = nom;
		this.prenom = prenom;
		MotDePasse = motDePasse;
		this.listChefRayon = listChefRayon;
		this.listRayon = listRayon;
	}

	public ChefMagasin() {
		super();
	}
}
