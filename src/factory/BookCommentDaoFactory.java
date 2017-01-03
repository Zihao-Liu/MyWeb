package factory;

import dao.BookCommentDao;
import daoImpl.BookCommentDaoImpl;

public class BookCommentDaoFactory {
	public static BookCommentDao getCommentDaoInstance(){
		return new BookCommentDaoImpl();
	}
}
