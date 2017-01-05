package servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.BookComment;
import bean.User;
import dao.BookCommentDao;
import factory.BookCommentDaoFactory;


public class AddBookComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public AddBookComment() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("gbk");
		ServletContext servletContext = getServletContext();
		RequestDispatcher dispatcher = null;
		String commentTitle = request.getParameter("commenttitle");
		String commentContent = request.getParameter("commentcontent");
		int bookID = Integer.parseInt(request.getParameter("bookID"));
		User user = (User)request.getSession().getAttribute("user");
		if(user == null){
			request.setAttribute("error", "请先登录");
			dispatcher = servletContext.getRequestDispatcher("/ShowBook?bookID="+bookID);
		}else{
			if(commentTitle == null||"".equals(commentTitle)){
				request.setAttribute("error", "标题不能为空");
				dispatcher = servletContext.getRequestDispatcher("/ShowBook?bookID="+bookID);
			}else{
				if(commentContent == null||"".equals(commentContent)){
					request.setAttribute("error", "内容不能为空");
					dispatcher = servletContext.getRequestDispatcher("/ShowBook?bookID="+bookID);
				}else{
					BookCommentDao commentDao = BookCommentDaoFactory.getCommentDaoInstance();
					BookComment comment = new BookComment();
					comment.setBookID(bookID);
					comment.setUserID(user.getUserID());
					comment.setCommentTitle(commentTitle);
					comment.setCommentContent(commentContent);
					comment.setPublishTime(new Date());
					commentDao.addComment(comment);
					dispatcher = servletContext.getRequestDispatcher("/ShowBook?bookID="+bookID);
				}
			}
		}
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
