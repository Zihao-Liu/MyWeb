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



public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Register() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext servletcontext = getServletContext();
		RequestDispatcher dispatcher = null;
		request.setCharacterEncoding("gbk");
		String userName = request.getParameter("username");
		String userPassword = request.getParameter("userpassword");
		String userSex = request.getParameter("usersex");
		
		if(userName==null||"".equals(userName)){
			request.setAttribute("error", "用户名不能为空");
			dispatcher = servletcontext.getRequestDispatcher("/register.jsp");
		}else{
			if(userName==null||"".equals(userPassword)){
				request.setAttribute("error", "密码不能为空");
				dispatcher = servletcontext.getRequestDispatcher("/register.jsp");
			}else{
				if(userSex==null){
					request.setAttribute("error", "请选择性别");
					dispatcher = servletcontext.getRequestDispatcher("/register.jsp");
				}else{
					UserDao userDao = UserDaoFactory.getUserDaoInstance();
					User user = new User();
					if(userDao.findUserByName(userName)==null){
						user.setUserName(userName);
						user.setUserSex(userSex);
						user.setPassword(userPassword);
						userDao.addUser(user);
						request.getSession().setAttribute("user",user);
						response.sendRedirect("index.jsp");
						return;
					}
					else{
						request.setAttribute("error", "用户名已存在");
						dispatcher = servletcontext.getRequestDispatcher("/register.jsp");
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
