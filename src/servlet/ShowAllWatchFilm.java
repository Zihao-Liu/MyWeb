package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FindWatchDao;
import factory.FindWatchDaoFactory;


public class ShowAllWatchFilm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ShowAllWatchFilm() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("gbk");
		ServletContext servletContext = getServletContext();
		RequestDispatcher dispatcher = null;
		
		int userID= Integer.parseInt(request.getParameter("userID"));
		FindWatchDao findWatchDao = FindWatchDaoFactory.getFindWatchDaoInstance();
		request.setAttribute("userwatchfilm", findWatchDao.findAllFilmWatch(userID));
		
		dispatcher=servletContext.getRequestDispatcher("/showAllWatchFilm.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
