package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User;
import dao.UserDao;
import factory.UserDaoFactory;




public class StatusRecognise extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public StatusRecognise() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext servletcontext = getServletContext();
		RequestDispatcher dispatcher = null;
		request.setCharacterEncoding("gbk");
		String userName = request.getParameter("username");
		String userPassword = request.getParameter("userpassword");
		if(userName == null||"".equals(userName)){
			request.setAttribute("error", "请输入用户名");
			dispatcher = servletcontext.getRequestDispatcher("/index.jsp");
		}else{
			if(userPassword == null||"".equals(userPassword)){
				request.setAttribute("error1", "请输入密码");
				dispatcher = servletcontext.getRequestDispatcher("/index.jsp");
			}
			else{
				UserDao userDao = UserDaoFactory.getUserDaoInstance();
				User user = userDao.findUserByName(userName);
				if(user == null){
					request.setAttribute("error", "该用户不存在");
					dispatcher = servletcontext.getRequestDispatcher("/index.jsp");
				}
				else{
					if(user.getPassword().equals(userPassword)){
						request.getSession().setAttribute("user", user);
						response.sendRedirect("index.jsp");
						return;
					}
					else{
						request.setAttribute("error", "密码错误");
						dispatcher = servletcontext.getRequestDispatcher("/index.jsp");
					}
				}
			}
		}
		
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
