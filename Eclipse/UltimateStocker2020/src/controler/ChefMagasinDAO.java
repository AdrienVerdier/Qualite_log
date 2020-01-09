package controler;

import javax.persistence.EntityManager;
import model.ChefMagasin;

public class ChefMagasinDAO {

	public static void ajouterChefMagasin(ChefMagasin ChefMagasin) {
		EntityManager em = Connexion.ouvrirconnexion();
		em.getTransaction().begin();
		em.persist(ChefMagasin);
		em.getTransaction().commit();
		Connexion.fermerconnexion(em);
	}

	public static void supprimerChefMagasin(ChefMagasin ChefMagasin) {
		EntityManager em = Connexion.ouvrirconnexion();
		em.getTransaction().begin();
		em.remove(ChefMagasin);
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

	public static ChefMagasin modifierChefMagasin(ChefMagasin ChefMagasin) {
		EntityManager em = Connexion.ouvrirconnexion();
		em.getTransaction().begin();
		ChefMagasin AncienChefMagasin = em.find(ChefMagasin.class, ChefMagasin.getIDChefMagasin());
		AncienChefMagasin.setMotDePasse(ChefMagasin.getMotDePasse());
		AncienChefMagasin.setNom(ChefMagasin.getNom());
		AncienChefMagasin.setPrenom(ChefMagasin.getPrenom());
		em.getTransaction().commit();
		Connexion.fermerconnexion(em);
		return ChefMagasin;
	}
}
