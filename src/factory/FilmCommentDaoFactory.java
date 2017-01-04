package factory;

import dao.FilmCommentDao;
import daoImpl.FilmCommentDaoImpl;

public class FilmCommentDaoFactory {
	public static FilmCommentDao getCommentDaoInstance(){
		return new FilmCommentDaoImpl();
	}
}
