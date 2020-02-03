import java.util.Scanner;

import controller.CandidateHelper;
import model.Candidate;

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
	}
	
	
	public static void main(String[] args) {
		runMenu();

	}
	
	public static void runMenu() {
		boolean goAgain = true;
		System.out.println("");
		while (goAgain) {
			System.out.println("*  Select an item:");
			System.out.println("*  1 -- Cast a Vote");
			System.out.println("*  2 -- Write-in Candidate");
			System.out.println("*  3 -- Delete a Candidate (official use only)");
			System.out.println("*  4 -- View Results");
			System.out.println("*  5 -- Close Voting Booth");
			System.out.print("*  Your selection: ");
			int selection = in.nextInt();
			in.nextLine();

			if (selection == 1) {
				
			} else if (selection == 2) {
				writeInCandidate();
			} else if (selection == 3) {
				
			} else if (selection == 4) {
				
			} else {
				//ch.cleanUp()
				System.out.println("Thank you for voting!");
				goAgain = false;
			}

		}

	}
}
