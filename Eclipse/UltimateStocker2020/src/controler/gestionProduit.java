package controler;

import java.util.ArrayList;
import java.util.Iterator;

import model.Rayon;
import model.Produit;

public class gestionProduit {
	
	public static boolean ajouterProduit(String description, int prix, int quantite, int codeRayon) {
		if(RayonDAO.rechercheRayonById(codeRayon) != null) {
			Rayon rayon = RayonDAO.rechercheRayonById(codeRayon);
			Produit produit = new Produit(ProduitDAO.returnMaxIDProduit(), prix, quantite, description, rayon);		
			RayonDAO.ajouterRayonProduit(rayon, produit);
			ProduitDAO.ajouterProduit(produit);
		}
		
		return true;
	}
	
	public static int nombreProduit(int codeRayon) {
		return getProduit(codeRayon).size();
	}
	
	public static void supprimerProduit(int codeRayon) {
		ProduitDAO.supprimerProduit(ProduitDAO.rechercheProduitById(codeRayon));
	}
	
	public static ArrayList<Produit> getProduit(){
		return ProduitDAO.returnAllProduit();		
	}
	
	public static ArrayList<Produit> getProduit(int codeRayon){
		Iterator<Produit> iter = ProduitDAO.returnAllProduit().iterator();
		ArrayList<Produit> retour = new ArrayList<Produit>();
		
		while(iter.hasNext()) {
			Produit prod = iter.next();
			
			if(prod.getIDRayon().getIDRayon() == codeRayon) {
				retour.add(prod);
			}
		}
		
		return retour;
	}

}
