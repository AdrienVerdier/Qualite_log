package controler;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Produit;

public class ProduitDAO {

	public static void ajouterProduit(Produit Produit) {
		EntityManager em = Connexion.ouvrirconnexion();
		em.getTransaction().begin();
		em.persist(Produit);
		em.getTransaction().commit();
		Connexion.fermerconnexion(em);
	}

	public static void supprimerProduit(Produit Produit) {
		EntityManager em = Connexion.ouvrirconnexion();
		em.getTransaction().begin();
		Produit Produit2 = em.find(Produit.class, Produit.getIDProduit());
		em.remove(Produit2);
		em.getTransaction().commit();
		Connexion.fermerconnexion(em);
	}

	public static Produit rechercheProduitById(int IDProduit) {
		EntityManager em = Connexion.ouvrirconnexion();
		em.getTransaction().begin();
		Produit Produit = em.find(Produit.class, IDProduit);
		em.getTransaction().commit();
		Connexion.fermerconnexion(em);
		return Produit;
	}

	public static void modifierProduit(int IDProduit, Produit Produit) {
		EntityManager em = Connexion.ouvrirconnexion();
		em.getTransaction().begin();
		Produit NouveauProduit = em.find(Produit.class, IDProduit);
		NouveauProduit.setDescription(Produit.getDescription());
		NouveauProduit.setPrix(Produit.getPrix());
		NouveauProduit.setQuantite(Produit.getQuantite());
		em.getTransaction().commit();
		Connexion.fermerconnexion(em);
	}

	public static ArrayList<Produit> retrunAllProduit() {
		EntityManager em = Connexion.ouvrirconnexion();
		em.getTransaction().begin();
		ArrayList<Produit> resultat = new ArrayList<Produit>();
		String queryString = "select c from Produit c";
		Query query = em.createQuery(queryString);
		List results = query.getResultList();
		for (int i = 0; i < results.size(); i++) {
			Produit Produit = (Produit) results.get(i);
			resultat.add(Produit);
		}
		em.getTransaction().commit();
		Connexion.fermerconnexion(em);
		return resultat;
	};
	
	public static int retrunMaxIDProduit() {
		EntityManager em = Connexion.ouvrirconnexion();
		em.getTransaction().begin();
		String queryString = "select p from Produit p";
		Query query = em.createQuery(queryString);
		List results = query.getResultList();
		int max = 0;
		for (int i = 0; i < results.size(); i++) {
			Produit Produit = (Produit) results.get(i);
			if(Produit.getIDProduit() >= max)
			{
				max = Produit.getIDProduit()+1;
			}
		}
		em.getTransaction().commit();
		Connexion.fermerconnexion(em);
		return max;
	};
}
