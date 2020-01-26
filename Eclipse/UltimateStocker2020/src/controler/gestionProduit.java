package controler;

import java.util.ArrayList;
import java.util.Iterator;

import model.Produit;
import model.Rayon;

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
	
	public static void modifierProduit(int idProduit, String description, int prix, int quantite, int codeRayon) {
		Produit produit = ProduitDAO.rechercheProduitById(idProduit);
		produit.setDescription(description);
		produit.setIDRayon(RayonDAO.rechercheRayonById(codeRayon));
		produit.setPrix(prix);
		produit.setQuantite(quantite);
		ProduitDAO.modifierProduit(idProduit, produit);
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
	
	public static String getDescription(int IDProduit) {
		Produit produit = ProduitDAO.rechercheProduitById(IDProduit);
		return produit.getDescription();
	}
	
	public static int getQuantite(int IDProduit) {
		Produit produit = ProduitDAO.rechercheProduitById(IDProduit);
		return produit.getQuantite();
	}
	
	public static int getPrix(int IDProduit) {
		Produit produit = ProduitDAO.rechercheProduitById(IDProduit);
		return produit.getPrix();
	}

}
