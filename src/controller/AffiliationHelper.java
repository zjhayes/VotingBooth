package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Affiliation;
import model.Candidate;

public class AffiliationHelper
{
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("VotingBooth");
	
	public void insertAffiliation(Affiliation a)
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(a);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Affiliation> showAllAffiliations()
	{
		EntityManager em = emfactory.createEntityManager();
		List<Affiliation> allAffiliations = em.createQuery("SELECT a FROM Affiliation a").getResultList();
		return allAffiliations;
	}
	
	public Affiliation searchForAffiliationById(int id)
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Affiliation found = em.find(Affiliation.class, id);
		em.close();
		return found;
	}
}
