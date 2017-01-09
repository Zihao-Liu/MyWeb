package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Follow;
import bean.User;
import dao.FollowDao;
import dao.UserDao;
import factory.FollowDaoFactory;
import factory.UserDaoFactory;


public class ShowFollow extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ShowFollow() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("gbk");
		ServletContext servletContext = getServletContext();
		RequestDispatcher dispatcher = null;
		
		int userID = Integer.parseInt(request.getParameter("userID"));
		FollowDao followDao = FollowDaoFactory.getFollowDaoInstance();
		
		List<Follow> followingList =followDao.findFollowingUser(userID);
		List<Follow> followerList = followDao.findFollowerUser(userID);
		UserDao userDao = UserDaoFactory.getUserDaoInstance();
		List<User> users = new ArrayList<User>();
		List<User> users2 =new ArrayList<User>();
		for(Follow follow:followingList){
			users.add(userDao.findUserByID(follow.getFollowerUserID()));
		}
		request.setAttribute("followingList", users);
		for(Follow follow:followerList){
			users2.add(userDao.findUserByID(follow.getFollowingUserID()));
		}
		request.setAttribute("followerList", users2);
		request.setAttribute("userNew", userDao.findUserByID(userID));
		dispatcher=servletContext.getRequestDispatcher("/showFollow.jsp");
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
