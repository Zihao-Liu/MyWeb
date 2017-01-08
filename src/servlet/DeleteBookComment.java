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
import dao.BookApproveDao;
import dao.BookCommentDao;
import dao.BookDao;
import factory.BookApproveDaoFactory;
import factory.BookCommentDaoFactory;
import factory.BookDaoFactory;


public class DeleteBookComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public DeleteBookComment() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("gbk");
		ServletContext servletContext = getServletContext();
		RequestDispatcher dispatcher =null;
		
		int commentID = Integer.parseInt(request.getParameter("commentID"));
		int userID = Integer.parseInt(request.getParameter("userID"));
		
		BookApproveDao bookApproveDao = BookApproveDaoFactory.getApproveDaoInstance();
		bookApproveDao.deleteApprove(commentID);
		BookCommentDao bookCommentDao = BookCommentDaoFactory.getCommentDaoInstance();
		int bookID = bookCommentDao.findCommentByCommentID(commentID).getBookID();
		bookCommentDao.deleteComment(commentID, userID);
		
		BookDao bookDao = BookDaoFactory.getBookDaoInstance();
		Book book = bookDao.findBookByID(bookID);
		request.setAttribute("book", book);
		BookCommentDao commentDao = BookCommentDaoFactory.getCommentDaoInstance();
		List<BookComment> comments1 = commentDao.findCommentByBookIDOrderByApprove(bookID);
		request.setAttribute("commentList1", comments1);
		List<BookComment> comments2 = commentDao.findCommentByBookIDOrderByPublishTime(bookID);
		request.setAttribute("commentList2", comments2);
		dispatcher = servletContext.getRequestDispatcher("/showBook.jsp");
		dispatcher.forward(request, response);
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
