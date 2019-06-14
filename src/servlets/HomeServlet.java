package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.Article;
import classes.XMLReader;

/**
 * Servlet implementation class Home
 */
@WebServlet("/Home")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private XMLReader xml = new XMLReader();
	private ArrayList<Article> articles;
	private ArrayList<Article> articlesHeadlineSorted;
	private ArrayList<Article> articlesAgencySorted;
	private ArrayList<Article> articlesIdSorted;
	
	   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();
    	XMLReader xml = new XMLReader();
		articles = new ArrayList<>(xml.getArticles());
		xml.sortById();
		articlesIdSorted = new ArrayList<>(xml.getArticles());
		xml.sortByHeadline();
		articlesHeadlineSorted = new ArrayList<>(xml.getArticles());
		xml.sortByAgency();
		articlesAgencySorted = new ArrayList<>(xml.getArticles());
		
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getAttribute("articles") == null) {
			request.setAttribute("articles", articles);
		}
		request.getRequestDispatcher("home.jsp").forward(request, response);
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getParameter("id_sort") != null) {
			request.setAttribute("articles", articlesIdSorted);
		}
		else if(request.getParameter("headline_sort") != null) {
			request.setAttribute("articles", articlesHeadlineSorted);
		}
		else if(request.getParameter("agency_sort") != null) {
			request.setAttribute("articles", articlesAgencySorted);
		}
	    doGet(request, response);
	}

}
