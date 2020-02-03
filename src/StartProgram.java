import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import javax.persistence.NoResultException;

import controller.CandidateHelper;
import model.Candidate;

// This Voting Booth allows users to cast their votes, and write-in a candidate who isn't listed.
// Officials can delete candidates, view results, or close the voting booth.
// Zachary Hayes - zjhayes@dmacc.edu

public class StartProgram
{
	static Scanner in = new Scanner(System.in);
	static CandidateHelper ch = new CandidateHelper();
	
	static final int VOTES_PER_PERSON = 1;
	
	public static void writeInCandidate()
	{
		System.out.print("Candidate name: ");
		String name= in.nextLine();
		
		Candidate toAdd = new Candidate(name, VOTES_PER_PERSON);
		ch.insertCandidate(toAdd);
		System.out.println("Candidate added. Thanks for voting!");
	}
	
	private static void castAVote() 
	{
		List<Candidate> foundItems;
		
		System.out.println("Who are you voting for? (Enter the ID of your Candidate.)");
		
		List<Candidate> candidates = ch.showAllCandidates();
		
		for(Candidate candidate : candidates)
		{
			System.out.println(candidate.getId() + " - " + candidate.getName());
		}
		
		try
		{
			int choice = in.nextInt();
			Candidate toEdit = ch.searchForCandidateById(choice);

			toEdit.addVotes(VOTES_PER_PERSON);
			
			ch.updateCandidate(toEdit);
			System.out.println("Thanks for voting!");
		}
		catch(InputMismatchException ex)
		{
			in.nextLine(); // Clear buffer.
			System.out.println("Invalid input. Please enter the numeric ID of the Candidate. Try again.");
			castAVote();
		}
		catch(NullPointerException ex)
		{
			System.out.println("The Candidate ID you entered does not exist. Try again.");
			castAVote();
		}
	}
	
	private static void viewResults() 
	{
		List<Candidate> candidates = ch.showAllCandidates();
		System.out.println("-- RESULTS --");
		for(Candidate candidate : candidates)
		{
			System.out.println(candidate.returnCandidateDetails());
		}
	}
	
	private static void deleteCandidate() 
	{
		System.out.print("Enter the Candidate to delete: ");
		String name = in.nextLine();
		
		Candidate toDelete = new Candidate(name);
		
		try
		{
			ch.deleteCandidate(toDelete);
			System.out.println("Election successfully rigged against " + name);
		}
		catch(NoResultException ex)
		{
			System.out.println("Candidate does not exist.");
		}
	}
	
	
	public static void main(String[] args) 
	{
		runMenu();

	}
	
	public static void runMenu() 
	{
		boolean goAgain = true;
		while (goAgain) {
			System.out.println("");
			System.out.println("*  Select an item:");
			System.out.println("*  1 -- Cast a Vote");
			System.out.println("*  2 -- Write-in Candidate");
			System.out.println("*  3 -- Delete a Candidate (official use only)");
			System.out.println("*  4 -- View Results (official use only)");
			System.out.println("*  5 -- Close Voting Booth");
			System.out.print("*  Your selection: ");
			int selection = in.nextInt();
			in.nextLine();

			if (selection == 1) {
				castAVote();
			} else if (selection == 2) {
				writeInCandidate();
			} else if (selection == 3) {
				deleteCandidate();
			} else if (selection == 4) {
				viewResults();
			} else {
				ch.cleanUp();
				System.out.println("Voting Booth closed.");
				goAgain = false;
			}
		}
	}
}
