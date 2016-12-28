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
import dao.BookDao;
import factory.BookDaoFactory;


public class BookClassify extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public BookClassify() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		ServletContext servletcontext = getServletContext();
		RequestDispatcher dispatcher = null;
		
		
		String bookType = request.getParameter("bookType");
		BookDao bookDao = BookDaoFactory.getBookDaoInstance();
		List<Book> books = bookDao.findAllBookByType(bookType);
		request.setAttribute("bookClassify", books);
		dispatcher = servletcontext.getRequestDispatcher("/bookClassify.jsp");
		dispatcher.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
