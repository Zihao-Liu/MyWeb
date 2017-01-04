package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Film;
import dao.FilmDao;
import factory.FilmDaoFactory;


public class FilmClassify extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public FilmClassify() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		ServletContext servletcontext = getServletContext();
		RequestDispatcher dispatcher = null;
		
		
		String filmType = request.getParameter("filmType");
		FilmDao filmDao = FilmDaoFactory.getFilmDaoInstance();
		List<Film> films = filmDao.findAllFilmByType(filmType);
		request.setAttribute("filmClassify", films);
		dispatcher = servletcontext.getRequestDispatcher("/filmClassify.jsp");
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
