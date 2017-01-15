package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Group;
import dao.GroupDao;
import factory.GroupDaoFactory;


public class GroupClassify extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public GroupClassify() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		ServletContext servletcontext = getServletContext();
		RequestDispatcher dispatcher = null;
		
		String groupType = request.getParameter("groupType");
		GroupDao groupDao = GroupDaoFactory.getGroupDaoInstance();
		List<Group> groups = groupDao.findAllGroupByType(groupType);
		request.setAttribute("groupClassify", groups);
		dispatcher = servletcontext.getRequestDispatcher("/groupClassify.jsp");
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
