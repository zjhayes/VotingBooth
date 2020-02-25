package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Voter;

public class VoterHelper
{
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("VotingBooth");
	
	public void insertVoter(Voter v)
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(v);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Voter> showAllVoters()
	{
		EntityManager em = emfactory.createEntityManager();
		List<Voter> allVoters = em.createQuery("SELECT v FROM Voter v").getResultList();
		return allVoters;
	}
}
