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
import bean.Watch;
import bean.User;
import dao.FilmCommentDao;
import dao.FilmDao;
import dao.WatchDao;
import dao.UserDao;
import factory.FilmCommentDaoFactory;
import factory.FilmDaoFactory;
import factory.WatchDaoFactory;
import factory.UserDaoFactory;


public class ModifyWatchNum extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public ModifyWatchNum() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext servletContext = getServletContext();
		RequestDispatcher dispatcher = null;
		
		User user= (User)request.getSession().getAttribute("user");
		
		int filmID = Integer.parseInt(request.getParameter("filmID"));
		int filmScore = Integer.parseInt(request.getParameter("score"));
		FilmDao filmDao = FilmDaoFactory.getFilmDaoInstance();
		Film film = filmDao.findFilmByID(filmID);
		if(user == null){
			request.setAttribute("error", "ÇëÏÈµÇÂ¼");
			dispatcher = servletContext.getRequestDispatcher("/showFilm.jsp");
		}
		else{
			int userID = user.getUserID();
			WatchDao watchDao = WatchDaoFactory.getWatchDaoInstance();
			if(watchDao.findWatch(filmID, userID)==null){
				watchDao.addWatch(filmID, userID, filmScore);
				filmDao.modifyFilmWatch(filmID, filmScore);
				UserDao userDao = UserDaoFactory.getUserDaoInstance();
				userDao.modifyUserWatch(userID);
				Watch watch = watchDao.findWatch(filmID, userID);
				request.setAttribute("watch", watch);
				film = filmDao.findFilmByID(filmID);
			}
			else{
				request.setAttribute("error", "ÄúÒÑ¶Á¹ý");
			}
			
			dispatcher = servletContext.getRequestDispatcher("/showFilm.jsp");
		}
		
		request.setAttribute("film", film);
		FilmCommentDao commentDao = FilmCommentDaoFactory.getCommentDaoInstance();
		List<FilmComment> comments1 = commentDao.findCommentByFilmIDOrderByApprove(filmID);
		request.setAttribute("commentList1", comments1);
		List<FilmComment> comments2 = commentDao.findCommentByFilmIDOrderByPublishTime(filmID);
		request.setAttribute("commentList2", comments2);
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
