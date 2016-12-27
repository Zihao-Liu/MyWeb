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
import bean.Comment;
import dao.BookDao;
import dao.CommentDao;
import factory.BookDaoFactory;
import factory.CommentDaoFactory;


public class SearchBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SearchBook() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("gbk");
		ServletContext servletContext = getServletContext();
		RequestDispatcher dispatcher = null;
		
		String bookName = request.getParameter("searchText");
		BookDao bookDao = BookDaoFactory.getBookDaoInstance();
		Book book = bookDao.findBookByName(bookName);
		if(book!=null){
			request.setAttribute("book", book);
			CommentDao commentDao = CommentDaoFactory.getCommentDaoInstance();
			List<Comment> comments1 = commentDao.findCommentByBookIDOrderByApprove(book.getBookID());
			request.setAttribute("commentList1", comments1);
			List<Comment> comments2 = commentDao.findCommentByBookIDOrderByPublishTime(book.getBookID());
			request.setAttribute("commentList2", comments2);
			dispatcher = servletContext.getRequestDispatcher("/showBook.jsp");
		}
		else{
			dispatcher = servletContext.getRequestDispatcher("/noBook.jsp"); 
		}
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
