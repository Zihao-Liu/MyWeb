package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Book;
import dao.BookDao;
import factory.BookDaoFactory;



public class AddBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public AddBook() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext servletContext = getServletContext();
		RequestDispatcher dispatcher = null;
		request.setCharacterEncoding("gbk");
		String bookName = request.getParameter("bookname");
		String bookAuthor = request.getParameter("bookauthor");
		String bookType = request.getParameter("booktype");
		String bookInfo = request.getParameter("bookinfo");
		
		if(bookName==null||bookAuthor==null||bookInfo==null
				||"".equals(bookName)||"".equals(bookAuthor)||"".equals(bookInfo)){
			request.setAttribute("error", "信息不完整");
			dispatcher = servletContext.getRequestDispatcher("/addBook.jsp");
		}else{
			BookDao bookDao = BookDaoFactory.getBookDaoInstance();
			Book book = new Book();
			if(bookDao.findBookByName(bookName)==null){
				book.setBookName(bookName);
				book.setBookAurthor(bookAuthor);
				book.setBookType(bookType);
				book.setBookInfo(bookInfo);
				bookDao.addBook(book);
				
				response.sendRedirect("index.jsp");
				return;
			}else{
				request.setAttribute("error", "图书已存在");
				dispatcher = request.getRequestDispatcher("/addBook.jsp");
			}
		}
		dispatcher.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
