package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Letter;
import dao.LetterDao;
import factory.LetterDaoFactory;


public class ShowLetter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ShowLetter() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("gbk");
		ServletContext servletContext = getServletContext();
		RequestDispatcher dispatcher = null;
		
		int letterID = Integer.parseInt(request.getParameter("letterID"));
		
		LetterDao letterDao = LetterDaoFactory.getLetterDaoInstance();
		letterDao.modifyLetterToRead(letterID);
		Letter letter = letterDao.findLetter(letterID);
		
		request.setAttribute("letter", letter);
		dispatcher=servletContext.getRequestDispatcher("/showLetter.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
