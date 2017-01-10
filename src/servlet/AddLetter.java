package servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import bean.Letter;

import dao.LetterDao;
import factory.LetterDaoFactory;



public class AddLetter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AddLetter() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("gbk");
		ServletContext servletContext = getServletContext();
		RequestDispatcher dispatcher = null;
		
		int receiveUserID = Integer.parseInt(request.getParameter("receiveUserID"));
		int sendUserID = Integer.parseInt(request.getParameter("sendUserID"));
		String letterContent = request.getParameter("letterContent");
		LetterDao letterDao = LetterDaoFactory.getLetterDaoInstance();
		Letter letter = new Letter();
		letter.setLetterContent(letterContent);
		letter.setSendUserID(sendUserID);
		letter.setReceiveUserID(receiveUserID);
		letter.setLetterSendTime(new Date());
		letterDao.addLetter(letter);
		dispatcher=servletContext.getRequestDispatcher("/success.jsp");
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
