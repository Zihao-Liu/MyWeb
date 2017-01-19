package servlet;

import java.io.IOException;
import java.util.Date;
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
import factory.AttendGroupDaoFactory;
import factory.GroupDaoFactory;
import factory.GroupPostDaoFactory;


public class AddGroupPost extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AddGroupPost() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("gbk");
		ServletContext servletContext = getServletContext();
		RequestDispatcher dispatcher = null;
		
		String postTitle = request.getParameter("posttitle");
		String postContent = request.getParameter("postcontent");
		int groupID = Integer.parseInt(request.getParameter("groupID"));
		GroupDao groupDao = GroupDaoFactory.getGroupDaoInstance();
		GroupPostDao postDao = GroupPostDaoFactory.getGroupPostDaoInstance();
		
		User user =(User)request.getSession().getAttribute("user");
		if(user !=null){
			AttendGroupDao attendGroupDao = AttendGroupDaoFactory.getAttendGroupDaoInstance();
			request.setAttribute("attendflag",attendGroupDao.findAttendGroup(user.getUserID(), groupID));
			if(postTitle==null||"".equals(postTitle))
				request.setAttribute("error", "标题不能为空");
			else{
				if(postContent==null||"".equals(postContent))
					request.setAttribute("error", "内容不能为空");
				else{
					GroupPost groupPost = new GroupPost();
					groupPost.setPostTitle(postTitle);
					groupPost.setPostContent(postContent);
					groupPost.setPublishTime(new Date());
					groupPost.setGroupID(groupID);
					groupPost.setUserID(user.getUserID());
					groupPost.setRecentModifyTime(new Date());
					postDao.addPost(groupPost);
					groupDao.addGroupPostNum(groupID);
				}
			}
		}
		else
			request.setAttribute("error", "请登录");
		
		
		Group group = groupDao.findGroupByID(groupID);
		request.setAttribute("group", group);
		List<GroupPost> posts = postDao.findPostByGroupIDOrderByRecentModifyTime(groupID);
		request.setAttribute("postList", posts);
		
		
		dispatcher = servletContext.getRequestDispatcher("/showGroup.jsp");
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
