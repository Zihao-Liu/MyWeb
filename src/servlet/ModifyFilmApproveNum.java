package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Film;
import bean.FilmComment;
import bean.User;
import dao.FilmApproveDao;
import dao.FilmCommentDao;
import dao.FilmDao;
import dao.UserDao;
import factory.FilmApproveDaoFactory;
import factory.FilmCommentDaoFactory;
import factory.FilmDaoFactory;
import factory.UserDaoFactory;


public class ModifyFilmApproveNum extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ModifyFilmApproveNum() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext servletContext = getServletContext();
		RequestDispatcher dispatcher = null;
		User user = (User)request.getSession().getAttribute("user");//��õ�ǰ��¼�û�
		if(user == null){
			request.setAttribute("error", "���ȵ�¼");
			dispatcher = servletContext.getRequestDispatcher("//showFilm.jsp");
		}
		else{
			int action = Integer.parseInt(request.getParameter("action"));//��õ��޻��Ƿ���
			int commentID = Integer.parseInt(request.getParameter("commentID"));
		
			FilmApproveDao approveDao = FilmApproveDaoFactory.getApproveDaoInstance();
			FilmCommentDao commentDao = FilmCommentDaoFactory.getCommentDaoInstance();
			int userID = commentDao.findCommentByCommentID(commentID).getUserID();//��ñ������û�ID
			UserDao userDao = UserDaoFactory.getUserDaoInstance();
			if(userID == user.getUserID()){
				request.setAttribute("error", "���ܸ��Լ�����");
			}
			else{
				if(approveDao.findApprove(commentID, user.getUserID())==null){
					userDao.modifyUserApprove(userID, action);
					commentDao.modifyCommentApprove(commentID,action);
					approveDao.addApprove(commentID, user.getUserID(), action);
				}else{
					/*if(action == -1){//ȡ������
						userDao.modifyUserApprove(userID, 0);
						commentDao.modifyCommentApprove(commentID,0);
						approveDao.deleteApprove(commentID, user.getUserID());
					}
					else if(action == -2){//ȡ������
						userDao.modifyUserApprove(userID, 1);
						commentDao.modifyCommentApprove(commentID,1);
						approveDao.deleteApprove(commentID, user.getUserID());
					}else*/
						request.setAttribute("error", "�������۹�");
				}
				
			}
			//int filmID = Integer.parseInt(request.getParameter("filmID"));
			int filmID = commentDao.findCommentByCommentID(commentID).getFilmID();
			FilmDao filmDao = FilmDaoFactory.getFilmDaoInstance();
			Film film = filmDao.findFilmByID(filmID);
			request.setAttribute("film", film);
			List<FilmComment> comments1 = commentDao.findCommentByFilmIDOrderByApprove(filmID);
			request.setAttribute("commentList1", comments1);
			List<FilmComment> comments2 = commentDao.findCommentByFilmIDOrderByPublishTime(filmID);
			request.setAttribute("commentList2", comments2);
			dispatcher = servletContext.getRequestDispatcher("/showFilm.jsp");
		}
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
