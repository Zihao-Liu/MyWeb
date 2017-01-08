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
import dao.FilmApproveDao;
import dao.FilmCommentDao;
import dao.FilmDao;
import factory.FilmApproveDaoFactory;
import factory.FilmCommentDaoFactory;
import factory.FilmDaoFactory;


public class DeleteFilmComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public DeleteFilmComment() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("gbk");
		ServletContext servletContext = getServletContext();
		RequestDispatcher dispatcher =null;
		
		int commentID = Integer.parseInt(request.getParameter("commentID"));
		int userID = Integer.parseInt(request.getParameter("userID"));
		
		FilmApproveDao filmApproveDao = FilmApproveDaoFactory.getApproveDaoInstance();
		filmApproveDao.deleteApprove(commentID);
		FilmCommentDao filmCommentDao = FilmCommentDaoFactory.getCommentDaoInstance();
		int filmID = filmCommentDao.findCommentByCommentID(commentID).getFilmID();
		filmCommentDao.deleteComment(commentID, userID);
		
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
