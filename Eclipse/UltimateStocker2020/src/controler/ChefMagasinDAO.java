package controler;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.ChefMagasin;
import model.ChefRayon;
import model.Rayon;

public class ChefMagasinDAO {

	public static void ajouterChefMagasin(ChefMagasin ChefMagasin) {
		Connexion.getEM().getTransaction().begin();
		Connexion.getEM().persist(ChefMagasin);
		Connexion.getEM().getTransaction().commit();
	}
	
	public static void ajouterChefMagasinChefRayon(ChefMagasin ChefMagasin,ChefRayon ChefRayon) {	
		Connexion.getEM().getTransaction().begin();
		List<ChefRayon> listChefRayon;
		listChefRayon = ChefMagasin.getListChefRayon();
		if(listChefRayon == null)
		{
			listChefRayon = new ArrayList<ChefRayon>();
		}
		listChefRayon.add(ChefRayon);
		ChefMagasin.setListChefRayon(listChefRayon);
		Connexion.getEM().getTransaction().commit();
	}
	
	public static void ajouterChefMagasinRayon(ChefMagasin ChefMagasin,Rayon Rayon) {	
		Connexion.getEM().getTransaction().begin();
		List<Rayon> listRayon;
		listRayon = ChefMagasin.getListRayon();
		if(listRayon == null)
		{
			listRayon = new ArrayList<Rayon>();
		}
		listRayon.add(Rayon);
		ChefMagasin.setListRayon(listRayon);
		Connexion.getEM().getTransaction().commit();
	}

	public static void supprimerChefMagasin(ChefMagasin ChefMagasin) {
		Connexion.getEM().getTransaction().begin();
		ChefMagasin ChefMagasin2 = Connexion.getEM().find(ChefMagasin.class, ChefMagasin.getIDChefMagasin());
		Connexion.getEM().remove(ChefMagasin2);
		Connexion.getEM().getTransaction().commit();
	}

	public static ChefMagasin rechercheChefMagasinById(int IDChefMagasin) {
		Connexion.getEM().getTransaction().begin();
		ChefMagasin ChefMagasin = Connexion.getEM().find(ChefMagasin.class, IDChefMagasin);
		Connexion.getEM().getTransaction().commit();
		return ChefMagasin;
	}

	public static void modifierChefMagasin(int IDChefMagasin, ChefMagasin ChefMagasin) {
		Connexion.getEM().getTransaction().begin();
		ChefMagasin NouveauChefMagasin = Connexion.getEM().find(ChefMagasin.class, IDChefMagasin);
		NouveauChefMagasin.setMotDePasse(ChefMagasin.getMotDePasse());
		NouveauChefMagasin.setNom(ChefMagasin.getNom());
		NouveauChefMagasin.setPrenom(ChefMagasin.getPrenom());
		Connexion.getEM().getTransaction().commit();
	}

	public static ArrayList<ChefMagasin> returnAllChefMagasin() {
		Connexion.getEM().getTransaction().begin();
		ArrayList<ChefMagasin> resultat = new ArrayList<ChefMagasin>();
		String queryString = "select c from ChefMagasin c";
		Query query = Connexion.getEM().createQuery(queryString);
		List results = query.getResultList();
		for (int i = 0; i < results.size(); i++) {
			ChefMagasin ChefMagasin = (ChefMagasin) results.get(i);
			resultat.add(ChefMagasin);
		}
		Connexion.getEM().getTransaction().commit();
		return resultat;
	};
	
	public static int returnMaxIDChefMagasin() {
		Connexion.getEM().getTransaction().begin();
		String queryString = "select c from ChefMagasin c";
		Query query = Connexion.getEM().createQuery(queryString);
		List results = query.getResultList();
		int max = 0;
		for (int i = 0; i < results.size(); i++) {
			ChefMagasin ChefMagasin = (ChefMagasin) results.get(i);
			if(ChefMagasin.getIDChefMagasin() >= max)
			{
				max = ChefMagasin.getIDChefMagasin()+1;
			}
		}
		Connexion.getEM().getTransaction().commit();
		return max;
	};
}
