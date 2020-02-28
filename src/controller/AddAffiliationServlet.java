package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddAffiliationServlet
 */
@WebServlet("/addAffiliationServlet")
public class AddAffiliationServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAffiliationServlet() 
    {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		AffiliationHelper dao = new AffiliationHelper();
		String path = "/registration.jsp";
		
		request.setAttribute("allAffiliations", dao.showAllAffiliations());
		
		if(request.getParameterMap().containsKey("doThis"))
		{
			String act = request.getParameter("doThis");
			if(act.equals("Create a New Affiliation"))
			{
				path = "/new-affiliation.jsp";
			}
		}
		
		if(dao.showAllAffiliations().isEmpty())
		{
			request.setAttribute("allAffiliations", " ");
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
