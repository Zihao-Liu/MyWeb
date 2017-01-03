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
import bean.Read;
import bean.User;
import dao.BookDao;
import dao.BookCommentDao;
import dao.ReadDao;
import dao.UserDao;
import factory.BookDaoFactory;
import factory.BookCommentDaoFactory;
import factory.ReadDaoFactory;
import factory.UserDaoFactory;


public class ModifyReadNum extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public ModifyReadNum() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext servletContext = getServletContext();
		RequestDispatcher dispatcher = null;
		
		User user= (User)request.getSession().getAttribute("user");
		
		int bookID = Integer.parseInt(request.getParameter("bookID"));
		int bookScore = Integer.parseInt(request.getParameter("score"));
		BookDao bookDao = BookDaoFactory.getBookDaoInstance();
		Book book = bookDao.findBookByID(bookID);
		if(user == null){
			request.setAttribute("error", "ÇëÏÈµÇÂ¼");
			dispatcher = servletContext.getRequestDispatcher("/showBook.jsp");
		}
		else{
			int userID = user.getUserID();
			ReadDao readDao = ReadDaoFactory.getReadDAoInstance();
			if(readDao.findread(bookID, userID)==null){
				readDao.addRead(bookID, userID, bookScore);
				bookDao.modifyBookRead(bookID, bookScore);
				UserDao userDao = UserDaoFactory.getUserDaoInstance();
				userDao.modifyUserRead(userID);
				Read read = readDao.findread(bookID, userID);
				request.setAttribute("read", read);
			}
			else{
				request.setAttribute("error", "ÄúÒÑ¶Á¹ý");
			}
			
			dispatcher = servletContext.getRequestDispatcher("/showBook.jsp");
		}
		request.setAttribute("book", book);
		BookCommentDao commentDao = BookCommentDaoFactory.getCommentDaoInstance();
		List<BookComment> comments1 = commentDao.findCommentByBookIDOrderByApprove(bookID);
		request.setAttribute("commentList1", comments1);
		List<BookComment> comments2 = commentDao.findCommentByBookIDOrderByPublishTime(bookID);
		request.setAttribute("commentList2", comments2);
		dispatcher.forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
