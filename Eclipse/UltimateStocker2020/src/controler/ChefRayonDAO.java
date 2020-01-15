package controler;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.ChefRayon;

public class ChefRayonDAO {

	public static void ajouterChefRayon(ChefRayon ChefRayon) {
		Connexion.getEM().getTransaction().begin();
		Connexion.getEM().persist(ChefRayon);
		Connexion.getEM().getTransaction().commit();
	}

	public static void supprimerChefRayon(ChefRayon ChefRayon) {
		Connexion.getEM().getTransaction().begin();
		ChefRayon ChefRayon2 = Connexion.getEM().find(ChefRayon.class, ChefRayon.getIDChefRayon());
		Connexion.getEM().remove(ChefRayon2);
		Connexion.getEM().getTransaction().commit();
	}

	public static ChefRayon rechercheChefRayonById(int IDChefRayon) {
		Connexion.getEM().getTransaction().begin();
		ChefRayon ChefRayon = Connexion.getEM().find(ChefRayon.class, IDChefRayon);
		Connexion.getEM().getTransaction().commit();
		return ChefRayon;
	}

	public static void modifierChefRayon(int IDChefRayon, ChefRayon ChefRayon) {
		Connexion.getEM().getTransaction().begin();
		ChefRayon NouveauChefRayon = Connexion.getEM().find(ChefRayon.class, IDChefRayon);
		NouveauChefRayon.setMotDePasse(ChefRayon.getMotDePasse());
		NouveauChefRayon.setNom(ChefRayon.getNom());
		NouveauChefRayon.setPrenom(ChefRayon.getPrenom());
		Connexion.getEM().getTransaction().commit();
	}

	public static ArrayList<ChefRayon> returnAllChefRayon() {
		Connexion.getEM().getTransaction().begin();
		ArrayList<ChefRayon> resultat = new ArrayList<ChefRayon>();
		String queryString = "select c from ChefRayon c";
		Query query = Connexion.getEM().createQuery(queryString);
		List results = query.getResultList();
		for (int i = 0; i < results.size(); i++) {
			ChefRayon ChefRayon = (ChefRayon) results.get(i);
			resultat.add(ChefRayon);
		}
		Connexion.getEM().getTransaction().commit();
		return resultat;
	};
	
	public static int returnMaxIDChefRayon() {
		Connexion.getEM().getTransaction().begin();
		String queryString = "select c from ChefRayon c";
		Query query = Connexion.getEM().createQuery(queryString);
		List results = query.getResultList();
		int max = 0;
		for (int i = 0; i < results.size(); i++) {
			ChefRayon ChefRayon = (ChefRayon) results.get(i);
			if(ChefRayon.getIDChefRayon() >= max)
			{
				max = ChefRayon.getIDChefRayon()+1;
			}
		}
		Connexion.getEM().getTransaction().commit();
		return max;
	};
}
