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
import dao.GroupPostDao;
import dao.AttendGroupDao;
import dao.GroupDao;
import factory.GroupPostDaoFactory;
import factory.AttendGroupDaoFactory;
import factory.GroupDaoFactory;


public class ShowGroup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ShowGroup() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("gbk");
		ServletContext servletContext = getServletContext();
		RequestDispatcher dispatcher = null;
		
		int groupID = Integer.parseInt(request.getParameter("groupID"));
		GroupDao groupDao = GroupDaoFactory.getGroupDaoInstance();
		Group group = groupDao.findGroupByID(groupID);
		request.setAttribute("group", group);
		GroupPostDao postDao = GroupPostDaoFactory.getGroupPostDaoInstance();
		List<GroupPost> posts = postDao.findPostByGroupIDOrderByPublishTime(groupID);
		request.setAttribute("postList", posts);
		
		User user =(User)request.getSession().getAttribute("user");
		if(user !=null){
			AttendGroupDao attendGroupDao = AttendGroupDaoFactory.getAttendGroupDaoInstance();
			request.setAttribute("attendflag",attendGroupDao.findAttendGroup(user.getUserID(), groupID));
		}
		dispatcher = servletContext.getRequestDispatcher("/showGroup.jsp");
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
