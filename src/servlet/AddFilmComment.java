package servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.FilmComment;
import bean.User;
import dao.FilmCommentDao;
import factory.FilmCommentDaoFactory;


public class AddFilmComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public AddFilmComment() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("gbk");
		ServletContext servletContext = getServletContext();
		RequestDispatcher dispatcher = null;
		
		String commentTitle = request.getParameter("commenttitle");
		String commentContent = request.getParameter("commentcontent");
		int filmID = Integer.parseInt(request.getParameter("filmID"));
		User user = (User)request.getSession().getAttribute("user");
		if(user == null){
			request.setAttribute("error", "请先登录");
			dispatcher = servletContext.getRequestDispatcher("/index.jsp");
		}else{
			if(commentTitle == null||"".equals(commentTitle)){
				request.setAttribute("error", "标题不能为空");
				dispatcher = servletContext.getRequestDispatcher("/ShowFilm?filmID="+filmID);
			}else{
				if(commentContent == null||"".equals(commentContent)){
					request.setAttribute("error", "内容不能为空");
					dispatcher = servletContext.getRequestDispatcher("/ShowFilm?filmID="+filmID);
				}else{
					FilmCommentDao commentDao = FilmCommentDaoFactory.getCommentDaoInstance();
					FilmComment comment = new FilmComment();
					comment.setFilmID(filmID);
					comment.setUserID(user.getUserID());
					comment.setCommentTitle(commentTitle);
					comment.setCommentContent(commentContent);
					comment.setPublishTime(new Date());
					commentDao.addComment(comment);
					dispatcher = servletContext.getRequestDispatcher("/ShowFilm?filmID="+filmID);
				}
			}
		}
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
