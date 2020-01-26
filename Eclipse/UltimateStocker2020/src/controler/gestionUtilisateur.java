package controler;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;

import model.ChefMagasin;
import model.ChefRayon;
import model.Rayon;

public class gestionUtilisateur {

	public static void ajouterChefRayon(String nom, String prenom, String motDePasse, int IDChefMagasin, String nomRayon) {		
		Iterator<Rayon> iter = RayonDAO.returnAllRayon().iterator();
		Rayon tmp;
		Rayon rayon = new Rayon();
		while(iter.hasNext()) {
			tmp = iter.next();
			if(tmp.getNom() == nomRayon) {
				rayon = tmp;
			}
		}
		ChefMagasin chefMagasin = ChefMagasinDAO.rechercheChefMagasinById(IDChefMagasin);
		ChefRayon chefRayon = new ChefRayon(ChefRayonDAO.returnMaxIDChefRayon(), nom, prenom, motDePasse, chefMagasin, rayon);
		RayonDAO.ajouterRayonChefRayon(rayon, chefRayon);
		ChefRayonDAO.ajouterChefRayon(chefRayon);
	}
	
	public static void modifierChefRayon(int idChefRayon, String nom, String prenom, String motDePasse, int IDChefMagasin, String nomRayon) {
		Iterator<Rayon> iter = RayonDAO.returnAllRayon().iterator();
		Rayon tmp;
		Rayon rayon = new Rayon();
		while(iter.hasNext()) {
			tmp = iter.next();
			if(tmp.getNom() == nomRayon) {
				rayon = tmp;
			}
		}
		ChefRayon chefRayon = ChefRayonDAO.rechercheChefRayonById(idChefRayon);
		chefRayon.setIDChefMagasin(ChefMagasinDAO.rechercheChefMagasinById(IDChefMagasin));
		chefRayon.setIDRayon(rayon);
		chefRayon.setMotDePasse(motDePasse);
		chefRayon.setNom(nom);
		chefRayon.setPrenom(prenom);
		ChefRayonDAO.modifierChefRayon(idChefRayon, chefRayon);
	}
	
	public static int nombreChefRayon() {
		return getChefRayon().size();
	}
	
	public static void supprimerChefRayon(int IDChefRayon) {
		ChefRayonDAO.supprimerChefRayon(ChefRayonDAO.rechercheChefRayonById(IDChefRayon));
	}
	
	public static ArrayList<ChefRayon> getChefRayon(){
		return ChefRayonDAO.returnAllChefRayon();			
	}
	
	public static void changerMDP (int IDChefRayon, boolean isChefMagasin, String motDePasse) {
		if(isChefMagasin) {
			ChefMagasin chefMagasin = ChefMagasinDAO.rechercheChefMagasinById(IDChefRayon);
			chefMagasin.setMotDePasse(motDePasse);
			ChefMagasinDAO.modifierChefMagasin(IDChefRayon, chefMagasin);
		}
		else {
			ChefRayon chefRayon = ChefRayonDAO.rechercheChefRayonById(IDChefRayon);
			chefRayon.setMotDePasse(motDePasse);
			ChefRayonDAO.modifierChefRayon(IDChefRayon, chefRayon);
		}
	}
	
	public static int authentification (int idUser, String password, boolean isChefMagasin) {
		if(isChefMagasin) {
			ChefMagasin chefMagasin = ChefMagasinDAO.rechercheChefMagasinById(idUser);
			if(password.equals(chefMagasin.getMotDePasse())) {
				return idUser;
			}
		}
		else {
			ChefRayon chefRayon = ChefRayonDAO.rechercheChefRayonById(idUser);
			if(password.equals(chefRayon.getMotDePasse())) {
				return idUser;
			}
		}
		
		return -1;
	}
	
	public static int getRayonChefRayon(int idUser) {
		ChefRayon chefRayon = ChefRayonDAO.rechercheChefRayonById(idUser);
		return chefRayon.getIDRayon().getIDRayon();
	}
	
}
