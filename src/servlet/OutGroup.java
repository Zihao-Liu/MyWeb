package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Group;
import bean.GroupPost;
import bean.User;
import dao.AttendGroupDao;
import dao.GroupDao;
import dao.GroupPostDao;
import dao.UserDao;
import factory.AttendGroupDaoFactory;
import factory.GroupDaoFactory;
import factory.GroupPostDaoFactory;
import factory.UserDaoFactory;


public class OutGroup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public OutGroup() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("gbk");
		ServletContext servletContext = getServletContext();
		RequestDispatcher dispatcher = null;
		
		User user =(User)request.getSession().getAttribute("user");
		int groupID = Integer.parseInt(request.getParameter("groupID"));
		
		GroupDao groupDao = GroupDaoFactory.getGroupDaoInstance();
		UserDao userDao = UserDaoFactory.getUserDaoInstance();
		AttendGroupDao attendGroupDao = AttendGroupDaoFactory.getAttendGroupDaoInstance();
		
		if(attendGroupDao.findAttendGroup(user.getUserID(), groupID)!=null){
			groupDao.subGroupUserNum(groupID);
			userDao.subUserAttend(user.getUserID());
			attendGroupDao.out(user.getUserID(), groupID);
		}
		else{
			request.setAttribute("error", "ÄúÒÑÍË³ö");
		}
		GroupPostDao postDao = GroupPostDaoFactory.getGroupPostDaoInstance();
		List<GroupPost> posts = postDao.findPostByGroupIDOrderByPublishTime(groupID);
		request.setAttribute("postList", posts);
		Group group = groupDao.findGroupByID(groupID);
		request.setAttribute("group", group);
		
		dispatcher = servletContext.getRequestDispatcher("/showGroup.jsp");
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
