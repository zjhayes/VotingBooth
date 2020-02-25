import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import controller.AffiliationHelper;
import controller.VoterHelper;
import model.Affiliation;
import model.Candidate;
import model.Voter;

public class VotingTester
{
	public static void main(String[] args)
	{
		
		Affiliation indie = new Affiliation("Independent");
		
		Candidate brian = new Candidate("Brian Carroll");
		Candidate jerome = new Candidate("Jerome Segal");
		
		List<Candidate> indieCandidates = new ArrayList<Candidate>();
		indieCandidates.add(brian);
		indieCandidates.add(jerome);
		indie.setListOfCandidates(indieCandidates);
		AffiliationHelper ah = new AffiliationHelper();
		ah.insertAffiliation(indie);
		
		
		Voter susan = new Voter("Susan", "Crowley", LocalDate.now(), indie);
		VoterHelper vh = new VoterHelper();
		
		vh.insertVoter(susan);
		
		List<Voter> allVoters = vh.showAllVoters();
		
		for(Voter v : allVoters)
		{
			System.out.println(v.toString());
		}
	}
}
