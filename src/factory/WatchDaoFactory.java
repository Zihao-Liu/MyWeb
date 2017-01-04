package factory;

import dao.WatchDao;
import daoImpl.WatchDaoImpl;

public class WatchDaoFactory {
	public static WatchDao getWatchDAoInstance(){
		return new WatchDaoImpl();
	}
}
