package controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
}
