package factory;

import dao.FindWatchDao;
import daoImpl.FindWatchDaoImpl;

public class FindWatchDaoFactory {
	public static FindWatchDao getFindWatchDaoInstance(){
		return new FindWatchDaoImpl();
	}
}
