import java.time.LocalDate;
import java.util.List;

import controller.AffiliationHelper;
import controller.VoterHelper;
import model.Affiliation;
import model.Voter;

public class VotingTester
{
	public static void main(String[] args)
	{
		
		Affiliation reps = new Affiliation("Republican");
		AffiliationHelper ah = new AffiliationHelper();
		ah.insertAffiliation(reps);
		
		
		Voter john = new Voter("John", "Plumbington", LocalDate.now(), reps);
		VoterHelper vh = new VoterHelper();
		
		vh.insertVoter(john);
		
		List<Voter> allVoters = vh.showAllVoters();
		
		for(Voter v : allVoters)
		{
			System.out.println(v.toString());
		}
	}
}
