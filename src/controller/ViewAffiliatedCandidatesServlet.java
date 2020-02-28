package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		String act = request.getParameter("doThis");
		String path = "/vote.jsp";
		
		if(act.equals("Edit Candidates")) {
			
			path = "/edit-candidates.jsp";
		}
		
		request.setAttribute("allAffiliations", dao.showAllCandidates());
		
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
