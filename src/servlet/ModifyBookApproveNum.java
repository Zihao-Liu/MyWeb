package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Book;
import bean.BookComment;
import bean.User;
import dao.BookApproveDao;
import dao.BookDao;
import dao.BookCommentDao;
import dao.UserDao;
import factory.BookApproveDaoFactory;
import factory.BookDaoFactory;
import factory.BookCommentDaoFactory;
import factory.UserDaoFactory;

public class ModifyBookApproveNum extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ModifyBookApproveNum() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext servletContext = getServletContext();
		RequestDispatcher dispatcher = null;
		User user = (User)request.getSession().getAttribute("user");//获得当前登录用户
		if(user == null){
			request.setAttribute("error", "请先登录");
			dispatcher = servletContext.getRequestDispatcher("/showBook.jsp");
		}
		else{
			int action = Integer.parseInt(request.getParameter("action"));//获得点赞还是反对
			int commentID = Integer.parseInt(request.getParameter("commentID"));
		
			BookApproveDao approveDao = BookApproveDaoFactory.getApproveDaoInstance();
			BookCommentDao commentDao = BookCommentDaoFactory.getCommentDaoInstance();
			int userID = commentDao.findCommentByCommentID(commentID).getUserID();//获得被点赞用户ID
			UserDao userDao = UserDaoFactory.getUserDaoInstance();
			if(userID == user.getUserID()){
				request.setAttribute("error", "不能给自己点赞");
			}
			else{
				if(approveDao.findApprove(commentID, user.getUserID())==null){
					userDao.modifyUserApprove(userID, action);
					commentDao.modifyCommentApprove(commentID,action);
					approveDao.addApprove(commentID, user.getUserID(), action);
				}else{
					/*if(action == -1){//取消点赞
						userDao.modifyUserApprove(userID, 0);
						commentDao.modifyCommentApprove(commentID,0);
						approveDao.deleteApprove(commentID, user.getUserID());
					}
					else if(action == -2){//取消反对
						userDao.modifyUserApprove(userID, 1);
						commentDao.modifyCommentApprove(commentID,1);
						approveDao.deleteApprove(commentID, user.getUserID());
					}else*/
						request.setAttribute("error", "您已评价过");
				}
				
			}
			//int bookID = Integer.parseInt(request.getParameter("bookID"));
			int bookID = commentDao.findCommentByCommentID(commentID).getBookID();
			BookDao bookDao = BookDaoFactory.getBookDaoInstance();
			Book book = bookDao.findBookByID(bookID);
			request.setAttribute("book", book);
			List<BookComment> comments1 = commentDao.findCommentByBookIDOrderByApprove(bookID);
			request.setAttribute("commentList1", comments1);
			List<BookComment> comments2 = commentDao.findCommentByBookIDOrderByPublishTime(bookID);
			request.setAttribute("commentList2", comments2);
			dispatcher = servletContext.getRequestDispatcher("/showBook.jsp");
		}
		dispatcher.forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
