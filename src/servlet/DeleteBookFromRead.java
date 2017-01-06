package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User;
import dao.FindReadDao;
import dao.FindWatchDao;
import dao.ReadDao;
import dao.StatusDao;
import dao.UserDao;
import factory.FindReadDaoFactory;
import factory.FindWatchDaoFactory;
import factory.ReadDaoFactory;
import factory.StatusDaoFactory;
import factory.UserDaoFactory;


public class DeleteBookFromRead extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public DeleteBookFromRead() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("gbk");
		ServletContext servletContext = getServletContext();
		RequestDispatcher dispatcher = null;
		
		User user = (User)request.getSession().getAttribute("user");
		int bookID = Integer.parseInt(request.getParameter("bookID"));
		float bookScore = Float.parseFloat(request.getParameter("bookScore"));
		
		ReadDao readDao = ReadDaoFactory.getReadDaoInstance();
		readDao.deleteRead(bookID, user.getUserID(),bookScore );
		FindReadDao findReadDao = FindReadDaoFactory.getFindReadDaoInstance();
		FindWatchDao findWatchDao = FindWatchDaoFactory.getFindWatchDaoInstance();
		request.setAttribute("userreadbook",findReadDao.findAllBookRead(user.getUserID()));
		request.setAttribute("userwatchfilm", findWatchDao.findAllFilmWatch(user.getUserID()));
		
		StatusDao statusDao = StatusDaoFactory.getStatusDaoInstance();
		request.setAttribute("userstatus", statusDao.findStatusByUserID(user.getUserID()));
		UserDao userDao = UserDaoFactory.getUserDaoInstance();
		User userNew = userDao.findUserByID(user.getUserID());
		request.setAttribute("userNew", userNew);
		dispatcher=servletContext.getRequestDispatcher("/personalinfo.jsp");
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
