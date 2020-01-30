package controler;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.ChefRayon;

public class ChefRayonDAO {

	public static void ajouterChefRayon(ChefRayon ChefRayon) {
		EntityManager em = Connexion.ouvrirconnexion();
		em.getTransaction().begin();
		em.persist(ChefRayon);
		em.getTransaction().commit();
		Connexion.fermerconnexion(em);
	}

	public static void supprimerChefRayon(ChefRayon ChefRayon) {
		EntityManager em = Connexion.ouvrirconnexion();
		em.getTransaction().begin();
		ChefRayon ChefRayon2 = em.find(ChefRayon.class, ChefRayon.getIDChefRayon());
		em.remove(ChefRayon2);
		em.getTransaction().commit();
		Connexion.fermerconnexion(em);
	}

	public static ChefRayon rechercheChefRayonById(int IDChefRayon) {
		EntityManager em = Connexion.ouvrirconnexion();
		em.getTransaction().begin();
		ChefRayon ChefRayon = em.find(ChefRayon.class, IDChefRayon);
		em.getTransaction().commit();
		Connexion.fermerconnexion(em);
		return ChefRayon;
	}

	public static void modifierChefRayon(int IDChefRayon, ChefRayon ChefRayon) {
		EntityManager em = Connexion.ouvrirconnexion();
		em.getTransaction().begin();
		ChefRayon NouveauChefRayon = em.find(ChefRayon.class, IDChefRayon);
		NouveauChefRayon.setMotDePasse(ChefRayon.getMotDePasse());
		NouveauChefRayon.setNom(ChefRayon.getNom());
		NouveauChefRayon.setPrenom(ChefRayon.getPrenom());
		em.getTransaction().commit();
		Connexion.fermerconnexion(em);
	}

	public static ArrayList<ChefRayon> retrunAllChefRayon() {
		EntityManager em = Connexion.ouvrirconnexion();
		em.getTransaction().begin();
		ArrayList<ChefRayon> resultat = new ArrayList<ChefRayon>();
		String queryString = "select c from ChefRayon c";
		Query query = em.createQuery(queryString);
		List results = query.getResultList();
		for (int i = 0; i < results.size(); i++) {
			ChefRayon ChefRayon = (ChefRayon) results.get(i);
			resultat.add(ChefRayon);
		}
		em.getTransaction().commit();
		Connexion.fermerconnexion(em);
		return resultat;
	};
	
	public static int retrunMaxIDChefRayon() {
		EntityManager em = Connexion.ouvrirconnexion();
		em.getTransaction().begin();
		String queryString = "select c from ChefRayon c";
		Query query = em.createQuery(queryString);
		List results = query.getResultList();
		int max = 0;
		for (int i = 0; i < results.size(); i++) {
			ChefRayon ChefRayon = (ChefRayon) results.get(i);
			if(ChefRayon.getIDChefRayon() >= max)
			{
				max = ChefRayon.getIDChefRayon()+1;
			}
		}
		em.getTransaction().commit();
		Connexion.fermerconnexion(em);
		return max;
	};
}
