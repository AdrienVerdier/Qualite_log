package controler;

import javax.persistence.EntityManager;

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
		em.remove(Produit);
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

	public static void modifierProduit(Produit Produit) {
		EntityManager em = Connexion.ouvrirconnexion();
		em.getTransaction().begin();
		Produit AncienProduit = em.find(Produit.class, Produit.getIDProduit());
		AncienProduit.setDescription(Produit.getDescription());
		AncienProduit.setIDRayon(Produit.getIDRayon());
		AncienProduit.setPrix(Produit.getPrix());
		AncienProduit.setQuantite(Produit.getQuantite());
		em.getTransaction().commit();
		Connexion.fermerconnexion(em);
	}
}
