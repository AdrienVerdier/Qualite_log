package controler;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.ChefMagasin;
import model.ChefRayon;
import model.Rayon;

public class ChefMagasinDAO {

	public static void ajouterChefMagasin(ChefMagasin ChefMagasin) {
		EntityManager em = Connexion.ouvrirconnexion();
		em.getTransaction().begin();
		em.persist(ChefMagasin);
		em.getTransaction().commit();
		Connexion.fermerconnexion(em);
	}
	
	public static void ajouterChefMagasinChefRayon(ChefMagasin ChefMagasin,ChefRayon ChefRayon) {
		EntityManager em = Connexion.ouvrirconnexion();		
		em.getTransaction().begin();
		List<ChefRayon> listChefRayon;
		listChefRayon = ChefMagasin.getListChefRayon();
		if(listChefRayon == null)
		{
			listChefRayon = new ArrayList<ChefRayon>();
		}
		listChefRayon.add(ChefRayon);
		ChefMagasin.setListChefRayon(listChefRayon);
		em.getTransaction().commit();
		Connexion.fermerconnexion(em);
	}
	
	public static void ajouterChefMagasinRayon(ChefMagasin ChefMagasin,Rayon Rayon) {
		EntityManager em = Connexion.ouvrirconnexion();		
		em.getTransaction().begin();
		List<Rayon> listRayon;
		listRayon = ChefMagasin.getListRayon();
		if(listRayon == null)
		{
			listRayon = new ArrayList<Rayon>();
		}
		listRayon.add(Rayon);
		ChefMagasin.setListRayon(listRayon);
		em.getTransaction().commit();
		Connexion.fermerconnexion(em);
	}

	public static void supprimerChefMagasin(ChefMagasin ChefMagasin) {
		EntityManager em = Connexion.ouvrirconnexion();
		em.getTransaction().begin();
		ChefMagasin ChefMagasin2 = em.find(ChefMagasin.class, ChefMagasin.getIDChefMagasin());
		em.remove(ChefMagasin2);
		em.getTransaction().commit();
		Connexion.fermerconnexion(em);
	}

	public static ChefMagasin rechercheChefMagasinById(int IDChefMagasin) {
		EntityManager em = Connexion.ouvrirconnexion();
		em.getTransaction().begin();
		ChefMagasin ChefMagasin = em.find(ChefMagasin.class, IDChefMagasin);
		em.getTransaction().commit();
		Connexion.fermerconnexion(em);
		return ChefMagasin;
	}

	public static void modifierChefMagasin(int IDChefMagasin, ChefMagasin ChefMagasin) {
		EntityManager em = Connexion.ouvrirconnexion();
		em.getTransaction().begin();
		ChefMagasin NouveauChefMagasin = em.find(ChefMagasin.class, IDChefMagasin);
		NouveauChefMagasin.setMotDePasse(ChefMagasin.getMotDePasse());
		NouveauChefMagasin.setNom(ChefMagasin.getNom());
		NouveauChefMagasin.setPrenom(ChefMagasin.getPrenom());
		em.getTransaction().commit();
		Connexion.fermerconnexion(em);
	}

	public static ArrayList<ChefMagasin> retrunAllChefMagasin() {
		EntityManager em = Connexion.ouvrirconnexion();
		em.getTransaction().begin();
		ArrayList<ChefMagasin> resultat = new ArrayList<ChefMagasin>();
		String queryString = "select c from ChefMagasin c";
		Query query = em.createQuery(queryString);
		List results = query.getResultList();
		for (int i = 0; i < results.size(); i++) {
			ChefMagasin ChefMagasin = (ChefMagasin) results.get(i);
			resultat.add(ChefMagasin);
		}
		em.getTransaction().commit();
		Connexion.fermerconnexion(em);
		return resultat;
	};
	
	public static int retrunMaxIDChefMagasin() {
		EntityManager em = Connexion.ouvrirconnexion();
		em.getTransaction().begin();
		String queryString = "select c from ChefMagasin c";
		Query query = em.createQuery(queryString);
		List results = query.getResultList();
		int max = 0;
		for (int i = 0; i < results.size(); i++) {
			ChefMagasin ChefMagasin = (ChefMagasin) results.get(i);
			if(ChefMagasin.getIDChefMagasin() >= max)
			{
				max = ChefMagasin.getIDChefMagasin()+1;
			}
		}
		em.getTransaction().commit();
		Connexion.fermerconnexion(em);
		return max;
	};
}
