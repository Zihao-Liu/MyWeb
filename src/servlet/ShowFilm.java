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
import bean.FilmComment;
import dao.FilmCommentDao;
import dao.FilmDao;
import factory.FilmCommentDaoFactory;
import factory.FilmDaoFactory;

public class ShowFilm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ShowFilm() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext servletContext = getServletContext();
		RequestDispatcher dispatcher = null;
		
		int filmID = Integer.parseInt(request.getParameter("filmID"));
		FilmDao filmDao = FilmDaoFactory.getFilmDaoInstance();
		Film film = filmDao.findFilmByID(filmID);
		request.setAttribute("film", film);
		FilmCommentDao commentDao = FilmCommentDaoFactory.getCommentDaoInstance();
		List<FilmComment> comments1 = commentDao.findCommentByFilmIDOrderByApprove(filmID);
		request.setAttribute("commentList1", comments1);
		List<FilmComment> comments2 = commentDao.findCommentByFilmIDOrderByPublishTime(filmID);
		request.setAttribute("commentList2", comments2);
		dispatcher = servletContext.getRequestDispatcher("/showFilm.jsp");
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
