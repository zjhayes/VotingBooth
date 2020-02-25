package controller;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Candidate;
import model.Voter;

/**
 * Servlet implementation class NavigationServlet
 */
@WebServlet("/navigationServlet")
public class NavigationServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NavigationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		CandidateHelper dao = new CandidateHelper();
		String act = request.getParameter("doThis");
		String path = "/results.jsp";
		
		if(act.equals("Delete"))
		{
			path = "/admin.jsp";
			
			try
			{
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Candidate candidateToDelete = dao.searchForCandidateById(tempId);
				dao.deleteCandidate(candidateToDelete);
			}
			catch(Exception ex)
			{
				request.setAttribute("error", ex.getMessage());
				path = "/error.jsp";
			}
		}
		else if(act.equals("Results")) 
		{
			List<Candidate> candidates = dao.showAllCandidates();
			Collections.sort(candidates);
			Collections.reverse(candidates);
			request.setAttribute("sortedCandidates", candidates);
			path = "/results.jsp";
		}
		else if(act.equals("Voter Registration"))
		{
			VoterHelper vh = new VoterHelper();
			List<Voter> voters = vh.showAllVoters();
			request.setAttribute("allVoters", voters);
			
			if(voters.isEmpty())
			{
				request.setAttribute("allVoters", " ");
			}
			 
			 path = "/records.jsp";
		}
		
		request.setAttribute("allCandidates", dao.showAllCandidates());
		
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
