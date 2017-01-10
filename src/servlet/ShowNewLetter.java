package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import bean.Letter;
import dao.LetterDao;
import factory.LetterDaoFactory;


public class ShowNewLetter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public ShowNewLetter() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("gbk");
		ServletContext servletContext = getServletContext();
		RequestDispatcher dispatcher = null;
		
		int receiveUserID = Integer.parseInt(request.getParameter("receiveUserID"));
		
		List<Letter> letters = new ArrayList<Letter>();
		LetterDao letterDao = LetterDaoFactory.getLetterDaoInstance();
		letters = letterDao.findAllLetterNotRead(receiveUserID);
		request.setAttribute("letters", letters);
		dispatcher=servletContext.getRequestDispatcher("/showNewLetter.jsp");
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
