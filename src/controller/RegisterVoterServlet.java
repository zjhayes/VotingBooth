package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Affiliation;
import model.Voter;

/**
 * Servlet implementation class RegisterVoterServlet
 */
@WebServlet("/registerVoterServlet")
public class RegisterVoterServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterVoterServlet() 
    {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		AffiliationHelper ah = new AffiliationHelper();
		VoterHelper vh = new VoterHelper();
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String affiliationId = request.getParameter("affiliation");
		LocalDate ld = LocalDate.now();
		
		Affiliation voterParty = ah.searchForAffiliationById(Integer.parseInt(affiliationId));
		
		Voter newVoter = new Voter(firstName, lastName, ld, voterParty);
		
		vh.insertVoter(newVoter);
		
		// Return to Sign-in
		List<Voter> voters = vh.showAllVoters();
		Collections.sort(voters);
		request.setAttribute("allVoters", voters);
		
		getServletContext().getRequestDispatcher("/signin.jsp").forward(request, response);;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
