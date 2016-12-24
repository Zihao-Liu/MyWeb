package factory;

import dao.FindReadDao;
import daoImpl.FindReadDaoImpl;

public class FindReadDaoFactory {
	public static FindReadDao getFindReadDaoInstance(){
		return new FindReadDaoImpl();
	}
}
