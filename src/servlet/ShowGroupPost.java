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
import dao.GroupPostCommentDao;
import dao.GroupPostDao;
import factory.GroupPostCommentDaoFactory;
import factory.GroupPostDaoFactory;


public class ShowGroupPost extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ShowGroupPost() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("gbk");
		ServletContext servletContext = getServletContext();
		RequestDispatcher dispatcher = null;
		
		int postID = Integer.parseInt(request.getParameter("postID"));
		
		GroupPost post = new GroupPost();
		GroupPostDao groupPostDao = GroupPostDaoFactory.getGroupPostDaoInstance();
		post = groupPostDao.findPostByPostID(postID);
		request.setAttribute("post", post);
		GroupPostCommentDao groupPostCommentDao =GroupPostCommentDaoFactory.getGroupPostCommentDaoInstance();
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
