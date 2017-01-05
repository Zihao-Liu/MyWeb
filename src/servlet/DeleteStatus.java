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



public class DeleteStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteStatus() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("gbk");
		ServletContext servletContext = getServletContext();
		RequestDispatcher dispatcher = null;
		
		int statusID = Integer.parseInt(request.getParameter("statusID"));
		User user = (User)request.getSession().getAttribute("user");
		
		StatusDao statusDao = StatusDaoFactory.getStatusDaoInstance();
		statusDao.deleteStatus(statusID);
		
		UserDao userDao = UserDaoFactory.getUserDaoInstance();
		
		FindReadDao findReadDao = FindReadDaoFactory.getFindReadDaoInstance();
		FindWatchDao findWatchDao = FindWatchDaoFactory.getFindWatchDaoInstance();
		User userNew = userDao.findUserByID(user.getUserID());
		request.setAttribute("userreadbook",findReadDao.findAllBookRead(user.getUserID()));
		request.setAttribute("userwatchfilm", findWatchDao.findAllFilmWatch(user.getUserID()));
		request.setAttribute("userstatus", statusDao.findStatusByUserID(user.getUserID()));
		request.setAttribute("userNew", userNew);
		
		dispatcher=servletContext.getRequestDispatcher("/personalinfo.jsp");
		dispatcher.forward(request, response);
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
