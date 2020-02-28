package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Affiliation;
import model.Candidate;
import model.Voter;

/**
 * Servlet implementation class ViewAllCandidatesServlet
 */
@WebServlet("/viewAffiliatedCandidatesServlet")
public class ViewAffiliatedCandidatesServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAffiliatedCandidatesServlet() 
    {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		AffiliationHelper dao = new AffiliationHelper();
		VoterHelper vh = new VoterHelper();
		CandidateHelper ch = new CandidateHelper();
		String path = "/vote.jsp";
		String voterId = "";
	
		if(request.getParameterMap().containsKey("voter"))
		{
			voterId = request.getParameter("voter");
		}
		
		if(request.getParameterMap().containsKey("doThis"))
		{
			String act = request.getParameter("doThis");
			
			if(act.equals("Edit Candidates")) {
				
				path = "/edit-candidates.jsp";
			}
		}
		
		request.setAttribute("affiliatedCandidates", ch.showAllCandidates());
		
		if(voterId != null && voterId.length() > 0)
		{
			List<Candidate> affiliatedCandidatesList = new ArrayList<Candidate>();

			Voter voter = vh.searchForVoterById(Integer.parseInt(voterId));
			request.setAttribute("voterid", voterId);
			Affiliation aff = voter.getAffiliation();
			affiliatedCandidatesList = aff.getListOfCandidates();
			
			if(!affiliatedCandidatesList.isEmpty())
			{
				request.setAttribute("affiliatedCandidates", affiliatedCandidatesList);
			}
		}
		
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
