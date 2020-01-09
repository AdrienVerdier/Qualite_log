package controler;

import javax.persistence.EntityManager;

import model.Rayon;

public class RayonDAO {
	public static void ajouterRayon(Rayon Rayon) {
		EntityManager em = Connexion.ouvrirconnexion();
		em.getTransaction().begin();
		em.persist(Rayon);
		em.getTransaction().commit();
		Connexion.fermerconnexion(em);
	}

	public static void supprimerRayon(Rayon Rayon) {
		EntityManager em = Connexion.ouvrirconnexion();
		em.getTransaction().begin();
		em.remove(Rayon);
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

}
