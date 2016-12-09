package factory;

import dao.CommentDao;
import daoImpl.CommentDaoImpl;

public class CommentDaoFactory {
	public static CommentDao getCommentDaoInstance(){
		return new CommentDaoImpl();
	}
}
