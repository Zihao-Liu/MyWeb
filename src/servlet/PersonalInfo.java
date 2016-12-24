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
import factory.FindReadDaoFactory;


public class PersonalInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public PersonalInfo() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("gbk");
		ServletContext servletContext = getServletContext();
		RequestDispatcher dispatcher = null;
		
		User user = (User)request.getSession().getAttribute("user");
		FindReadDao findReadDao = FindReadDaoFactory.getFindReadDaoInstance();
		System.out.println(user.getUserID());
		//List <Book> books = findReadDao.findAllBookRead(user.getUserID());
		request.setAttribute("userreadbook",findReadDao.findAllBookRead(user.getUserID()));
		dispatcher=servletContext.getRequestDispatcher("/personalinfo.jsp");
		dispatcher.forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
