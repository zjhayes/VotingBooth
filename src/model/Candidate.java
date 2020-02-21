// Zachary Hayes - zjhayes@dmacc.edu

package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="candidates")
public class Candidate implements Comparable<Candidate>
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	@Column(name="NAME")
	private String name;
	@Column(name="VOTES")
	private int votes;
	
	public Candidate()
	{
		
	}
	
	public Candidate(String name)
	{
		this.name = name;
	}
	
	public Candidate(String name, int votes)
	{
		this.name = name;
		this.votes = votes;
	}
	
	public String returnCandidateDetails()
	{
		return name + ": " + votes;
	}
	
	public void addVotes(int votesToAdd)
	{
		this.votes += votesToAdd;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getVotes()
	{
		return votes;
	}

	public void setVotes(int votes)
	{
		this.votes = votes;
	}

	@Override
	public int compareTo(Candidate compareCandidate)
	{
	    return Integer.compare(this.getVotes(),compareCandidate.getVotes());
	}
}
