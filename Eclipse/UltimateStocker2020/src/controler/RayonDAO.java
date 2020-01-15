package controler;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.ChefMagasin;
import model.ChefRayon;
import model.Produit;
import model.Rayon;

public class RayonDAO {
	public static void ajouterRayon(Rayon Rayon) {
		Connexion.getEM().getTransaction().begin();
		Connexion.getEM().persist(Rayon);
		Connexion.getEM().getTransaction().commit();
	}
	
	public static void ajouterRayonChefRayon(Rayon Rayon,ChefRayon ChefRayon) {
		Connexion.getEM().getTransaction().begin();
		List<ChefRayon> listChefRayon;
		listChefRayon = Rayon.getListChefRayon();
		if(listChefRayon == null)
		{
			listChefRayon = new ArrayList<ChefRayon>();
		}
		listChefRayon.add(ChefRayon);
		Rayon.setListChefRayon(listChefRayon);
		Connexion.getEM().getTransaction().commit();
	}
	
	public static void ajouterRayonProduit(Rayon Rayon,Produit Produit) {
		Connexion.getEM().getTransaction().begin();
		List<Produit> listProduit;
		listProduit = Rayon.getListProduit();
		if(listProduit == null)
		{
			listProduit = new ArrayList<Produit>();
		}
		listProduit.add(Produit);
		Rayon.setListProduit(listProduit);
		Connexion.getEM().getTransaction().commit();
	}

	public static void supprimerRayon(Rayon Rayon) {
		Connexion.getEM().getTransaction().begin();
		Rayon Rayon2 = Connexion.getEM().find(Rayon.class, Rayon.getIDRayon());
		Connexion.getEM().remove(Rayon2);
		Connexion.getEM().getTransaction().commit();
	}

	public static Rayon rechercheRayonById(int IDRayon) {
		Connexion.getEM().getTransaction().begin();
		Rayon Rayon = Connexion.getEM().find(Rayon.class, IDRayon);
		Connexion.getEM().getTransaction().commit();
		return Rayon;
	}

	public static void modifierRayon(int IDRayon, Rayon Rayon) {
		Connexion.getEM().getTransaction().begin();
		Rayon NouveauRayon = Connexion.getEM().find(Rayon.class, IDRayon);
		NouveauRayon.setNom(Rayon.getNom());
		Connexion.getEM().getTransaction().commit();
	}

	public static ArrayList<Rayon> returnAllRayon() {
		Connexion.getEM().getTransaction().begin();
		ArrayList<Rayon> resultat = new ArrayList<Rayon>();
		String queryString = "select c from Rayon c";
		Query query = Connexion.getEM().createQuery(queryString);
		List results = query.getResultList();
		for (int i = 0; i < results.size(); i++) {
			Rayon Rayon = (Rayon) results.get(i);
			resultat.add(Rayon);
		}
		Connexion.getEM().getTransaction().commit();
		return resultat;
	};
	
	public static int returnMaxIDRayon() {
		Connexion.getEM().getTransaction().begin();
		String queryString = "select r from Rayon r";
		Query query = Connexion.getEM().createQuery(queryString);
		List results = query.getResultList();
		int max = 0;
		for (int i = 0; i < results.size(); i++) {
			Rayon Rayon = (Rayon) results.get(i);
			if(Rayon.getIDRayon() >= max)
			{
				max = Rayon.getIDRayon()+1;
			}
		}
		Connexion.getEM().getTransaction().commit();
		return max;
	};

}
