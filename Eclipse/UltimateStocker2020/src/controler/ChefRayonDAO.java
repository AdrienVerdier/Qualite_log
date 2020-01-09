package controler;

import javax.persistence.EntityManager;

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
		em.remove(ChefRayon);
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
}
