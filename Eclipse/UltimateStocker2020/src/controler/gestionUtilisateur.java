package controler;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;

import model.ChefMagasin;
import model.ChefRayon;
import model.Rayon;

public class gestionUtilisateur {

	public static void ajouterChefRayon(String nom, String prenom, String motDePasse, int IDChefMagasin, int IDRayon) {		
		ChefMagasin chefMagasin = ChefMagasinDAO.rechercheChefMagasinById(IDChefMagasin);
		Rayon rayon = RayonDAO.rechercheRayonById(IDRayon);
		ChefRayon chefRayon = new ChefRayon(ChefRayonDAO.returnMaxIDChefRayon(), nom, prenom, motDePasse, chefMagasin, rayon);
		RayonDAO.ajouterRayonChefRayon(rayon, chefRayon);
		ChefRayonDAO.ajouterChefRayon(chefRayon);
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
	
}
