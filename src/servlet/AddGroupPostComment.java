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

import bean.GroupPost;
import bean.GroupPostComment;
import bean.User;
import dao.GroupPostCommentDao;
import dao.GroupPostDao;
import factory.GroupPostCommentDaoFactory;
import factory.GroupPostDaoFactory;


public class AddGroupPostComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AddGroupPostComment() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("gbk");
		ServletContext servletContext = getServletContext();
		RequestDispatcher dispatcher = null;
		
		String commentTitle = request.getParameter("commenttitle");
		String commentContent = request.getParameter("commentcontent");
		int postID = Integer.parseInt(request.getParameter("postID"));
		GroupPostDao postDao = GroupPostDaoFactory.getGroupPostDaoInstance();
		GroupPostCommentDao groupPostCommentDao = GroupPostCommentDaoFactory.getGroupPostCommentDaoInstance();
		User user =(User)request.getSession().getAttribute("user");
		if(user !=null){
			if(commentTitle==null||"".equals(commentTitle))
				request.setAttribute("error", "标题不能为空");
			else{
				if(commentContent==null||"".equals(commentContent))
					request.setAttribute("error", "内容不能为空");
				else{
					GroupPostComment groupPostComment = new GroupPostComment();
					groupPostComment.setCommentTitle(commentTitle);
					groupPostComment.setCommentContent(commentContent);
					groupPostComment.setPublishTime(new Date());
					groupPostComment.setPostID(postID);
					groupPostComment.setUserID(user.getUserID());
					groupPostCommentDao.addComment(groupPostComment);
					postDao.addCommentNum(postID);
					postDao.updateRecentModifyTime(groupPostComment);
				}
			}
		}
		else
			request.setAttribute("error", "请登录");
		
		GroupPost post = new GroupPost();
		GroupPostDao groupPostDao = GroupPostDaoFactory.getGroupPostDaoInstance();
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
