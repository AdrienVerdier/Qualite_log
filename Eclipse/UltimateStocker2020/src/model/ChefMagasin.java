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
	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "IDChefMagasin")
	private List<ChefRayon> listChefRayon;
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
	public ChefMagasin(int iDChefMagasin, String nom, String prenom, String motDePasse, List<ChefRayon> listChefRayon) {
		super();
		IDChefMagasin = iDChefMagasin;
		Nom = nom;
		this.prenom = prenom;
		MotDePasse = motDePasse;
		this.listChefRayon = listChefRayon;
	}
	
	
}
