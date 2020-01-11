package main;

import controler.ChefMagasinDAO;
import controler.ChefRayonDAO;
import controler.Connexion;
import controler.ProduitDAO;
import controler.RayonDAO;
import model.*;

public class MainCreation {

	public static void main(String[] args) {
		Connexion.init();
		
		ChefMagasin ChefMagasin1 = new ChefMagasin(1,"nom","prenom","password",null,null);
		
		Rayon Rayon1 = new Rayon(1,"Rayon1",null,null,ChefMagasin1);
		Rayon Rayon2 = new Rayon(2,"Rayon2",null,null,ChefMagasin1);
		Rayon Rayon3 = new Rayon(3,"Rayon3",null,null,ChefMagasin1);
		
		ChefRayon ChefRayon1 = new ChefRayon(1,"nom1","prenom1","password",ChefMagasin1,Rayon1);
		ChefRayon ChefRayon2 = new ChefRayon(2,"nom2","prenom2","password",ChefMagasin1,Rayon2);
		ChefRayon ChefRayon3 = new ChefRayon(3,"nom3","prenom3","password",ChefMagasin1,Rayon3);
		ChefRayon ChefRayon4 = new ChefRayon(4,"nom4","prenom4","password",ChefMagasin1,Rayon3);
		
		Produit Produit1 = new Produit(1,10,10,"description",Rayon1);
		Produit Produit2 = new Produit(2,100,0,"description",Rayon1);
		Produit Produit3 = new Produit(3,50,5,"description",Rayon2);
		
		ChefMagasinDAO.ajouterChefMagasin(ChefMagasin1);

		ChefMagasinDAO.ajouterChefMagasinRayon(ChefMagasin1, Rayon1);
		RayonDAO.ajouterRayon(Rayon1);
		ChefMagasinDAO.ajouterChefMagasinRayon(ChefMagasin1, Rayon2);
		RayonDAO.ajouterRayon(Rayon2);
		ChefMagasinDAO.ajouterChefMagasinRayon(ChefMagasin1, Rayon3);
		RayonDAO.ajouterRayon(Rayon3);
		
		ChefMagasinDAO.ajouterChefMagasinChefRayon(ChefMagasin1, ChefRayon1);
		RayonDAO.ajouterRayonChefRayon(Rayon1, ChefRayon1);
		ChefRayonDAO.ajouterChefRayon(ChefRayon1);
		ChefMagasinDAO.ajouterChefMagasinChefRayon(ChefMagasin1, ChefRayon2);
		RayonDAO.ajouterRayonChefRayon(Rayon1, ChefRayon2);
		ChefRayonDAO.ajouterChefRayon(ChefRayon2);
		ChefMagasinDAO.ajouterChefMagasinChefRayon(ChefMagasin1, ChefRayon3);
		RayonDAO.ajouterRayonChefRayon(Rayon2, ChefRayon3);
		ChefRayonDAO.ajouterChefRayon(ChefRayon3);
		ChefMagasinDAO.ajouterChefMagasinChefRayon(ChefMagasin1, ChefRayon4);
		RayonDAO.ajouterRayonChefRayon(Rayon3, ChefRayon4);
		ChefRayonDAO.ajouterChefRayon(ChefRayon4);
		
		RayonDAO.ajouterRayonProduit(Rayon1, Produit1);
		RayonDAO.ajouterRayonProduit(Rayon1, Produit2);
		RayonDAO.ajouterRayonProduit(Rayon2, Produit3);
		ProduitDAO.ajouterProduit(Produit1);
		ProduitDAO.ajouterProduit(Produit2);
		ProduitDAO.ajouterProduit(Produit3);

		ChefMagasin ChefMagasin2 = new ChefMagasin(1,"test","modif","wesh",null,null);
		ChefMagasinDAO.modifierChefMagasin(1,ChefMagasin2);
		//RayonDAO.supprimerRayon(Rayon1);
	}

}
