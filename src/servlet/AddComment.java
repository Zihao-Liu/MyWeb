package servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Comment;
import bean.User;
import dao.CommentDao;
import factory.CommentDaoFactory;


public class AddComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public AddComment() {
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
			request.setAttribute("error", "���ȵ�¼");
			dispatcher = servletContext.getRequestDispatcher("/index.jsp");
		}else{
			if(commentTitle == null||"".equals(commentTitle)){
				request.setAttribute("error", "���ⲻ��Ϊ��");
				dispatcher = servletContext.getRequestDispatcher("/ShowBook?bookID="+bookID);
			}else{
				if(commentContent == null||"".equals(commentContent)){
					request.setAttribute("error", "���ݲ���Ϊ��");
					dispatcher = servletContext.getRequestDispatcher("/ShowBook?bookID="+bookID);
				}else{
					CommentDao commentDao = CommentDaoFactory.getCommentDaoInstance();
					Comment comment = new Comment();
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