package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AttendGroupDao;
import factory.AttendGroupDaoFactory;


public class ShowAllAttendGroup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ShowAllAttendGroup() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("gbk");
		ServletContext servletContext = getServletContext();
		RequestDispatcher dispatcher = null;
		
		int userID= Integer.parseInt(request.getParameter("userID"));
		AttendGroupDao attendGroupDao = AttendGroupDaoFactory.getAttendGroupDaoInstance();
		request.setAttribute("userattendgroup", attendGroupDao.findAllAttendGroup(userID));
		
		dispatcher=servletContext.getRequestDispatcher("/showAllAttendGroup.jsp");
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
