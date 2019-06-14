package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/Search")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("search.jsp").forward(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = "";
		String headline = "";
		String agency = "";
		String date = "";
		String city = "";
		String content = "";
		if(request.getParameter("search_id") != null) {
			id = request.getParameter("search_id");
		}
		if(request.getParameter("search_headline") != null) {
			headline = request.getParameter("search_headline");
		}
		if(request.getParameter("search_agency") != null) {
			agency = request.getParameter("search_agency");
		}
		if(request.getParameter("search_date") != null) {
			date = request.getParameter("search_date");
		}
		if(request.getParameter("search_city") != null) {
			city = request.getParameter("search_city");
		}
		if(request.getParameter("search_content") != null) {
			content = request.getParameter("search_content");
		}
		
		response.sendRedirect("SearchResults?id=" + id + "&headline=" + headline + "&agency=" + agency + "&date=" + date + "&city=" + city + "&content=" + content);
	}

}
