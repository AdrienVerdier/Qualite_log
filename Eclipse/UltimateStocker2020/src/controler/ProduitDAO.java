package controler;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Produit;

public class ProduitDAO {

	public static void ajouterProduit(Produit Produit) {
		Connexion.getEM().getTransaction().begin();
		Connexion.getEM().persist(Produit);
		Connexion.getEM().getTransaction().commit();
	}

	public static void supprimerProduit(Produit Produit) {
		Connexion.getEM().getTransaction().begin();
		Produit Produit2 = Connexion.getEM().find(Produit.class, Produit.getIDProduit());
		Connexion.getEM().remove(Produit2);
		Connexion.getEM().getTransaction().commit();
	}

	public static Produit rechercheProduitById(int IDProduit) {
		Connexion.getEM().getTransaction().begin();
		Produit Produit = Connexion.getEM().find(Produit.class, IDProduit);
		Connexion.getEM().getTransaction().commit();
		return Produit;
	}

	public static void modifierProduit(int IDProduit, Produit Produit) {
		Connexion.getEM().getTransaction().begin();
		Produit NouveauProduit = Connexion.getEM().find(Produit.class, IDProduit);
		NouveauProduit.setDescription(Produit.getDescription());
		NouveauProduit.setPrix(Produit.getPrix());
		NouveauProduit.setQuantite(Produit.getQuantite());
		Connexion.getEM().getTransaction().commit();
	}

	public static ArrayList<Produit> returnAllProduit() {
		Connexion.getEM().getTransaction().begin();
		ArrayList<Produit> resultat = new ArrayList<Produit>();
		String queryString = "select c from Produit c";
		Query query = Connexion.getEM().createQuery(queryString);
		List results = query.getResultList();
		for (int i = 0; i < results.size(); i++) {
			Produit Produit = (Produit) results.get(i);
			resultat.add(Produit);
		}
		Connexion.getEM().getTransaction().commit();
		return resultat;
	};
	
	public static int returnMaxIDProduit() {
		Connexion.getEM().getTransaction().begin();
		String queryString = "select p from Produit p";
		Query query = Connexion.getEM().createQuery(queryString);
		List results = query.getResultList();
		int max = 0;
		for (int i = 0; i < results.size(); i++) {
			Produit Produit = (Produit) results.get(i);
			if(Produit.getIDProduit() >= max)
			{
				max = Produit.getIDProduit()+1;
			}
		}
		Connexion.getEM().getTransaction().commit();
		return max;
	};
}
