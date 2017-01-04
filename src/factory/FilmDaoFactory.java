package factory;

import dao.FilmDao;
import daoImpl.FilmDaoImpl;

public class FilmDaoFactory {
	public static FilmDao getFilmDaoInstance(){
		return new FilmDaoImpl();
	}
}
