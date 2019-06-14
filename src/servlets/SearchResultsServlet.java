package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.Article;
import classes.XMLReader;

/**
 * Servlet implementation class SearchResultsServlet
 */
@WebServlet("/SearchResults")
public class SearchResultsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private XMLReader xml;
	private ArrayList<Article> filteredArticles;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchResultsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		xml = new XMLReader();
		String id;
		String agency;
		String headline;
		String date;
		String city;
		String content;
		if(request.getParameter("id") != null) {
			id = request.getParameter("id");
		} else {
			id = "";
		}
		if(request.getParameter("agency") != null) {
			agency = request.getParameter("agency");
		} else {
			agency = "";
		}
		if(request.getParameter("headline") != null) {
			headline = request.getParameter("headline");
		} else {
			headline = "";
		}
		if(request.getParameter("date") != null) {
			date = request.getParameter("date");
		} else {
			date = "";
		}
		if(request.getParameter("city") != null) {
			city = request.getParameter("city");
		} else {
			city = "";
		}
		if(request.getParameter("content") != null) {
			content = request.getParameter("content");
		} else {
			content = "";
		}
		filteredArticles = xml.getFilteredArticles(id, headline, agency, date, city, content);
		request.setAttribute("articles", filteredArticles);
		
		request.getRequestDispatcher("search_results.jsp").forward(request, response);
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
