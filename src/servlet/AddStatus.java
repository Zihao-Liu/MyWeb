package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Status;
import bean.User;
import dao.StatusDao;
import factory.StatusDaoFactory;


public class AddStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AddStatus() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("gbk");
		ServletContext servletContext = getServletContext();
		RequestDispatcher dispatcher = null;
		
		User user = (User)request.getSession().getAttribute("user");
		String statusContent = request.getParameter("statusContent");
		if(user == null){
			request.setAttribute("error", "请先登录");
			dispatcher = servletContext.getRequestDispatcher("/index.jsp");
		}else{
			if(statusContent==null||"".equals(statusContent)){
				request.setAttribute("contenterror", "状态不能为空");
				dispatcher = servletContext.getRequestDispatcher("/index.jsp");
			}
			else{
				StatusDao statusDao = StatusDaoFactory.getStatusDaoInstance();
				Status status = new Status();
				status.setUserID(user.getUserID());
				status.setStatusContent(statusContent);
				status.setPublishTime(new Date());
				statusDao.addStatus(status);
				List<Status> statuss = new ArrayList<Status>();
				statuss = statusDao.findAllStatus();
				request.setAttribute("statuss", statuss);
				dispatcher = servletContext.getRequestDispatcher("/index.jsp");
			}
		}
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
