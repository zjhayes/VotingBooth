package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Candidate;

public class CandidateHelper
{
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("VotingBooth");
	
	public void insertCandidate(Candidate candidate)
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(candidate);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Candidate> showAllCandidates()
	{
		EntityManager em = emfactory.createEntityManager();
		List<Candidate> results = em.createQuery("SELECT i FROM Candidate i").getResultList();
		em.close();
		return results;
	}
	
	public Candidate searchForCandidateById(int id)
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Candidate found = em.find(Candidate.class, id);
		em.close();
		return found;
	}
	
	public void updateCandidate(Candidate toEdit)
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	public void deleteCandidate(Candidate toDelete)
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Candidate> typedQuery = em.createQuery("SELECT candidate FROM Candidate candidate WHERE candidate.name = :selectedCandidate", Candidate.class);
		
		typedQuery.setParameter("selectedCandidate", toDelete.getName());	
		typedQuery.setMaxResults(1);
		
		Candidate result = typedQuery.getSingleResult();
		
		// Remove candidate
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public void cleanUp()
	{
		emfactory.close();
	}
}
