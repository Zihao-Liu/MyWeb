package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User;
import dao.FindReadDao;
import dao.FindWatchDao;
import dao.StatusDao;
import dao.UserDao;
import factory.FindReadDaoFactory;
import factory.FindWatchDaoFactory;
import factory.StatusDaoFactory;
import factory.UserDaoFactory;


public class ModifyUserHide extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ModifyUserHide() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("gbk");
		ServletContext servletContext = getServletContext();
		RequestDispatcher dispatcher = null;
		
		int userID = Integer.parseInt(request.getParameter("userID"));
		int hide = Integer.parseInt(request.getParameter("hide"));
		UserDao userDao = UserDaoFactory.getUserDaoInstance();
		userDao.modifyUserHide(userID,hide);
		User userNew =userDao.findUserByID(userID);
		FindReadDao findReadDao = FindReadDaoFactory.getFindReadDaoInstance();
		FindWatchDao findWatchDao = FindWatchDaoFactory.getFindWatchDaoInstance();
		request.setAttribute("userreadbook",findReadDao.findAllBookRead(userNew.getUserID()));
		request.setAttribute("userwatchfilm", findWatchDao.findAllFilmWatch(userNew.getUserID()));
		
		StatusDao statusDao = StatusDaoFactory.getStatusDaoInstance();
		request.setAttribute("userstatus", statusDao.findStatusByUserID(userNew.getUserID()));;
		request.setAttribute("userNew", userNew);
		dispatcher=servletContext.getRequestDispatcher("/personalinfo.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
