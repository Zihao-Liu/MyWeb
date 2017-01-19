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
import dao.GroupPostApproveDao;
import dao.GroupPostCommentDao;
import dao.GroupPostDao;
import dao.UserDao;
import factory.GroupPostApproveDaoFactory;
import factory.GroupPostCommentDaoFactory;
import factory.GroupPostDaoFactory;
import factory.UserDaoFactory;


public class ModifyGroupPostApproveNum extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ModifyGroupPostApproveNum() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("gbk");
		ServletContext servletContext = getServletContext();
		RequestDispatcher dispatcher = null;
		int action = Integer.parseInt(request.getParameter("action"));//��õ��޻��Ƿ���
		int postID = Integer.parseInt(request.getParameter("postID"));
		User user = (User)request.getSession().getAttribute("user");//��õ�ǰ��¼�û�
		if(user == null){
			request.setAttribute("error", "���ȵ�¼");
			dispatcher = servletContext.getRequestDispatcher("/showGroupPost.jsp");
		}
		else{
			GroupPostApproveDao approveDao = GroupPostApproveDaoFactory.getGroupPostApproveDaoInstance();
			GroupPostDao groupPostDao = GroupPostDaoFactory.getGroupPostDaoInstance();
			int userID = groupPostDao.findPostByPostID(postID).getUserID();//��ñ������û�ID
			UserDao userDao = UserDaoFactory.getUserDaoInstance();
			if(userID == user.getUserID()){
				request.setAttribute("error", "���ܸ��Լ�����");
			}
			else{
				if(approveDao.findApprove(postID, user.getUserID())==null){
					userDao.modifyUserApprove(userID, action);
					approveDao.modifyPostApprove(postID, action);
					approveDao.addApprove(postID, user.getUserID(), action);
				}else
					request.setAttribute("error", "�������۹�");
				
			}
			dispatcher = servletContext.getRequestDispatcher("/showGroupPost.jsp");
		}
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
