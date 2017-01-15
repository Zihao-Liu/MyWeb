package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Follow;
import bean.User;
import dao.AttendGroupDao;
import dao.FindReadDao;
import dao.FindWatchDao;
import dao.FollowDao;
import dao.StatusDao;
import dao.UserDao;
import factory.AttendGroupDaoFactory;
import factory.FindReadDaoFactory;
import factory.FindWatchDaoFactory;
import factory.FollowDaoFactory;
import factory.StatusDaoFactory;
import factory.UserDaoFactory;


public class ShowUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ShowUser() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("gbk");
		ServletContext servletContext = getServletContext();
		RequestDispatcher dispatcher = null;
		
		int userID= Integer.parseInt(request.getParameter("userID"));
		User user = (User)request.getSession().getAttribute("user");
		FindReadDao findReadDao = FindReadDaoFactory.getFindReadDaoInstance();
		FindWatchDao findWatchDao = FindWatchDaoFactory.getFindWatchDaoInstance();
		request.setAttribute("userreadbook",findReadDao.findAllBookRead(userID));
		request.setAttribute("userwatchfilm", findWatchDao.findAllFilmWatch(userID));
		AttendGroupDao attendGroupDao = AttendGroupDaoFactory.getAttendGroupDaoInstance();
		request.setAttribute("userattendgroup", attendGroupDao.findAllAttendGroup(userID));
		StatusDao statusDao = StatusDaoFactory.getStatusDaoInstance();
		request.setAttribute("userstatus", statusDao.findStatusByUserID(userID));
		UserDao userDao = UserDaoFactory.getUserDaoInstance();
		User userNew = userDao.findUserByID(userID);
		request.setAttribute("userNew", userNew);
		
		FollowDao followDao = FollowDaoFactory.getFollowDaoInstance();
		Follow follow = null;
		if(user!=null){
			follow = followDao.findFollow(userID, user.getUserID());
		}
		request.setAttribute("follow", follow);
		dispatcher=servletContext.getRequestDispatcher("/showUser.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
