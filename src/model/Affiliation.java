package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="affiliations")
public class Affiliation
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="AFFILIATION_ID")
	private int id;
	@Column(name="AFFILIATION_NAME")
	private String affiliationName;
	@OneToMany(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
	@JoinTable
	(
		name="CANDIDATE_AFFILIATIONS",
		joinColumns = {@JoinColumn(name="AFFILIATION_ID", referencedColumnName="AFFILIATION_ID")},
		inverseJoinColumns = {@JoinColumn(name="CANDIDATE_ID", referencedColumnName="ID", unique=true)}
	)
	private List<Candidate> listOfCandidates;
	
	public Affiliation() 
	{
		super();
	}
	
	public Affiliation(int id, String affiliationName)
	{
		super();
		this.id = id;
		this.affiliationName = affiliationName;
	}
	
	public Affiliation(String affiliationName)
	{
		super();
		this.affiliationName = affiliationName;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getAffiliationName()
	{
		return affiliationName;
	}

	public void setAffiliationName(String affiliationName)
	{
		this.affiliationName = affiliationName;
	}

	@Override
	public String toString()
	{
		return "Affiliation [id=" + id + ", affiliationName=" + affiliationName + "]";
	}
	
	
}
