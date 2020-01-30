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
		EntityManager em = Connexion.ouvrirconnexion();
		em.getTransaction().begin();
		em.persist(Rayon);
		em.getTransaction().commit();
		Connexion.fermerconnexion(em);
	}
	
	public static void ajouterRayonChefRayon(Rayon Rayon,ChefRayon ChefRayon) {
		EntityManager em = Connexion.ouvrirconnexion();		
		em.getTransaction().begin();
		List<ChefRayon> listChefRayon;
		listChefRayon = Rayon.getListChefRayon();
		if(listChefRayon == null)
		{
			listChefRayon = new ArrayList<ChefRayon>();
		}
		listChefRayon.add(ChefRayon);
		Rayon.setListChefRayon(listChefRayon);
		em.getTransaction().commit();
		Connexion.fermerconnexion(em);
	}
	
	public static void ajouterRayonProduit(Rayon Rayon,Produit Produit) {
		EntityManager em = Connexion.ouvrirconnexion();		
		em.getTransaction().begin();
		List<Produit> listProduit;
		listProduit = Rayon.getListProduit();
		if(listProduit == null)
		{
			listProduit = new ArrayList<Produit>();
		}
		listProduit.add(Produit);
		Rayon.setListProduit(listProduit);
		em.getTransaction().commit();
		Connexion.fermerconnexion(em);
	}

	public static void supprimerRayon(Rayon Rayon) {
		EntityManager em = Connexion.ouvrirconnexion();
		em.getTransaction().begin();
		Rayon Rayon2 = em.find(Rayon.class, Rayon.getIDRayon());
		em.remove(Rayon2);
		em.getTransaction().commit();
		Connexion.fermerconnexion(em);
	}

	public static Rayon rechercheRayonById(int IDRayon) {
		EntityManager em = Connexion.ouvrirconnexion();
		em.getTransaction().begin();
		Rayon Rayon = em.find(Rayon.class, IDRayon);
		em.getTransaction().commit();
		Connexion.fermerconnexion(em);
		return Rayon;
	}

	public static void modifierRayon(int IDRayon, Rayon Rayon) {
		EntityManager em = Connexion.ouvrirconnexion();
		em.getTransaction().begin();
		Rayon NouveauRayon = em.find(Rayon.class, IDRayon);
		NouveauRayon.setNom(Rayon.getNom());
		em.getTransaction().commit();
		Connexion.fermerconnexion(em);
	}

	public static ArrayList<Rayon> retrunAllRayon() {
		EntityManager em = Connexion.ouvrirconnexion();
		em.getTransaction().begin();
		ArrayList<Rayon> resultat = new ArrayList<Rayon>();
		String queryString = "select c from Rayon c";
		Query query = em.createQuery(queryString);
		List results = query.getResultList();
		for (int i = 0; i < results.size(); i++) {
			Rayon Rayon = (Rayon) results.get(i);
			resultat.add(Rayon);
		}
		em.getTransaction().commit();
		Connexion.fermerconnexion(em);
		return resultat;
	};
	
	public static int retrunMaxIDRayon() {
		EntityManager em = Connexion.ouvrirconnexion();
		em.getTransaction().begin();
		String queryString = "select r from Rayon r";
		Query query = em.createQuery(queryString);
		List results = query.getResultList();
		int max = 0;
		for (int i = 0; i < results.size(); i++) {
			Rayon Rayon = (Rayon) results.get(i);
			if(Rayon.getIDRayon() >= max)
			{
				max = Rayon.getIDRayon()+1;
			}
		}
		em.getTransaction().commit();
		Connexion.fermerconnexion(em);
		return max;
	};

}
