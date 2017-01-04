package factory;

import dao.FilmApproveDao;
import daoImpl.FilmApproveDaoImpl;

public class FilmApproveDaoFactory {
	public static FilmApproveDao getApproveDaoInstance(){
		return new FilmApproveDaoImpl();
	}
}
