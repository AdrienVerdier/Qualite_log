package controler;

import javax.persistence.*;

public class Connexion {
	
	private static EntityManagerFactory emf;
	private static EntityManager em;
	
	public static void init()
	{
		emf = Persistence.createEntityManagerFactory("initialisation");
		em = emf.createEntityManager();
	}
	
	public static void modification()
	{
		emf = Persistence.createEntityManagerFactory("modification");
		em = emf.createEntityManager();
	}

	static public EntityManager getEM() {
		return em;
	}

	static public void fermerconnexion() {
		em.close();
	}
}