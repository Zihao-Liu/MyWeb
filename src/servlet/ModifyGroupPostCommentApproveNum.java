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
import bean.User;
import dao.GroupPostCommentApproveDao;
import dao.GroupPostCommentDao;
import dao.GroupPostDao;
import dao.UserDao;
import factory.GroupPostCommentApproveDaoFactory;
import factory.GroupPostCommentDaoFactory;
import factory.GroupPostDaoFactory;
import factory.UserDaoFactory;


public class ModifyGroupPostCommentApproveNum extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ModifyGroupPostCommentApproveNum() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("gbk");
		ServletContext servletContext = getServletContext();
		RequestDispatcher dispatcher = null;
		int action = Integer.parseInt(request.getParameter("action"));//获得点赞还是反对
		int commentID = Integer.parseInt(request.getParameter("commentID"));
		User user = (User)request.getSession().getAttribute("user");//获得当前登录用户
		GroupPostCommentDao groupPostCommentDao =GroupPostCommentDaoFactory.getGroupPostCommentDaoInstance();
		GroupPostComment groupPostComment = groupPostCommentDao.findPostCommentByCommentID(commentID);
		if(user == null){
			request.setAttribute("error", "请先登录");
			dispatcher = servletContext.getRequestDispatcher("/showGroupPost.jsp");
		}
		else{
			GroupPostCommentApproveDao approveDao = GroupPostCommentApproveDaoFactory.getGroupPostCommentApproveDaoInstance();
			int userID = groupPostComment.getUserID();//获得被点赞用户ID
			UserDao userDao = UserDaoFactory.getUserDaoInstance();
			if(userID == user.getUserID()){
				request.setAttribute("error", "不能给自己点赞");
			}
			else{
				if(approveDao.findApprove(commentID, user.getUserID())==null){
					userDao.modifyUserApprove(userID, action);
					approveDao.modifyCommentApprove(commentID, action);
					approveDao.addApprove(commentID, user.getUserID(), action);
				}else
					request.setAttribute("error", "您已评价过");
				
			}
			dispatcher = servletContext.getRequestDispatcher("/showGroupPost.jsp");
		}
		GroupPost post = new GroupPost();
		GroupPostDao groupPostDao = GroupPostDaoFactory.getGroupPostDaoInstance();
		post = groupPostDao.findPostByPostID(groupPostComment.getPostID());
		request.setAttribute("post", post);
		List<GroupPostComment> groupPostComments = groupPostCommentDao.findAllCommentByPostID(groupPostComment.getPostID());
		request.setAttribute("commentList", groupPostComments);
		dispatcher = servletContext.getRequestDispatcher("/showGroupPost.jsp");
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
