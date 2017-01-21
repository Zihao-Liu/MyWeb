package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.GroupPost;
import bean.GroupPostComment;
import dao.GroupPostCommentApproveDao;
import dao.GroupPostCommentDao;
import dao.GroupPostDao;
import factory.GroupPostCommentApproveDaoFactory;
import factory.GroupPostCommentDaoFactory;
import factory.GroupPostDaoFactory;


public class DeleteGroupPostComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public DeleteGroupPostComment() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("gbk");
		ServletContext servletContext = getServletContext();
		RequestDispatcher dispatcher =null;
		
		int commentID = Integer.parseInt(request.getParameter("commentID"));
		int userID = Integer.parseInt(request.getParameter("userID"));
		
		GroupPostCommentApproveDao groupPostCommentApproveDao = GroupPostCommentApproveDaoFactory.getGroupPostCommentApproveDaoInstance();
		groupPostCommentApproveDao.deleteApprove(commentID);
		GroupPostCommentDao groupPostCommentDao = GroupPostCommentDaoFactory.getGroupPostCommentDaoInstance();
		int postID = groupPostCommentDao.findPostCommentByCommentID(commentID).getPostID();
		groupPostCommentDao.deleteComment(commentID, userID);
		
		GroupPost post = new GroupPost();
		GroupPostDao groupPostDao = GroupPostDaoFactory.getGroupPostDaoInstance();
		groupPostDao.subCommentNum(postID);
		post = groupPostDao.findPostByPostID(postID);
		request.setAttribute("post", post);
		List<GroupPostComment> groupPostComments = groupPostCommentDao.findAllCommentByPostID(postID);
		request.setAttribute("commentList", groupPostComments);
		dispatcher = servletContext.getRequestDispatcher("/showGroupPost.jsp");
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
