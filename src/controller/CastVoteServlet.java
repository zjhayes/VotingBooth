package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Candidate;

/**
 * Servlet implementation class CastVoteServlet
 */
@WebServlet("/castVoteServlet")
public class CastVoteServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	private static final int VOTES_PER_PERSON = 1;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CastVoteServlet() 
    {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		CandidateHelper dao = new CandidateHelper();

		String path = "/success.jsp";
		
		String id = request.getParameter("id");
		
		try
		{
			Candidate chosenCandidate = dao.searchForCandidateById(Integer.parseInt(id));
			chosenCandidate.addVotes(VOTES_PER_PERSON);
			dao.updateCandidate(chosenCandidate);
		}
		catch(Exception ex)
		{
			path = "/error.jsp";
		}
		
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
