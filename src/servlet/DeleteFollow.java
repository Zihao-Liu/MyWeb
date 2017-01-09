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
import dao.FollowDao;
import dao.StatusDao;
import dao.UserDao;
import factory.FindReadDaoFactory;
import factory.FindWatchDaoFactory;
import factory.FollowDaoFactory;
import factory.StatusDaoFactory;
import factory.UserDaoFactory;


public class DeleteFollow extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public DeleteFollow() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("gbk");
		ServletContext servletContext = getServletContext();
		RequestDispatcher dispatcher = null;
		
		int followerUserID = Integer.parseInt(request.getParameter("followerUserID"));
		int followingUserID = Integer.parseInt(request.getParameter("followingUserID"));
		System.out.println(followerUserID );
		System.out.println(followingUserID);
		FollowDao followDao = FollowDaoFactory.getFollowDaoInstance();
		if(followDao.findFollow(followerUserID ,followingUserID)==null)
			request.setAttribute("error", "不能重复提交");
		else
			followDao.deleteFollow(followerUserID, followingUserID);
		request.setAttribute("follow", followDao.findFollow(followerUserID, followingUserID));
		FindReadDao findReadDao = FindReadDaoFactory.getFindReadDaoInstance();
		FindWatchDao findWatchDao = FindWatchDaoFactory.getFindWatchDaoInstance();
		request.setAttribute("userreadbook",findReadDao.findAllBookRead(followerUserID ));
		request.setAttribute("userwatchfilm", findWatchDao.findAllFilmWatch(followerUserID ));
		
		StatusDao statusDao = StatusDaoFactory.getStatusDaoInstance();
		request.setAttribute("userstatus", statusDao.findStatusByUserID(followerUserID ));
		UserDao userDao = UserDaoFactory.getUserDaoInstance();
		User userNew = userDao.findUserByID(followerUserID );
		request.setAttribute("userNew", userNew);
		dispatcher=servletContext.getRequestDispatcher("/showUser.jsp");
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
