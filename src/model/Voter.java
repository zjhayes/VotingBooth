package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="voters")
public class Voter
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="VOTER_ID")
	private int id;
	@Column(name="FIRST_NAME")
	private String firstName;
	@Column(name="LAST_NAME")
	private String lastName;
	@Column(name="REGISTRATION_DATE")
	private LocalDate registrationDate;
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="AFFILIATION_ID")
	private Affiliation affiliation;
	
	
	public Voter() {}
	
	public Voter(int id, String firstName, String lastName, LocalDate registrationDate, Affiliation affiliation)
	{
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.registrationDate = registrationDate;
		this.affiliation = affiliation;
	}
	
	public Voter(String firstName, String lastName, LocalDate registrationDate, Affiliation affiliation)
	{
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.registrationDate = registrationDate;
		this.affiliation = affiliation;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public LocalDate getRegistrationDate()
	{
		return registrationDate;
	}

	public void setRegistrationDate(LocalDate registrationDate)
	{
		this.registrationDate = registrationDate;
	}
	
	public void setRegistrationDate()
	{
		this.registrationDate = LocalDate.now();
	}

	public Affiliation getAffiliation()
	{
		return affiliation;
	}

	public void setAffiliation(Affiliation affiliation)
	{
		this.affiliation = affiliation;
	}

	@Override
	public String toString()
	{
		return "Voter [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", registrationDate="
				+ registrationDate + ", affiliation=" + affiliation + "]";
	}
	
}
