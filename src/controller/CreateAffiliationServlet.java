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

/**
 * Servlet implementation class CreateAffiliationServlet
 */
@WebServlet("/createAffiliationServlet")
public class CreateAffiliationServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateAffiliationServlet() 
    {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		AffiliationHelper ah = new AffiliationHelper();
		CandidateHelper ch = new CandidateHelper();
		String affiliationName = request.getParameter("affiliationName");
		
		String[] selectedCandidates = request.getParameterValues("allCandidatestoAdd");
		List<Candidate> selectedCandidatesList = new ArrayList<Candidate>();
		
		if(selectedCandidates != null && selectedCandidates.length > 0)
		{
			for(int i = 0; i < selectedCandidates.length; i++)
			{
				Candidate c = ch.searchForCandidateById(Integer.parseInt(selectedCandidates[i]));
				selectedCandidatesList.add(c);
			}
		}
		
		Affiliation af = new Affiliation(affiliationName);
		af.setListOfCandidates(selectedCandidatesList);
		ah.insertAffiliation(af);
		
		request.setAttribute("doThis", "Edit Candidates");
		
		getServletContext().getRequestDispatcher("/viewAllCandidatesServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
