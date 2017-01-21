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
import bean.GroupPostComment;
import bean.User;
import dao.AttendGroupDao;
import dao.GroupDao;
import dao.GroupPostApproveDao;
import dao.GroupPostCommentApproveDao;
import dao.GroupPostCommentDao;
import dao.GroupPostDao;
import factory.AttendGroupDaoFactory;
import factory.GroupDaoFactory;
import factory.GroupPostApproveDaoFactory;
import factory.GroupPostCommentApproveDaoFactory;
import factory.GroupPostCommentDaoFactory;
import factory.GroupPostDaoFactory;


public class DeleteGroupPost extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public DeleteGroupPost() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("gbk");
		ServletContext servletContext = getServletContext();
		RequestDispatcher dispatcher =null;
		
		int postID = Integer.parseInt(request.getParameter("postID"));
		int userID = Integer.parseInt(request.getParameter("userID"));
		
		GroupPostCommentDao groupPostCommentDao = GroupPostCommentDaoFactory.getGroupPostCommentDaoInstance();
		List<GroupPostComment> groupPostComments = groupPostCommentDao.findAllCommentByPostID(postID);
		GroupPostCommentApproveDao groupPostCommentApproveDao = GroupPostCommentApproveDaoFactory.getGroupPostCommentApproveDaoInstance();
		for(GroupPostComment groupPostComment:groupPostComments){
			groupPostCommentApproveDao.deleteApprove(groupPostComment.getCommentID());
			groupPostCommentDao.deleteComment(groupPostComment.getCommentID(), userID);
		}
		
		
		GroupPostApproveDao groupPostApproveDao = GroupPostApproveDaoFactory.getGroupPostApproveDaoInstance();
		groupPostApproveDao.deleteApprove(postID);
		GroupPostDao groupPostDao = GroupPostDaoFactory.getGroupPostDaoInstance();
		int groupID = groupPostDao.findPostByPostID(postID).getGroupID();
		groupPostDao.deletePost(postID, userID);
		
		
		GroupDao groupDao = GroupDaoFactory.getGroupDaoInstance();
		Group group = groupDao.findGroupByID(groupID);
		request.setAttribute("group", group);
		GroupPostDao postDao = GroupPostDaoFactory.getGroupPostDaoInstance();
		List<GroupPost> posts = postDao.findPostByGroupIDOrderByRecentModifyTime(groupID);
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
