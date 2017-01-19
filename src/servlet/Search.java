package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Book;
import bean.Film;
import bean.Group;
import bean.User;
import dao.BookDao;
import dao.FilmDao;
import dao.GroupDao;
import dao.UserDao;
import factory.BookDaoFactory;
import factory.FilmDaoFactory;
import factory.GroupDaoFactory;
import factory.UserDaoFactory;


public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Search() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("gbk");
		ServletContext servletContext = getServletContext();
		RequestDispatcher dispatcher = null;
		
		String itemName = request.getParameter("searchText");
		BookDao bookDao = BookDaoFactory.getBookDaoInstance();
		Book book = bookDao.findBookByName(itemName);
		FilmDao filmDao = FilmDaoFactory.getFilmDaoInstance();
		Film film = filmDao.findFilmByName(itemName);
		GroupDao groupDao = GroupDaoFactory.getGroupDaoInstance();
		Group group = groupDao.findGroupByName(itemName);
		UserDao userDao = UserDaoFactory.getUserDaoInstance();
		User user = userDao.findUserByName(itemName);
		if(book!=null)
			request.setAttribute("booksearch", book);
		if(film!=null)
			request.setAttribute("filmsearch", film);
		if(group!=null)
			request.setAttribute("groupsearch", group);
		if(user!=null)
			request.setAttribute("usersearch", user);
		dispatcher = servletContext.getRequestDispatcher("/searchresult.jsp");
		
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
