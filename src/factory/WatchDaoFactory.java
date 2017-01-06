package factory;

import dao.WatchDao;
import daoImpl.WatchDaoImpl;

public class WatchDaoFactory {
	public static WatchDao getWatchDaoInstance(){
		return new WatchDaoImpl();
	}
}
