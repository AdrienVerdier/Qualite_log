package controler;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JComboBox;

import model.Rayon;
import model.ChefMagasin;
import model.ChefRayon;

public class gestionRayon {
	
	public static void ajouterRayon(String nom, int IDChefMagasin) {		
		ChefMagasin chefMagasin = ChefMagasinDAO.rechercheChefMagasinById(IDChefMagasin);
		Rayon rayon = new Rayon(RayonDAO.returnMaxIDRayon(), nom, null, null, chefMagasin);
		ChefMagasinDAO.ajouterChefMagasinRayon(chefMagasin, rayon);
		RayonDAO.ajouterRayon(rayon);
	}
	
	public static void modifierRayon(int idRayon, String nouveauNom) {
		Rayon rayon = RayonDAO.rechercheRayonById(idRayon);
		rayon.setNom(nouveauNom);
		RayonDAO.modifierRayon(idRayon, rayon);
	}
	
	public static int nombreRayon(int IDChefRayon, boolean isChefMagasin) {
		if(isChefMagasin) {
			return getRayon().size();
		}
		else {
			return getRayon(IDChefRayon).size();
		}
	}
	
	public static void supprimerRayon(int codeRayon) {
		RayonDAO.supprimerRayon(RayonDAO.rechercheRayonById(codeRayon));
	}
	
	public static ArrayList<Rayon> getRayon(){
		return RayonDAO.returnAllRayon();			
	}
	
	public static ArrayList<Rayon> getRayon(int IDChefRayon){
		Iterator<Rayon> iter = RayonDAO.returnAllRayon().iterator();
		ArrayList<Rayon> retour = new ArrayList<Rayon>();
		
		while(iter.hasNext()) {
			Rayon rayon = iter.next();
			
			if(rayon.getListChefRayon().contains(ChefRayonDAO.rechercheChefRayonById(IDChefRayon))) {
				retour.add(rayon);
			}
		}
		
		return retour;
	}
	
	public static JComboBox<String> RemplirListeRayon (JComboBox<String> dropDownList){
		Iterator<Rayon> rayon = RayonDAO.returnAllRayon().iterator();
		Rayon tmp;
		
		while(rayon.hasNext()){
			tmp = rayon.next();
			
			dropDownList.addItem(tmp.getNom());
		}
		
		return dropDownList;
	}

}
